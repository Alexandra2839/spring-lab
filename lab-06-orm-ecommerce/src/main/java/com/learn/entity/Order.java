package com.learn.entity;

import com.learn.enums.PaymentMethod;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@Table (name = "orders")
public class Order extends BaseEntity{

    private BigDecimal paidPrice;
    private BigDecimal totalPrice;

    @ManyToOne
    private Customer customer;
    @OneToOne
    private Cart cart;

    @OneToOne
    private Payment payment;
}
