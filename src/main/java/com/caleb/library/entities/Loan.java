package com.caleb.library.entities;

import com.caleb.library.entities.pk.LoanPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_loan")
public class Loan {

    @EmbeddedId
    private LoanPK id = new LoanPK();

    private LocalDate dateLoan;
    private LocalDate returnDate;
    private LocalDate dateReturned;
    private LocalDate renew;
    private String observations;

    public Loan(){}

    public Loan(Person person, Book book, LocalDate dateLoan, LocalDate returnDate, LocalDate dateReturned, LocalDate renew, String observations) {
        id.setPerson(person);
        id.setBook(book);
        this.dateLoan = dateLoan;
        this.returnDate = returnDate;
        this.dateReturned = dateReturned;
        this.renew = renew;
        this.observations = observations;
    }

    public Person getPerson(){
        return id.getPerson();
    }

    public void setPerson(Person person){
        id.setPerson(person);
    }

    public Book getBook(){
        return id.getBook();
    }

    public void setBook(Book book){
        id.setBook(book);
    }

    public LocalDate getDateLoan() {
        return dateLoan;
    }

    public void setDateLoan(LocalDate dateLoan) {
        this.dateLoan = dateLoan;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDate getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(LocalDate dateReturned) {
        this.dateReturned = dateReturned;
    }

    public LocalDate getRenew() {
        return renew;
    }

    public void setRenew(LocalDate renew) {
        this.renew = renew;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return Objects.equals(id, loan.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
