package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.DTO.CategoriesDTO;
import com.ecommerce.ecommerce.DTO.ProductsDTO;
import com.ecommerce.ecommerce.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import java.net.URI;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productService;


    // Buscar Todos
    @GetMapping
    public ResponseEntity<Page<ProductsDTO>> findAll(@RequestParam( value = "page", defaultValue = "0") Integer page,
                                                     @RequestParam(value = "size", defaultValue = "5") Integer size){

        PageRequest pageRequest = PageRequest.of(page, size);
        Page<ProductsDTO> productDTOS = productService.buscarTodos(pageRequest);
        return ResponseEntity.ok(productDTOS);
    }

    // Buscar todos por id
    @GetMapping("/{id}")
    public ResponseEntity<ProductsDTO> findById(@PathVariable Integer id){
        ProductsDTO obj = productService.buscarPorId(id);
        return ResponseEntity.ok().body(obj);
    }

    // Inserir produto
    @PostMapping
    public ResponseEntity<ProductsDTO> insert(@RequestBody ProductsDTO dto){
        dto = productService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    // Alterar produto
    @PutMapping("/{id}")
    public ResponseEntity<ProductsDTO> update (@PathVariable Integer id, @RequestBody ProductsDTO dto){
        dto = productService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    // Deletar produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Integer id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
