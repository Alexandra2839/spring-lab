package com.learn.repository;

import com.learn.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id
    Optional<MovieCinema> findById(Long id);


    //Write a derived query to count all movie cinemas with a specific cinema id
    Integer countByCinema_Id(Long id);


    //Write a derived query to count all movie cinemas with a specific movie id
    Integer countByMovie_Id(Long id);


    //Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema> findByDateTimeAfter(LocalDateTime dateTime);


    //Write a derived query to find the top 3 expensive movies
    List<MovieCinema> findTop3ByOrderByMoviePriceDesc();


    //Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema> findByMovieNameContaining(String name);


    //Write a derived query to list all movie cinemas in a specific location name
    List<MovieCinema> findByCinemaLocationName(String location);


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date
    @Query("select mc from MovieCinema mc where mc.dateTime > ?1")
    List<MovieCinema> fetchAllMovieCinemaAfterDate(@Param("dateTime")LocalDateTime dateTime);


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id
    @Query(value = "select * from movie_cinema wehere cinema_id = ?1", nativeQuery = true)
    Integer countByCinemaId(Long id);

    //Write a native query that returns all movie cinemas by location name
    @Query(value = "select * from movie_cinema mc join cinema c on mc.cinema_id = c.id join location l on c.location_id = l.id where l.name = ?1", nativeQuery = true)
    List<MovieCinema> listAllByLocationName(String name);


}