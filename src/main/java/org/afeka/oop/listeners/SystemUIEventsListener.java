package org.afeka.oop.listeners;

import org.afeka.oop.model.*;

public interface SystemUIEventsListener {

    void createCountryViewEvent(String name);

    void createStadiumViewEvent(String name, String address, String capacity);

    void createTeamViewEvent(Team team);

    void createSportsmanViewEvent(String name, Country country, Sportsman sportsman, SPORT_TYPE sportType);

    void createRefereeViewEvent(String name, Country country, Referee referee, SPORT_TYPE sportType);

    void createTeamCompetitionViewEvent(Competition<Team> competition);

    void createSingleCompetitionViewEvent(Competition<Sportsman> competition);

    void determineTheWinnersInTeamCompetition(Competition<Team> competition);

    void determineTheWinnersInSingleCompetition(Competition<Sportsman> competition);

    void addSportsmanToTeamViewEvent(Sportsman newSportsman, Team team);

    void addTeamToCompetitionViewEvent(Team team, Competition<Team> competition);

    void addSportsmanToCompetitionViewEvent(Sportsman sportsman, Competition<Sportsman> competition);


}
