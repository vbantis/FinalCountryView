package com.example.countryregionexcersise.services;

import com.example.countryregionexcersise.entities.CountryLanguagesEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryLanguagesRepository extends BaseRepository<CountryLanguagesEntity, Integer> {

    List<CountryLanguagesEntity> findSpokenLanguages(String id);

}
