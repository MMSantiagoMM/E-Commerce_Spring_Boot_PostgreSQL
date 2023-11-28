package com.hexagonal.ecommerce.infrastructure.controllers.order_controller;

import com.hexagonal.ecommerce.application.dto.OrderDTO;
import com.hexagonal.ecommerce.domain.models.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IOrderController {

    ResponseEntity<Order> create (OrderDTO orderDTO);

    ResponseEntity<List<Order>> getAll();

    ResponseEntity<Order> getOne(@PathVariable Long id);

    ResponseEntity<Order> update(@PathVariable Long id, @RequestBody OrderDTO orderDTO);

    ResponseEntity<Void> delete (@PathVariable Long id);



}
