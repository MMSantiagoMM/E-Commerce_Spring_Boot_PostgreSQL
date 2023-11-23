package com.hexagonal.ecommerce.infrastructure.controllers.product_controller;

import com.hexagonal.ecommerce.application.dto.ProductDTO;
import com.hexagonal.ecommerce.application.service.product_service.ProductService;
import com.hexagonal.ecommerce.domain.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController implements IProductController{


    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }


    @Override
    public ResponseEntity<Product> create(ProductDTO productDTO) {
        return new ResponseEntity<>(service.create(productDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Product> getOne(Long id) {
        return service.getOne(id).map(product ->
                        new ResponseEntity<>(product,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<Product> update(Long id, ProductDTO productDTO) {
        return service.update(id,productDTO)
                .map(product -> new ResponseEntity<>(product,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.OK));
    }

    @Override
    public ResponseEntity<Product> updateByField(Long id, ProductDTO productDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        if(service.delete(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
