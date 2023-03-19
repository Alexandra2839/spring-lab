package com.learn.spring04thymeleaf.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CartItem {
    private Product product;
    private Integer quantity;
    private BigDecimal totalAmount;
}
