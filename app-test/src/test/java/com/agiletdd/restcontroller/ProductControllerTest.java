package com.agiletdd.restcontroller;

import com.agiletdd.application.domain.Product;
import com.agiletdd.application.domain.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.stream.IntStream;

import static com.agiletdd.application.service.ProductType.TYPE_1;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.springframework.test.annotation.DirtiesContext.MethodMode.AFTER_METHOD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by imasd on 14/4/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductControllerTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        assertNotNull(productRepository);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void should_get_all_products() {
        ResultActions result = null;
        _given:
        {
            IntStream.range(1, 3).forEach(i -> {
                productRepository.save(new Product("prod" + i, TYPE_1.name(), i * 1.0));
            });
        }

        _when:
        try {
            result = mockMvc.perform(MockMvcRequestBuilders.get("/product").accept(MediaType.APPLICATION_JSON_UTF8));
        } catch (Exception e) {
            fail(e.getMessage());
        }

        _then:
        try {
            result.andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(2)));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    @DirtiesContext(methodMode = AFTER_METHOD)
    public void should_create_product() {
        ResultActions result = null;
        String productRequestStr = null;
        _given:
        {
            productRequestStr = "{ \"name\":\"product1\", \"type\":\"TYPE_1\", \"price\":1.0 }";
        }

        _when:
        try {
            result = mockMvc.perform(post("/product").contentType(MediaType.APPLICATION_JSON_UTF8).content(productRequestStr));
        } catch (Exception e) {
            fail(e.getMessage());
        }

        _then:
        try {
            result.andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                    .andExpect(jsonPath("$.name", equalTo("product1")))
                    .andExpect(jsonPath("$.type", equalTo("TYPE_1")))
                    .andExpect(jsonPath("$.price", equalTo(1.0)));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
