package com.example.exostu.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.exostu.dto.SchoolDto;

@Service
public class SchoolService {
    private final RestTemplate restTemplate;

    @Value("${school.service.url}") // Mets l'URL de ton microservice School dans application.properties
    private String schoolServiceUrl;

    public SchoolService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public SchoolDto getSchoolById(String schoolId) {
        String url = "http://127.0.0.1:8080/" + "schools/" + schoolId;
        return restTemplate.getForObject(url, SchoolDto.class);
    }
}