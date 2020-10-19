package org.afeka.oop.listeners;

import org.afeka.oop.model.*;

public interface SystemEventsListener {

    void createCountryModelEvent(Country country);

    void createSportsmanModelEvent(Sportsman newSportsman);

    void createRefereeModelEvent(Referee newReferee);

    void createStadiumModelEvent(Stadium stadium);

    void createTeamModelEvent(Team team);

    void createTeamCompetitionModelEvent(Competition<Team> competition);

    void createSingleCompetitionModelEvent(Competition<Sportsman> competition);

}
