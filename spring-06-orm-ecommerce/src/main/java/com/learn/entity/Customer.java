package com.learn.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String firstName;
    private String lastName;
    private String userName;

//    @OneToOne (mappedBy = "customer")// no need tto have a way to find balance from customer & keep main customer table clean
//    private Balance balance;

//    @OneToMany (mappedBy = "customer")
//    private List<Address> addressList;


}
