package com.learn.lab03springboot;

import com.learn.lab03springboot.service.CartService;
import com.learn.lab03springboot.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LabApplication {

    public static void main(String[] args) {


        ApplicationContext context = SpringApplication.run(LabApplication.class, args);
        ProductService productService = context.getBean(ProductService.class);
        productService.initialiseProductList();

        CartService cartService = context.getBean(CartService.class);
        cartService.initialiseCartList();
    }

}
