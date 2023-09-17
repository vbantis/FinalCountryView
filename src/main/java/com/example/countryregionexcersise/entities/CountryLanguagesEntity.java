package com.example.countryregionexcersise.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "country_languages", schema = "nation", catalog = "")
@IdClass(CountryLanguagesEntityPK.class)
@NamedQueries({
        @NamedQuery(name = "CountryLanguagesEntity.findSpokenLanguages",
                query = "SELECT l.language FROM CountryLanguagesEntity cl LEFT JOIN LanguagesEntity l on l.languageId= cl.languageId WHERE cl.countryId = :id"),

})
public class CountryLanguagesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "country_id", nullable = false)
    private int countryId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "language_id", nullable = false)
    private int languageId;
    @Basic
    @Column(name = "official", nullable = false)
    private byte official;

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public byte getOfficial() {
        return official;
    }

    public void setOfficial(byte official) {
        this.official = official;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryLanguagesEntity that = (CountryLanguagesEntity) o;

        if (countryId != that.countryId) return false;
        if (languageId != that.languageId) return false;
        if (official != that.official) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = countryId;
        result = 31 * result + languageId;
        result = 31 * result + (int) official;
        return result;
    }
}
