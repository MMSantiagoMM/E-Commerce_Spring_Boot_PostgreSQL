package com.hexagonal.ecommerce.application.service.customer_service;

import com.hexagonal.ecommerce.application.dto.CostumerDTO;
import com.hexagonal.ecommerce.domain.models.Costumer;

import java.util.List;
import java.util.Optional;

public interface ICostumerService {

    Costumer create(CostumerDTO costumerDTO);
    List<Costumer> getAllCostumers();
    Optional<Costumer> getOneCostumer(Long id);
    Optional<Costumer> updateCostumer(Long id, CostumerDTO costumerDTO);
    Optional<Costumer> updatedByFieldCostumer(Long id, CostumerDTO costumerDTO);
    Boolean deleteCostumer(Long id);
}
