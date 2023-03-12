
package com.learn.lab03springboot.service;



import com.learn.lab03springboot.model.Cart;
import com.learn.lab03springboot.model.CartItem;

import java.util.List;
import java.util.UUID;

public interface CartService {
    List<Cart> retrieveCartList();

    List<CartItem> retrieveCartDetail(UUID cartId);

    void initialiseCartList();
}
