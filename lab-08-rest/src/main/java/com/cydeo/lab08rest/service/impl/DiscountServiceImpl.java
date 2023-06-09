package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.DiscountDTO;
import com.cydeo.lab08rest.entity.Discount;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.DiscountRepository;
import com.cydeo.lab08rest.service.DiscountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {

    public final DiscountRepository discountRepository;
    public final MapperUtil mapperUtil;

    public DiscountServiceImpl(DiscountRepository discountRepository, MapperUtil mapperUtil) {
        this.discountRepository = discountRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<DiscountDTO> getAllDiscounts() {
        return discountRepository.findAll().stream().map(discount -> mapperUtil.convert(discount, new DiscountDTO())).collect(Collectors.toList());
    }

    @Override
    public DiscountDTO update(DiscountDTO discount) {

        Discount discount1 = discountRepository.getReferenceById(discount.getId());

        Discount convertedDiscount = mapperUtil.convert(discount, new Discount());

        convertedDiscount.setId(discount1.getId());

        discountRepository.save(convertedDiscount);

        return mapperUtil.convert(convertedDiscount, new DiscountDTO());
    }

    @Override
    public void create(DiscountDTO discount) {
        discountRepository.save(mapperUtil.convert(discount, new Discount()));

    }

    @Override
    public DiscountDTO getDiscountByName(String name) {
        return mapperUtil.convert(discountRepository.findFirstByName(name), new DiscountDTO());
    }
}
