package com.caleb.library.entities.pk;

import com.caleb.library.entities.Course;
import com.caleb.library.entities.Person;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class StudentPK {

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person people;

    public StudentPK(){}

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Person getPerson() {
        return people;
    }

    public void setPerson(Person people) {
        this.people = people;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentPK studentPK = (StudentPK) o;
        return Objects.equals(course, studentPK.course) && Objects.equals(people, studentPK.people);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, people);
    }
}
