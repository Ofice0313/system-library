package com.caleb.library.repositories;

import com.caleb.library.entities.Employee;
import com.caleb.library.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
}
