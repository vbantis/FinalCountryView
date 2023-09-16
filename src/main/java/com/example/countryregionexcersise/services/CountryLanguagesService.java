package com.example.countryregionexcersise.services;

import com.example.countryregionexcersise.entities.CountryLanguagesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryLanguagesService extends BaseService<CountryLanguagesEntity, Integer> {
    private final CountryLanguagesRepository countryRepository;



    @Autowired
    public CountryLanguagesService(CountryLanguagesRepository repository, CountryLanguagesRepository countryRepository) {
        super(repository);
        this.countryRepository = countryRepository;
    }

    public List<CountryLanguagesEntity> getSpokenLanguages(String id) {
        List<CountryLanguagesEntity> countryLanguagesDTO = countryRepository.findSpokenLanguages(id);

        return null != countryLanguagesDTO && countryLanguagesDTO.size() > 0 ? countryLanguagesDTO : new ArrayList<CountryLanguagesEntity>();
    }

    // You can add additional methods specific to CountryService here
}
