package org.afeka.oop.listeners;

import org.afeka.oop.model.*;

public interface SystemEventsListener {

    void createCountryModelEvent(Country country);

    void createPersonModelEvent(Person person);

    void createStadiumModelEvent(Stadium stadium);

    void createTeamModelEvent(Team team);

    void determineTheWinnersInOlympicGamesModelEvent(String[] winners);

    void addSportsmanToTeamModelEvent(Sportsman newSportsman, Team team);

    void addTeamToCompetitionModelEvent(Team team, Competition<Team> competition);

    void addSportsmanToCompetitionModelEvent(Sportsman sportsman, Competition<Sportsman> competition);

    void determineTheWinnersInTeamCompetitionModelEvent(Competition<Team> competition);

    void determineTheWinnersInSingleCompetitionModelEvent(Competition<Sportsman> competition);

    void createTeamCompetitionModelEvent(Competition<Team> competition);

    void createSingleCompetitionModelEvent(Competition<Sportsman> competition);

}
