package com.caleb.library.dto;

import com.caleb.library.entities.Department;
import com.caleb.library.entities.Employee;

import java.util.ArrayList;
import java.util.List;

public class DepartmentWithEmployeesDTO {

    private Integer id;
    private String name;

    private List<EmployeeDTO> employees = new ArrayList<>();

    public DepartmentWithEmployeesDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public DepartmentWithEmployeesDTO(Department entity){
        id = entity.getId();
        name = entity.getName();

        for (Employee emp: entity.getEmployees()){
            employees.add(new EmployeeDTO(emp));
        }
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }
}
