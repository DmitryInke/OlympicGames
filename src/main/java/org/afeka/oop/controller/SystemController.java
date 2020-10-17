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
    public void createCountryViewEvent(String name) {
        if (name.startsWith(" ") || name.isEmpty()) {
            systemView.exceptionMessage("You must enter a name");
        } else {
            try {
                systemModel.createCountry(new Country(name));
                systemView.successfulMessage("Country are successfully added to the storage");
            } catch (Exception e) {
                systemView.exceptionMessage(e.getMessage());
            }
        }
    }

    @Override
    public void createStadiumViewEvent(String name, String address, String capacity) {
        try {
            Integer.parseInt(capacity);
        } catch (Exception e) {
            systemView.exceptionMessage("You must enter a valid capacity");
            return;
        }
        if (name.startsWith(" ") || name.isEmpty()) {
            systemView.exceptionMessage("You must enter a name");
        } else if (address.startsWith(" ") || address.isEmpty()) {
            systemView.exceptionMessage("You must enter an address");
        } else if (Integer.parseInt(capacity) > 0) {
            try {
                systemModel.createStadium(new Stadium(name, address,Integer.parseInt(capacity)));
                systemView.successfulMessage("Stadium are successfully added to the storage");
            } catch (Exception e) {
                systemView.exceptionMessage(e.getMessage());
            }
        } else {
            systemView.exceptionMessage("You must enter a valid capacity");
        }
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