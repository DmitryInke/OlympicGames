package org.afeka.oop.model;

public class Referee extends Person {

    public Referee(String name, Country country, SPORT_TYPE sportType) {
        super(name, country, sportType);
    }

    public boolean equals(Object other) {
        if (!(other instanceof Referee))
            return false;

        return super.equals(other);
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(super.toString());
        return sb.toString();
    }
}
