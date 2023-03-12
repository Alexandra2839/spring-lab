package com.learn.repository;

import com.learn.model.Product;


public interface CartRepository {
    boolean addCartDatabase(Product product, int quantity);
}
