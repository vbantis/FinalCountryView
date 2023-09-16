package com.example.countryregionexcersise.services;

import com.example.countryregionexcersise.DTO.ContinentDTO;
import com.example.countryregionexcersise.DTO.CountryStatsDTO;
import com.example.countryregionexcersise.entities.ContinentsEntity;
import com.example.countryregionexcersise.entities.CountriesEntity;
import com.example.countryregionexcersise.entities.CountryStatsEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContinetsService extends BaseService<ContinentsEntity, Integer> {
    @PersistenceContext
    private EntityManager entityManager;
    private final ContinentsRepository continentsRepository;

    @Autowired
    public ContinetsService(ContinentsRepository repository, ContinentsRepository countryRepository) {
        super(repository);
        this.continentsRepository = countryRepository;
    }

    public List<ContinentDTO> getContinentsView() {
        Query query = entityManager.createNamedQuery("ContinentsEntity.getAllContinetsWithCoutryStats");
        List<Object[]> results = query.getResultList();
        List<ContinentDTO> dtos = new ArrayList<>();

        for (Object[] row : results) {
            String continentName = (String) row[0];
            String regionName = (String) row[1];
            String countryName = (String) row[2];
            Integer year = (Integer) row[3];
            Integer population = (Integer) row[4];
            BigDecimal gdp = (BigDecimal) row[5];

            ContinentDTO dto = new ContinentDTO(continentName, regionName, countryName, year, population, gdp);
            dtos.add(dto);
        }

        return dtos;

    }


}
