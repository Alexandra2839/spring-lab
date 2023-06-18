package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.client.CurrencyApiClient;
import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.entity.Order;
import com.cydeo.lab08rest.enums.Currency;
import com.cydeo.lab08rest.enums.PaymentMethod;
import com.cydeo.lab08rest.exception.NotFoundException;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.OrderRepository;
import com.cydeo.lab08rest.service.OrderService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class OrderServiceImpl implements OrderService {

    @Value("${access_key}")
    private String accessKey;

    private final OrderRepository orderRepository;
    private final MapperUtil mapperUtil;

    private final CurrencyApiClient currencyApiClient;

    public OrderServiceImpl(OrderRepository orderRepository, MapperUtil mapperUtil,
                            CurrencyApiClient currencyApiClient) {
        this.orderRepository = orderRepository;
        this.mapperUtil = mapperUtil;
        this.currencyApiClient = currencyApiClient;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream().map(order -> mapperUtil.convert(order, new OrderDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO update(OrderDTO order) {

        Order order1 = orderRepository.getReferenceById(order.getId());
        Order convertedOrder = mapperUtil.convert(order, new Order());

        convertedOrder.setId(order1.getId());
        orderRepository.save(convertedOrder);
        return mapperUtil.convert(convertedOrder, new OrderDTO());
    }

    @Override
    public void create(OrderDTO order) {

        orderRepository.save(mapperUtil.convert(order, new Order()));

    }

    @Override
    public List<OrderDTO> getOrderByPaymentMethod(PaymentMethod paymentMethod) {
        return orderRepository.findAllByPayment_PaymentMethod(paymentMethod).stream()
                .map(order -> mapperUtil.convert(order, new OrderDTO())).collect(Collectors.toList());
    }


    @Override
    public List<OrderDTO> getOrderListByEmail(String email) {
        return orderRepository.findAllByCustomer_Email(email).stream()
                .map(order -> mapperUtil.convert(order, new OrderDTO())).collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(Long id, Optional<String> currency) {

        Order order = orderRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Order could not be found."));


        currency.ifPresent(curr ->{

            //validateCurrency(curr);

            BigDecimal currencyRate = getCurrencyRate(curr);
            BigDecimal newPaidPrice = order.getPaidPrice().multiply(currencyRate);
            BigDecimal newTotalPrice = order.getTotalPrice().multiply(currencyRate);

            order.setPaidPrice(newPaidPrice);
            order.setTotalPrice(newTotalPrice);
        });

        return mapperUtil.convert(order, new OrderDTO());
    }

//    private void validateCurrency(String curr) {
//        //check if currency is valid
//        List<String> currencies = Stream.of(Currency.values())
//                .map(currency -> currency.value)
//                .collect(Collectors.toList());
//
//        boolean contains = currencies.contains(curr);
//
//        if (!contains){
//
//        }
//    }

    private BigDecimal getCurrencyRate(String currency){
        Map<String, Double> quotes = currencyApiClient.getCurrencyRates(accessKey,currency, "USD", 1).getQuotes();
        String expectedCurrency= "USD" + currency.toUpperCase();

        return BigDecimal.valueOf(quotes.get(expectedCurrency));
    }
}
