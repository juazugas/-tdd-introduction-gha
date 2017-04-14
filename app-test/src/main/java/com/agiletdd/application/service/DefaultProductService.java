package com.agiletdd.application.service;

import com.agiletdd.application.domain.Product;
import com.agiletdd.application.domain.ProductRepository;

import java.util.List;

/**
 * Created by imasd on 12/4/17.
 */
public class DefaultProductService implements ProductService {

    ProductRepository productRepository;

    public DefaultProductService(ProductRepository productRepository) {

        this.productRepository = productRepository;

    }

    @Override
    public Product saveProduct(String name, ProductType type, double price) {

        return productRepository.save(new Product(name, type.name(),price));

    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updatePrice(Product product, double price) {
        product.setPrice(price);
        return productRepository.save(product);
    }


}
