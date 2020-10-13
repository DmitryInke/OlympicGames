package org.afeka.oop.listeners;

import org.afeka.oop.model.*;


public interface SystemEventsListener {

	void createCountryModelEvent(Country country);

	void createCompetitionModelEvent(Competition competition);

	void createPersonModelEvent(Person person);

	void createStadiumModelEvent(Stadium stadium);

	void createTeamModelEvent(Team team);

	void determineTheWinnersInOlympicGamesModelEvent(String[] ranks);

	void AddSportsmanToTeamModelEvent(Sportsman newSportsman, Team team);

	void addSportsmanToCompetitionModelEvent(Sportsman newSportsman, SingleCompetition singleCompetition);

	void addDetermineTheWinnersInCompetition(Competition competition);

	void addTeamToCompetitionModelEvent(Team newTeam, TeamCompetition teamCompetition);
}
