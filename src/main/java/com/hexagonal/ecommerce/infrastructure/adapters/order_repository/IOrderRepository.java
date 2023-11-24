package com.hexagonal.ecommerce.infrastructure.adapters.order_repository;

import com.hexagonal.ecommerce.infrastructure.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<OrderEntity,Long> {
}
