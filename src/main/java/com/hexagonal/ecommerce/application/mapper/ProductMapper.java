package com.hexagonal.ecommerce.application.mapper;


import com.hexagonal.ecommerce.application.dto.ProductDTO;
import com.hexagonal.ecommerce.domain.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO toDto(Product product);
    Product toProduct(ProductDTO productDTO);
}
