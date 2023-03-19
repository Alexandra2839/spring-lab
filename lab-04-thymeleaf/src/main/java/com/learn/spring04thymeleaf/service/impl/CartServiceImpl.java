package com.learn.spring04thymeleaf.service.impl;

import com.learn.spring04thymeleaf.model.Cart;
import com.learn.spring04thymeleaf.service.CartService;
import com.learn.spring04thymeleaf.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {
    public static Cart CART = new Cart(BigDecimal.ZERO,new ArrayList<>());

    private final ProductService productService;

    public CartServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Cart addToCart(UUID productId, Integer quantity){
        //todo retrieve product from repository method

        //todo initialise cart item
        //todo calculate cart total amount
        //todo add to cart
        return CART;
    }

    @Override
    public boolean deleteFromCart(UUID productId){
        //todo delete product object from cart using stream
        return true;
    }
}
