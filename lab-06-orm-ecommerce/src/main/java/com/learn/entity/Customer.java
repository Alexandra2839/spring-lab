package com.learn.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer extends BaseEntity{

    private String email;
    private String firstName;
    private String lastName;
    private String userName;

//    @OneToOne (mappedBy = "customer")// no need tto have a way to find balance from customer & keep main customer table clean
//    private Balance balance;

//    @OneToMany (mappedBy = "customer")
//    private List<Address> addressList;


}
