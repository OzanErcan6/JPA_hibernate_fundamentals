package com.ozzyjpa.demojpa;

import com.ozzyjpa.demojpa.entity.Course;
import com.ozzyjpa.demojpa.entity.Student;
import com.ozzyjpa.demojpa.jpa.CourseRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest
public class JPQLTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    @Test
    void findById_basic() {
        List resultList = entityManager.createNamedQuery("query_get_all_courses").getResultList();
        logger.info("result list {}", resultList.get(0));
    }

    @Test
    void findById_typed() {
        TypedQuery<Course> query = entityManager.createNamedQuery("query_get_all_courses", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("result list {}", resultList);
    }

    @Test
    void findById_where() {
        TypedQuery<Course> query = entityManager.createNamedQuery("query_get_ders", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("result list2 {}", resultList);
    }

    @Test
    void jpql_courses_without_students() {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c where c.students is empty ", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("result list2 {}", resultList);
    }

    @Test
    void jpql_courses_at_least_2_students() {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c where size(c.students) >= 2", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("result list2 {}", resultList);
    }

    @Test
    void jpql_courses_ordered_by_students() {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c order by size(c.students)", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("result list2 {}", resultList);
    }

    @Test
    void jpql_courses_ordered_desc_by_students() {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c order by size(c.students) desc", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("result list2 {}", resultList);
    }

    @Test
    void jpql_students_with_passports_in_a_certain_pattern() {
        TypedQuery<Student> query = entityManager.createQuery("select s from Student s where s.passport.number like '%12%'", Student.class);
        List<Student> resultList = query.getResultList();
        logger.info("result list2 {}", resultList);
    }

    @Test // courses with students only
    void join() {
        Query query = entityManager.createQuery("select c,s from Course c JOIN c.students s");
        List<Object[]> resultList = query.getResultList();
        logger.info("result list2 size {}", resultList.size());
        for (Object[] result : resultList){
            logger.info("coursee: {} student: {}", result[0], result[1]);
        }
    }

    @Test // all courses even without students
    void left_join() {
        Query query = entityManager.createQuery("select c,s from Course c LEFT JOIN c.students s");
        List<Object[]> resultList = query.getResultList();
        logger.info("result list2 size {}", resultList.size());
        for (Object[] result : resultList){
            logger.info("coursee: {} student: {}", result[0], result[1]);
        }
    }

    @Test
    void cross_join() {
        Query query = entityManager.createQuery("select c,s from Course c, Student s");
        List<Object[]> resultList = query.getResultList();
        logger.info("result list2 size {}", resultList.size());
        for (Object[] result : resultList){
            logger.info("coursee: {} student: {}", result[0], result[1]);
        }
    }
}
