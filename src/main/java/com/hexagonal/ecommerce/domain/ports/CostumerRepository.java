package com.hexagonal.ecommerce.domain.ports;

import com.hexagonal.ecommerce.application.dto.CostumerDTO;
import com.hexagonal.ecommerce.domain.models.Costumer;

import java.util.List;
import java.util.Optional;

public interface CostumerRepository {

    Costumer create(Costumer costumer);
    List<Costumer> getAllCostumers();
    Optional<Costumer> getOneCostumer(Long id);
    Optional<Costumer> updateCostumer(Long id, Costumer costumer);
    Optional<Costumer> updatedByFieldCostumer(Long id, Costumer costumer);
    Boolean deleteCostumer(Long id);
}
