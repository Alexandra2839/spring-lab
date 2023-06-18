package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.enums.PaymentMethod;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<OrderDTO> getAllOrders();

    OrderDTO update(OrderDTO order);

    void create (OrderDTO order);

    List<OrderDTO> getOrderByPaymentMethod(PaymentMethod paymentMethod);

    List<OrderDTO> getOrderListByEmail(String email);

    OrderDTO getOrderById(Long id, Optional<String> currency);
}
