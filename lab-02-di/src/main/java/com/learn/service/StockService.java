package com.learn.service;

import com.learn.model.Product;

public interface StockService {
    boolean checkStockIsAvailable(Product product, int quantity);
}
