package com.hexagonal.ecommerce.application.service;

import com.hexagonal.ecommerce.application.dto.CostumerDTO;
import com.hexagonal.ecommerce.application.mapper.CostumerMapper;
import com.hexagonal.ecommerce.domain.models.Costumer;
import com.hexagonal.ecommerce.infrastructure.adapters.CostumerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostumerService implements ICostumerService {

    private final CostumerRepository repository;
    private final CostumerMapper mapper;

    public CostumerService(CostumerRepository repository, CostumerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public Costumer create(CostumerDTO costumerDTO) {
        return repository.create(mapper.toCostumer(costumerDTO));
    }

    @Override
    public List<Costumer> getAllCostumers() {
        return repository.getAllCostumers();
    }

    @Override
    public Optional<Costumer> getOneCostumer(Long id) {
        return repository.getOneCostumer(id);
    }

    @Override
    public Optional<Costumer> updateCostumer(Long id, CostumerDTO costumerDTO) {
        return repository.updateCostumer(id,mapper.toCostumer(costumerDTO));
    }

    @Override
    public Optional<Costumer> updatedByFieldCostumer(Long id, CostumerDTO costumerDTO) {
        return Optional.empty();
    }

    @Override
    public Boolean deleteCostumer(Long id) {
        return repository.deleteCostumer(id);
    }
}
