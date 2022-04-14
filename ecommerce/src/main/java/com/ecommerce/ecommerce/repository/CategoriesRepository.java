package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
}
