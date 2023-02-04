package com.ozzyjpa.demojpa.jpa;

import com.ozzyjpa.demojpa.entity.Course;
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
            entityManager.persist(course);
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

    public void playEM(){
// LESSON-1 course_updated ismi ile kaydedilir entityManager.merge() vs yapmaya gerek yok
        Course course1 = new Course("course gamze final1");
        entityManager.persist(course1);
        Course course2 = new Course("course angular4 final2");
        entityManager.persist(course2);

        entityManager.flush();
        //entityManager.detach(course2); // entity manager does not track course2 anymore
        //entityManager.clear(); // detachs everything from entity manager

        course1.setName("course gamze_updated final 1");
        course2.setName("course angular4_updated final 2");

        entityManager.refresh(course2); // after entityManager.flush(); changes on course2 discarded
        entityManager.flush();
    }

}
