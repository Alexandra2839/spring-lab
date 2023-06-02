package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.DiscountDTO;
import com.cydeo.lab08rest.dto.ResponseWrapper;
import com.cydeo.lab08rest.service.DiscountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/discount")
public class DiscountController {

    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllDiscounts(){
        return ResponseEntity.ok(new ResponseWrapper("Retrieved all discounts",discountService.getAllDiscounts() ));
    }

    @GetMapping("/{name}")
    public ResponseEntity<ResponseWrapper> getDiscountByName(@PathVariable ("name") String name){
        return ResponseEntity.ok(new ResponseWrapper("Discount retrieved", discountService.getDiscountByName(name)));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createDiscount(@RequestBody DiscountDTO discountDTO){
        discountService.create(discountDTO);
        return ResponseEntity.ok(new ResponseWrapper("Discount created",discountDTO));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateDiscount(@RequestBody DiscountDTO discountDTO){
        return ResponseEntity.ok(new ResponseWrapper("Discount Updated", discountService.update(discountDTO)));
    }

}
