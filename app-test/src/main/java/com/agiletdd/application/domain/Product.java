package com.agiletdd.application.domain;

import java.time.Instant;
import java.util.UUID;

/**
 * Created by imasd on 12/4/17.
 */
public class Product {

    private static final int MIN_NAME_LENGTH = 4;

    private final UUID id;
    private String name;
    private String type;
    private double price;
    private Instant creationInstant;

    public Product(String name, String type, double price){

        if (name.length() < MIN_NAME_LENGTH)
            throw new InvalidUserParameterException("Name must be greater than 3");

        if (price<=0) {
            throw new InvalidUserParameterException("price must be greater than 0");
        }

        this.id = UUID.randomUUID();
        this.name = name;
        this.type = type;
        this.price = price;
        this.creationInstant = Instant.now();

    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public Instant getCreationInstant() {
        return creationInstant;
    }
}
