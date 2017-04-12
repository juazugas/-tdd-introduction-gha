package com.agiletdd.application.service;

import com.agiletdd.application.domain.Product;

/**
 * Created by imasd on 12/4/17.
 */
public interface ProductService {


    Product saveProduct(String name, ProductType type, double price);
}
