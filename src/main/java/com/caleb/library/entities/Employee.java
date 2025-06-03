package com.caleb.library.entities;

import com.caleb.library.entities.enuns.TypeEmployee;
import com.caleb.library.entities.pk.EmployeePK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_employee")
public class Employee {

    @EmbeddedId
    private EmployeePK id = new EmployeePK();

    private String name;
    private TypeEmployee typeEmployee;

    public Employee(){}

    public Employee(Department department, Person person, String name, TypeEmployee typeEmployee) {
        id.setDepartment(department);
        id.setPerson(person);
        this.name = name;
        this.typeEmployee = typeEmployee;
    }

    public Department getDepartment(){
        return id.getDepartment();
    }

    public void setDepartment(Department department){
        id.setDepartment(department);
    }

    public Person getPerson(){
        return id.getPerson();
    }

    public void setPerson(Person person){
        id.setPerson(person);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeEmployee getTypeEmployee() {
        return typeEmployee;
    }

    public void setTypeEmployee(TypeEmployee typeEmployee) {
        this.typeEmployee = typeEmployee;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
