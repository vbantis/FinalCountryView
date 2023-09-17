package com.example.countryregionexcersise.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

public class LanguageDTO implements Serializable {
   private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LanguageDTO(String language) {
        this.language = language;
    }
}
