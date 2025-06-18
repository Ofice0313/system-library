package com.caleb.library.dto;

import com.caleb.library.entities.Course;

public class CourseDTO {

    private Integer id;
    private String name;

    public CourseDTO(){}

    public CourseDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CourseDTO(Course entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
