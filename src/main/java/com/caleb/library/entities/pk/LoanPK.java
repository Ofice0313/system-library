package com.caleb.library.entities.pk;

import com.caleb.library.entities.Book;
import com.caleb.library.entities.Person;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class LoanPK {

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public LoanPK(){}

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LoanPK loanPK = (LoanPK) o;
        return Objects.equals(person, loanPK.person) && Objects.equals(book, loanPK.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, book);
    }
}
