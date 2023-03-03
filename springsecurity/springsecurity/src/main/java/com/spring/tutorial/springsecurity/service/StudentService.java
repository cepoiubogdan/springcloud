package com.spring.tutorial.springsecurity.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.tutorial.springsecurity.model.Course;
import com.spring.tutorial.springsecurity.model.Student;
import com.spring.tutorial.springsecurity.model.exception.CourseException;
import com.spring.tutorial.springsecurity.model.exception.StudentException;
import com.spring.tutorial.springsecurity.model.request.AddCourseRequest;
import com.spring.tutorial.springsecurity.model.response.AddCourseResponse;
import com.spring.tutorial.springsecurity.repository.CourseRepository;
import com.spring.tutorial.springsecurity.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentsRepository studentsRepository;
    @Autowired
    CourseRepository courseRepository;

    public List<Student> getAllStudents(){
        return studentsRepository.findAll();
    }
    public AddCourseResponse saveCourse(AddCourseRequest request){
        try {
            Student student = studentsRepository.findById(request.getStudentId()).orElseThrow(()->new StudentException("Could not fetch student"));
            Course course = courseRepository.findById(request.getCourseId()).orElseThrow(()->new CourseException("Could not fetch student"));
            student.getCourses().add(course);
            studentsRepository.save(student);
            return new AddCourseResponse("OK");
        }catch(RuntimeException e){
                return new AddCourseResponse(e.getMessage());
        }
        catch(Exception e){
            return new AddCourseResponse("Internal");
        }
    }
    public List<Student> findAllStudentsByCourseId(Integer courseId){
        return studentsRepository.findByCoursesId(courseId);
    }
}
