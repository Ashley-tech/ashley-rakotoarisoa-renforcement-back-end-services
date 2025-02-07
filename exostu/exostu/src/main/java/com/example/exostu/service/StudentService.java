package com.example.exostu.service;

import org.springframework.stereotype.Service;

import com.example.exostu.repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
