package com.learn.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class MovieCinema {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;


    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Cinema cinema;

    @OneToMany(mappedBy = "movieCinema")
    private List<Ticket> ticketList;

    public MovieCinema(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
