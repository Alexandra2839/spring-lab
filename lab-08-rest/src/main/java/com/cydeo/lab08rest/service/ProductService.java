package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.ProductDTO;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<ProductDTO> getAll();

    ProductDTO update(ProductDTO productDTO);

    void create (ProductDTO productDTO);

    ProductDTO getProductByName (String name);

    List<ProductDTO> getTop3();
    List<ProductDTO> getAllByPrice(BigDecimal price);

    List<ProductDTO> getAllByPriceAndQuantity(BigDecimal price, Integer quantity);

    List<ProductDTO> getAllByCategoryId(Long id);

    Integer countProductByPriceGreaterThan(BigDecimal price);

    List<ProductDTO> getByCategoryAndPrice(List<Long> categoryId, BigDecimal price);



}
