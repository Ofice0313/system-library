package com.caleb.library.dto;

import com.caleb.library.entities.Book;

public class BookDTO {

    private Integer id;
    private String title;
    private String ISBN;
    private String CDU;
    private String language;
    private String caption;
    private String matter;
    private String countryPublished;
    private int yearOfEdition;

    public BookDTO(Integer id, String title, String ISBN, String CDU, String language, String caption, String matter, String countryPublished, int yearOfEdition) {
        this.id = id;
        this.title = title;
        this.ISBN = ISBN;
        this.CDU = CDU;
        this.language = language;
        this.caption = caption;
        this.matter = matter;
        this.countryPublished = countryPublished;
        this.yearOfEdition = yearOfEdition;
    }

    public BookDTO(Book book) {
        id = book.getId();
        title = book.getTitle();
        ISBN = book.getISBN();
        CDU = book.getCDU();
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

    public String getISBN() {
        return ISBN;
    }

    public String getCDU() {
        return CDU;
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
