package com.cognizant.spring_learn_country_code;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    public Country getCountry(String code) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        @SuppressWarnings("unchecked")
        List<Country> countries =
                (List<Country>) context.getBean("countryList");

        for (Country country : countries) {

            if (country.getCode().equalsIgnoreCase(code)) {
                ((ClassPathXmlApplicationContext) context).close();
                return country;
            }

        }

        ((ClassPathXmlApplicationContext) context).close();
        return null;
    }
}
