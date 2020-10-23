package org.afeka.oop.model;

import org.afeka.oop.listeners.SystemEventsListener;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OlympicGames implements IOlympicGames {

    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private List<Competition<Team>> allTeamsInCompetition;
    private List<Competition<Sportsman>> allSportsmansInCompetition;
    private List<Country> allCountries;
    private List<Stadium> allStadiums;
    private List<Sportsman> allSportsmans;
    private List<Referee> allReferee;
    private List<Team> allTeams;
    private String[] winners;
    private ArrayList<SystemEventsListener> listeners;

    public OlympicGames() {
        this.allTeamsInCompetition = new ArrayList<Competition<Team>>();
        this.allSportsmansInCompetition = new ArrayList<Competition<Sportsman>>();
        this.allCountries = new ArrayList<Country>();
        this.allStadiums = new ArrayList<Stadium>();
        this.allSportsmans = new ArrayList<Sportsman>();
        this.allReferee = new ArrayList<Referee>();
        this.allTeams = new ArrayList<Team>();
        this.winners = new String[3];
        this.listeners = new ArrayList<SystemEventsListener>();
    }

    public void registerListener(SystemEventsListener listener) {
        listeners.add(listener);
    }

    public String[] getWinners() {
        return winners;
    }


    public void createTeamCompetition(Competition<Team> newCompetition) throws Exception {
        for (int i = 0; i < allTeamsInCompetition.size(); i++) {
            if (allTeamsInCompetition.get(i).equals(newCompetition)) {
                throw new Exception("This competition already exists");
            }
        }
        allTeamsInCompetition.add(newCompetition);
        fireCreateTeamCompetitionEvent(newCompetition);
    }

    public void createSingleCompetition(Competition<Sportsman> newCompetition) throws Exception {
        for (int i = 0; i < allSportsmansInCompetition.size(); i++) {
            if (allSportsmansInCompetition.get(i).equals(newCompetition)) {
                throw new Exception("This competition already exists");
            }
        }
        allSportsmansInCompetition.add(newCompetition);
        fireCreateSingleCompetitionEvent(newCompetition);
    }

    public void createCountry(Country newCountry) throws Exception {
        for (int i = 0; i < allCountries.size(); i++) {
            if (allCountries.get(i).equals(newCountry)) {
                throw new Exception("This country already exists");
            }
        }
        allCountries.add(newCountry);
        fireCreateCountryEvent(newCountry);
    }

    public void createStadium(Stadium newStadium) throws Exception {
        for (int i = 0; i < allStadiums.size(); i++) {
            if (allStadiums.get(i).equals(newStadium)) {
                throw new Exception("This stadium already exists");
            }
        }
        allStadiums.add(newStadium);
        fireCreateStadiumEvent(newStadium);
    }

    public void createSportsman(Sportsman newSportsman) throws Exception {
        for (int i = 0; i < allSportsmans.size(); i++) {
            if (allSportsmans.get(i).equals(newSportsman)) {
                throw new Exception("This sportsman already exists");
            }
        }
        allSportsmans.add(newSportsman);
        fireCreateSportsmanEvent(newSportsman);
    }

    public void createReferee(Referee newReferee) throws Exception {
        for (int i = 0; i < allReferee.size(); i++) {
            if (allReferee.get(i).equals(newReferee)) {
                throw new Exception("This referee already exists");
            }
        }
        allReferee.add(newReferee);
        fireCreateRefereeEvent(newReferee);
    }

    public void createTeam(Team newTeam) throws Exception {
        for (int i = 0; i < allTeams.size(); i++) {
            if (allTeams.get(i).equals(newTeam)) {
                throw new Exception("This team already exists");
            }
        }
        allTeams.add(newTeam);
        fireCreateTeamEvent(newTeam);

    }

    public void determineTheWinnersInOlympicGames(LocalDate startDate, LocalDate endDate) throws Exception {
        if (startDate.isBefore(endDate)) {
            if (allSportsmansInCompetition.size() + allTeamsInCompetition.size() < 1) {
                throw new Exception("It is impossible to determine the winner without competition");
            }
            if (allCountries.size() < 3) {
                throw new Exception(
                        "It is impossible to determine the winner if there are less than 3 countries");
            }
            Collections.sort(allCountries, new CompareCountryByMedals());
            for (int i = 0; i < winners.length; i++) {
                winners[i] = allCountries.get(i).getName();
            }
        } else {
            throw new Exception("Invalid date of the Olympiad " + dateFormat.format(startDate) + " after " + dateFormat.format(endDate));
        }
    }

    public void addSportsmanToTeam(Sportsman newSportsman, Team team) throws Exception {
        team.addSportsmanToTeam(newSportsman);
    }

    public void addTeamToCompetition(Team team, Competition<Team> competition) throws Exception {
        competition.addCompetitorsToCompetition(team);
    }

    public void addSportsmanToCompetition(Sportsman sportsman, Competition<Sportsman> competition) throws Exception {
        competition.addCompetitorsToCompetition(sportsman);
    }

    public void determineTheWinnersInTeamCompetition(Competition<Team> competition) throws Exception {
        competition.determineTheWinners();
    }

    public void determineTheWinnersInSingleCompetition(Competition<Sportsman> competition) throws Exception {
        competition.determineTheWinners();
    }

    private void fireCreateTeamCompetitionEvent(Competition<Team> competition) {
        for (SystemEventsListener l : listeners) {
            l.createTeamCompetitionModelEvent(competition);
        }
    }

    private void fireCreateSingleCompetitionEvent(Competition<Sportsman> competition) {
        for (SystemEventsListener l : listeners) {
            l.createSingleCompetitionModelEvent(competition);
        }
    }

    private void fireCreateCountryEvent(Country newCountry) {
        for (SystemEventsListener l : listeners) {
            l.createCountryModelEvent(newCountry);
        }

    }

    private void fireCreateTeamEvent(Team newTeam) {
        for (SystemEventsListener l : listeners) {
            l.createTeamModelEvent(newTeam);
        }

    }

    private void fireCreateSportsmanEvent(Sportsman newSportsman) {
        for (SystemEventsListener l : listeners) {
            l.createSportsmanModelEvent(newSportsman);
        }
    }

    private void fireCreateRefereeEvent(Referee newReferee) {
        for (SystemEventsListener l : listeners) {
            l.createRefereeModelEvent(newReferee);
        }
    }

    private void fireCreateStadiumEvent(Stadium newStadium) {
        for (SystemEventsListener l : listeners) {
            l.createStadiumModelEvent(newStadium);
        }

    }

}
