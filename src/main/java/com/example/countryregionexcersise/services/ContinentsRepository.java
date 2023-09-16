package com.example.countryregionexcersise.services;

import com.example.countryregionexcersise.entities.ContinentsEntity;
import com.example.countryregionexcersise.entities.CountryLanguagesEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContinentsRepository extends BaseRepository<ContinentsEntity, Integer> {

    List<Object> getAllContinetsWithCoutryStats();

}
