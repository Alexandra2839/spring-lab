package com.learn.spring04thymeleaf.service.impl;

import com.learn.spring04thymeleaf.model.Cart;
import com.learn.spring04thymeleaf.model.CartItem;
import com.learn.spring04thymeleaf.model.Product;
import com.learn.spring04thymeleaf.service.CartService;
import com.learn.spring04thymeleaf.service.ProductService;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring5.processor.SpringUErrorsTagProcessor;

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

        Product product = productService.findProductById(productId);


        CartItem cartItem = new CartItem();

        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItem.setTotalAmount(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
        CART.getCartItemList().add(cartItem);
        CART.setCartTotalAmount(CART.getCartTotalAmount().add(cartItem.getTotalAmount()));


        return CART;
    }

    @Override
    public boolean deleteFromCart(UUID productId){
        //todo delete product object from cart using stream
        return true;
    }
}
