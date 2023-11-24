package com.hexagonal.ecommerce.infrastructure.mapper;


import com.hexagonal.ecommerce.domain.models.Order;
import com.hexagonal.ecommerce.infrastructure.entities.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IOrderMapper {

    IOrderMapper INSTANCE = Mappers.getMapper(IOrderMapper.class);

    Order toOrder(OrderEntity orderEntity);
    List<Order> toOrders(List<OrderEntity> orderEntities);
    OrderEntity toEntity(Order order);
}
