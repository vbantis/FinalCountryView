package com.example.countryregionexcersise.services;

import com.example.countryregionexcersise.entities.CountriesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService extends BaseService<CountriesEntity, Integer> {
    private final CountryRepository countryRepository;


    @Autowired
    public CountryService(CountryRepository repository, CountryRepository countryRepository) {
        super(repository);
        this.countryRepository = countryRepository;
    }


}
