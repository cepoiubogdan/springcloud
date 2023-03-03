package com.spring.tutorial.springsecurity.controller;

import com.spring.tutorial.springsecurity.auth.AuthenticationResponse;
import com.spring.tutorial.springsecurity.model.request.InsertCourseRequest;
import com.spring.tutorial.springsecurity.model.response.InsertCourseResponse;
import com.spring.tutorial.springsecurity.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/course")
public class CourseController {
    @Autowired
    CourseService courseService;
    @PostMapping("save")
    public ResponseEntity<InsertCourseResponse> saveCourse(@RequestBody InsertCourseRequest request){
        return ResponseEntity.ok(courseService.save(request));
    }
}
