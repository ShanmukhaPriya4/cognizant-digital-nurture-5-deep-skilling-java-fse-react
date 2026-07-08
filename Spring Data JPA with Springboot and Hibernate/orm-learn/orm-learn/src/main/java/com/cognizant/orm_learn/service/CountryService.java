package com.cognizant.orm_learn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }


    @Transactional
    public Country getCountry(String code) {
        return countryRepository.findById(code).orElse(null);
    }


    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {

        Optional<Country> result = countryRepository.findById(countryCode);

        if (!result.isPresent()) {
            throw new CountryNotFoundException(
                    "Country with code " + countryCode + " not found"
            );
        }

        return result.get();
    }


    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }


    @Transactional
    public void updateCountry(String code, String name) {

        Country country = countryRepository.findById(code).orElse(null);

        if (country != null) {

            country.setName(name);

            countryRepository.save(country);
        }
    }


    @Transactional
    public void deleteCountry(String code) {

        countryRepository.deleteById(code);
    }


    // Hands-on 1: Query Methods

    @Transactional
    public List<Country> searchCountries(String text) {

        return countryRepository.findByNameContaining(text);
    }


    @Transactional
    public List<Country> searchCountriesSorted(String text) {

        return countryRepository.findByNameContainingOrderByNameAsc(text);
    }


    @Transactional
    public List<Country> findCountriesStartingWith(String alphabet) {

        return countryRepository.findByNameStartingWith(alphabet);
    }
}