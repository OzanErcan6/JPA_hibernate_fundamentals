package com.ozzyjpa.demojpa.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    //@Column(name="fullname", nullable = false)
    @Column(nullable = false)
    private String name;

    @OneToOne//(fetch = FetchType.LAZY)
    private Passport passport;

    @ManyToMany//(fetch = FetchType.EAGER)
    @JoinTable(name="STUDENT_COURSE",
    joinColumns = @JoinColumn(name="STUDENT_ID"),
    inverseJoinColumns = @JoinColumn(name="COURSE_ID"))
    private List<Course> courses = new ArrayList<>();

    @Embedded
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Student(String name) {
        this.name = name;
    }

    protected Student() {}

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

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
