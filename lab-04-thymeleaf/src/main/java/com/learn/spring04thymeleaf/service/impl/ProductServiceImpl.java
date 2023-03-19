package com.learn.spring04thymeleaf.service.impl;


import com.learn.spring04thymeleaf.model.Product;
import com.learn.spring04thymeleaf.repository.ProductRepository;
import com.learn.spring04thymeleaf.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public boolean productCreate(Product product){
        // todo implement method
        product.setId(UUID.randomUUID());

        return productRepository.save(product);
    }

    @Override
    public List<Product> listProduct() {
        // todo implement method


        return productRepository.findAll();
    }

    @Override
    public Product findProductById(UUID uuid){
        // todo implement method
        return new Product();
    }

}