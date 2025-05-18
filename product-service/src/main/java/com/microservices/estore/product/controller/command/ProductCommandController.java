package com.microservices.estore.product.controller.command;

import com.microservices.estore.product.command.CreateProductCommand;
import com.microservices.estore.product.model.ProductModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductCommandController {

    private CommandGateway commandGateway;

    private final Environment environment;

    public ProductCommandController(Environment environment, CommandGateway commandGateway) {
        this.environment = environment;
        this.commandGateway = commandGateway;
    }

    @GetMapping
    public String getProduct() {
        return "No products available yet " + environment.getProperty("local.server.port");
    }

    @PostMapping
    public String createProduct(@RequestBody ProductModel productModel) {

        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .title(productModel.getTitle())
                .price(productModel.getPrice())
                .quantity(productModel.getQuantity())
                .productId(UUID.randomUUID().toString()).build();

        String returnValue;
        try {
            returnValue = commandGateway.sendAndWait(createProductCommand);
        } catch (Exception e) {
            returnValue = e.getMessage();
        }

        return returnValue;
    }

    @PutMapping
    public String updateProduct() {
        return "ProductModel updated via port " + environment.getProperty("local.server.port");
    }

    @DeleteMapping
    public String deleteProduct() {
        return "ProductModel deleted via port " + environment.getProperty("local.server.port");
    }
}
