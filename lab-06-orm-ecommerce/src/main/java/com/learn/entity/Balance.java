package com.learn.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Balance extends BaseEntity{



    private Integer amount;

    @OneToOne (fetch = FetchType.LAZY)
    private Customer customer;


}
