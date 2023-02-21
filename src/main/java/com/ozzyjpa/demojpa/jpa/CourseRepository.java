package com.ozzyjpa.demojpa.jpa;

import com.ozzyjpa.demojpa.entity.Course;
import com.ozzyjpa.demojpa.entity.Person;
import com.ozzyjpa.demojpa.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional // so that db operations are not left unfinished
public class CourseRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    public Course findById(long id){
        return entityManager.find(Course.class, id);
    }

    //insert or update
    public Course save(Course course){
        if(course.getId() == null){ // insert
            entityManager.persist(course);
        }
        else { // update
            entityManager.merge(course);
        }
        return course;
    }

    public void deleteById(int id) {
        Course course = findById(id);
        entityManager.remove(course);
    }

    public void playEM(){
// LESSON-1 course_updated ismi ile kaydedilir entityManager.merge() vs yapmaya gerek yok
        Course course1 = new Course("course gamze final1");
        entityManager.persist(course1);
        Course course2 = new Course("course angular4 final2");
        entityManager.persist(course2);

        entityManager.flush();
        //entityManager.detach(course2); // entity manager does not track course2 anymore
        //entityManager.clear(); // detachs everything from entity manager

        course1.setName("course gamze_updated final 1");
        course2.setName("course angular4_updated final 2");

        entityManager.refresh(course2); // after entityManager.flush(); changes on course2 discarded
        entityManager.flush();
    }

    public void addHardCodedReviewsForCourse() {
        Course course = findById(10L);
        logger.info("all reviews : {}", course.getReviews());

        Review review1 = new Review("greattt", "5");
        Review review2 = new Review("not that great", "2");

        course.addReview(review1);
        review1.setCourse(course);

        course.addReview(review2);
        review2.setCourse(course);

        entityManager.persist(review1);
        entityManager.persist(review2);

        logger.info("all reviews : {}", course.getReviews());

    }

    public void addReviewsForCourse(Long courseId, List<Review> reviews) {
        Course course = findById(courseId);
        logger.info("all reviews : {}", course.getReviews());

        for(Review review: reviews) {
            course.addReview(review);
            review.setCourse(course);
            entityManager.persist(review);
        }
    }
}
