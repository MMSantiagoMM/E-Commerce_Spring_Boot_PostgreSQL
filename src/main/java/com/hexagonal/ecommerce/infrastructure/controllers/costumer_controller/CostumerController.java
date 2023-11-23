package com.hexagonal.ecommerce.infrastructure.controllers.costumer_controller;


import com.hexagonal.ecommerce.application.dto.CostumerDTO;
import com.hexagonal.ecommerce.application.service.customer_service.CostumerService;
import com.hexagonal.ecommerce.domain.models.Costumer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("costumers")
public class CostumerController implements ICostumerController {

    private final CostumerService service;


    public CostumerController(CostumerService service) {
        this.service = service;
    }


    @Override
    @PostMapping
    public ResponseEntity<Costumer> insert(CostumerDTO costumerDTO) {
        return new ResponseEntity<>(service.create(costumerDTO), HttpStatus.CREATED);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Costumer>> getAll() {
        return new ResponseEntity<>(service.getAllCostumers(),HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Costumer> getOne(Long id) {
        return service.getOneCostumer(id)
                .map(costumer -> new ResponseEntity<>(costumer,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Costumer> update(Long id, CostumerDTO costumer) {
        return service.updateCostumer(id,costumer)
                .map(costumer2 -> new ResponseEntity<>(costumer2,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<Costumer> updateByField(Long id, CostumerDTO costumer) {
        return null;
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        if(service.deleteCostumer(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
