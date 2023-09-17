package com.example.countryregionexcersise;

import com.example.countryregionexcersise.DTO.ContinentDTO;
import com.example.countryregionexcersise.DTO.CountryStatsDTO;
import com.example.countryregionexcersise.DTO.LanguageDTO;
import com.example.countryregionexcersise.entities.CountriesEntity;
import com.example.countryregionexcersise.entities.CountryLanguagesEntity;
import com.example.countryregionexcersise.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/countries")
@CrossOrigin(origins = "http://localhost:4200")
public class CountryController {

    @Autowired
    private CountryService service;
    @Autowired
    private CountryLanguagesService countryLanguagesService;
    @Autowired
    private CountryStatsService countryStatsService;
    @Autowired
    private ContinetsService continetsService;

    /* Question 1 endpoint start*/
    @GetMapping
    public List<CountriesEntity> getAllCountries() {
        return service.findAll();
    }

    @GetMapping("/country/{id}")
    public List<LanguageDTO> getCountriesSpokenLanguages(@PathVariable String id) {
        return countryLanguagesService.getSpokenLanguages(id);
    }

    /* Question 1 endpoint end*/

    //TODO EMPTY SPACE


    /* Question 2endpoint start*/
    @GetMapping("/stats")
    public List<CountryStatsDTO> getCountriesStats() {
        return countryStatsService.getCountryStats();
    }
    /* Question 2endpoint end*/ //

    //TODO EMPTY SPACE

    /* Question 3 endpoint start*/
    @GetMapping("/continents")
    public List<ContinentDTO> getCountriesContinents() {
        return continetsService.getContinentsView();
    }
    /* Question 3 endpoint end*/

    @GetMapping("/{id}")
    public Optional<CountriesEntity> getById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public CountriesEntity create(@RequestBody CountriesEntity country) {
        return service.save(country);
    }

    @PutMapping("/{id}")
    public CountriesEntity update(@PathVariable Integer id, @RequestBody CountriesEntity country) {
        // Additional checks and logic can go here
        return service.save(country);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
