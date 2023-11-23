package com.hexagonal.ecommerce.infrastructure.adapters.product_repository;

import com.hexagonal.ecommerce.infrastructure.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepositoryDB extends JpaRepository<ProductEntity,Long> {
}
