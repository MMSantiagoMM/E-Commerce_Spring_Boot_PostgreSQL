package com.hexagonal.ecommerce.application.mapper;


import com.hexagonal.ecommerce.application.dto.CostumerDTO;
import com.hexagonal.ecommerce.domain.models.Costumer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CostumerMapper {

    CostumerMapper INSTANCE = Mappers.getMapper(CostumerMapper.class);

    Costumer toCostumer (CostumerDTO costumerDTO);
    CostumerDTO toDTO (Costumer costumer);



}
