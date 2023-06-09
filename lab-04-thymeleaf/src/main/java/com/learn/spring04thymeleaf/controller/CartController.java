package com.learn.spring04thymeleaf.controller;



import static com.learn.spring04thymeleaf.service.impl.CartServiceImpl.CART;

import com.learn.spring04thymeleaf.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class CartController {


    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public String seeCart(Model model){

        model.addAttribute("cart", CART);

        return "cart/show-cart";
    }

    @GetMapping("/addToCart/{productId}/{quantity}")
    public String addToCart(@PathVariable("productId") UUID productId,
                            @PathVariable("quantity") Integer quantity){

        cartService.addToCart(productId, quantity);

        return "redirect:/cart";
    }


    @GetMapping("/delete/{productId}")
        public String deleteFromCart(@PathVariable ("productId") UUID productId){

        cartService.deleteFromCart(productId);
        return "redirect:/cart";
    }


}
