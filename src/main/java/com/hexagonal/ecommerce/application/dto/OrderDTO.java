package com.hexagonal.ecommerce.application.dto;

import java.time.LocalDate;
import java.util.List;

public class OrderDTO {

    private Long costumer;
    private Long products;
    private Double totalPrice;
    private LocalDate dateBuy;

    public OrderDTO() {
    }

    public OrderDTO(Long costumer,Long products, Double totalPrice, LocalDate dateBuy) {
        this.costumer = costumer;
        this.products = products;
        this.totalPrice = totalPrice;
        this.dateBuy = dateBuy;
    }

    public Long getCostumer() {
        return costumer;
    }

    public void setCostumer(Long costumer) {
        this.costumer = costumer;
    }

    public Long getProducts() {
        return products;
    }

    public void setProducts(Long products) {
        this.products = products;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(LocalDate dateBuy) {
        this.dateBuy = dateBuy;
    }
}
