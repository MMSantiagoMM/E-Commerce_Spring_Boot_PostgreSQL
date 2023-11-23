package com.hexagonal.ecommerce.domain.ports;

import com.hexagonal.ecommerce.domain.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Product create(Product product);
    List<Product> getAll();
    Optional<Product> getOne(Long id);
    Optional<Product> update(Long id, Product product);
    Optional<Product> updateByField(Long id, Product product);
    Boolean delete(Long id);

}
