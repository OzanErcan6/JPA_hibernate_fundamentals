package com.ozzyjpa.demojpa;


import com.ozzyjpa.demojpa.entity.Address;
import com.ozzyjpa.demojpa.entity.Course;
import com.ozzyjpa.demojpa.entity.Passport;
import com.ozzyjpa.demojpa.entity.Student;
import com.ozzyjpa.demojpa.jpa.StudentRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest
public class StudentRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional
    void retrieveStudentAndPassportDetails() {
        Student student = entityManager.find(Student.class, 10001L);
        logger.info("studentt {}", student);
        logger.info("passport_idd {}", student.getPassport());
    }

    @Test
    @Transactional
    void retrieveStudentAndPassportDetails2() {
        Passport passport = entityManager.find(Passport.class, 20001L);
        logger.info("passportt {}", passport);
        logger.info("studentt {}", passport.getStudent());
    }

    @Test
    @Transactional
    void retrieveStudentAndPassportDetails3() {
        Student student = studentRepository.findById(10001);
        logger.info("studentt {}", student);
        logger.info("passport_idd {}", student.getPassport());
    }

    @Test
    void some_test() {
        studentRepository.some_operations_for_persistence_context();
    }

    @Test
    @DirtiesContext // after test run spring reverts db changes
    void playEM_test() {
        studentRepository.saveStudentWithPassport();
    }

    @Test
    void saveStudentAndPassword() {
        Passport passport = new Passport("N123456");
        Student student = new Student("ozzy");
        studentRepository.saveStudentWithPassport(student,passport);
    }

    @Test
    void findByStudent() {

        Student student1 = studentRepository.findById(80);
        System.out.println(student1.toString());
    }


    @Test
    @Transactional
    void retrievePassportAndAssociatedStudent() {
        Passport passport = entityManager.find(Passport.class, 20001L);
        logger.info("passportt {}", passport);
        logger.info("passport_idd {}", passport.getStudent());
    }

    @Test
    @Transactional
    void retrieveStudentAndCourse() {
        Student student = entityManager.find(Student.class, 10001L);
        student.setAddress(new Address("a101", "b101", "istanbul"));
        entityManager.flush();
        logger.info("studentt {}", student);
        logger.info("coursess {}", student.getAddress().toString());
    }

    @Test
    @Transactional
    void setAddressDetails() {
        Student student = entityManager.find(Student.class, 10001L);

        logger.info("studentt {}", student);
        logger.info("coursess {}", student.getCourses());
    }

    @Test
    @Transactional
    void retrieveStudentAndCourse2() {
        Course course = entityManager.find(Course.class, 10L);
        logger.info("coursee {}", course);
        logger.info("studentts {}", course.getStudents());
    }

    @Test
    @DirtiesContext
    void insertStudentAndCourse() {
        Student student = new Student("Gamze Ercan2");
        Passport passport = new Passport("G12345");
        studentRepository.insertStudentAndPassport(student,passport);
        Course course = new Course("React Native in 100 steps2");
        Course course2 = new Course("React in 100 steps2");
        studentRepository.insertStudentAndCourse(student, course);
        studentRepository.insertStudentAndCourse(student, course2);
    }

}
