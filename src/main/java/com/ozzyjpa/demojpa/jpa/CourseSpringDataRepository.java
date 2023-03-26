package com.ozzyjpa.demojpa.jpa;

import com.ozzyjpa.demojpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
    List<Course> findByName(String name);
    List<Course> deleteByName(String name);
    List<Course> findByNameOrderByIdDesc(String name);
    List<Course> findByNameAndId(String name, Long id);
    Long countByName(String name);

    @Query("Select c from Course c where c.name like '%ders%'")
    List<Course> findLikeDers();

    @Query(value = "Select * from Course where name like '%ders%'", nativeQuery = true)
    List<Course> findLikeDersNativeQuery();

    @Query(name = "query_get_ders")
    List<Course> findLikeDersUsingNamedQuery();

}
