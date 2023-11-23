package com.hexagonal.ecommerce.infrastructure.adapters.costumer_repository;

import com.hexagonal.ecommerce.domain.models.Costumer;
import com.hexagonal.ecommerce.domain.ports.CostumerRepository;
import com.hexagonal.ecommerce.infrastructure.exceptions.CostumerNotFoundException;
import com.hexagonal.ecommerce.infrastructure.mapper.ICostumerMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CostumerRepositoryDB implements CostumerRepository {

    private final ICostumerRepositoryDB repositoryDB;
    private final ICostumerMapper mapper;

    public CostumerRepositoryDB(ICostumerRepositoryDB repositoryDB, ICostumerMapper mapper) {
        this.repositoryDB = repositoryDB;
        this.mapper = mapper;
    }


    @Override
    public Costumer create(Costumer costumer) {
        repositoryDB.save(mapper.toCostumerEntity(costumer));
        return costumer;
    }

    @Override
    public List<Costumer> getAllCostumers() {
        return mapper.toCostumers(repositoryDB.findAll());
    }

    @Override
    public Optional<Costumer> getOneCostumer(Long id) {
        return Optional.of(mapper.toCostumer(repositoryDB.findById(id)
                .orElseThrow(()-> new CostumerNotFoundException(id))));
    }

    @Override
    public Optional<Costumer> updateCostumer(Long id, Costumer costumer) {
        return Optional.of(repositoryDB.findById(id)
                .map(costumer2 -> {
                    costumer2.setName(costumer.getName());
                    costumer2.setDocument(costumer.getDocument());
                    costumer2.setTelephone(costumer.getTelephone());
                    return mapper.toCostumer(repositoryDB.save(costumer2));
                }).orElseThrow(()-> new CostumerNotFoundException(id)));
    }

    @Override
    public Optional<Costumer> updatedByFieldCostumer(Long id, Costumer costumer) {
        return null;
    }

    @Override
    public Boolean deleteCostumer(Long id) {
        if(repositoryDB.existsById(id)){
            repositoryDB.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
