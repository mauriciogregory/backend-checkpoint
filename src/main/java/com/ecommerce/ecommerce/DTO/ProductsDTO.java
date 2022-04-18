package com.ecommerce.ecommerce.DTO;

import com.ecommerce.ecommerce.entities.Categories;
import com.ecommerce.ecommerce.entities.Products;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductsDTO {

    private Integer id;
    private String title;
    private String description;
    private Double price;
    private String image;

    private List<CategoriesDTO> categories = new ArrayList<>(); // Lista de categorias

    public ProductsDTO() {
    }

    public ProductsDTO(Integer id, String title, String description, Double price, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public ProductsDTO(Products entity) {
        id = entity.getId();
        title = entity.getTitle();
        description = entity.getDescription();
        price = entity.getPrice();
        image = entity.getImage();
    }

    // Recebe a entidade, mais as categorias, pra cada categoria adicionada, cria um DTO
    public ProductsDTO(Products product, Set<Categories> categorie){
        this(product);
        categorie.forEach(item -> this.categories.add(new CategoriesDTO(item)));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<CategoriesDTO> getCategories() {
        return categories;
    }

}