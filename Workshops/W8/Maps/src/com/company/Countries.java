package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Countries {
    private Map<String, String> countriesCapital = new HashMap<String, String>();
    private String chosenCountry;

    public Countries() {
        countriesCapital.put("Afghanistan", "Kabul");
        countriesCapital.put("Albania", "Tirana");
        countriesCapital.put("Algeria", "Algiers");
        countriesCapital.put("Madagascar", "Antananarivo");
        countriesCapital.put("Maldives", "Male");
        countriesCapital.put("Bahamas", "Nassau");
        countriesCapital.put("Denmark", "Copenhagen");
        countriesCapital.put("Dominican Republic", "Santo Domingo");
        countriesCapital.put("Hungary", "Budapest");
        countriesCapital.put("Indonesia", "Jakarta");
        countriesCapital.put("Israel", "Jerusalem");
        countriesCapital.put("Japan", "Tokyo");
        countriesCapital.put("Kosovo", "Pristina");
        countriesCapital.put("Libya", "Tripoli");
        countriesCapital.put("Lebanon", "Beirut");
        countriesCapital.put("Yemen", "Sana'a");
        countriesCapital.put("United Arab Emirates", "Abu Dhabi");
        countriesCapital.put("Turkey", "Ankara");
        countriesCapital.put("Sudan", "Khartoum");
        countriesCapital.put("Switzerland", "Bern");
        countriesCapital.put("Germany", "Berlin");
        countriesCapital.put("Jamaica", "Kingston");
        countriesCapital.put("Uruguay", "Montevideo");
        countriesCapital.put("Venezuela", "Caracas");
        countriesCapital.put("Zimbabwe", "Harare");
    }

    public String getCapital() {
        boolean containsCountry = countriesCapital.containsKey(chosenCountry);

        if (containsCountry) {
            return countriesCapital.get(chosenCountry);
        } else {
            return "NOT FOUND";
        }
    }

    public void processRequest() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a country: ");
        chosenCountry = sc.nextLine();
        System.out.println("The capital of " + chosenCountry + " is " + getCapital());
    }
}
