package com.example.countryregionexcersise.services;

import com.example.countryregionexcersise.DTO.CountryStatsDTO;
import com.example.countryregionexcersise.entities.CountriesEntity;
import com.example.countryregionexcersise.entities.CountryLanguagesEntity;
import com.example.countryregionexcersise.entities.CountryStatsEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CountryStatsService extends BaseService<CountryStatsEntity, Integer> {
    @PersistenceContext
    private EntityManager entityManager;
    private final CountryStatsRepository countryRepository;



    @Autowired
    public CountryStatsService(CountryStatsRepository repository, CountryStatsRepository countryRepository) {
        super(repository);
        this.countryRepository = countryRepository;
    }

    public List<CountryStatsDTO> getCountryStats() {
        List<CountryStatsEntity> statsList = countryRepository.findValidStatsOrderByRatio();

        Map<Integer, CountryStatsEntity> maxGdpPerPopulationByCountry = new HashMap<>();

        for (CountryStatsEntity stat : statsList) {
            maxGdpPerPopulationByCountry.putIfAbsent(stat.getCountryId(), stat);
        }

        // Fetch corresponding CountriesEntity objects for each maximum ratio record
        List<CountryStatsDTO> resultList = new ArrayList<>();
        for (Integer countryId : maxGdpPerPopulationByCountry.keySet()) {
            CountriesEntity country = entityManager.find(CountriesEntity.class, countryId);
            if (country != null) {
                CountryStatsDTO countryStatsDTO = new CountryStatsDTO();
                countryStatsDTO.setName(country.getName());
                countryStatsDTO.setCountryCode3(country.getCountryCode3());
                countryStatsDTO.setYear(maxGdpPerPopulationByCountry.get(countryId).getYear());
                countryStatsDTO.setPopulation(maxGdpPerPopulationByCountry.get(countryId).getPopulation());
                countryStatsDTO.setGdp(maxGdpPerPopulationByCountry.get(countryId).getGdp());

                resultList.add(countryStatsDTO);
            }
        }

        return resultList;
    }

    // You can add additional methods specific to CountryService here
}
