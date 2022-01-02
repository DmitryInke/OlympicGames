package org.afeka.oop.model;

import org.afeka.oop.dao.MySQL;

import java.util.ArrayList;
import java.util.List;

public class Team implements CompetitorsDetails {
    private Integer tid = null;
    private final SPORT_TYPE sportType;
    private final List<Sportsman> allSportsmans;
    private final Country country;

    public Team(SPORT_TYPE sportType, Country country) {
        this.sportType = sportType;
        this.allSportsmans = new ArrayList<>();
        this.country = country;
    }

    public SPORT_TYPE getSportType() {
        return sportType;
    }

    public List<Sportsman> getAllSportsmans() {
        return allSportsmans;
    }

    public Country getCountry() {
        return country;
    }

    public Integer getPid() {
        return getTid();
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public int teamSize() {
        return allSportsmans.size();
    }

    public void addSportsmanToTeam(Sportsman newSportsman) throws Exception {
        if ((newSportsman.getSportType() == SPORT_TYPE.BOTH || getSportType().equals(newSportsman.getSportType()))
                && newSportsman.getCountry() == getCountry() && !allSportsmans.contains(newSportsman)) {
            allSportsmans.add(newSportsman);
            MySQL.addSportsmanToTeam(this, newSportsman);
        } else {
            throw new Exception("Failed to add because it already exists/invalid credentials");
        }
    }

    public boolean equals(Object other) {
        if (!(other instanceof Team))
            return false;
        Team temp = (Team) other;
        return country.equals(temp.country) && sportType.equals(temp.sportType);
    }

    @Override
    public String toString() {
        return "Team: " + country + " (" + sportType + ")";
    }
}
