package com.ozzyjpa.demojpa;

import com.ozzyjpa.demojpa.entity.Course;
import com.ozzyjpa.demojpa.jpa.CourseRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

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

}
