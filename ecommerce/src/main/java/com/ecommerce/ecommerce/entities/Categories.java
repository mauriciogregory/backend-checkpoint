package com.ecommerce.ecommerce.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table
public class Categories implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Integer id;
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Products> products = new HashSet<>();

    public Categories() {
    }

    public Categories(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Categories(String name) {
        this.name = name;
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