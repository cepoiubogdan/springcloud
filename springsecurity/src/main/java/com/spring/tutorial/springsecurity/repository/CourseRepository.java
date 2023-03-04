package com.spring.tutorial.springsecurity.repository;

import com.spring.tutorial.springsecurity.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}
