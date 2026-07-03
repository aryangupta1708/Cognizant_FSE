package com.cognizant.countrymanagementservice.service;

import com.cognizant.countrymanagementservice.model.Country;

import java.util.List;

public interface CountryService {

    Country getCountry(String code);

    Country addCountry(Country country);

    Country updateCountry(Country country);

    void deleteCountry(String code);

    List<Country> searchCountries(String name);

    List<Country> getAllCountries();
}