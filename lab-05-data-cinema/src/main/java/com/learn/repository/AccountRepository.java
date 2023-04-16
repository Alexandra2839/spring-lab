package com.learn.repository;

import com.learn.entity.AccountDetails;
import com.learn.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountDetails, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    List<AccountDetails> findByCountryOrState(String country, String state);


    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<AccountDetails> findByAgeLessThanEqual(Integer age);


    //Write a derived query to list all accounts with a specific role
    List<AccountDetails> findByRole(Role role);


    //Write a derived query to list all accounts between a range of ages
    List<AccountDetails> findByAgeBetween(Integer age1, Integer age2);


    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<AccountDetails> findByAddressStartingWith(String pattern);


    //Write a derived query to sort the list of accounts with age
    List<AccountDetails> findByOrderByAgeDesc();


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("select a from AccountDetails a")

    List<AccountDetails> retrieveAllAccounts();


    //Write a JPQL query to list all admin accounts
    @Query("select a from AccountDetails a where a.role = 'ADMIN'")

    List<AccountDetails> retrieveAllAdminAccounts();


    //Write a JPQL query to sort all accounts with age
    @Query("select a from AccountDetails a order by a.age desc ")

    List<AccountDetails> sortAllAccountsWithAge();


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "select * from account_details where age< ?1",nativeQuery = true)
    List<AccountDetails> retrieveAccountsWithAgeLowerThan(int age);


    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
    @Query(value = "select * from account_details where name ilike concat('%', ?1, '%') or address ilike concat('%', ?1, '%') or country ilike concat('%', ?1, '%') or state ilike concat('%', ?1, '%') or city ilike concat('%', ?1, '%')", nativeQuery = true)
    List<AccountDetails> retrieveAccountsThatContainsValue(String pattern);

    //Write a native query to read all accounts with an age higher than a specific value
    @Query(value = "select * from account_details where age> ?1", nativeQuery = true)
    List<AccountDetails> retrieveAccountsWithAgeHigherThan(int age);

}