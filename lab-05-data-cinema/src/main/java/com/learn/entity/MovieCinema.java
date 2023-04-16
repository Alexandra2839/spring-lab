package com.learn.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class MovieCinema {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;


    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    @ManyToOne (fetch = FetchType.LAZY)
    private Cinema cinema;

    @OneToMany(mappedBy = "movieCinema")
    private List<Ticket> ticketList;

    public MovieCinema(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "MovieCinema{" +
                "dateTime=" + dateTime +
                '}';
    }
}
