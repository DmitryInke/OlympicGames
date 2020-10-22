package org.afeka.oop.listeners;

import org.afeka.oop.model.*;

import java.time.LocalDate;

public interface SystemUIEventsListener {

    void createCountryViewEvent(String name);

    void createStadiumViewEvent(String name, String address, String capacity);

    void createTeamViewEvent(Country country, SPORT_TYPE sportType);

    void createSportsmanViewEvent(String name, Country country, Sportsman sportsman, SPORT_TYPE sportType);

    void createRefereeViewEvent(String name, Country country, Referee referee, SPORT_TYPE sportType);

    void createTeamCompetitionViewEvent(SPORT_TYPE sportType, Stadium stadium, Referee referee, Class<Team> clazz);

    void createSingleCompetitionViewEvent(SPORT_TYPE sportType, Stadium stadium, Referee referee, Class<Sportsman> clazz);

    void determineTheWinnersInTeamCompetition(Competition<Team> competition);

    void determineTheWinnersInSingleCompetition(Competition<Sportsman> competition);

    void addSportsmanToTeamViewEvent(Sportsman newSportsman, Team team);

    void addTeamToCompetitionViewEvent(Team team, Competition<Team> competition);

    void addSportsmanToCompetitionViewEvent(Sportsman sportsman, Competition<Sportsman> competition);

    void determineTheWinnersInOlympicGames(LocalDate startDate, LocalDate endDate);


}
