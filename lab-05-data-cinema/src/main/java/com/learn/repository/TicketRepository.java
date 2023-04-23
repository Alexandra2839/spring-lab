package com.learn.repository;

import com.learn.entity.Movie;
import com.learn.entity.Ticket;
import com.learn.entity.UserAccount;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
    Integer countByUserAccountId(Long userId);


    //Write a derived query to list all tickets by specific email
    List<Ticket> findByUserAccountEmail(String email);


    //Write a derived query to count how many tickets are sold for a specific movie
    Integer countByMovieCinemaMovieName(String name);


    //Write a derived query to list all tickets between a range of dates
    List <Ticket> findAllByDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("select t from Ticket t where t.userAccount.id = ?1 ")
    List<Ticket> listTicketsByUserId(Long id);


    //Write a JPQL query that returns all tickets between a range of dates
    @Query("select t from Ticket t where t.dateTime between ?1 and ?2")
    List<Ticket> listAllTicketsBetweenDates(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought

    @Query(value = "select count(*) from ticket where user_account_id = ?1 ", nativeQuery = true)
    Integer countNumberTicketsByUserId(@Param ("userId")Long userId);


    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value = "select coiunt(*) from ticket where  user_account_id = ?1  and dateTime between ?2 and ?3", nativeQuery = true)
    Integer countAllTicketsBetweenDate(@Param("userId") Long userId, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);


    //Write a native query to distinct all tickets by movie name
    @Query(value = "select distinct (m.name) from ticket t join movie_cinema mc on mc.id = t.movie_cinema_id" +
            "join movie m on m.id = mc.movie_id", nativeQuery = true)
    List<String> listAllDistinctMovieNames();


    //Write a native query to find all tickets by user email
    @Query(value = "select * from ticket t join user_account ua on t.user_account_id = ua.id", nativeQuery = true)
    List<Ticket> listAllTicketsByEmail(@Param("email") String email);


    //Write a native query that returns all tickets
    @Query(value = "select * from ticket", nativeQuery = true)
    List<Ticket> listAllTickets();

    //Write a native query to list all tickets where a specific value should be containable
    // in the username or account name or movie name
    @Query(value = "select * from ticket t " +
            "join user_account ua on ua.id = t.user_account_id " +
            "join account_details ad on ad.id = ua.account_details_id " +
            "join movie_cinema mc on t.movie_ciname_id = mc.id " +
            "join movie m on m.id = mc.movie_id" +
            "where ua.username ilike concat('%' + ?1 + '%') " +
            "or ad.name ilike concat('%' + ?1 + '%') " +
            "or m.name ilike concat('%' + ?1 + '%') ", nativeQuery = true)
    List<Ticket> listTicketsWithValue(@Param("value")String value);


}