package org.afeka.oop.model;

import java.util.ArrayList;

import DmitryInke.listeners.SystemEventsListener;

public interface IOlympicGames {

	public ArrayList<Competition> getAllCompetitions();

	public ArrayList<Country> getAllCountries();

	public ArrayList<Stadium> getAllStadiums();

	public ArrayList<Person> getAllPersons();

	public ArrayList<Team> getAllTeams();

	public String[] getRanks();
	
	public Enum<SPORT_TYPE> getSportType();

	public void registerListener(SystemEventsListener systemController);

	public void createCompetition(Competition newCompetition) throws Exception;

	public void createCountry(Country newCountry) throws Exception;

	public void createStadium(Stadium newStadium) throws Exception;

	public void createPerson(Person newPerson) throws Exception;

	public void createTeam(Team newTeam) throws Exception;
	
	public void determineTheWinnersInOlympicGames() throws Exception;
	
	public void addSportsmanToTeam(Sportsman newSportsman, Team team) throws Exception;
	
	public void addSportsmanToCompetition(Sportsman newSportsman, SingleCompetition singleCompetition) throws Exception;
	
	public void determineTheWinnersInCompetition(Competition competition) throws Exception;
	
	public void addTeamToCompetition(Team newTeam, TeamCompetition teamCompetition) throws Exception;
}
