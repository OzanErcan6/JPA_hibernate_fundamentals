package com.ozzyjpa.demojpa;


import com.ozzyjpa.demojpa.entity.Course;
import com.ozzyjpa.demojpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;


@SpringBootTest
public class CriteriaQueryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    @Test
    void basic() {
        // "select c from Course c"
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> courseRoot = cq.from(Course.class);

        TypedQuery<Course> query = entityManager.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Result: {}", resultList);
    }

    @Test
    void all_courses_contain_course() {
        //select * from course where name like 'course%';
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> courseRoot = cq.from(Course.class);
        Predicate likeCourse = cb.like(courseRoot.get("name"), "course%");
        cq.where(likeCourse);

        TypedQuery<Course> query = entityManager.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Result: {}", resultList);
    }

    @Test
    void all_courses_without_student() {
        //select c from course c where c.student is empty;
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> courseRoot = cq.from(Course.class);
        Predicate studentsIsEmpty = cb.isEmpty(courseRoot.get("students"));
        cq.where(studentsIsEmpty);

        TypedQuery<Course> query = entityManager.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Result: {}", resultList);
    }

    @Test
    void join() {
        //select c from course c join c.student s;
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> courseRoot = cq.from(Course.class);
        Join<Object,Object> join = courseRoot.join("students");

        TypedQuery<Course> query = entityManager.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Result: {}", resultList);
    }

    @Test
    void left_join() {
        //select c from course c join c.student s;
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> courseRoot = cq.from(Course.class);
        Join<Object,Object> join = courseRoot.join("students", JoinType.LEFT);

        TypedQuery<Course> query = entityManager.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Result: {}", resultList);
    }

}
