package com.learn.spring04thymeleaf.controller;

import com.learn.spring04thymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public String getList(Model model){

        model.addAttribute("productList", productService.listProduct());

        return "product/list";
    }
}
