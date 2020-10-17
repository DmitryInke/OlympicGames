package org.afeka.oop.listeners;

import org.afeka.oop.model.*;

import java.util.List;

public interface SystemUIEventsListener {
    List<Competition<Team>> getAllTeamsInCompetition();

    List<Competition<Sportsman>> getAllSportsmansInCompetition();

    List<Country> getAllCountries();

    List<Stadium> getAllStadiums();

    List<Person> getAllPersons();

    List<Team> getAllTeams();

    void showAllDataViewEvent();

    void createCountryViewEvent(String name);

    void createStadiumViewEvent(String name, String address, String capacity);

    void createTeamViewEvent(Team team);

    void createPersonViewEvent(Person person);

    void createTeamCompetitionViewEvent(Competition<Team> competition);

    void createSingleCompetitionViewEvent(Competition<Sportsman> competition);

    void determineTheWinnersInTeamCompetition(Competition<Team> competition);

    void determineTheWinnersInSingleCompetition(Competition<Sportsman> competition);

    void addSportsmanToTeamViewEvent(Sportsman newSportsman, Team team);

    void addTeamToCompetitionViewEvent(Team team, Competition<Team> competition);

    void addSportsmanToCompetitionViewEvent(Sportsman sportsman, Competition<Sportsman> competition);


}
