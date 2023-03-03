package com.spring.tutorial.springsecurity.controller;


import com.spring.tutorial.springsecurity.model.Student;
import com.spring.tutorial.springsecurity.model.request.AddCourseRequest;
import com.spring.tutorial.springsecurity.model.response.AddCourseResponse;
import com.spring.tutorial.springsecurity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping("/all")
    public List<Student> getStudent(){
        return studentService.getAllStudents();
    }
    @PostMapping("/addCourse")
    public AddCourseResponse addCourse(@RequestBody AddCourseRequest request ){
        return studentService.saveCourse(request);
    }

    @GetMapping("/students/{courseId}")
    public List<Student> findByCourseId(@PathVariable("courseId") Integer courseId){
        return studentService.findAllStudentsByCourseId(courseId);
    }

}
