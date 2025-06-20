package com.caleb.library.dto;

import com.caleb.library.entities.Course;
import com.caleb.library.entities.Department;
import com.caleb.library.entities.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseWithStudentsDTO {

    private Integer id;
    private String name;
    private Integer yearOfStudy;

    private List<StudentDTO> Students = new ArrayList<>();

    public CourseWithStudentsDTO(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public CourseWithStudentsDTO(Course entity){

        id = entity.getId();
        name = entity.getName();

        for (Student emp: entity.getStudents()){
            Students.add(new StudentDTO(emp));
        }
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<StudentDTO> getStudents() {
        return Students;
    }
}
