package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.dto.ProductRequest;
import com.cydeo.lab08rest.dto.ResponseWrapper;
import com.cydeo.lab08rest.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;

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

    @GetMapping("/{name}")
    public ResponseEntity<ResponseWrapper> getProductByName(@PathVariable ("name") String name){
        return ResponseEntity.ok(new ResponseWrapper("Product by name retrieved", productService.getProductByName(name)));
    }

    @GetMapping("/top3")
    public ResponseEntity<ResponseWrapper> getTop3Products(){
        return ResponseEntity.ok(new ResponseWrapper("Top 3 products retrieved", productService.getTop3()));
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<ResponseWrapper> countProductsByPriceGreaterThan(@PathVariable ("price")BigDecimal price){
        return ResponseEntity.ok(new ResponseWrapper("counted products by price", productService.countProductByPriceGreaterThan(price)));
    }

    @GetMapping("/price/{price}/quantity/{quantity}")
    public ResponseEntity<ResponseWrapper> getProductsByPriceAndQuantity(@PathVariable("price") BigDecimal price, @PathVariable ("quantity") Integer quantity){
        return ResponseEntity.ok(new ResponseWrapper("Products by price and quantity retrieved", productService.getAllByPriceAndQuantity(price, quantity)));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<ResponseWrapper> getProductsByCategory(@PathVariable ("id") Long id){
        return ResponseEntity.ok(new ResponseWrapper("Products by category retrieved", productService.getAllByCategoryId(id)));
    }

    @PostMapping("/categoryandprice")
    public ResponseEntity<ResponseWrapper> getByCategoryAndPrice(@RequestBody ProductRequest productRequest){
        return ResponseEntity.ok(new ResponseWrapper("Product list retrieved", productService.getByCategoryAndPrice(productRequest.getCategoryList(), productRequest.getPrice())));
    }
}
