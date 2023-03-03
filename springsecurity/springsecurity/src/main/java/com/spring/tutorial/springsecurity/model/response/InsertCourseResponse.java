package com.spring.tutorial.springsecurity.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InsertCourseResponse {
    private String status;
    private String statusMessage;
}
