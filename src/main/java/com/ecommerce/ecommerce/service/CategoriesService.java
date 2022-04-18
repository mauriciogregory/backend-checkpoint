package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.DTO.CategoriesDTO;
import com.ecommerce.ecommerce.entities.Categories;
import com.ecommerce.ecommerce.repository.CategoriesRepository;
import com.ecommerce.ecommerce.service.Exception.EntidadeNaoEncontrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    // GET
    public Page<CategoriesDTO> buscarTodos(Pageable pageable) {
        return categoriesRepository.findAll(pageable).map(CategoriesDTO::new);
    }

    // GET por id
    @Transactional(readOnly = true)
    public CategoriesDTO buscarPorId(Integer id){
        Optional<Categories> categoryOptional = categoriesRepository.findById(id);
        Categories categories = categoryOptional.orElseThrow(() ->
                new EntidadeNaoEncontrada("Entidade não encontrada!"));
        return new CategoriesDTO(categories);
    }

    // DELETE
    public void delete(Integer id){
        try {
            categoriesRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException emptyRes){
            throw new EntidadeNaoEncontrada("o ID " + id + " não foi encontrado!");
        }
        catch (DataIntegrityViolationException dataInt){
            throw new EntidadeNaoEncontrada("Exceção de Integridade do Banco!");
        }
    }

    // POST
    @Transactional
    public CategoriesDTO insert(CategoriesDTO dto){
        Categories entity = new Categories();
        entity.setName(dto.getName());
        entity = categoriesRepository.save(entity);
        return new CategoriesDTO(entity);
    }

    // PUT
    @Transactional
    public CategoriesDTO update(Integer id, CategoriesDTO dto){ // Recebe id do DTO
        try{
            Categories categorie = categoriesRepository.getById(id);
            categorie.setName(dto.getName());
            categorie = categoriesRepository.save(categorie);
            return new CategoriesDTO(categorie);
        }
        catch (EntidadeNaoEncontrada notFound){
            throw new EntidadeNaoEncontrada("O ID " + id + " não foi encontrado!");
        }
    }
}
