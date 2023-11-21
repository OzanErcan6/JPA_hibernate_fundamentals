package com.ozzyjpa.demojpa.jpa;


import com.ozzyjpa.demojpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJpaRepository extends JpaRepository<Student, Long> {
    Student findByName(String name);
}
