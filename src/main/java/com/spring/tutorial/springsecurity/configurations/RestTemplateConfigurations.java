package com.spring.tutorial.springsecurity.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfigurations {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
