package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {


    List<CustomerDTO> listAllCustomers();

    CustomerDTO update(CustomerDTO customer);

    void create(CustomerDTO customer);

    CustomerDTO getCustomerByEmail(String email);
}
