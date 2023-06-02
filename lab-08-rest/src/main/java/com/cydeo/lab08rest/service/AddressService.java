package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.AddressDTO;

import java.util.List;

public interface AddressService {

    List<AddressDTO> getAllAddresses();

    AddressDTO update(AddressDTO addressDTO);

    void create(AddressDTO addressDTO);

    List<AddressDTO> getAllByStartsWith(String address);

    List<AddressDTO> getAllByCustomerId(Long id);

    List<AddressDTO> getAllByCustomerIdAndName (Long id, String name);
}
