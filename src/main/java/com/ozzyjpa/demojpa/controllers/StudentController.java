package com.ozzyjpa.demojpa.controllers;

import com.ozzyjpa.demojpa.entity.Student;
import com.ozzyjpa.demojpa.jpa.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository dao;

//    @GetMapping
//    public List<Student> findAllStudents() {
//        return dao.findAll();
//    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        return dao.findById(studentId);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudentByStudentId(@PathVariable int studentId){
         dao.deleteById(studentId);
    }

    @PutMapping
    public Student updateStudentByStudentId(@RequestBody Student student){
        return dao.save(student);
    }

    @PostMapping
    public Student createPost(@RequestBody Student student){
        return dao.save(student);
    }
}
