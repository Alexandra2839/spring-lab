package com.learn.lab03springboot.service;



import com.learn.lab03springboot.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> searchProduct(String name);

    void initialiseProductList();
}
