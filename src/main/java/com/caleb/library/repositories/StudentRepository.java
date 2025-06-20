package com.caleb.library.repositories;

import com.caleb.library.entities.Employee;
import com.caleb.library.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
