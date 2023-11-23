package com.hexagonal.ecommerce.domain.models;

import java.time.LocalDate;
import java.util.List;

public class Order {

    private Long id;
    private Costumer costumer;
    private List<Product> products;
    private Double totalPrice;
    private LocalDate dateBuy;

    public Order() {
    }

    public Order(Long id, Costumer costumer, List<Product> products, Double totalPrice, LocalDate dateBuy) {
        this.id = id;
        this.costumer = costumer;
        this.products = products;
        this.totalPrice = totalPrice;
        this.dateBuy = dateBuy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
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
