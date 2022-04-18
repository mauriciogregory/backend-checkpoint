package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.DTO.CategoriesDTO;
import com.ecommerce.ecommerce.DTO.ProductsDTO;
import com.ecommerce.ecommerce.entities.Categories;
import com.ecommerce.ecommerce.entities.Products;
import com.ecommerce.ecommerce.repository.CategoriesRepository;
import com.ecommerce.ecommerce.repository.ProductsRepository;
import com.ecommerce.ecommerce.service.Exception.BDexcecao;
import com.ecommerce.ecommerce.service.Exception.EntidadeNaoEncontrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productRepository;

    @Autowired
    private CategoriesRepository categoriesRepository;

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
        //Products entity = products.get();
        Products entity = products.orElseThrow(() -> new EntidadeNaoEncontrada("Não encontrado!"));
        return new ProductsDTO(entity, entity.getCategories());
    }

    private void copyToEntity(ProductsDTO dto, Products entity){
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImage(dto.getImage());
        entity.getCategories().clear(); // certifica que não há nada em categories
        for (CategoriesDTO categoriesDTO : dto.getCategories()){
            Categories categories = categoriesRepository.getById(categoriesDTO.getId());
            entity.getCategories().add(categories);
        }
    }
// PUT
    @Transactional
    public ProductsDTO insert(ProductsDTO dto) {
        Products entity = new Products();
        copyToEntity(dto, entity);
        entity = productRepository.save(entity);
        return new ProductsDTO(entity);
    }

    // UPDATE
    @Transactional
    public ProductsDTO update(Integer id, ProductsDTO dto){
        try {
            Products entity = productRepository.getById(id.intValue());
            copyToEntity(dto, entity);
            entity = productRepository.save(entity);
            return new ProductsDTO(entity);
        }
        catch (EntityNotFoundException exception){
            throw new EntidadeNaoEncontrada("O ID " + id + " não foi encontrado.");
        }
    }

    // DELETE
    public void delete(Integer id){
        try {
            productRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException exception){
            throw  new EntidadeNaoEncontrada("O ID " + id + " não foi encontrado.");
        }
        catch (DataIntegrityViolationException exception2){
            throw new BDexcecao("Violação de integridade do banco!");
        }
    }
}
