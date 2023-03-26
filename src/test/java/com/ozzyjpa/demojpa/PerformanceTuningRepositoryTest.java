package com.ozzyjpa.demojpa;

import com.ozzyjpa.demojpa.entity.Course;
import com.ozzyjpa.demojpa.entity.Review;
import com.ozzyjpa.demojpa.jpa.CourseRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest
public class PerformanceTuningRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional
    void creatingOnePlusOneProblem() {
        List<Course> courses = entityManager.createNamedQuery("query_get_all_courses",Course.class).getResultList();

        for (Course course: courses){
            logger.info("Courses {} Students {}", course, course.getStudents());
        }
    }

    @Test
    @Transactional
    void solvingOnePlusOneProblem() {
        EntityGraph<Course> entityGraph = entityManager.createEntityGraph(Course.class);
        entityGraph.addSubgraph("students");

        List<Course> courses = entityManager.createNamedQuery("query_get_all_courses",Course.class)
                .setHint("javax.persistence.loadgraph", entityGraph)
                .getResultList();

        for (Course course: courses){
            logger.info("Courses {} Students {}", course, course.getStudents());
        }
    }

    @Test
    @Transactional
    void solvingOnePlusOneProblemUsingJoinFetch() {
        List<Course> courses = entityManager.createNamedQuery("query_get_all_courses_join_fetch",Course.class).getResultList();

        for (Course course: courses){
            logger.info("Courses {} Students {}", course, course.getStudents());
        }
    }



}
