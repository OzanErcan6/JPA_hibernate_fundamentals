package com.ozzyjpa.demojpa;

import com.ozzyjpa.demojpa.entity.Course;
import com.ozzyjpa.demojpa.entity.Review;
import com.ozzyjpa.demojpa.jpa.CourseRepository;
import com.ozzyjpa.demojpa.jpa.CourseSpringDataRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.domain.Sort.Direction.DESC;


@SpringBootTest
public class CourseSpringDataRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseSpringDataRepository courseRepository;

    @Test
    void findById_course_present() {
        Optional<Course> courseOptional = courseRepository.findById(10L);
        assertTrue(courseOptional.isPresent());
        logger.info("{}", courseOptional.isPresent());
    }

    @Test
    void findById_course_not_present() {
        Optional<Course> courseOptional = courseRepository.findById(1L);
        assertFalse(courseOptional.isPresent());
        logger.info("{}", courseOptional.isPresent());
    }


    @Test
    void create_and_update_spring_data_repository() {
        Course newCourse = new Course("my latest microservice course");
        courseRepository.save(newCourse);

        newCourse.setName("my latest microservice course-updated");
        courseRepository.save(newCourse);
    }

    @Test
    void find_all_spring_data_repository() {
        logger.info("all courses: {}", courseRepository.findAll());
        logger.info("course count: {}", courseRepository.count());
    }

    @Test
    void sort() {
        logger.info("all courses: {}", courseRepository.findAll(Sort.by(Sort.Direction.DESC, "name")));
        logger.info("course count: {}", courseRepository.count());
    }

    @Test
    void pagination() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<Course> firstPage = courseRepository.findAll(pageRequest);
        logger.info("all courses: {}", firstPage.getContent());

        //iterate pages
        //Pageable secondPageable = firstPage.nextPageable();
        //Page<Course> secondPage = courseRepository.findAll(secondPageable);
    }

    @Test
    void findUsingName() {
        logger.info("all courses: {}", courseRepository.findByName("course_updated"));
        logger.info("all courses sorted: {}", courseRepository.findByNameOrderByIdDesc("course_updated"));
        logger.info("all courses with id: {}", courseRepository.findByNameAndId("course_updated",18L));
        logger.info("all courses count: {}", courseRepository.countByName("course_updated"));
    }

}
