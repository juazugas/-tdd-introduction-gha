package com.agiletdd.application.service;

import com.agiletdd.application.domain.Product;
import com.agiletdd.application.domain.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static com.agiletdd.application.service.ProductType.TYPE_1;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertEquals;
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
       _given:{
            doAnswer(invocation -> invocation.getArguments()[0])
                .when(productRepository).save(any(Product.class));
       }

       _when: {
           product = productService.saveProduct("product", TYPE_1, 1.0);
       }

       _then: {
            assertNotNull(product);
            assertNotNull(product.getId());
            assertThat(product, hasProperty("name", equalTo("product")));
       }
   }

    @Test
    public void should_list_all_products() {

    }

}
