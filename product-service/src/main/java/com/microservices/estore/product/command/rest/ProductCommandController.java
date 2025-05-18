package com.microservices.estore.product.command.rest;

import com.microservices.estore.product.command.CreateProductCommand;
import jakarta.validation.Valid;
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

    @PostMapping
    public String createProduct(@Valid @RequestBody CreateProductRestModel createProductRestModel) {

        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .title(createProductRestModel.getTitle())
                .price(createProductRestModel.getPrice())
                .quantity(createProductRestModel.getQuantity())
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
        return "CreateProductRestModel updated via port " + environment.getProperty("local.server.port");
    }

    @DeleteMapping
    public String deleteProduct() {
        return "CreateProductRestModel deleted via port " + environment.getProperty("local.server.port");
    }
}
