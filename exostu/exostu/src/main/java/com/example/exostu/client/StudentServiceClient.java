package com.example.exostu.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.exostu.document.Student;

@FeignClient(name = "exostu")
public interface StudentServiceClient {
    @GetMapping("/{id}")
    Student getStudentById(@PathVariable("id") Long id);
}
