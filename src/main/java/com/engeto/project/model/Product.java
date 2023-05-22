package com.engeto.project.model;

import java.math.BigDecimal;

public class Product {

    private int id;
    private int partNo;
    private String name;
    private String description;
    private boolean isForSale;
    private BigDecimal price;

    public Product(int id,int partNo, String name, String description, boolean isForSale, BigDecimal price) {
        this.id = id;
        this.partNo = partNo;
        this.name = name;
        this.description = description;
        this.isForSale = isForSale;
        this.price = price;
    }

    public Product() {

    }

    // Getters/Setters

    public int getPartNo() {
        return partNo;
    }

    public void setPartNo(int partNo) {
        this.partNo = partNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getisForSale() {

        return isForSale;
    }
    public void setisForSale(boolean isForSale) {

        this.isForSale = isForSale;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
