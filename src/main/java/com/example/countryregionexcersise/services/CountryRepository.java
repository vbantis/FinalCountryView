package com.example.countryregionexcersise.services;

import com.example.countryregionexcersise.entities.CountriesEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends BaseRepository<CountriesEntity, Integer> {

    List<CountriesEntity> findByName(String name);


}
