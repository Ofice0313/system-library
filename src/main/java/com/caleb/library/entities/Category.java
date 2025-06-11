package com.caleb.library.entities;

import com.caleb.library.entities.enuns.TypeCategory;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private TypeCategory typeCategory;

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Category(){

    }

    public Category(Integer id, TypeCategory typeCategory, Book book) {
        this.id = id;
        this.typeCategory = typeCategory;
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TypeCategory getTypeCategory() {
        return typeCategory;
    }

    public void setTypeCategory(TypeCategory typeCategory) {
        this.typeCategory = typeCategory;
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
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
