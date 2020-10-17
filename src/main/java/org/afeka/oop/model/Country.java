package org.afeka.oop.model;

public class Country {
    private String name;
    private int numOfMedals;

    private final int FIRST_PLACE = 3;
    private final int SECOND_PLACE = 2;
    private final int THIRD_PLACE = 1;

    public Country(String name) {
        this.name = name;
        this.numOfMedals = 0;
    }

    public int getNumOfMedals() {
        return numOfMedals;
    }

    public void CalculateNumOfMedals(int place) {
        switch (place) {
            case 0:
                this.numOfMedals += FIRST_PLACE;
                break;
            case 1:
                this.numOfMedals += SECOND_PLACE;
                break;
            case 2:
                this.numOfMedals += THIRD_PLACE;
                break;
        }
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object other) {
        if (!(other instanceof Country))
            return false;
        Country temp = (Country) other;
        return name.equalsIgnoreCase(temp.name);
    }

    @Override
    public String toString() {
        return getName();
    }

}
