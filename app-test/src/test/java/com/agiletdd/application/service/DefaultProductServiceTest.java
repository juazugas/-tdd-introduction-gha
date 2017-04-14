package com.agiletdd.application.service;

import com.agiletdd.application.domain.Product;
import com.agiletdd.application.domain.ProductRepository;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.agiletdd.application.service.ProductType.TYPE_1;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

/**
 * Created by imasd on 12/4/17.
 */
public class DefaultProductServiceTest {

    ProductService productService;
    ProductRepository productRepository;

    @Before
    public void setUp() {
        productRepository = mock(ProductRepository.class);
        productService = new DefaultProductService(productRepository);
    }

    @Test
    public void should_register_new_products() {
        Product product;
        _given:
        {
            doAnswer(invocation -> invocation.getArguments()[0])
                    .when(productRepository).save(any(Product.class));
        }

        _when:
        {
            product = productService.saveProduct("product", TYPE_1, 1.0);
        }

        _then:
        {
            assertNotNull(product);
            assertNotNull(product.getId());
            assertThat(product, hasProperty("name", equalTo("product")));
        }
    }

    @Test
    public void should_list_all_products() {
        List<Product> products = null;
        _given:
        {
            Product product1 = new Product("product1", "TYPE_1", 1.0);
            Product product2 = new Product("product2", "TYPE_1", 2.0);
            doReturn(Arrays.asList(product1, product2))
                    .when(productRepository).findAll();
        }

        _when:
        {
            products = productService.findAllProducts();
        }

        _then:
        {
            assertNotNull(products);
            assertThat(products, hasSize(2));
        }
    }

    @Test
    public void should_update_product_price() {
        Product product = null, result = null;
        double price = 1.0, newPrice = 2.0;
        _given: {
           product = new Product("any-name", TYPE_1.name(), price);
           doAnswer(invocation -> invocation.getArgumentAt(0, Product.class))
                   .when(productRepository).save(any(Product.class));
        }

        _when: {
            result = productService.updatePrice(product, newPrice);
        }

        _then:
        {
            assertNotNull(result);
            assertFalse(result.getPrice() == price);
            assertThat(result, hasProperty("price", equalTo(newPrice)));
        }
    }

}
