package org.afeka.oop.controller;

import org.afeka.oop.listeners.SystemEventsListener;
import org.afeka.oop.listeners.SystemUIEventsListener;
import org.afeka.oop.model.*;
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
        systemView.createCountryViewEvent(country);

    }

    @Override
    public void createSportsmanModelEvent(Sportsman newSportsman) {
        systemView.createSportsmanViewEvent(newSportsman);

    }

    @Override
    public void createRefereeModelEvent(Referee newReferee) {
        systemView.createRefereeViewEvent(newReferee);

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
                systemModel.createStadium(new Stadium(name, address, Integer.parseInt(capacity)));
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
    public void createRefereeViewEvent(String name, Country country, Referee referee, SPORT_TYPE sportType) {
        if (name.startsWith(" ") || name.isEmpty()) {
            systemView.exceptionMessage("You must enter a name");
        } else if (country == null) {
            systemView.exceptionMessage("You must select a country");
        } else {
            try {
                systemModel.createReferee(new Referee(name, country, sportType));
                systemView.successfulMessage("Referee is successfully added to the storage");
            } catch (Exception e) {
                systemView.exceptionMessage(e.getMessage());
            }
        }
    }

    @Override
    public void createSportsmanViewEvent(String name, Country country, Sportsman sportsman, SPORT_TYPE sportType) {
        if (name.startsWith(" ") || name.isEmpty()) {
            systemView.exceptionMessage("You must enter a name");
        } else if (country == null) {
            systemView.exceptionMessage("You must select a country");
        } else {
            try {
                systemModel.createSportsman(new Sportsman(name, country, sportType));
                systemView.successfulMessage("Sportsman is successfully added to the storage");
            } catch (Exception e) {
                systemView.exceptionMessage(e.getMessage());
            }
        }
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