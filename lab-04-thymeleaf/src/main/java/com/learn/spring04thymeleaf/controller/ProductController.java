package com.learn.spring04thymeleaf.controller;

import com.learn.spring04thymeleaf.model.Product;
import com.learn.spring04thymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/create-form")
    public String createProduct(Model model){

        model.addAttribute("product", new Product());

        return "product/create-product";
    }

    @PostMapping("/create-product")
    public String createProduct(@ModelAttribute ("product") Product product){

        productService.productCreate(product);

        return "redirect:/list";
    }
}
