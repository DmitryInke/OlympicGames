package org.afeka.oop.model;

public class Sportsman extends Person implements CompetitorsDetails {

    public Sportsman(String name, Country country, SPORT_TYPE sportType) {
        super(name, country, sportType);
    }

    public boolean equals(Object other) {
        if (!(other instanceof Sportsman))
            return false;

        if (!(super.equals(other)))
            return false;

        return true;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(super.toString());
        return sb.toString();
    }
}
