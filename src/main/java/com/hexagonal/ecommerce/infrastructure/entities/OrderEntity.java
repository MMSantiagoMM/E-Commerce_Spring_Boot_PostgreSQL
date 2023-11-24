package com.hexagonal.ecommerce.infrastructure.entities;


import com.hexagonal.ecommerce.domain.models.Product;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "costumer_fk")
    private CostumerEntity costumer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "products_id")
    private List<Product> products;

    private Double totalPrice;
    private LocalDate dateBuy;

    public OrderEntity() {
    }

    public OrderEntity(Long id, CostumerEntity costumer, List<Product> products, Double totalPrice, LocalDate dateBuy) {
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

    public CostumerEntity getCostumer() {
        return costumer;
    }

    public void setCostumer(CostumerEntity costumer) {
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
