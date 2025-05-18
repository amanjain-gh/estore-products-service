package com.microservices.estore.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private Environment environment;

    @GetMapping
    public String getProduct() {
        return "No products available yet " + environment.getProperty("local.server.port");
    }

    @PostMapping
    public String createProduct() {
        return "Product created via port " + environment.getProperty("local.server.port");
    }

    @PutMapping
    public String updateProduct() {
        return "Product updated via port " + environment.getProperty("local.server.port");
    }

    @DeleteMapping
    public String deleteProduct() {
        return "Product deleted via port " + environment.getProperty("local.server.port");
    }
}
