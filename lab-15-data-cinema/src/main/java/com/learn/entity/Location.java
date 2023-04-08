package com.learn.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
//@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private String address;
    private String latitude;
    private String longitude;
    private String country;
    private String city;
    private String state;
    private String postalCode;


    @OneToMany (mappedBy = "location")
    private List<Cinema> cinemaList;

    public Location(String name,String address,  String country, String city, String state, String postalCode) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;

    }
}
