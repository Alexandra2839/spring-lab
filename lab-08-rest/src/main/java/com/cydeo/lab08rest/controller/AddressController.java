package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.dto.ResponseWrapper;
import com.cydeo.lab08rest.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllAddresses(){
        return ResponseEntity.ok(new ResponseWrapper("All addresses retrieved", addressService.getAllAddresses()));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> update(@RequestBody AddressDTO addressDTO){
        return ResponseEntity.ok(new ResponseWrapper("Address updated", addressService.update(addressDTO)));
    }

    @PostMapping ResponseEntity<ResponseWrapper> create(@RequestBody AddressDTO addressDTO){
        addressService.create(addressDTO);
        return ResponseEntity.ok(new ResponseWrapper("Address created", addressDTO));
    }

    @GetMapping("/startsWith/{address}")
    public ResponseEntity<ResponseWrapper> getAllByStartsWith(@PathVariable("address") String address){
        return ResponseEntity.ok(new ResponseWrapper("All addresses starts with " + address + " retrieved", addressService.getAllByStartsWith(address) ));
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<ResponseWrapper> getAllByCustomerID(@PathVariable ("id") Long id){
        return ResponseEntity.ok(new ResponseWrapper("All addresses by customer id retrieved", addressService.getAllByCustomerId(id)));
    }

    @GetMapping("/customer/{customerId}/name/{name}")
    public ResponseEntity<ResponseWrapper> getAllByCustomerIdAndName(@PathVariable ("customerId") Long customerId, @PathVariable ("name") String name){
        return ResponseEntity.ok(new ResponseWrapper("All addresses by customer id and name retirieved", addressService.getAllByCustomerIdAndName(customerId,name)));
    }

}
