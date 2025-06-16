package com.caleb.library.dto;

import com.caleb.library.entities.Book;

public class BookDTO {

    private Integer id;
    private String title;
    private String isbn;
    private String cdu;
    private String language;
    private String caption;
    private String matter;
    private String countryPublished;
    private int yearOfEdition;


    public BookDTO(Integer id, String title, String isbn, String cdu, String language, String caption, String matter, String countryPublished, int yearOfEdition) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.cdu = cdu;
        this.language = language;
        this.caption = caption;
        this.matter = matter;
        this.countryPublished = countryPublished;
        this.yearOfEdition = yearOfEdition;
    }

    public BookDTO(Book book) {
        id = book.getId();
        title = book.getTitle();
        isbn = book.getIsbn();
        cdu = book.getCdu();
        language = book.getLanguage();
        caption = book.getCaption();
        matter = book.getMatter();
        countryPublished = book.getCountryPublished();
        yearOfEdition = book.getYearOfEdition();
    }

    public BookDTO(){

    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getCdu() {
        return cdu;
    }

    public String getLanguage() {
        return language;
    }

    public String getCaption() {
        return caption;
    }

    public String getMatter() {
        return matter;
    }

    public String getCountryPublished() {
        return countryPublished;
    }

    public int getYearOfEdition() {
        return yearOfEdition;
    }
}
