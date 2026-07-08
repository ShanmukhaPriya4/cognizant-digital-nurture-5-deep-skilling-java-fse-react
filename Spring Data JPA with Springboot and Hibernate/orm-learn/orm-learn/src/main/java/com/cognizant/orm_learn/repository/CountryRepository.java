package com.cognizant.orm_learn.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.orm_learn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    Optional<Country> findByCode(String code);


    // 1. Search countries containing given text
    List<Country> findByNameContaining(String text);


    // 2. Search countries containing text and sort by name ascending
    List<Country> findByNameContainingOrderByNameAsc(String text);


    // 3. Find countries starting with given alphabet
    List<Country> findByNameStartingWith(String alphabet);

}
