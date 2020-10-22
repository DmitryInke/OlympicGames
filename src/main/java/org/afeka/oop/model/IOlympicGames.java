package org.afeka.oop.model;

import org.afeka.oop.listeners.SystemEventsListener;

import java.time.LocalDate;

public interface IOlympicGames {
    String[] getWinners();

    void registerListener(SystemEventsListener systemController);

    void createTeamCompetition(Competition<Team> newCompetition) throws Exception;

    void createSingleCompetition(Competition<Sportsman> newCompetition) throws Exception;

    void createCountry(Country newCountry) throws Exception;

    void createStadium(Stadium newStadium) throws Exception;

    void createSportsman(Sportsman newSportsman) throws Exception;

    void createReferee(Referee newReferee) throws Exception;

    void createTeam(Team newTeam) throws Exception;

    void determineTheWinnersInOlympicGames(LocalDate startDate, LocalDate endDate) throws Exception;

    void addSportsmanToTeam(Sportsman newSportsman, Team team) throws Exception;

    void addTeamToCompetition(Team team, Competition<Team> competition) throws Exception;

    void addSportsmanToCompetition(Sportsman sportsman, Competition<Sportsman> competition) throws Exception;

    void determineTheWinnersInTeamCompetition(Competition<Team> competition) throws Exception;

    void determineTheWinnersInSingleCompetition(Competition<Sportsman> competition) throws Exception;
}
