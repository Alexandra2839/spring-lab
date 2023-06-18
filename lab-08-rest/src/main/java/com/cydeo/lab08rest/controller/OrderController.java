package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.dto.ResponseWrapper;
import com.cydeo.lab08rest.enums.PaymentMethod;
import com.cydeo.lab08rest.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllOrders(){
        return ResponseEntity.ok(new ResponseWrapper("All Orders Retrieved", orderService.getAllOrders()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper> getOrderById(@PathVariable("id") Long id,
                                                        @RequestParam(required = false) Optional<String> currency){
        return ResponseEntity.ok(new ResponseWrapper("Order by id Retrieved",
                orderService.getOrderById(id, currency), HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateOrder(@RequestBody OrderDTO orderDTO){
        return ResponseEntity.ok(new ResponseWrapper("Order Updated", orderService.update(orderDTO)));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createOrder(@RequestBody OrderDTO orderDTO){

        orderService.create(orderDTO);
        return ResponseEntity.ok(new ResponseWrapper("Order Created", orderDTO));
    }

    @GetMapping("/paymentMethod/{paymentMethod}")
    public ResponseEntity<ResponseWrapper> ListOrdersByPaymentMethod(
            @PathVariable ("paymentMethod") PaymentMethod paymentMethod){
        return ResponseEntity.ok(new ResponseWrapper("Orders by payment method retrieved",
                orderService.getOrderByPaymentMethod(paymentMethod)));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ResponseWrapper> ListOrdersByEmail(@PathVariable("email") String email){
        return ResponseEntity.ok(new ResponseWrapper("Orders by email retrieved",
                orderService.getOrderListByEmail(email)));
    }
}
