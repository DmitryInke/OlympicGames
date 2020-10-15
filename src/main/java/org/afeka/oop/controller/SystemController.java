package org.afeka.oop.controller;

import java.util.List;

import org.afeka.oop.listeners.SystemEventsListener;
import org.afeka.oop.listeners.SystemUIEventsListener;
import org.afeka.oop.model.Competition;
import org.afeka.oop.model.Country;
import org.afeka.oop.model.IOlympicGames;
import org.afeka.oop.model.Person;
import org.afeka.oop.model.SPORT_TYPE;
import org.afeka.oop.model.Sportsman;
import org.afeka.oop.model.Stadium;
import org.afeka.oop.model.Team;
import org.afeka.oop.view.AbstractSystemView;

public class SystemController implements SystemUIEventsListener, SystemEventsListener {

	private IOlympicGames systemModel;
	private AbstractSystemView systemView;

	public SystemController(IOlympicGames theModel, AbstractSystemView theView) {
		this.systemModel = theModel;
		this.systemView = theView;

		systemModel.registerListener(this);
		systemView.registerListener(this);
	}

	@Override
	public void createCountryModelEvent(Country country) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createPersonModelEvent(Person person) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createStadiumModelEvent(Stadium stadium) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createTeamModelEvent(Team team) {
		// TODO Auto-generated method stub

	}

	@Override
	public void determineTheWinnersInOlympicGamesModelEvent(String[] winners) {
		// TODO Auto-generated method stub

	}

	@Override
	public void AddSportsmanToTeamModelEvent(Sportsman newSportsman, Team team) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTeamToCompetitionModelEvent(Team team, Competition<Team> competition) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSportsmanToCompetitionModelEvent(Sportsman sportsman, Competition<Sportsman> competition) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addDetermineTheWinnersInTeamCompetitionModelEvent(Competition<Team> competition) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addDetermineTheWinnersInSingleCompetitionModelEvent(Competition<Sportsman> competition) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createTeamCompetitionModelEvent(Competition<Team> competition) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createSingleCompetitionModelEvent(Competition<Sportsman> competition) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Competition<Team>> getAllTeamsInCompetition() {
		return systemModel.getAllTeamsInCompetition();
	}

	@Override
	public List<Competition<Sportsman>> getAllSportsmansInCompetition() {
		return systemModel.getAllSportsmansInCompetition();
	}

	@Override
	public List<Country> getAllCountries() {
		return systemModel.getAllCountries();
	}

	@Override
	public List<Stadium> getAllStadiums() {
		return systemModel.getAllStadiums();
	}

	@Override
	public List<Person> getAllPersons() {
		return systemModel.getAllPersons();
	}

	@Override
	public List<Team> getAllTeams() {
		return systemModel.getAllTeams();
	}

	@Override
	public SPORT_TYPE getSportType() {
		return systemModel.getSportType();
	}

	@Override
	public void showAllDataViewEvenet() {
		for (Competition<Team> competition : systemModel.getAllTeamsInCompetition()) {
			systemView.createTeamCompetitionViewEvent(competition);
		}

		for (Competition<Sportsman> competition : systemModel.getAllSportsmansInCompetition()) {
			systemView.createSingleCompetitionViewEvent(competition);
		}
		
		

	}

	@Override
	public void createCountryViewEvent(Country country) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createStadiumViewEvent(Stadium stadium) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createTeamViewEvent(Team team) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createPersonViewEvent(Person person) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createTeamCompetitionViewEvent(Competition<Team> competition) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createSingleCompetitionViewEvent(Competition<Sportsman> competition) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addDetermineTheWinnersInTeamCompetition(Competition<Team> competition) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addDetermineTheWinnersInSingleCompetition(Competition<Sportsman> competition) {
		// TODO Auto-generated method stub

	}

	@Override
	public void AddSportsmanToTeamViewEvent(Sportsman newSportsman, Team team) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTeamToCompetitionViewEvent(Team team, Competition<Team> competition) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSportsmanToCompetitionViewEvent(Sportsman sportsman, Competition<Sportsman> competition) {
		// TODO Auto-generated method stub

	}

}
