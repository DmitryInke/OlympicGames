package org.afeka.oop.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import DmitryInke.listeners.SystemEventsListener;

public class OlympicGames implements IOlympicGames {
	private Date startDate;
	private Date endDate;
	private DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
	private Enum<SPORT_TYPE> sportType;
	private ArrayList<Competition> allCompetitions;
	private ArrayList<Country> allCountries;
	private ArrayList<Stadium> allStadiums;
	private ArrayList<Person> allPersons;
	private ArrayList<Team> allTeams;
	private String[] ranks;
	private ArrayList<SystemEventsListener> listeners;

	public OlympicGames() {
		this.allCompetitions = new ArrayList<Competition>();
		this.allCountries = new ArrayList<Country>();
		this.allStadiums = new ArrayList<Stadium>();
		this.allPersons = new ArrayList<Person>();
		this.allTeams = new ArrayList<Team>();
		this.ranks = new String[3];
		this.listeners = new ArrayList<SystemEventsListener>();
	}

	public void registerListener(SystemEventsListener listener) {
		listeners.add(listener);
	}

	public ArrayList<Competition> getAllCompetitions() {
		return allCompetitions;
	}

	public ArrayList<Country> getAllCountries() {
		return allCountries;
	}

	public ArrayList<Stadium> getAllStadiums() {
		return allStadiums;
	}

	public ArrayList<Person> getAllPersons() {
		return allPersons;
	}

	public ArrayList<Team> getAllTeams() {
		return allTeams;
	}

	public String[] getRanks() {
		return ranks;
	}

	public Enum<SPORT_TYPE> getSportType() {
		return sportType;
	}

	public void createCompetition(Competition newCompetition) throws Exception {
		for (int i = 0; i < allCompetitions.size(); i++) {
			if (allCompetitions.get(i).equals(newCompetition)) {
				throw new Exception("This competition already exists");
			}
		}
		allCompetitions.add(newCompetition);
		fireCreateCompetitionEvent(newCompetition);
	}

	public void createCountry(Country newCountry) throws Exception {
		for (int i = 0; i < allCountries.size(); i++) {
			if (allCountries.get(i).equals(newCountry)) {
				throw new Exception("This country already exists");
			}
		}
		allCountries.add(newCountry);
		fireCreateCountryEvent(newCountry);
	}

	public void createStadium(Stadium newStadium) throws Exception {
		for (int i = 0; i < allStadiums.size(); i++) {
			if (allStadiums.get(i).equals(newStadium)) {
				throw new Exception("This stadium already exists");
			}
		}
		allStadiums.add(newStadium);
		fireCreateStadiumEvent(newStadium);
	}

	public void createPerson(Person newPerson) throws Exception {
		for (int i = 0; i < allPersons.size(); i++) {
			if (allPersons.get(i).equals(newPerson)) {
				throw new Exception("This person already exists");
			}
		}
		allPersons.add(newPerson);
		fireCreatePersonEvent(newPerson);
	}

	public void createTeam(Team newTeam) throws Exception {
		for (int i = 0; i < allTeams.size(); i++) {
			if (allTeams.get(i).equals(newTeam)) {
				throw new Exception("This team already exists");
			}
		}
		allTeams.add(newTeam);
		fireCreateTeamEvent(newTeam);

	}

	public void determineTheWinnersInOlympicGames() throws Exception {
		if (allCompetitions.size() < 1) {
			throw new Exception("It is impossible to determine the winner without competition");
		}
		if (allCountries.size() < 3) {
			throw new Exception(
					"It is impossible It is impossible to determine the winner if there are less than 3 countries");
		}
		Collections.sort(allCountries, new CompareCountryByMedals());
		for (int i = 0; i < ranks.length; i++) {
			ranks[i] = allCountries.get(i).getName();
		}
		fireDetermineTheWinnersInOlympicGamesEvent(ranks);

	}

	public void addSportsmanToTeam(Sportsman newSportsman, Team team) throws Exception {
			team.addSportsmanToTeam(newSportsman);
			fireAddSportsmanToTeam(newSportsman, team);
		}
	

	public void addSportsmanToCompetition(Sportsman newSportsman, SingleCompetition singleCompetition) throws Exception {
				singleCompetition.addSportsManToCompetition(newSportsman);
				fireAddSportsmanToCompetition(newSportsman, singleCompetition);
			}
	
	public void determineTheWinnersInCompetition(Competition competition) throws Exception {
			competition.determineTheWinners();
			fireDetermineTheWinnersInCompetition(competition);
		}
	
	public void addTeamToCompetition(Team newTeam, TeamCompetition teamCompetition) throws Exception{
		teamCompetition.addTeamToCompetition(newTeam);
		fireAddTeamToCompetition(newTeam, teamCompetition);
	}

	private void fireAddTeamToCompetition(Team newTeam, TeamCompetition teamCompetition) {
		for (SystemEventsListener l : listeners) {
			l.addTeamToCompetitionModelEvent(newTeam, teamCompetition);
		}
		
	}

	private void fireDetermineTheWinnersInCompetition(Competition competition) {
		for (SystemEventsListener l : listeners) {
			l.addDetermineTheWinnersInCompetition(competition);
		}
		
	}

	private void fireAddSportsmanToCompetition(Sportsman newSportsman, SingleCompetition singleCompetition) {
		for (SystemEventsListener l : listeners) {
			l.addSportsmanToCompetitionModelEvent(newSportsman, singleCompetition);
		}

	}

	private void fireAddSportsmanToTeam(Sportsman newSportsman, Team team) {
		for (SystemEventsListener l : listeners) {
			l.AddSportsmanToTeamModelEvent(newSportsman, team);
		}

	}

	private void fireDetermineTheWinnersInOlympicGamesEvent(String[] ranks) {
		for (SystemEventsListener l : listeners) {
			l.determineTheWinnersInOlympicGamesModelEvent(ranks);
		}

	}

	private void fireCreateCompetitionEvent(Competition competition) {
		for (SystemEventsListener l : listeners) {
			l.createCompetitionModelEvent(competition);
		}
	}

	private void fireCreateCountryEvent(Country newCountry) {
		for (SystemEventsListener l : listeners) {
			l.createCountryModelEvent(newCountry);
		}

	}

	private void fireCreateTeamEvent(Team newTeam) {
		for (SystemEventsListener l : listeners) {
			l.createTeamModelEvent(newTeam);
		}

	}

	private void fireCreatePersonEvent(Person newPerson) {
		for (SystemEventsListener l : listeners) {
			l.createPersonModelEvent(newPerson);
		}

	}

	private void fireCreateStadiumEvent(Stadium newStadium) {
		for (SystemEventsListener l : listeners) {
			l.createStadiumModelEvent(newStadium);
		}

	}

}
