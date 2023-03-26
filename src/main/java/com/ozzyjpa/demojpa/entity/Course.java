package com.ozzyjpa.demojpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name="CourseDetails") // use to rename table name
@NamedQueries(value = {
        @NamedQuery(name="query_get_all_courses", query = "Select c from Course c"),
        @NamedQuery(name="query_get_ders", query = "Select c from Course c where c.name like '%ders%'")
})
@SQLDelete(sql = "update course set is_deleted = true where id = ?")
@Where(clause = "is_deleted = false") // do not work with native queries
public class Course {

    @Id
    @GeneratedValue
    private Long id;
    //@Column(name="fullname", nullable = false)
    @Column(nullable = false)
    private String name;
    // Review is the owner, put mappedBy to the non owner
    @OneToMany(mappedBy = "course")  // default is lazy fetching, use @Transactional or eager fetching (fetch = FetchType.EAGER)
    private List<Review> reviews = new ArrayList<>();
    @ManyToMany(mappedBy = "courses") // courses variable in the Student entity could have the (mappedBy = "students") does not matter
    @JsonIgnore
    private List<Student> students = new ArrayList<>();
    @UpdateTimestamp
    private LocalDateTime lastUpdated;
    @CreationTimestamp
    private LocalDateTime createdDate;
    @Column
    private boolean isDeleted;
    public Course(String name) {
        this.name = name;
    }
    protected Course() {}

    // to update the cache data
    @PreRemove
    public void preRemove(){
        this.isDeleted =true;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        if(review != null)
            this.reviews.add(review);
    }

    public void removeReview(Review review) {
        if(review != null)
            this.reviews.remove(review);
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastUpdated=" + lastUpdated +
                ", createdDate=" + createdDate +
                '}';
    }
}
