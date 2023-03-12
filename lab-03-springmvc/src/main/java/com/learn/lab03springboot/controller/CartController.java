package com.learn.lab03springboot.controller;

import com.learn.lab03springboot.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class CartController {

    private final CartService cartService;

    @RequestMapping("/cart-list")
    public String getCartList(Model model){

        model.addAttribute("cartList" ,cartService.retrieveCartList());

        return "cart/cart-list";
    }
}
