package org.afeka.oop.model;

public abstract class Person {
    protected String name;
    protected SPORT_TYPE sportType;
    protected Country country;

    public Person(String name, Country country, SPORT_TYPE sportType) {
        this.country = country;
        this.name = name;
        this.sportType = sportType;
    }

    public String getName() {
        return name;
    }

    public SPORT_TYPE getSportType() {
        return sportType;
    }

    public Country getCountry() {
        return country;
    }

    public boolean equals(Object other) {
        if (!(other instanceof Person))
            return false;

        Person temp = (Person) other;
        return name.equalsIgnoreCase(temp.name) && sportType.equals(temp.sportType) && country.equals(temp.country);
    }

    @Override
    public String toString() {
        return "" + name + ", country: " + country.getName() + ", sport type: " + (sportType);
    }
}
