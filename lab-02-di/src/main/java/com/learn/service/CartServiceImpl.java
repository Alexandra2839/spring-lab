package com.learn.service;

import com.learn.model.Cart;
import com.learn.model.Product;
import com.learn.model.Cart;
import com.learn.model.Product;
import com.learn.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class CartServiceImpl implements CartService{


    private final CartRepository cartRepository;
    private final StockService service;

    public CartServiceImpl(CartRepository cartRepository, StockService service) {
        this.cartRepository = cartRepository;
        this.service = service;
    }

    public Cart addCart(Product product, int quantity) {
        boolean stockAvailable = service.checkStockIsAvailable(product, quantity);
        Cart cart = new Cart();
        if (!stockAvailable){
            return cart;
        }
        cartRepository.addCartDatabase(product, quantity);
        BigDecimal totalAmount = product.getPrice().multiply(new BigDecimal(quantity));
        Map<Product, Integer> productMap = new HashMap<>();
        productMap.put(product, quantity);
        cart.setCartTotalAmount(totalAmount);
        cart.setProductMap(productMap);
        return cart;

    }
}
