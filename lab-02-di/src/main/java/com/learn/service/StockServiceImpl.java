package com.learn.service;

import com.learn.model.Product;
import org.springframework.stereotype.Component;

@Component
public class StockServiceImpl implements StockService{
    @Override
    public boolean checkStockIsAvailable(Product product, int quantity) {
        return product.getRemainingQuantity() > quantity;
    }
}
