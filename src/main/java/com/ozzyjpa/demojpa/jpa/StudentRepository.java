package com.ozzyjpa.demojpa.jpa;

import com.ozzyjpa.demojpa.entity.Course;
import com.ozzyjpa.demojpa.entity.Passport;
import com.ozzyjpa.demojpa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional // so that db operations are not left unfinished
public class StudentRepository {

    //entity manager is an interface to comminicate with persistense context
    @Autowired
    EntityManager entityManager;

    public Student findById(long id){
        return entityManager.find(Student.class, id);
    }

    //insert or update
    public Student save(Student student){
        if(student.getId() == null){ // insert
            entityManager.persist(student);
        }
        else { // update
            entityManager.merge(student);
        }
        return student;
    }

    public void deleteById(int id) {
        Student student = findById(id);
        entityManager.remove(student);
    }

    public void saveStudentWithPassport(){
        Passport passport1 = new Passport("Z1234");
        entityManager.persist(passport1);
        Student student1 = new Student("Mike");
        student1.setPassport(passport1);

        entityManager.persist(student1);
    }

    public void insertStudentAndCourse(Student student, Course course){
        student.addCourse(course);
        course.addStudent(student);

        entityManager.persist(student);
        entityManager.persist(course);
    }



    public void some_operations_for_persistence_context() {
        Student student = entityManager.find(Student.class, 10002L);
        // persistence context (student)
        Passport passport = student.getPassport();
        // persistence context (student,passport)

        passport.setNumber("N1231232");
        // persistence context (student,passport++)

        student.setName("gamze2");
        // persistence context (student++,passport++)

    }
}
