package com.microservices.estore.product.core.repository;

import com.microservices.estore.product.core.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

    Product findByProductId(String productId);

    Product findByProductIdOrTitle(String productId, String title);
}
