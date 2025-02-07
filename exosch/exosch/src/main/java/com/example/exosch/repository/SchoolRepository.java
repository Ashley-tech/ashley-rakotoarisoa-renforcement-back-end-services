package com.example.exosch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exosch.entity.School;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
