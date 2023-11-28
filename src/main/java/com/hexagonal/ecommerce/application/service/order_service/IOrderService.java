package com.hexagonal.ecommerce.application.service.order_service;

import com.hexagonal.ecommerce.application.dto.OrderDTO;
import com.hexagonal.ecommerce.domain.models.Order;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

import java.util.List;
import java.util.Optional;

public interface IOrderService {

    Order create(OrderDTO order);

    List<Order> getAll();

    Optional<Order> getOne(Long id);

    Optional<Order>update(Long id, OrderDTO orderDTO);

    Boolean delete(Long id);
}
