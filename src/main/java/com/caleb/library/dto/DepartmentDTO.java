package com.caleb.library.dto;

import com.caleb.library.entities.Author;
import com.caleb.library.entities.Department;

import java.time.Instant;

public class DepartmentDTO {

    private Integer id;
    private String name;

    public DepartmentDTO(){}

    public DepartmentDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public DepartmentDTO(Department entity) {
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
