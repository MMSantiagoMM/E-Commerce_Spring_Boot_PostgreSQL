package com.hexagonal.ecommerce.infrastructure.adapters.order_repository;

import com.hexagonal.ecommerce.domain.models.Order;
import com.hexagonal.ecommerce.domain.ports.OrderRepository;
import com.hexagonal.ecommerce.infrastructure.adapters.costumer_repository.CostumerRepositoryDB;
import com.hexagonal.ecommerce.infrastructure.adapters.costumer_repository.ICostumerRepositoryDB;
import com.hexagonal.ecommerce.infrastructure.adapters.product_repository.IProductRepositoryDB;
import com.hexagonal.ecommerce.infrastructure.adapters.product_repository.ProductRepositoryDB;
import com.hexagonal.ecommerce.infrastructure.entities.OrderEntity;
import com.hexagonal.ecommerce.infrastructure.exceptions.OrderNotFoundException;
import com.hexagonal.ecommerce.infrastructure.mapper.ICostumerMapper;
import com.hexagonal.ecommerce.infrastructure.mapper.IOrderMapper;
import com.hexagonal.ecommerce.infrastructure.mapper.IProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepositoryDB implements OrderRepository {

    private final IOrderRepository orderRepository;
    private final CostumerRepositoryDB costumerRepositoryDB;
    private final ProductRepositoryDB productRepositoryDB;
    private final IOrderMapper mapper;
    private final IProductMapper productMapper;
    private final ICostumerMapper costumerMapper;
    private final ICostumerRepositoryDB iCostumerRepositoryDB;
    private final IProductRepositoryDB iProductRepositoryDB;

    public OrderRepositoryDB(IOrderRepository orderRepository,
                             CostumerRepositoryDB costumerRepositoryDB, ProductRepositoryDB productRepositoryDB, IOrderMapper mapper, IProductMapper productMapper, ICostumerMapper costumerMapper, ICostumerRepositoryDB iCostumerRepositoryDB, IProductRepositoryDB iProductRepositoryDB) {
        this.orderRepository = orderRepository;
        this.costumerRepositoryDB = costumerRepositoryDB;
        this.productRepositoryDB = productRepositoryDB;
        this.mapper = mapper;
        this.productMapper = productMapper;
        this.costumerMapper = costumerMapper;
        this.iCostumerRepositoryDB = iCostumerRepositoryDB;
        this.iProductRepositoryDB = iProductRepositoryDB;
    }


    @Override
    public Order create(Order order) {
        //orderRepository.save(mapper.toEntity(order));
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCostumer(iCostumerRepositoryDB.findById(
                order.getCostumer().getId()
        ).get());

        orderEntity.setProducts(iProductRepositoryDB.findById(
                order.getProducts().getId()
        ).get());
        /*orderEntity.setProducts(productMapper.toEntity(
                productRepositoryDB.getOne(order.getProducts().getId())
                        .get()
        ));*/
        orderEntity.setTotalPrice(order.getTotalPrice());
        orderEntity.setDateBuy(order.getDateBuy());
        orderRepository.save(orderEntity);
        System.out.println("Helloooooooooooooooooo");
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
        return null;
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
