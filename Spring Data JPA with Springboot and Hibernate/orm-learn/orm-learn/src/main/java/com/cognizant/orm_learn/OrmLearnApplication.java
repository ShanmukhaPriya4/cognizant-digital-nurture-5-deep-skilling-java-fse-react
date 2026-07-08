package com.cognizant.orm_learn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        countryService = context.getBean(CountryService.class);

        testQueryMethods();
    }


    private static void testGetAllCountries() {

        LOGGER.info("Start");

        List<Country> countries = countryService.getAllCountries();

        LOGGER.debug("countries={}", countries);

        LOGGER.info("End");
    }


    private static void findCountryByCodeTest() {

        LOGGER.info("Start");

        try {
            Country country = countryService.findCountryByCode("IN");

            LOGGER.debug("Country: {}", country);

            LOGGER.info("Country Name: {}", country.getName());

        } catch (CountryNotFoundException e) {

            LOGGER.error(e.getMessage());
        }

        LOGGER.info("End");
    }


    private static void testAddCountry() {

        LOGGER.info("Start");

        Country country = new Country();

        country.setCode("US");
        country.setName("United States");

        countryService.addCountry(country);

        try {
            Country addedCountry = countryService.findCountryByCode("US");

            LOGGER.debug("Country: {}", addedCountry);

            LOGGER.info("Country Name: {}", addedCountry.getName());

        } catch (CountryNotFoundException e) {

            LOGGER.error(e.getMessage());
        }

        LOGGER.info("End");
    }


    private static void testUpdateCountry() {

        LOGGER.info("Start");

        countryService.updateCountry("US", "United States of America");

        try {
            Country updatedCountry = countryService.findCountryByCode("US");

            LOGGER.debug("Updated Country: {}", updatedCountry);

            LOGGER.info("Updated Country Name: {}", updatedCountry.getName());

        } catch (CountryNotFoundException e) {

            LOGGER.error(e.getMessage());
        }

        LOGGER.info("End");
    }


    private static void testDeleteCountry() {

        LOGGER.info("Start");

        String code = "US";

        countryService.deleteCountry(code);

        LOGGER.info("Country deleted successfully: {}", code);

        LOGGER.info("End");
    }


    private static void testQueryMethods() {

        LOGGER.info("Start");


        // Search countries containing "ou"
        List<Country> countries = countryService.searchCountries("ou");

        LOGGER.info("Countries containing 'ou':");

        for (Country country : countries) {

            LOGGER.info("{} - {}", country.getCode(), country.getName());
        }


        // Search countries containing "ou" sorted by name
        List<Country> sortedCountries = countryService.searchCountriesSorted("ou");

        LOGGER.info("Sorted Countries:");

        for (Country country : sortedCountries) {

            LOGGER.info("{} - {}", country.getCode(), country.getName());
        }


        // Countries starting with "Z"
        List<Country> zCountries = countryService.findCountriesStartingWith("Z");

        LOGGER.info("Countries starting with Z:");

        for (Country country : zCountries) {

            LOGGER.info("{} - {}", country.getCode(), country.getName());
        }


        LOGGER.info("End");
    }
}