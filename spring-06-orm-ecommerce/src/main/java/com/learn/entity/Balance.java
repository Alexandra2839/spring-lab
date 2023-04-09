package com.learn.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Data
@NoArgsConstructor
public class Balance extends BaseEntity{



    private Integer amount;

    @OneToOne
    private Customer customer;


}
