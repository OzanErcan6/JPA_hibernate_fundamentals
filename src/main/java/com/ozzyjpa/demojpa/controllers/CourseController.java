package com.ozzyjpa.demojpa.controllers;

import com.ozzyjpa.demojpa.entity.Course;
import com.ozzyjpa.demojpa.jpa.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseRepository dao;

//    @GetMapping
//    public List<Course> findAllCourses() {
//        return dao.findAll();
//    }

    @GetMapping("/{courseId}")
    public Course getCourseById(@PathVariable int courseId){
        return dao.findById(courseId);
    }

    @DeleteMapping("/{courseId}")
    public void deleteCourseByCourseId(@PathVariable int courseId){
         dao.deleteById(courseId);
    }

    @PutMapping
    public Course updateCourseByCourseId(@RequestBody Course course){
        return dao.save(course);
    }

    @PostMapping
    public Course createPost(@RequestBody Course course){
        return dao.save(course);
    }
}
