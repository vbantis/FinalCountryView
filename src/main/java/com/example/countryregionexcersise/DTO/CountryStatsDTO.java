package com.example.countryregionexcersise.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

public class CountryStatsDTO implements Serializable {
 private String name;
 private String countryCode3;
 private Integer year;
 private Integer population;
 private BigDecimal gdp;

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getCountryCode3() {
  return countryCode3;
 }

 public void setCountryCode3(String countryCode3) {
  this.countryCode3 = countryCode3;
 }

 public Integer getYear() {
  return year;
 }

 public void setYear(Integer year) {
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
}
