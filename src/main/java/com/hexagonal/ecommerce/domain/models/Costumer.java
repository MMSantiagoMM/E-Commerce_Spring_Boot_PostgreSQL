package com.hexagonal.ecommerce.domain.models;

public class Costumer {

    private Long id;
    private String name;
    private String document;
    private String telephone;

    public Costumer() {
    }

    public Costumer(Long id, String name, String document, String telephone) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.telephone = telephone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
