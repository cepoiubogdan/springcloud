package com.spring.tutorial.springsecurity.service;

import com.spring.tutorial.springsecurity.model.Course;
import com.spring.tutorial.springsecurity.model.Student;
import com.spring.tutorial.springsecurity.model.request.InsertCourseRequest;
import com.spring.tutorial.springsecurity.model.response.InsertCourseResponse;
import com.spring.tutorial.springsecurity.repository.CourseRepository;
import com.spring.tutorial.springsecurity.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentsRepository studentsRepository;

    public InsertCourseResponse save(InsertCourseRequest request){
        try {
            Student student=studentsRepository.findById(request.getStudentId()).orElseThrow(RuntimeException::new);
            courseRepository.save(new Course(request.getName()));
            return new InsertCourseResponse("OK","OK");
        }
        catch (RuntimeException e){
            return new InsertCourseResponse("ERROR","Student not found");
        }
        catch (Exception e){
            return new InsertCourseResponse("ERROR","Invalid course data");
        }

    }
}
