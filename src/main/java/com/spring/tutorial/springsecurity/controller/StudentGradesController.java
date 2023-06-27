package com.spring.tutorial.springsecurity.controller;

import com.spring.tutorial.springsecurity.model.Grade;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/grades")
public class StudentGradesController {
    @Autowired
    RestTemplate restTemplate;

    public static final String GRADES_SERVICE="gradesService";

    private static final String BASEURL ="http://localhost:8090/grades/student-grades";

    @GetMapping("/student-grades")
    @CircuitBreaker(name=GRADES_SERVICE,fallbackMethod = "getGradesErrorResponse")
    public List<Grade> getStudentGrades(){
        return restTemplate.getForObject(BASEURL, ArrayList.class);
    }
    public List<Grade> getGradesErrorResponse(Exception e){
        List<Grade> grades=new ArrayList<>();
        grades.add(new Grade("template",10.0f));
        grades.add(new Grade("template",9.0f));
        return grades;
    }
}
