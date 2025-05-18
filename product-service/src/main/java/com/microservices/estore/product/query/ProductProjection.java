package com.microservices.estore.product.query;

import com.microservices.estore.product.entity.Product;
import com.microservices.estore.product.events.ProductCreatedEvent;
import com.microservices.estore.product.repository.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
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
