package com.caleb.library.dto;

import com.caleb.library.entities.Employee;
import com.caleb.library.entities.enuns.TypeEmployee;

public class EmployeeDTO {

    private String name;
    private TypeEmployee typeEmployee;

    private Integer personId;
    private String personName;
    private String personPhone;
    private String personEmail;

    public EmployeeDTO(String name, TypeEmployee typeEmployee, Integer personId, String personName, String personPhone, String personEmail) {
        this.name = name;
        this.typeEmployee = typeEmployee;
        this.personId = personId;
        this.personName = personName;
        this.personPhone = personPhone;
        this.personEmail = personEmail;
    }

    public EmployeeDTO(Employee employee){
        name = employee.getName();
        typeEmployee = employee.getTypeEmployee();
        personId = employee.getPerson().getId();
        personName = employee.getPerson().getName();
        personEmail = employee.getPerson().getEmail();
        personPhone = employee.getPerson().getPhone();
    }

    public String getName() {
        return name;
    }

    public TypeEmployee getTypeEmployee() {
        return typeEmployee;
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
