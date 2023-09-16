package com.example.countryregionexcersise.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "country_stats", schema = "nation", catalog = "")
@IdClass(CountryStatsEntityPK.class)
@NamedQueries({
        @NamedQuery(name = "CountryStatsEntity.findValidStatsOrderByRatio",
                query = "SELECT c FROM CountryStatsEntity c WHERE c.population IS NOT NULL AND c.gdp IS NOT NULL ORDER BY c.gdp / c.population DESC")
})
public class CountryStatsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "country_id", nullable = false)
    private int countryId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "year", nullable = false)
    private int year;
    @Basic
    @Column(name = "population", nullable = true)
    private Integer population;
    @Basic
    @Column(name = "gdp", precision = 15, scale = 0)
    private BigDecimal gdp;

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public BigDecimal getGdp() {
        return gdp;
    }

    public void setGdp(BigDecimal gdp) {
        this.gdp = gdp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryStatsEntity that = (CountryStatsEntity) o;

        if (countryId != that.countryId) return false;
        if (year != that.year) return false;
        if (population != null ? !population.equals(that.population) : that.population != null) return false;
        if (gdp != null ? !gdp.equals(that.gdp) : that.gdp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = countryId;
        result = 31 * result + year;
        result = 31 * result + (population != null ? population.hashCode() : 0);
        result = 31 * result + (gdp != null ? gdp.hashCode() : 0);
        return result;
    }
}
