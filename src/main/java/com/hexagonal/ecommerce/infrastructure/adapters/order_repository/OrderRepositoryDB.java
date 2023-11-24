package com.hexagonal.ecommerce.infrastructure.adapters.order_repository;

import com.hexagonal.ecommerce.domain.models.Order;
import com.hexagonal.ecommerce.domain.ports.OrderRepository;
import com.hexagonal.ecommerce.infrastructure.adapters.costumer_repository.ICostumerRepositoryDB;
import com.hexagonal.ecommerce.infrastructure.adapters.product_repository.IProductRepositoryDB;
import com.hexagonal.ecommerce.infrastructure.exceptions.OrderNotFoundException;
import com.hexagonal.ecommerce.infrastructure.exceptions.ProductNotFoundException;
import com.hexagonal.ecommerce.infrastructure.mapper.IOrderMapper;

import java.util.List;
import java.util.Optional;

public class OrderRepositoryDB implements OrderRepository {

    private final IOrderRepository orderRepository;
    private final ICostumerRepositoryDB costumerRepositoryDB;
    private final IProductRepositoryDB productRepositoryDB;
    private final IOrderMapper mapper;

    public OrderRepositoryDB(IOrderRepository orderRepository, ICostumerRepositoryDB costumerRepositoryDB, IProductRepositoryDB productRepositoryDB, IOrderMapper mapper) {
        this.orderRepository = orderRepository;
        this.costumerRepositoryDB = costumerRepositoryDB;
        this.productRepositoryDB = productRepositoryDB;
        this.mapper = mapper;
    }


    @Override
    public Order create(Order order) {
        orderRepository.save(mapper.toEntity(order));
        return order;
    }

    @Override
    public List<Order> getAll() {
        return mapper.toOrders(orderRepository.findAll());
    }

    @Override
    public Optional<Order> getOne(Long id) {
        return Optional.of(mapper.toOrder(orderRepository.findById(id)
                .orElseThrow(()-> new OrderNotFoundException(id))));
    }

    @Override
    public Optional<Order> update(Long id, Order order) {
        return Optional.of(orderRepository.findById(id)
                .map(order2 -> {
                    order2.setCostumer(costumerRepositoryDB.
                            findById(order.getCostumer().getId()).get());
                    //order2.setProducts(productRepositoryDB.findById(order.getProducts()).get());
                    order2.setTotalPrice(order.getTotalPrice());
                    order2.getDateBuy();
                    return mapper.toOrder(orderRepository.findById(id).get());
                }).orElseThrow(()-> new ProductNotFoundException(id)));
    }

    @Override
    public Boolean delete(Long id) {
        if(orderRepository.existsById(id)){
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
