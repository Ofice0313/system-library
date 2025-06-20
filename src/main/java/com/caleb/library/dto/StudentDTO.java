package com.caleb.library.dto;

import com.caleb.library.entities.Student;

public class StudentDTO {

    private Integer yearOfStudent;

    private Integer personId;
    private String personName;
    private String personPhone;
    private String personEmail;

    public StudentDTO(Integer yearOfStudent, Integer personId, String personName, String personPhone, String personEmail) {
        this.yearOfStudent = yearOfStudent;
        this.personId = personId;
        this.personName = personName;
        this.personPhone = personPhone;
        this.personEmail = personEmail;
    }

    public StudentDTO(Student student){
        yearOfStudent = student.getYearOfStudy();
        personId = student.getPerson().getId();
        personName = student.getPerson().getName();
        personEmail = student.getPerson().getEmail();
        personPhone = student.getPerson().getPhone();
    }

    public Integer getPersonId() {
        return personId;
    }

    public String getPersonName() {
        return personName;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public String getPersonEmail() {
        return personEmail;
    }
}
