package com.spring.tutorial.springsecurity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class Grade {
    private String name;
    private float grade;
}
