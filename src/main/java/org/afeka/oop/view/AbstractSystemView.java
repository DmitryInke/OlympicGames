package org.afeka.oop.view;

import org.afeka.oop.listeners.SystemUIEventsListener;
import org.afeka.oop.model.Competition;
import org.afeka.oop.model.Country;
import org.afeka.oop.model.Person;
import org.afeka.oop.model.Sportsman;
import org.afeka.oop.model.Stadium;
import org.afeka.oop.model.Team;

public interface AbstractSystemView {

	void registerListener(SystemUIEventsListener newListener);

	void createCountryViewEvent(Country country);

	void createPersonViewEvent(Person person);

	void createStadiumViewEvent(Stadium stadium);

	void createTeamViewEvent(Team team);

	void AddSportsmanToTeamViewEvent(Sportsman newSportsman, Team team);

	void addTeamToCompetitionViewEvent(Team team, Competition<Team> competition);

	void addSportsmanToCompetitionViewEvent(Sportsman sportsman, Competition<Sportsman> competition);

	void createTeamCompetitionViewEvent(Competition<Team> competition);

	void createSingleCompetitionViewEvent(Competition<Sportsman> competition);

	void successfulMessage(String msg);

	void exceptionMessage(String msg);

}
