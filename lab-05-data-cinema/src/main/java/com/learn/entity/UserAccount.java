package com.learn.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
//@Table(name = "userAccounts")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String username;

    @OneToMany (mappedBy = "userAccount")
    private List<Ticket> ticketList;

    @OneToOne
    private AccountDetails accountDetails;

    public UserAccount(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
