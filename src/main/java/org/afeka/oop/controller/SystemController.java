package org.afeka.oop.controller;

import org.afeka.oop.listeners.SystemEventsListener;
import org.afeka.oop.listeners.SystemUIEventsListener;
import org.afeka.oop.model.*;
import org.afeka.oop.view.AbstractSystemView;

import java.time.LocalDate;

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
    public void createTeamViewEvent(Country country, SPORT_TYPE sportType) {
        if (country == null) {
            systemView.exceptionMessage("You must select a country");
        } else {
            try {
                systemModel.createTeam(new Team(sportType, country));
                systemView.successfulMessage("Team are successfully added to the storage");
            } catch (Exception e) {
                systemView.exceptionMessage(e.getMessage());
            }
        }

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
    public void createTeamCompetitionViewEvent(SPORT_TYPE sportType, Stadium stadium, Referee referee,
                                               Class<Team> clazz) {
        if (stadium == null || referee == null) {
            systemView.exceptionMessage("Invalid credentials");
        } else if (!(referee.getSportType() == SPORT_TYPE.BOTH || sportType.equals(referee.getSportType()))) {
            systemView.exceptionMessage("The type needs to match");
        } else {
            try {
                systemModel.createTeamCompetition(new Competition<Team>(sportType, stadium, referee, clazz));
                systemView.successfulMessage("Team competition are successfully added to the storage");
            } catch (Exception e) {
                systemView.exceptionMessage(e.getMessage());
            }
        }

    }

    @Override
    public void createSingleCompetitionViewEvent(SPORT_TYPE sportType, Stadium stadium, Referee referee,
                                                 Class<Sportsman> clazz) {
        if (stadium == null || referee == null) {
            systemView.exceptionMessage("Invalid credentials");
        } else if (!(referee.getSportType() == SPORT_TYPE.BOTH || sportType.equals(referee.getSportType()))) {
            systemView.exceptionMessage("The type needs to match");
        } else {
            try {
                systemModel.createSingleCompetition(new Competition<Sportsman>(sportType, stadium, referee, clazz));
                systemView.successfulMessage("Single competition are successfully added to the storage");
            } catch (Exception e) {
                systemView.exceptionMessage(e.getMessage());
            }
        }

    }

    @Override
    public void determineTheWinnersInTeamCompetition(Competition<Team> competition) {
        if (competition == null) {
            systemView.exceptionMessage("You must select a team competition");
        } else {
            try {
                systemModel.determineTheWinnersInTeamCompetition(competition);
                systemView.successfulMessage("You hold a team competition");
            } catch (Exception e) {
                systemView.exceptionMessage(e.getMessage());
            }
        }

    }

    @Override
    public void determineTheWinnersInSingleCompetition(Competition<Sportsman> competition) {
        if (competition == null) {
            systemView.exceptionMessage("You must select a single competition");
        } else {
            try {
                systemModel.determineTheWinnersInSingleCompetition(competition);
                systemView.successfulMessage("You hold a single competition");
            } catch (Exception e) {
                systemView.exceptionMessage(e.getMessage());
            }
        }
    }

    @Override
    public void addSportsmanToTeamViewEvent(Sportsman newSportsman, Team team) {
        if (newSportsman == null || team == null) {
            systemView.exceptionMessage("Invalid credentials");
        } else {
            try {
                systemModel.addSportsmanToTeam(newSportsman, team);
                systemView.successfulMessage("Sportsman is successfully added to the team");
            } catch (Exception e) {
                systemView.exceptionMessage(e.getMessage());
            }
        }
    }

    @Override
    public void addTeamToCompetitionViewEvent(Team team, Competition<Team> competition) {
        if (competition == null || team == null) {
            systemView.exceptionMessage("Invalid credentials");
        } else {
            try {
                systemModel.addTeamToCompetition(team, competition);
                systemView.successfulMessage("Team is successfully added to the competition");
            } catch (Exception e) {
                systemView.exceptionMessage(e.getMessage());
            }
        }
    }

    @Override
    public void addSportsmanToCompetitionViewEvent(Sportsman sportsman, Competition<Sportsman> competition) {
        if (competition == null || sportsman == null) {
            systemView.exceptionMessage("Invalid credentials");
        } else {
            try {
                systemModel.addSportsmanToCompetition(sportsman, competition);
                systemView.successfulMessage("Sportsman is successfully added to the competition");
            } catch (Exception e) {
                systemView.exceptionMessage(e.getMessage());
            }
        }

    }

    @Override
    public void determineTheWinnersInOlympicGames(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            systemView.exceptionMessage("Choose date for olympic games");
        } else {
            try {
                systemModel.determineTheWinnersInOlympicGames(startDate, endDate);
                systemView.successfulMessage("The Winners"+"\n1: " + systemModel.getWinners()[0] + "\n2: " + systemModel.getWinners()[1] + "\n3: " + systemModel.getWinners()[2] + "\n We will see you in four years");
            } catch (Exception e) {
                systemView.exceptionMessage(e.getMessage());
            }
        }
    }

}