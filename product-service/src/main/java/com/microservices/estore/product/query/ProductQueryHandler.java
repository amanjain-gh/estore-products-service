package com.microservices.estore.product.query;

import com.microservices.estore.product.core.data.Product;
import com.microservices.estore.product.core.repository.ProductRepository;
import com.microservices.estore.product.query.rest.ProductRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductQueryHandler {

    private final ProductRepository productRepository;

    public ProductQueryHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    public List<ProductRestModel> findProducts(FindProductsQuery findProductsQuery) {

        List<ProductRestModel> productsRest = new ArrayList<>();
        List<Product> storedProducts = productRepository.findAll();

        for (Product product : storedProducts) {
            ProductRestModel productRestModel = new ProductRestModel();
            BeanUtils.copyProperties(product, productRestModel);
            productsRest.add(productRestModel);
        }

        return productsRest;
    }
}
