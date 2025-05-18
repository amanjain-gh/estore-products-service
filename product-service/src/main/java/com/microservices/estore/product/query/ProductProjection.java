package com.microservices.estore.product.query;

import com.microservices.estore.product.core.data.Product;
import com.microservices.estore.product.core.events.ProductCreatedEvent;
import com.microservices.estore.product.core.repository.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductProjection {

    private ProductRepository productRepository;

    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent productCreatedEvent) {

        Product product = new Product();
        BeanUtils.copyProperties(productCreatedEvent, product);

        productRepository.save(product);
    }

}
