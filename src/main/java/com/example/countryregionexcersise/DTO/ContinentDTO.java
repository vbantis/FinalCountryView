package com.example.countryregionexcersise.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

public class ContinentDTO implements Serializable {
    private String continentName;
    private String regionName;
    private String countryName;
    private Integer year;
    private Integer population;
    private BigDecimal gdp;

    // Constructors, getters and setters

    public ContinentDTO(String continentName, String regionName, String countryName,
                        Integer year, Integer population, BigDecimal gdp) {
        this.continentName = continentName;
        this.regionName = regionName;
        this.countryName = countryName;
        this.year = year;
        this.population = population;
        this.gdp = gdp;
    }

    public String getContinentName() {
        return continentName;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getCountryName() {
        return countryName;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getPopulation() {
        return population;
    }

    public BigDecimal getGdp() {
        return gdp;
    }
}
