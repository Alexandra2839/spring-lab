package com.learn.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Data
@NoArgsConstructor
public class Balance {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private Integer amount;

    @OneToOne
    private Customer customer;

    public Balance(Integer amount) {
        this.amount = amount;
    }
}
