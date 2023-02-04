package com.ozzyjpa.demojpa.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

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
