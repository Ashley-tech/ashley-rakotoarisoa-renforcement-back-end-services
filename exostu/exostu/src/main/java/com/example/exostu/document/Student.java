package com.example.exostu.document;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "students")
public class Student {
    @Id
    private ObjectId object_id;

    private String name;

    private String age;

    private String genre;

    private Long school_id;

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
}
