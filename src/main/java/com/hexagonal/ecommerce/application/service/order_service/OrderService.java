package com.hexagonal.ecommerce.application.service.order_service;

import com.hexagonal.ecommerce.application.dto.OrderDTO;
import com.hexagonal.ecommerce.domain.models.Order;
import com.hexagonal.ecommerce.infrastructure.adapters.costumer_repository.CostumerRepositoryDB;
import com.hexagonal.ecommerce.infrastructure.adapters.order_repository.OrderRepositoryDB;
import com.hexagonal.ecommerce.infrastructure.adapters.product_repository.ProductRepositoryDB;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService{

    private final OrderRepositoryDB repositoryDB;
    private final CostumerRepositoryDB costumerRepositoryDB;
    private final ProductRepositoryDB productRepositoryDB;

    public OrderService(OrderRepositoryDB repositoryDB, CostumerRepositoryDB costumerRepositoryDB,
                        ProductRepositoryDB productRepositoryDB) {
        this.repositoryDB = repositoryDB;
        this.costumerRepositoryDB = costumerRepositoryDB;
        this.productRepositoryDB = productRepositoryDB;
    }


    @Override
    public Order create(OrderDTO orderDto) {
        Order order = new Order();
        order.setCostumer(costumerRepositoryDB.getOneCostumer(orderDto.getCostumer()).get());
        order.setProducts(productRepositoryDB.getOne(orderDto.getProducts()).get());
        order.setTotalPrice(orderDto.getTotalPrice());
        order.setDateBuy(orderDto.getDateBuy());
        repositoryDB.create(order);
        return order;
    }

    @Override
    public List<Order> getAll() {
        return repositoryDB.getAll();
    }

    @Override
    public Optional<Order> getOne(Long id) {
        return Optional.of(repositoryDB.getOne(id))
                .orElseThrow();
    }

    @Override
    public Optional<Order> update(Long id, OrderDTO orderDTO) {
        return null; /*Optional.of(repositoryDB.update(id,mapper.toOrder(orderDTO)))
                .orElseThrow();*/
    }

    @Override
    public Boolean delete(Long id) {
        return repositoryDB.delete(id);
    }
}
