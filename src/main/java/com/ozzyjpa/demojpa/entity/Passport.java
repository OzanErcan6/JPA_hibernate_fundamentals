package com.ozzyjpa.demojpa.entity;

import javax.persistence.*;

@Entity
public class Passport {

    @Id
    @GeneratedValue
    private Long id;

    private String number;

    public Passport(String number) {
        this.number = number;
    }

    protected Passport() {}

    // student is the owner, put mappedBy to the non owner
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
    private Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", Number='" + number + '\'' +
                '}';
    }
}
