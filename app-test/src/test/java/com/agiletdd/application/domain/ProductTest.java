package com.agiletdd.application.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.*;

/**
 * Created by imasd on 13/4/17.
 */
public class ProductTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void should_be_created_with_valid_parameters () {
        Product product = new Product("product", "type", 1.0);

        assertNotNull(product);
        assertThat(product, hasProperty("name", equalTo("product")));
        assertNotNull(product.getId());
        assertThat(product, hasProperty("price", greaterThan(0.0)));
    }

    @Test(expected = InvalidProductParameterException.class)
    public void should_not_create_product_with_invalid_name() {
        new Product("na", null, 0);
    }

    @Test(expected = InvalidProductParameterException.class)
    public void should_not_create_product_with_invalid_price() {
        new Product("name", null, -1);
    }

}