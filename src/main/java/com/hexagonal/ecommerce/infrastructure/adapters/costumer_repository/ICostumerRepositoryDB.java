package com.hexagonal.ecommerce.infrastructure.adapters.costumer_repository;

import com.hexagonal.ecommerce.infrastructure.entities.CostumerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICostumerRepositoryDB extends JpaRepository<CostumerEntity,Long> {
}
