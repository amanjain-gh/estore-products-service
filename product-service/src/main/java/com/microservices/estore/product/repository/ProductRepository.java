package com.microservices.estore.product.repository;

import com.microservices.estore.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

    Product findByProductId(String productId);

    Product findByProductIdOrTitle(String productId, String title);
}
