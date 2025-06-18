package com.caleb.library.dto;

import com.caleb.library.entities.Person;

public class PersonDTO {

    private Integer id;
    private String name;
    private String phone ;
    private String email;

    public PersonDTO(){}

    public PersonDTO(Integer id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public PersonDTO(Person person) {
        id = person.getId();
        name = person.getName();
        phone = person.getPhone();
        email = person.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
