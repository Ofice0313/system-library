package com.caleb.library.entities;

import com.caleb.library.entities.enuns.LoanStatus;
import com.caleb.library.entities.pk.LoanPK;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_loan")
public class Loan {

    @EmbeddedId
    private LoanPK id = new LoanPK();
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dateLoan;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant returnDate;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dateReturned;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant renew;
    private String observations;

    private LoanStatus status;

    public Loan(){}

    public Loan(Person person, Book book, Instant dateLoan, Instant returnDate, Instant dateReturned, Instant renew, String observations, LoanStatus status) {
        id.setPerson(person);
        id.setBook(book);
        this.dateLoan = dateLoan;
        this.returnDate = returnDate;
        this.dateReturned = dateReturned;
        this.renew = renew;
        this.observations = observations;
        this.status = status;
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

    public Instant getDateLoan() {
        return dateLoan;
    }

    public void setDateLoan(Instant dateLoan) {
        this.dateLoan = dateLoan;
    }

    public Instant getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Instant returnDate) {
        this.returnDate = returnDate;
    }

    public Instant getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(Instant dateReturned) {
        this.dateReturned = dateReturned;
    }

    public Instant getRenew() {
        return renew;
    }

    public void setRenew(Instant renew) {
        this.renew = renew;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
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
