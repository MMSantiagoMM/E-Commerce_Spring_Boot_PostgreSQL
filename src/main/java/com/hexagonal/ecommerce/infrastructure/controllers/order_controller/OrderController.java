package com.hexagonal.ecommerce.infrastructure.controllers.order_controller;

import com.hexagonal.ecommerce.application.dto.OrderDTO;
import com.hexagonal.ecommerce.application.service.order_service.OrderService;
import com.hexagonal.ecommerce.domain.models.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController implements IOrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }



    @Override
    @PostMapping
    public ResponseEntity<Order> create(OrderDTO orderDTO) {
        return new ResponseEntity<>(service.create(orderDTO), HttpStatus.CREATED);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Order>> getAll() {
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Order> getOne(Long id) {
        return service.getOne(id)
                .map(order -> new ResponseEntity<>(order,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Order> update(Long id, OrderDTO orderDTO) {
        return service.update(id, orderDTO)
                .map(order -> new ResponseEntity<>(order,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(Long id) {
        if(service.delete(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
