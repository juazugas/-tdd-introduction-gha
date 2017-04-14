package com.agiletdd.framework.restcontroller;

/**
 * Created by imasd on 14/4/17.
 */
public class CreateProductRequest {

    private String name;
    private String type;
    private double price;

    public CreateProductRequest() {}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
