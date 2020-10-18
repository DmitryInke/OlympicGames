package org.afeka.oop.view;

import org.afeka.oop.listeners.SystemUIEventsListener;
import org.afeka.oop.model.*;

public interface AbstractSystemView {

    void registerListener(SystemUIEventsListener newListener);

    void createCountryViewEvent(Country country);

    void createSportsmanViewEvent(Sportsman sportsman);

    void createRefereeViewEvent(Referee referee);

    void createStadiumViewEvent(Stadium stadium);

    void createTeamViewEvent(Team team);

    void createTeamCompetitionViewEvent(Competition<Team> competition);

    void createSingleCompetitionViewEvent(Competition<Sportsman> competition);

    void successfulMessage(String msg);

    void exceptionMessage(String msg);

}
