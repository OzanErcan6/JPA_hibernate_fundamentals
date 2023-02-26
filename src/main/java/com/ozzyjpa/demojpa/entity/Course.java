package com.ozzyjpa.demojpa.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
    private List<Student> students = new ArrayList<>();
    @UpdateTimestamp
    private LocalDateTime lastUpdated;
    @CreationTimestamp
    private LocalDateTime createdDate;
    public Course(String name) {
        this.name = name;
    }
    protected Course() {}


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
                ", reviews=" + reviews +
                ", lastUpdated=" + lastUpdated +
                ", createdDate=" + createdDate +
                '}';
    }
}
