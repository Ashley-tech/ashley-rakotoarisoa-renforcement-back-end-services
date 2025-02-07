package com.example.exostu.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.exostu.repository.StudentRepository;

@Component
public class DataSender {

    @Bean
    CommandLineRunner initDatabase(StudentRepository studentRepository) {
        return args -> {
            //studentRepository.save(new Student(null, "Ashley", "23", "M", 2L));
        };
    }
}
