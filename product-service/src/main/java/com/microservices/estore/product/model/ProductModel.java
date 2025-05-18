package com.microservices.estore.product.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductModel {

    private String title;

    private BigDecimal price;

    private Integer quantity;
}
