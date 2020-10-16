package org.afeka.oop.model;

import org.afeka.oop.listeners.SystemEventsListener;

import java.util.List;

public interface IOlympicGames {

    List<Competition<Team>> getAllTeamsInCompetition();

    List<Competition<Sportsman>> getAllSportsmansInCompetition();

    List<Country> getAllCountries();

    List<Stadium> getAllStadiums();

    List<Person> getAllPersons();

    List<Team> getAllTeams();

    String[] getWinners();

    SPORT_TYPE getSportType();

    void registerListener(SystemEventsListener systemController);

    void createTeamCompetition(Competition<Team> newCompetition) throws Exception;

    void createSingleCompetition(Competition<Sportsman> newCompetition) throws Exception;

    void createCountry(Country newCountry) throws Exception;

    void createStadium(Stadium newStadium) throws Exception;

    void createPerson(Person newPerson) throws Exception;

    void createTeam(Team newTeam) throws Exception;

    void determineTheWinnersInOlympicGames() throws Exception;

    void addSportsmanToTeam(Sportsman newSportsman, Team team) throws Exception;

    void addTeamToCompetition(Team team, Competition<Team> competition) throws Exception;

    void addSportsmanToCompetition(Sportsman sportsman, Competition<Sportsman> competition) throws Exception;

    void determineTheWinnersInTeamCompetition(Competition<Team> competition) throws Exception;

    void determineTheWinnersInSingleCompetition(Competition<Sportsman> competition) throws Exception;
}
