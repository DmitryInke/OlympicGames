package org.afeka.oop.model;

import java.util.ArrayList;

public class Team {
	private SPORT_TYPE sportType;
	private ArrayList<Sportsman> allSportsmans;
	private Country country;

	public Team(SPORT_TYPE sportType, Country country) {
		this.sportType = sportType;
		this.allSportsmans = new ArrayList<Sportsman>();
		this.country = country;
	}

	public SPORT_TYPE getSportType() {
		return sportType;
	}

	public ArrayList<Sportsman> getAllSportsmans() {
		return allSportsmans;
	}

	public Country getCountry() {
		return country;
	}
	
	public int teamSize() {
		return allSportsmans.size();
	}

	public void addSportsmanToTeam(Sportsman newSportsman) throws Exception {
		if (newSportsman.getSportType() != getSportType() || newSportsman.getCountry() != getCountry()) {
			throw new Exception("This sportsman is not fit in the team");
		} else {
			for (int i = 0; i < allSportsmans.size(); i++) {
				if (allSportsmans.get(i).equals(newSportsman)) {
					throw new Exception("This sportsman already exists in team");
				}
			}
			allSportsmans.add(newSportsman);
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
		return "Team [sportType=" + sportType + ", allSportsmans=" + allSportsmans + ", country=" + country.getName()
				+ "]";
	}

}
