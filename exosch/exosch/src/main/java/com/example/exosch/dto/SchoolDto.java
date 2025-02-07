package com.example.exosch.dto;

import lombok.Builder;

@Builder
public class SchoolDto {
    private Long id;
    private String name;
    private String adress;
    private String director;

    public SchoolDto(Long id, String name, String adress, String director) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.director = director;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getDirector() {
        return director;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
