package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
}
