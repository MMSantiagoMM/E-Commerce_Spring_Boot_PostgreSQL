package com.hexagonal.ecommerce.application.service.product_service;

import com.hexagonal.ecommerce.application.dto.ProductDTO;
import com.hexagonal.ecommerce.domain.models.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    Product create (ProductDTO productDTO);
    List<Product> getAll();
    Optional<Product> getOne(Long id);
    Optional<Product> update(Long id, ProductDTO productDTO);
    Optional<Product> updateByField(Long id, ProductDTO productDTO);
    Boolean delete(Long id);



}
