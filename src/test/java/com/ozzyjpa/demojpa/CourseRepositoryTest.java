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

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class CourseRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    void findById_basic() {
        Course course = courseRepository.findById(3);
        assertEquals("3.derss",course.getName());
    }

    @Test
    @DirtiesContext
        // after test run spring reverts db changes
    void deleteById_basic() {
        courseRepository.deleteById(19);
        assertNull(courseRepository.findById(19));
        //assertTrue(courseRepository.findById(18).isDeleted());
    }

    @Test
    @DirtiesContext // after test run spring reverts db changes
    void insert_basic() {
        Course course = new Course("en yeni dersim");
        courseRepository.save(course);
        assertEquals("en yeni dersim", courseRepository.findById(course.getId()).getName());
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

    @Test
    @DirtiesContext // after test run spring reverts db changes
    void addHardCodedReviewsForCourse_test() {
        courseRepository.addHardCodedReviewsForCourse();
    }

    @Test
    @DirtiesContext // after test run spring reverts db changes
    void addReviewsForCourse_test() {
        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review("greato", "5"));
        reviews.add(new Review("greatoo", "5"));
        reviews.add(new Review("greatooo", "5"));
        courseRepository.addReviewsForCourse(13L, reviews);
    }

    @Test
    void retrieveReviewsForCourse() {
        Course course = courseRepository.findById(10L);
        logger.info("all reviews {}", course.getReviews());
    }

    @Test
    @Transactional
    void retrieveCourseForReview() {
        Review review = entityManager.find(Review.class, 30001L);
        logger.info("course {}", review.getCourse());
    }

    @Test
    @Transactional
    // if we put transactional on the test
    // after querying the same course the result will be read from cache
    // and it will not query the same thing
    // to efficiently use first level cache
    // transaction should be in the service layer
    void findByIdFirstLevelCacheDemo() {
        Course course = courseRepository.findById(10L);
        logger.info("first course retrieved {}", course);

        Course course1 = courseRepository.findById(10L);
        logger.info("first course retrieved again {}", course1);
    }
}
