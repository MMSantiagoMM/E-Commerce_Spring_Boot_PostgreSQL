package com.hexagonal.ecommerce.infrastructure.exceptions;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(Long id){
        super("Product with the id: " + id + " was not found");
    }
}
