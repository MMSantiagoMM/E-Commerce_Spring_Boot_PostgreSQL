package com.hexagonal.ecommerce.infrastructure.exceptions;

public class CostumerNotFoundException extends RuntimeException{
    public CostumerNotFoundException(Long id){
        super("Costumer with the id: " + id + " was not found");
    }
}
