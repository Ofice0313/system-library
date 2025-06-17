package com.caleb.library.dto;

import com.caleb.library.entities.Category;
import com.caleb.library.entities.Publisher;
import com.caleb.library.entities.enuns.TypeCategory;

public class CategoryDTO {

    private Integer id;
    private TypeCategory typeCategory;

    public CategoryDTO(){}

    public CategoryDTO(Integer id, TypeCategory typeCategory) {
        this.id = id;
        this.typeCategory = typeCategory;
    }

    public CategoryDTO(Category entity) {
        id = entity.getId();
        typeCategory = entity.getTypeCategory();
    }

    public Integer getId() {
        return id;
    }

    public TypeCategory getTypeCategory() {
        return typeCategory;
    }
}
