package com.spring.tutorial.springsecurity.repository;

import com.spring.tutorial.springsecurity.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepository  extends JpaRepository<Student,Integer> {
     List<Student> findByCoursesId(Integer id);
}
