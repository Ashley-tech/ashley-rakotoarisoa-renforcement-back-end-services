package com.example.exostu.dto;

import org.bson.types.ObjectId;
import lombok.Builder;

@Builder
public class StudentDto {
    private ObjectId object_id;
    private String name;
    private String age;
    private String genre;
    private SchoolDto school;

    public StudentDto(ObjectId object_id, String name, String age, String genre, SchoolDto school) {
        this.object_id = object_id;
        this.name = name;
        this.age = age;
        this.genre = genre;
        this.school = school;
    }

    public ObjectId getId() {
        return object_id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getGenre() {
        return genre;
    }

    public SchoolDto getSchool() {
        return school;
    }

    public void setSchool(SchoolDto school) {
        this.school= school;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
