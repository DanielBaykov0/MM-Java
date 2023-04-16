package com.IntermediateLevelOOP.statickeyword;

public class CountriesApp {

    public static void main(String[] args) {

        System.out.println("Number of countries: " + Country.getNumberOfCountries());
        Country brazil = new Country("Brazil", 210000000, "Brasilia");
        brazil.getDetails();
        Country germany = new Country("Germany", 830000000, "Berlin");
        germany.getDetails();
        Country japan = new Country("Japan", 1250000000, "Tokio");
        japan.getDetails();
        System.out.println("Number of countries: " + Country.getNumberOfCountries());
    }
}
