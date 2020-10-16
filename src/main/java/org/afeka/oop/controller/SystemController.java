package org.afeka.oop.controller;

import org.afeka.oop.listeners.SystemEventsListener;
import org.afeka.oop.listeners.SystemUIEventsListener;
import org.afeka.oop.model.*;
import org.afeka.oop.view.AbstractSystemView;

import java.util.List;

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
        systemView.createCountryViewEvent(country);

    }

    @Override
    public void createPersonModelEvent(Person person) {
        systemView.createPersonViewEvent(person);

    }

    @Override
    public void createStadiumModelEvent(Stadium stadium) {
        systemView.createStadiumViewEvent(stadium);

    }

    @Override
    public void createTeamModelEvent(Team team) {
        systemView.createTeamViewEvent(team);

    }

    @Override
    public void determineTheWinnersInOlympicGamesModelEvent(String[] winners) {
        systemView.determineTheWinnersInOlympicGamesViewEvent(winners);

    }

    @Override
    public void addSportsmanToTeamModelEvent(Sportsman newSportsman, Team team) {
        systemView.addSportsmanToTeamViewEvent(newSportsman, team);

    }

    @Override
    public void addTeamToCompetitionModelEvent(Team team, Competition<Team> competition) {
        systemView.addTeamToCompetitionViewEvent(team, competition);

    }

    @Override
    public void addSportsmanToCompetitionModelEvent(Sportsman sportsman, Competition<Sportsman> competition) {
        systemView.addSportsmanToCompetitionViewEvent(sportsman, competition);

    }

    @Override
    public void determineTheWinnersInTeamCompetitionModelEvent(Competition<Team> competition) {
        systemView.addDetermineTheWinnersInTeamCompetitionViewEvent(competition);

    }

    @Override
    public void determineTheWinnersInSingleCompetitionModelEvent(Competition<Sportsman> competition) {
        systemView.addDetermineTheWinnersInSingleCompetitionViewEvent(competition);

    }

    @Override
    public void createTeamCompetitionModelEvent(Competition<Team> competition) {
        systemView.createTeamCompetitionViewEvent(competition);

    }

    @Override
    public void createSingleCompetitionModelEvent(Competition<Sportsman> competition) {
        systemView.createSingleCompetitionViewEvent(competition);

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
    public void showAllDataViewEvent() {
        for (Competition<Team> competition : systemModel.getAllTeamsInCompetition()) {
            systemView.createTeamCompetitionViewEvent(competition);
        }

        for (Competition<Sportsman> competition : systemModel.getAllSportsmansInCompetition()) {
            systemView.createSingleCompetitionViewEvent(competition);
        }

        for (Country country : systemModel.getAllCountries()) {
            systemView.createCountryViewEvent(country);
        }

        for (Stadium stadium : systemModel.getAllStadiums()) {
            systemView.createStadiumViewEvent(stadium);
        }

        for (Person person : systemModel.getAllPersons()) {
            systemView.createPersonViewEvent(person);
        }

        for (Team team : systemModel.getAllTeams()) {
            systemView.createTeamViewEvent(team);
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
    public void determineTheWinnersInTeamCompetition(Competition<Team> competition) {
        // TODO Auto-generated method stub

    }

    @Override
    public void determineTheWinnersInSingleCompetition(Competition<Sportsman> competition) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addSportsmanToTeamViewEvent(Sportsman newSportsman, Team team) {
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