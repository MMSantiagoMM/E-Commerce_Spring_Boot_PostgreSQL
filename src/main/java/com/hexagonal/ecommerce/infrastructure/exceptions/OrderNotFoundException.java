package com.hexagonal.ecommerce.infrastructure.exceptions;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(Long id){
        super("Order with the id: " + id + " was not found");
    }
}
