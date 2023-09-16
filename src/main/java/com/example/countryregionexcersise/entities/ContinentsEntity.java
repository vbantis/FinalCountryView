package com.example.countryregionexcersise.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "continents", schema = "nation", catalog = "")
@NamedQueries({
        @NamedQuery(name = "ContinentsEntity.getAllContinetsWithCoutryStats",
                query = "SELECT distinct  a.name,r.name,ce.name,cs.year,cs.population,cs.gdp" +
                        " FROM ContinentsEntity a " +
                        "LEFT JOIN RegionsEntity r on r.continentId=a.continentId " +
                        "LEFT JOIN CountriesEntity ce on ce.regionId=r.regionId " +
                        "LEFT JOIN CountryStatsEntity cs on cs.countryId = ce.countryId")


})
public class ContinentsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "continent_id", nullable = false)
    private int continentId;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    public int getContinentId() {
        return continentId;
    }

    public void setContinentId(int continentId) {
        this.continentId = continentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContinentsEntity that = (ContinentsEntity) o;

        if (continentId != that.continentId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = continentId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
