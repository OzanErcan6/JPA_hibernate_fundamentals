package com.ozzyjpa.demojpa;


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
    void some_test() {
        studentRepository.some_operations_for_persistence_context();
    }

    @Test
    @DirtiesContext // after test run spring reverts db changes
    void playEM_test() {
        studentRepository.saveStudentWithPassport();
    }

    @Test
    @Transactional
    void retrievePassportAndAssociatedStudent() {
        Passport passport = entityManager.find(Passport.class, 20001L);
        logger.info("passportt {}", passport);
        logger.info("passport_idd {}", passport.getStudent());
    }
}
