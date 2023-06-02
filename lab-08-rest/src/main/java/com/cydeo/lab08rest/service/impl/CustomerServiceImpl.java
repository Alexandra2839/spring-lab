package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.entity.Customer;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.CustomerRepository;
import com.cydeo.lab08rest.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final MapperUtil mapperUtil;

    public CustomerServiceImpl(CustomerRepository customerRepository, MapperUtil mapperUtil) {
        this.customerRepository = customerRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<CustomerDTO> listAllCustomers() {
        return customerRepository.findAll().stream().map(customer -> mapperUtil.convert(customer, new CustomerDTO())).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO update(CustomerDTO customer) {

        //find current customer
        Customer customerDTO = customerRepository.retrieveByCustomerEmail(customer.getEmail());

        Customer convertedCustomer = mapperUtil.convert(customer, new Customer());
        //set id to the converted object
        convertedCustomer.setId(customer.getId());
        //save the updated user in the db
        customerRepository.save(convertedCustomer);

        return mapperUtil.convert(convertedCustomer, new CustomerDTO());
    }

    @Override
    public void create(CustomerDTO customer) {
         customerRepository.save(mapperUtil.convert(customer, new Customer()));
    }

    @Override
    public CustomerDTO getCustomerByEmail(String email) {
        return mapperUtil.convert(customerRepository.retrieveByCustomerEmail(email), new CustomerDTO());
    }
}
