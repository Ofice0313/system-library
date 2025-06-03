package com.caleb.library.entities;

import com.caleb.library.entities.pk.StudentPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_student")
public class Student {

    @EmbeddedId
    private StudentPK id = new StudentPK();

    private int yearOfStudy;

    public Student(){}

    public Student(Course course, Person person, int yearOfStudy) {
        id.setCourse(course);
        id.setPerson(person);
        this.yearOfStudy = yearOfStudy;
    }

    public Course getCourse(){
        return id.getCourse();
    }

    public void setCourse(Course course){
        id.setCourse(course);
    }

    public Person getPerson(){
        return id.getPerson();
    }

    public void setPerson(Person person){
        id.setPerson(person);
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
