package com.cognizant.countrymanagementservice.service;

import com.cognizant.countrymanagementservice.model.Country;
import com.cognizant.countrymanagementservice.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country getCountry(String code) {
        return countryRepository.findById(code).orElse(null);
    }

    @Override
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country updateCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    @Override
    public List<Country> searchCountriesSorted(String name) {
        return countryRepository.findByNameContainingIgnoreCaseOrderByNameAsc(name);
    }

    @Override
    public List<Country> searchCountriesStartingWith(String alphabet) {
        return countryRepository.findByNameStartingWithIgnoreCase(alphabet);
    }

    @Override
    public List<Country> searchCountries(String name) {
        return countryRepository.findByNameContainingIgnoreCase(name);
    }
    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
        }




}