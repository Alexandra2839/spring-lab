package com.learn.spring04thymeleaf.controller;



import static com.learn.spring04thymeleaf.service.impl.CartServiceImpl.CART;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

    @GetMapping("/cart")
    public String seeCart(Model model){

        model.addAttribute("cart", CART);

        return "cart/show-cart";
    }
}
