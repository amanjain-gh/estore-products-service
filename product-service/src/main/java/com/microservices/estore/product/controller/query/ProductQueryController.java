package com.microservices.estore.product.controller.query;

import com.microservices.estore.product.entity.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductQueryController {

    @GetMapping
    public List<Product> getProducts() {
        return null;
    }
}
