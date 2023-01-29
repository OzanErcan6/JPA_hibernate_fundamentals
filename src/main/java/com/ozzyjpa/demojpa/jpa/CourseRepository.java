package com.ozzyjpa.demojpa.jpa;

import com.ozzyjpa.demojpa.entity.Course;
import com.ozzyjpa.demojpa.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional // so that db operations are not left unfinished
public class CourseRepository {

    @Autowired
    EntityManager entityManager;

    public Course findById(long id){
        return entityManager.find(Course.class, id);
    }

    //insert or update
    public Course save(Course course){
        if(course.getId() == null){ // insert
            entityManager.merge(course);
        }
        else { // update
            entityManager.merge(course);
        }
        return course;
    }

    public void deleteById(int id) {
        Course course = findById(id);
        entityManager.remove(course);
    }


}
