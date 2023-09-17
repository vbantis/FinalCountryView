package com.example.countryregionexcersise.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "countries", schema = "nation", catalog = "")
@NamedQueries({
        @NamedQuery(name = "CountriesEntity.findByName",
                query = "SELECT c FROM CountriesEntity c WHERE c.name = :name")

})
public class CountriesEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "country_id", nullable = false)
    private int countryId;
    @Basic
    @Column(name = "name", nullable = true, length = 50)
    private String name;
    @Basic
    @Column(name = "area", nullable = false, precision = 15, scale = 2)
    private BigDecimal area;
    @Basic
    @Column(name = "national_day", nullable = true)
    private Date nationalDay;
    @Basic
    @Column(name = "country_code2", nullable = false, length = 2)
    private String countryCode2;
    @Basic
    @Column(name = "country_code3", nullable = false, length = 3)
    private String countryCode3;
    @Basic
    @Column(name = "region_id", nullable = false)
    private int regionId;

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public Date getNationalDay() {
        return nationalDay;
    }

    public void setNationalDay(Date nationalDay) {
        this.nationalDay = nationalDay;
    }

    public String getCountryCode2() {
        return countryCode2;
    }

    public void setCountryCode2(String countryCode2) {
        this.countryCode2 = countryCode2;
    }

    public String getCountryCode3() {
        return countryCode3;
    }

    public void setCountryCode3(String countryCode3) {
        this.countryCode3 = countryCode3;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountriesEntity that = (CountriesEntity) o;

        if (countryId != that.countryId) return false;
        if (regionId != that.regionId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (area != null ? !area.equals(that.area) : that.area != null) return false;
        if (nationalDay != null ? !nationalDay.equals(that.nationalDay) : that.nationalDay != null) return false;
        if (countryCode2 != null ? !countryCode2.equals(that.countryCode2) : that.countryCode2 != null) return false;
        if (countryCode3 != null ? !countryCode3.equals(that.countryCode3) : that.countryCode3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = countryId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + (nationalDay != null ? nationalDay.hashCode() : 0);
        result = 31 * result + (countryCode2 != null ? countryCode2.hashCode() : 0);
        result = 31 * result + (countryCode3 != null ? countryCode3.hashCode() : 0);
        result = 31 * result + regionId;
        return result;
    }
}
