package com.example.exosch.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.exosch.entity.School;

@FeignClient(name = "exosch")
public interface SchoolServiceClient {
    @GetMapping("/{id}")
    School getSchoolById(@PathVariable("id") Long id);
}
