package com.hexagonal.ecommerce.infrastructure.controllers;

import com.hexagonal.ecommerce.application.dto.CostumerDTO;
import com.hexagonal.ecommerce.domain.models.Costumer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ICostumerController {

    ResponseEntity<Costumer> insert (@RequestBody CostumerDTO costumerDTO);
    ResponseEntity<List<Costumer>> getAll();
    ResponseEntity<Costumer> getOne(@PathVariable Long id);
    ResponseEntity<Costumer> update(@PathVariable Long id, @RequestBody CostumerDTO costumer);
    ResponseEntity<Costumer> updateByField(@PathVariable Long id, @RequestBody CostumerDTO costumer);
    ResponseEntity<Void> delete(@PathVariable Long id);

}
