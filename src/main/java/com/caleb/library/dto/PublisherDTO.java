package com.caleb.library.dto;

import com.caleb.library.entities.Publisher;

public class PublisherDTO {

    private Integer id;
    private String name;
    private String contact;
    private String site;

    public PublisherDTO(){}

    public PublisherDTO(Integer id, String name, String contact, String site) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.site = site;
    }

    public PublisherDTO(Publisher entity) {
        id = entity.getId();
        name = entity.getName();
        contact = entity.getContact();
        site = entity.getSite();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getSite() {
        return site;
    }
}
