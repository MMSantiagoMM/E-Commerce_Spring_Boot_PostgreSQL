package com.hexagonal.ecommerce.infrastructure.mapper;


import com.hexagonal.ecommerce.domain.models.Costumer;
import com.hexagonal.ecommerce.infrastructure.entities.CostumerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICostumerMapper {

    ICostumerMapper INSTANCE = Mappers.getMapper(ICostumerMapper.class);

    Costumer toCostumer (CostumerEntity costumerEntity);
    CostumerEntity toCostumerEntity(Costumer costumer);
    List<Costumer> toCostumers(List<CostumerEntity> costumers);

}
