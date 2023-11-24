package com.hexagonal.ecommerce.domain.ports;

import com.hexagonal.ecommerce.domain.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    Order create(Order order);
    List<Order> getAll();
    Optional<Order> getOne(Long id);
    Optional<Order> update(Long id, Order order);
    Boolean delete (Long id);
}
