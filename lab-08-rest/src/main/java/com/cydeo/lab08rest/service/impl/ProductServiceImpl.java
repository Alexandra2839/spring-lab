package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.entity.Product;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.ProductRepository;
import com.cydeo.lab08rest.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final MapperUtil mapperUtil;

    public ProductServiceImpl(ProductRepository productRepository, MapperUtil mapperUtil) {
        this.productRepository = productRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<ProductDTO> getAll() {
        return productRepository.findAll().stream()
                .map(product -> mapperUtil.convert(product,new ProductDTO())).collect(Collectors.toList());
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {

        Product product1 = productRepository.getReferenceById(productDTO.getId());

        Product convertedProduct = mapperUtil.convert(productDTO, new Product());
        convertedProduct.setId(product1.getId());
        productRepository.save(convertedProduct);
        return mapperUtil.convert(convertedProduct, new ProductDTO());
    }

    @Override
    public void create(ProductDTO productDTO) {

        productRepository.save(mapperUtil.convert(productDTO, new Product()));

    }

    @Override
    public ProductDTO getProductByName(String name) {
        return mapperUtil.convert(productRepository.findFirstByName(name), new ProductDTO());
    }

    @Override
    public List<ProductDTO> getTop3() {
        return productRepository.findTop3ByOrderByPriceDesc().stream()
                .map(product -> mapperUtil.convert(product, new ProductDTO())).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getAllByPrice(BigDecimal price) {
        return productRepository.findAllByPrice(price).stream()
                .map(product -> mapperUtil.convert(product, new ProductDTO())).collect(Collectors.toList());
    }

    public Integer countProductByPriceGreaterThan(BigDecimal price){
        return productRepository.countProductByPriceGreaterThan(price);
    }

    @Override
    public List<ProductDTO> getByCategoryAndPrice(List<Long> categoryId, BigDecimal price) {
        return productRepository.retrieveProductListByCategory(categoryId, price).stream()
                .map(product -> mapperUtil.convert(product, new ProductDTO())).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getAllByPriceAndQuantity(BigDecimal price, Integer quantity) {
        return productRepository.retrieveProductListGreaterThanPriceAndLowerThanRemainingQuantity(price,quantity)
                .stream()
                .map(product -> mapperUtil.convert(product, new ProductDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getAllByCategoryId(Long id) {
        return productRepository.retrieveProductListByCategory(id).stream()
                .map(product -> mapperUtil.convert(product, new ProductDTO())).collect(Collectors.toList());
    }
}
