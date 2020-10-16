package org.afeka.oop.view;

import org.afeka.oop.listeners.SystemUIEventsListener;
import org.afeka.oop.model.*;

public interface AbstractSystemView {

    void registerListener(SystemUIEventsListener newListener);

    void createCountryViewEvent(Country country);

    void createPersonViewEvent(Person person);

    void createStadiumViewEvent(Stadium stadium);

    void createTeamViewEvent(Team team);

    void addSportsmanToTeamViewEvent(Sportsman newSportsman, Team team);

    void addDetermineTheWinnersInTeamCompetitionViewEvent(Competition<Team> competition);

    void addDetermineTheWinnersInSingleCompetitionViewEvent(Competition<Sportsman> competition);

    void determineTheWinnersInOlympicGamesViewEvent(String[] winners);

    void addTeamToCompetitionViewEvent(Team team, Competition<Team> competition);

    void addSportsmanToCompetitionViewEvent(Sportsman sportsman, Competition<Sportsman> competition);

    void createTeamCompetitionViewEvent(Competition<Team> competition);

    void createSingleCompetitionViewEvent(Competition<Sportsman> competition);

    void successfulMessage(String msg);

    void exceptionMessage(String msg);

}
