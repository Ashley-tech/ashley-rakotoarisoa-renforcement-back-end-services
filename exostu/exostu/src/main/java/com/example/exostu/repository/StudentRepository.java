package com.example.exostu.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.exostu.document.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
    /*@SuppressWarnings("null")
    @Override
    List<Student> findAll();
    Student findById(ObjectId object_id);*/
}