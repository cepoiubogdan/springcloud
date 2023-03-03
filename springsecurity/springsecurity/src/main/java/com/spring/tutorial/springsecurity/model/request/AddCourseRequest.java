package com.spring.tutorial.springsecurity.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddCourseRequest {
    private Integer studentId;
    private Integer courseId;
}
