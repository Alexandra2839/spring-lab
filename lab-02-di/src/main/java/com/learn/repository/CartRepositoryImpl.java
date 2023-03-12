package com.learn.repository;


import com.learn.model.Product;
import org.springframework.stereotype.Component;

@Component
public class CartRepositoryImpl implements CartRepository{
    public boolean addCartDatabase(Product product, int quantity) {
        System.out.println(product.getName() + " is added to database");
        return true;
    }
}
