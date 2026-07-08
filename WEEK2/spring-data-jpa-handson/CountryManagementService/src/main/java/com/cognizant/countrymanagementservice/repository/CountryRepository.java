package com.cognizant.countrymanagementservice.repository;

import com.cognizant.countrymanagementservice.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // 1. Search country by containing text
    List<Country> findByNameContainingIgnoreCase(String name);

    // 2. Search country by containing text and sort ascending
    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String name);

    // 3. Search country starting with alphabet
    List<Country> findByNameStartingWithIgnoreCase(String alphabet);

}