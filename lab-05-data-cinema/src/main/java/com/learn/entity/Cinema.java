package com.learn.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@Table(name = "cinemas")
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String sponsoredName;

    @OneToMany (mappedBy = "cinema")
    private List<MovieCinema> movieCinemaList;


    @ManyToOne
    private Location location;


    public Cinema(String name, String sponsoredName) {
        this.name = name;
        this.sponsoredName = sponsoredName;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "name='" + name + '\'' +
                ", sponsoredName='" + sponsoredName + '\'' +
                '}';
    }
}
