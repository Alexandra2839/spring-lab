package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.dto.DiscountDTO;

import java.util.List;

public interface DiscountService {

    List<DiscountDTO> getAllDiscounts();

    DiscountDTO update(DiscountDTO discount);

    void create(DiscountDTO discount);

    DiscountDTO getDiscountByName(String name);
}
