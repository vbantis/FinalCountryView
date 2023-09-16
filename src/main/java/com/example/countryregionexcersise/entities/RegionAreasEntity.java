package com.example.countryregionexcersise.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "region_areas", schema = "nation", catalog = "")
public class RegionAreasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "region_name", nullable = false, length = 100)
    private String regionName;
    @Basic
    @Column(name = "region_area", precision = 15, scale = 2, nullable = false)
    private BigDecimal regionArea;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public BigDecimal getRegionArea() {
        return regionArea;
    }

    public void setRegionArea(BigDecimal regionArea) {
        this.regionArea = regionArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegionAreasEntity that = (RegionAreasEntity) o;

        if (regionName != null ? !regionName.equals(that.regionName) : that.regionName != null) return false;
        if (regionArea != null ? !regionArea.equals(that.regionArea) : that.regionArea != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = regionName != null ? regionName.hashCode() : 0;
        result = 31 * result + (regionArea != null ? regionArea.hashCode() : 0);
        return result;
    }
}
