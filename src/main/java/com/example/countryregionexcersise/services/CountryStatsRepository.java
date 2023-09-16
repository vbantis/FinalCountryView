package com.example.countryregionexcersise.services;

import com.example.countryregionexcersise.entities.CountryLanguagesEntity;
import com.example.countryregionexcersise.entities.CountryStatsEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryStatsRepository extends BaseRepository<CountryStatsEntity, Integer> {

    List<CountryStatsEntity> findValidStatsOrderByRatio();

}
