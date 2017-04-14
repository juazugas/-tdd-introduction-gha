package com.agiletdd.framework.restcontroller;

/**
 * Created by imasd on 14/4/17.
 */
public class CreateProductRequest {

    private String name;
    private String type;
    private double price;

    public CreateProductRequest() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
