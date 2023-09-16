package com.example.countryregionexcersise.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "regions", schema = "nation", catalog = "")
public class RegionsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "region_id", nullable = false)
    private int regionId;
    @Basic
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic
    @Column(name = "continent_id", nullable = false)
    private int continentId;

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContinentId() {
        return continentId;
    }

    public void setContinentId(int continentId) {
        this.continentId = continentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegionsEntity that = (RegionsEntity) o;

        if (regionId != that.regionId) return false;
        if (continentId != that.continentId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = regionId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + continentId;
        return result;
    }
}
