package com.learn.lab03springboot.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class Product {
    private UUID id;
    private Integer remainingQuantity;
    private Integer quantity;
    private BigDecimal price;
    private String name;
}
