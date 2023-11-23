package com.hexagonal.ecommerce.infrastructure.mapper;


import com.hexagonal.ecommerce.domain.models.Product;
import com.hexagonal.ecommerce.infrastructure.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductMapper {

    IProductMapper INSTANCE = Mappers.getMapper(IProductMapper.class);

    ProductEntity toEntity(Product product);
    Product toProduct (ProductEntity productEntity);
    List<Product> toProducts (List<ProductEntity> productEntityList);
}
