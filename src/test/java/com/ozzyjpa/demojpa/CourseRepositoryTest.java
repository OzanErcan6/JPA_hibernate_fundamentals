package com.ozzyjpa.demojpa;

import com.ozzyjpa.demojpa.entity.Course;
import com.ozzyjpa.demojpa.jpa.CourseRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class CourseRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepository;

    @Test
    void findById_basic() {
        Course course = courseRepository.findById(3);
        assertEquals("3.derss",course.getName());
    }

    @Test
    @DirtiesContext
        // after test run spring reverts db changes
    void deleteById_basic() {
        courseRepository.deleteById(15);
        assertNull(courseRepository.findById(15));
    }

    @Test
    @DirtiesContext // after test run spring reverts db changes
    void insert_basic() {
        Course course = new Course("yeni.ders");
        courseRepository.save(course);
        assertEquals("yeni.ders", courseRepository.findById(16).getName());
    }

    @Test
    @DirtiesContext // after test run spring reverts db changes
    void update_basic() {
        Course course = courseRepository.findById(13);
        assertEquals("gamzee2e3",course.getName());
        course.setName("3.derss");
        courseRepository.save(course);
        assertEquals("3.derss", courseRepository.findById(3).getName());
    }

    @Test
    @DirtiesContext // after test run spring reverts db changes
    void playEM_test() {
        courseRepository.playEM();
    }
}
