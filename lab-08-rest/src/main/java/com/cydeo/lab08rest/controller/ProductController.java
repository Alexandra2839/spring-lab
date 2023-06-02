package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.dto.ResponseWrapper;
import com.cydeo.lab08rest.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAll(){
        return ResponseEntity.ok(new ResponseWrapper("All products retrieved", productService.getAll()));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> update(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(new ResponseWrapper("Product updated", productService.update(productDTO)));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> create(@RequestBody ProductDTO productDTO){
        productService.create(productDTO);
        return ResponseEntity.ok(new ResponseWrapper("Product created", productDTO));
    }
}
