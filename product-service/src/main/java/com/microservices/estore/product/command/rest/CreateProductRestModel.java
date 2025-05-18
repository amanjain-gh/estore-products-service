package com.microservices.estore.product.command.rest;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductRestModel {

    @NotBlank(message = "Product Title cannot be empty")
    private String title;

    @Min(value = 1, message = "Product price should be greater than 0")
    private BigDecimal price;

    @Min(value = 1, message = "Quantity cannot be lower than 1")
    @Max(value = 5, message = "Quantity cannot be larger than 5")
    private Integer quantity;
}
