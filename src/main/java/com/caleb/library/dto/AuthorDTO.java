package com.caleb.library.dto;

import com.caleb.library.entities.Author;
import jakarta.persistence.Column;

import java.time.Instant;

public class AuthorDTO {

    private Integer id;
    private String name;
    private String nationality;
    private Instant dateOfBirth;

    public AuthorDTO(){}

    public AuthorDTO(Integer id, String name, String nationality, Instant dateOfBirth) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
    }

    public AuthorDTO(Author entity) {
        id = entity.getId();
        name = entity.getName();
        nationality = entity.getNationality();
        dateOfBirth = entity.getDateOfBirth();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public Instant getDateOfBirth() {
        return dateOfBirth;
    }
}
