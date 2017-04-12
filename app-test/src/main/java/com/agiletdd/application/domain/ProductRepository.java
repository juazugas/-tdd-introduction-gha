package com.agiletdd.application.domain;

import java.util.List;

/**
 * Created by imasd on 12/4/17.
 */
public interface ProductRepository {
    Product save(Product product);

    List<Product> findAll();
}
