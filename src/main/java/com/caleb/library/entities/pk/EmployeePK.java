package com.caleb.library.entities.pk;

import com.caleb.library.entities.Department;
import com.caleb.library.entities.Person;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class EmployeePK {

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public EmployeePK(){}

    public EmployeePK(Department department, Person person) {
        this.department = department;
        this.person = person;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EmployeePK that = (EmployeePK) o;
        return Objects.equals(department, that.department) && Objects.equals(person, that.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(department, person);
    }
}
