package com.cognizant.countrymanagementservice.controller;

import com.cognizant.countrymanagementservice.model.Country;
import com.cognizant.countrymanagementservice.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code) {
        return countryService.getCountry(code);
    }

    @PostMapping
    public Country addCountry(@RequestBody Country country) {
        return countryService.addCountry(country);
    }

    @PutMapping
    public Country updateCountry(@RequestBody Country country) {
        return countryService.updateCountry(country);
    }

    @DeleteMapping("/{code}")
    public void deleteCountry(@PathVariable String code) {
        countryService.deleteCountry(code);
    }

    @GetMapping("/search/{name}")
    public List<Country> searchCountries(@PathVariable String name) {
        return countryService.searchCountries(name);
    }

    @GetMapping("/search/sorted/{name}")
    public List<Country> searchCountriesSorted(@PathVariable String name) {
        return countryService.searchCountriesSorted(name);
    }

    @GetMapping("/startswith/{alphabet}")
    public List<Country> searchCountriesStartingWith(@PathVariable String alphabet) {
        return countryService.searchCountriesStartingWith(alphabet);
    }

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }
}