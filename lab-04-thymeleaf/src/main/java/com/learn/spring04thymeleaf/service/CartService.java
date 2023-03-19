package com.learn.spring04thymeleaf.service;


import com.learn.spring04thymeleaf.model.Cart;

import java.util.UUID;

public interface CartService {
    Cart addToCart(UUID productId, Integer quantity);
    boolean deleteFromCart(UUID productId);
}
