package com.agiletdd.application.service;

import com.agiletdd.application.domain.Product;

import java.util.List;

/**
 * Created by imasd on 12/4/17.
 */
public interface ProductService {


    Product saveProduct(String name, ProductType type, double price);

    List<Product> findAllProducts();

    Product updatePrice(Product product, double price);
}
