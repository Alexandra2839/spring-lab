package com.learn.service;

import com.learn.model.Cart;
import com.learn.model.Product;

public interface CartService {
    Cart addCart(Product product, int quantity);
}
