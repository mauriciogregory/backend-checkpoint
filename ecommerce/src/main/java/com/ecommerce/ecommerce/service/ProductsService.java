package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.DTO.ProductsDTO;
import com.ecommerce.ecommerce.entities.Products;
import com.ecommerce.ecommerce.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productRepository;

    // GET
    @Transactional(readOnly = true)
    public Page<ProductsDTO> buscarTodos(PageRequest pageRequest){
        Page<Products> result = productRepository.findAll(pageRequest);
        return result.map(product -> new ProductsDTO(product));
}

// GET BY ID
    @Transactional(readOnly = true)
    public ProductsDTO buscarPorId(Integer id){
        Optional<Products> products = productRepository.findById(id);
        Products entity = products.get();
        return new ProductsDTO(entity);
    }

// PUT - TO REVIEW
    @Transactional
    public ProductsDTO insert(ProductsDTO dto) {
        Products entity = new Products();
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImage(dto.getImage());
        entity = productRepository.save(entity);
        return new ProductsDTO(entity);
    }
}
