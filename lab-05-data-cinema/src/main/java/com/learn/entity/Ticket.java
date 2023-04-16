package com.learn.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
//@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    private String seatNumber;
    private String rowNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private MovieCinema movieCinema;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserAccount userAccount;

    @Override
    public String toString() {
        return "Ticket{" +
                "dateTime=" + dateTime +
                ", seatNumber='" + seatNumber + '\'' +
                ", rowNumber='" + rowNumber + '\'' +
                '}';
    }
}
