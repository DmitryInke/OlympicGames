package org.afeka.oop.listeners;

import java.util.List;

import org.afeka.oop.model.Competition;
import org.afeka.oop.model.Country;
import org.afeka.oop.model.Person;
import org.afeka.oop.model.SPORT_TYPE;
import org.afeka.oop.model.Sportsman;
import org.afeka.oop.model.Stadium;
import org.afeka.oop.model.Team;

public interface SystemUIEventsListener {
	List<Competition<Team>> getAllTeamsInCompetition();

	List<Competition<Sportsman>> getAllSportsmansInCompetition();

	List<Country> getAllCountries();

	List<Stadium> getAllStadiums();

	List<Person> getAllPersons();

	List<Team> getAllTeams();

	SPORT_TYPE getSportType();
	
	void showAllDataViewEvenet();
	
	void createCountryViewEvent(Country country);
	
	void createStadiumViewEvent(Stadium stadium);

	void createTeamViewEvent(Team team);
	
	void createPersonViewEvent(Person person);
	
	void createTeamCompetitionViewEvent(Competition<Team> competition);

	void createSingleCompetitionViewEvent(Competition<Sportsman> competition);
	
	void addDetermineTheWinnersInTeamCompetition(Competition<Team> competition);

	void addDetermineTheWinnersInSingleCompetition(Competition<Sportsman> competition);
	
	void AddSportsmanToTeamViewEvent(Sportsman newSportsman, Team team);
	
	void addTeamToCompetitionViewEvent(Team team, Competition<Team> competition);

	void addSportsmanToCompetitionViewEvent(Sportsman sportsman, Competition<Sportsman> competition);
	
	
}
