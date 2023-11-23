package com.hexagonal.ecommerce.application.service.product_service;

import com.hexagonal.ecommerce.application.dto.ProductDTO;
import com.hexagonal.ecommerce.application.mapper.ProductMapper;
import com.hexagonal.ecommerce.domain.models.Product;
import com.hexagonal.ecommerce.infrastructure.adapters.product_repository.ProductRepositoryDB;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{

    private final ProductRepositoryDB repositoryDB;
    private final ProductMapper mapper;

    public ProductService(ProductRepositoryDB repositoryDB, ProductMapper mapper) {
        this.repositoryDB = repositoryDB;
        this.mapper = mapper;
    }


    @Override
    public Product create(ProductDTO productDTO) {
        return repositoryDB.create(mapper.toProduct(productDTO));
    }

    @Override
    public List<Product> getAll() {
        return repositoryDB.getAll();
    }

    @Override
    public Optional<Product> getOne(Long id) {
        return repositoryDB.getOne(id);
    }

    @Override
    public Optional<Product> update(Long id, ProductDTO productDTO) {
        return repositoryDB.update(id,mapper.toProduct(productDTO));
    }

    @Override
    public Optional<Product> updateByField(Long id, ProductDTO productDTO) {
        return Optional.empty();
    }

    @Override
    public Boolean delete(Long id) {
        return repositoryDB.delete(id);
    }
}
