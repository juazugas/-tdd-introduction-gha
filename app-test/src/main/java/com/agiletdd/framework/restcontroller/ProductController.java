package com.agiletdd.framework.restcontroller;

import com.agiletdd.application.domain.Product;
import com.agiletdd.application.service.ProductService;
import com.agiletdd.application.service.ProductType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by imasd on 14/4/17.
 */
@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public List<Product> products() {
        return productService.findAllProducts();
    }

    @PostMapping("/product")
    public Product saveProduct(@RequestBody CreateProductRequest productRequest) {
        return productService.saveProduct(productRequest.getName(), ProductType.valueOf(productRequest.getType()), productRequest.getPrice());
    }

}
