package com.hexagonal.ecommerce.infrastructure.controllers.product_controller;

import com.hexagonal.ecommerce.application.dto.ProductDTO;
import com.hexagonal.ecommerce.domain.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IProductController {
    @PostMapping
    ResponseEntity<Product> create(@RequestBody ProductDTO productDTO);

    @GetMapping
    ResponseEntity<List<Product>> getAll();

    @GetMapping("/{id}")
    ResponseEntity<Product> getOne (@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<Product> update(@PathVariable Long id,
                                   @RequestBody ProductDTO productDTO);

    @PatchMapping("/{id}")
    ResponseEntity<Product> updateByField(@PathVariable Long id,
                                          @RequestBody ProductDTO productDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);


}
