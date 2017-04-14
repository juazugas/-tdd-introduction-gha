package com.agiletdd.framework.persistence;

import com.agiletdd.application.domain.Product;
import com.agiletdd.application.domain.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by imasd on 13/4/17.
 */
@Repository
public interface JpaProductRepository extends ProductRepository, JpaRepository<Product, String>{

}
