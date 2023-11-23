package com.hexagonal.ecommerce.application.dto;

public class CostumerDTO {

    private String name;
    private String document;
    private String telephone;

    public CostumerDTO() {
    }

    public CostumerDTO(String name, String document, String telephone) {
        this.name = name;
        this.document = document;
        this.telephone = telephone;
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
