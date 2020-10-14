package org.afeka.oop.listeners;

import org.afeka.oop.model.Competition;
import org.afeka.oop.model.Country;
import org.afeka.oop.model.Person;
import org.afeka.oop.model.Sportsman;
import org.afeka.oop.model.Stadium;
import org.afeka.oop.model.Team;

public interface SystemEventsListener {

	void createCountryModelEvent(Country country);

	void createPersonModelEvent(Person person);

	void createStadiumModelEvent(Stadium stadium);

	void createTeamModelEvent(Team team);

	void determineTheWinnersInOlympicGamesModelEvent(String[] winners);

	void AddSportsmanToTeamModelEvent(Sportsman newSportsman, Team team);

	void addTeamToCompetitionModelEvent(Team team, Competition<Team> competition);

	void addSportsmanToCompetitionModelEvent(Sportsman sportsman, Competition<Sportsman> competition);

	void addDetermineTheWinnersInTeamCompetitionModelEvent(Competition<Team> competition);

	void addDetermineTheWinnersInSingleCompetitionModelEvent(Competition<Sportsman> competition);

	void createTeamCompetitionModelEvent(Competition<Team> competition);

	void createSingleCompetitionModelEvent(Competition<Sportsman> competition);

}
