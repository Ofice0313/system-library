package com.caleb.library.dto;

import com.caleb.library.entities.Author;
import com.caleb.library.entities.Book;

import java.util.ArrayList;
import java.util.List;

public class BookPublisherAuthorDTO {

    private Integer id;
    private String title;
    private String isbn;
    private String cdu;
    private String language;
    private String caption;
    private String matter;
    private String countryPublished;
    private int yearOfEdition;

    private PublisherDTO publisher;

    private List<AuthorDTO> authors = new ArrayList<>();

    public BookPublisherAuthorDTO(){}

    public BookPublisherAuthorDTO(Integer id, String title, String isbn, String cdu, String language, String caption, String matter, String countryPublished, int yearOfEdition, PublisherDTO publisher) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.cdu = cdu;
        this.language = language;
        this.caption = caption;
        this.matter = matter;
        this.countryPublished = countryPublished;
        this.yearOfEdition = yearOfEdition;
        this.publisher = publisher;
    }

    public BookPublisherAuthorDTO(Book entity) {
        id = entity.getId();
        title = entity.getTitle();
        isbn = entity.getIsbn();
        cdu = entity.getCdu();
        language = entity.getLanguage();
        caption = entity.getCaption();
        matter = entity.getMatter();
        countryPublished = entity.getCountryPublished();
        yearOfEdition = entity.getYearOfEdition();
        publisher = new PublisherDTO(entity.getPublisher());

        for (Author author: entity.getAuthors()){
            authors.add(new AuthorDTO(author));
        }

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

    public PublisherDTO getPublisher() {
        return publisher;
    }

    public List<AuthorDTO> getAuthors() {
        return authors;
    }
}
