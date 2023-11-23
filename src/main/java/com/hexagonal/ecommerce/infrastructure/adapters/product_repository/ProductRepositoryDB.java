package com.hexagonal.ecommerce.infrastructure.adapters.product_repository;


import com.hexagonal.ecommerce.domain.models.Product;
import com.hexagonal.ecommerce.domain.ports.ProductRepository;
import com.hexagonal.ecommerce.infrastructure.exceptions.ProductNotFoundException;
import com.hexagonal.ecommerce.infrastructure.mapper.IProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryDB implements ProductRepository {

    private final IProductRepositoryDB repositoryDB;
    private final IProductMapper mapper;

    public ProductRepositoryDB(IProductRepositoryDB repositoryDB, IProductMapper mapper) {
        this.repositoryDB = repositoryDB;
        this.mapper = mapper;
    }

    @Override
    public Product create(Product product) {
        repositoryDB.save(mapper.toEntity(product));
        return product;
    }

    @Override
    public List<Product> getAll() {
        return mapper.toProducts(repositoryDB.findAll());
    }

    @Override
    public Optional<Product> getOne(Long id) {
        return Optional.of(mapper.toProduct(repositoryDB.findById(id)
                .orElseThrow(()-> new ProductNotFoundException(id))));
    }

    @Override
    public Optional<Product> update(Long id, Product product) {
        return Optional.of(repositoryDB.findById(id)
                .map(product2 -> {
                    product2.setName(product.getName());
                    product2.setDescription(product.getDescription());
                    product2.setPrice(product.getPrice());
                    return mapper.toProduct(repositoryDB.save(product2));
                }).orElseThrow(()-> new ProductNotFoundException(id)));
    }

    @Override
    public Optional<Product> updateByField(Long id, Product product) {
        return Optional.empty();
    }

    @Override
    public Boolean delete(Long id) {
        if(repositoryDB.existsById(id)){
            repositoryDB.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
