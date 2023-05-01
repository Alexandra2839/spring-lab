package com.learn.repository;

import com.learn.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name
    Optional<Cinema> findByName(String name);


    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema> findTop3BySponsoredNameContainingOrderBySponsoredName(String sponsoredName);


    //Write a derived query to list all cinemas in a specific country
    List<Cinema> findByLocationCountry(String country);


    //Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> findByNameOrSponsoredName(String name, String sponsoredName);


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id
    @Query("select c.name from Cinema c where c.id = ?1")
    Optional<Cinema> retrieveCinemaById(Long id);


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country
    @Query(value = "select * from cimena c join location l on c.location_id = l.id where l.country = ?1 ", nativeQuery = true)
    List<Cinema> fetchAllCinemaByCountry (String country);


    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
    @Query(value = "select * from cinema where lower(name) like lower(concat('%', ?1, '%')) or lowe(sponsored_name) like lower(concat('%', ?1,'%'))", nativeQuery = true)
    List<Cinema> fetchAllCinemasByNameOrSponsoredNameContains(String pattern);


    //Write a native query to sort all cinemas by name
    @Query(value = "select * from cinema order by name ", nativeQuery = true)
    List<Cinema> sortAllByName();


    //Write a native query to distinct all cinemas by sponsored name
    @Query(value = "SELECT DISTINCT sponsored_name FROM cinema",nativeQuery = true)
    List<String> distinctBySponsoredName();

}