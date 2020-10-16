package org.afeka.oop.model;

import java.util.Comparator;

public class CompareCountryByMedals implements Comparator<Country> {

    @Override
    public int compare(Country country1, Country country2) {
        if (country1.getNumOfMedals() > country2.getNumOfMedals())
            return -1;
        else if (country1.getNumOfMedals() < country2.getNumOfMedals())
            return 1;
        else
            return 0;
    }

}
