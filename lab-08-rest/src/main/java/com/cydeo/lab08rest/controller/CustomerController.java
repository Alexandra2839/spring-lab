package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.dto.ResponseWrapper;
import com.cydeo.lab08rest.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController{

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllCustomers(){

        return ResponseEntity.ok(new ResponseWrapper("All customers retrieved", customerService.listAllCustomers()));

    }

    @GetMapping("/{email}")
    public ResponseEntity<ResponseWrapper> getCustomerByEmail(@PathVariable ("email") String email){
        return ResponseEntity.ok(new ResponseWrapper("Customer retrieved", customerService.getCustomerByEmail(email)));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.create(customerDTO);
        return ResponseEntity.ok(new ResponseWrapper("Customer created",customerDTO ));

    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateCustomer(@RequestBody CustomerDTO customerDTO){

        return ResponseEntity.ok(new ResponseWrapper("Customer Updated", customerService.update(customerDTO)));
    }

}

