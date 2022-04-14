package com.ecommerce.ecommerce.DTO;

import com.ecommerce.ecommerce.entities.Categories;

public class CategoriesDTO {


    private Integer id;
    private String name;

    public CategoriesDTO() {
    }

    public CategoriesDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoriesDTO(Categories categories) {
        id = categories.getId();
        name = categories.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
