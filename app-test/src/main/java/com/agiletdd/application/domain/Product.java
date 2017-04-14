package com.agiletdd.application.domain;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

/**
 * Created by imasd on 12/4/17.
 */
@Entity
@Table
@Access(AccessType.FIELD)
public class Product {

    private static final int MIN_NAME_LENGTH = 4;

    @Id
    private UUID id;

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private double price;

    @Column(name="creation_date")
    private Instant creationInstant;

    public Product() { /*no-op constructor*/}

    public Product(String name, String type, double price){

        if (name.length() < MIN_NAME_LENGTH)
            throw new InvalidProductParameterException("Name must be greater than 3");

        this.id = UUID.randomUUID();
        this.name = name;
        this.type = type;
        this.creationInstant = Instant.now();
        this.setPrice(price);
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

    public void setPrice(double price) {
        if (price<=0) {
            throw new InvalidProductParameterException("price must be greater than 0");
        }

        this.price = price;
    }
}
