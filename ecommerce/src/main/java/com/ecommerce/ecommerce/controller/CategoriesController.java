package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.DTO.CategoriesDTO;
import com.ecommerce.ecommerce.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    private CategoriesService categoryService;

    // BUSCAR TODOS OS PRODUTOS
    @GetMapping
    public ResponseEntity<Page<CategoriesDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "3") Integer size){
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<CategoriesDTO> list = categoryService.buscarTodos(pageRequest);
        return ResponseEntity.ok().body(list);
    }

    // BUSCAR PRODUTOS POR ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriesDTO> findById(@PathVariable Integer id) throws Exception {
        CategoriesDTO obj = categoryService.buscarPorId(id);
        return ResponseEntity.ok().body(obj);
    }

    // DELETAR POR ID
    @DeleteMapping("/{id}")
    public ResponseEntity<CategoriesDTO> delete(@PathVariable Integer id){
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // INSERIR
    @PostMapping
    public ResponseEntity<CategoriesDTO> insert(@RequestBody CategoriesDTO dto){
        dto = categoryService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(dto.getId()).toUri(); // Busca o caminho do registro criado
        return ResponseEntity.created(uri).body(dto);
    }

    // ALTERAR
    @PutMapping("/{id}")                        // <-- Pega o id que chega na varivael
    public ResponseEntity<CategoriesDTO> update(@PathVariable Integer id, CategoriesDTO dto){
        dto = categoryService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }
}
