package com.hexagonal.ecommerce.infrastructure.adapters;

import com.hexagonal.ecommerce.infrastructure.entities.CostumerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICostumerRepository extends JpaRepository<CostumerEntity,Long> {
}
