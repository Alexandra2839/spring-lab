package com.learn.spring04thymeleaf.service;


import com.learn.spring04thymeleaf.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    boolean productCreate(Product product);
    List<Product> listProduct();
    Product findProductById(UUID uuid);
}
