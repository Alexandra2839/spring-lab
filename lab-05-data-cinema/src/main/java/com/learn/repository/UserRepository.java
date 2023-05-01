package com.learn.repository;


import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import com.learn.entity.UserAccount;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserAccount, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?
    Optional<UserAccount> findByEmail(String email);


    //Write a derived query to read a user with a username?
    Optional<UserAccount> findByUsername (String username);


    //Write a derived query to list all users that contain a specific name?
    List<UserAccount> findByAccountDetailsNameContains(String name);


    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    List<UserAccount> findByAccountDetailsNameContainsIgnoreCase(String name);


    //Write a derived query to list all users with an age greater than a specified age?
    List<UserAccount> findByAccountDetailsAgeGreaterThan(int age);


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?
    @Query("select ua from UserAccount ua where ua.email = ?1")
    Optional<UserAccount> listUserByEmail(@Param("email") String email);


    //Write a JPQL query that returns a user read by username?
    @Query("select ua from UserAccount ua where ua.username = ?1")
    Optional<UserAccount> listUserByUsername(@Param("username") String username);


    //Write a JPQL query that returns all users?
    @Query("select ua from UserAccount ua")
    List<UserAccount> listAllUsers ();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?
    @Query(value = "select * from user_account ua join account_details ad on ua.account_details_id = ad.id " +
            "where  ad.name ilike concat('%', ?1, '%')", nativeQuery = true)
    List<UserAccount> listAllUsersContainsName(@Param("name") String name);


    //Write a native query that returns all users?
    @Query(value = "select * from user_account ", nativeQuery = true)
    List<UserAccount> listAllUsersNative ();

    //Write a native query that returns all users in the range of ages?
    @Query(value = "select * from user_account ua join account_details ad on ua.account_details_id = ad.id " +
            "where ad.age between ?1 and ?2", nativeQuery = true)
    List<UserAccount> listAllInAgeRange (@Param ("age1") int age1, @Param("age2") int age2);


    //Write a native query to read a user by email?
    @Query(value = "select * from user_account where email = ?1", nativeQuery = true)
    Optional<UserAccount> listByEmail (@Param("email") String email);


}