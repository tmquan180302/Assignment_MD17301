package com.example.assignment_md17301.model;

public class Product {
    private String id;
    private String name;
    private String type;
    private String condition;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getLifespan() {
        return lifespan;
    }

    public void setLifespan(String lifespan) {
        this.lifespan = lifespan;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Product(String id, String name, String type, String condition, String lifespan, Integer price, String detail, String seller) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.condition = condition;
        this.lifespan = lifespan;
        this.price = price;
        this.detail = detail;
        this.seller = seller;
    }

    private String lifespan;
    private Integer price;
    private String detail;
    private String seller;

}
