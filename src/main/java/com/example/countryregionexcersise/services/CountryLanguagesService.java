package com.example.countryregionexcersise.services;

import com.example.countryregionexcersise.DTO.ContinentDTO;
import com.example.countryregionexcersise.DTO.LanguageDTO;
import com.example.countryregionexcersise.entities.CountryLanguagesEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CountryLanguagesService extends BaseService<CountryLanguagesEntity, Integer> {
    private final CountryLanguagesRepository countryRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public CountryLanguagesService(CountryLanguagesRepository repository, CountryLanguagesRepository countryRepository) {
        super(repository);
        this.countryRepository = countryRepository;
    }

    public List<LanguageDTO> getSpokenLanguages(String id) {
        Query query = entityManager.createNamedQuery("CountryLanguagesEntity.findSpokenLanguages")
                .setParameter("id", id);
        List<String> results = query.getResultList();
        List<LanguageDTO> dtos = new ArrayList<>();

        for (String language : results) {
            LanguageDTO dto = new LanguageDTO(language);
            dtos.add(dto);
        }
        return dtos;
    }

    // You can add additional methods specific to CountryService here
}
