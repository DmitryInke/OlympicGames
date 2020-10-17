package org.afeka.oop.model;

import org.afeka.oop.listeners.SystemEventsListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class OlympicGames implements IOlympicGames {

    private DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
    private List<Competition<Team>> allTeamsInCompetition;
    private List<Competition<Sportsman>> allSportsmansInCompetition;
    private List<Country> allCountries;
    private List<Stadium> allStadiums;
    private List<Person> allPersons;
    private List<Team> allTeams;
    private String[] winners;
    private ArrayList<SystemEventsListener> listeners;

    public OlympicGames() {
        this.allTeamsInCompetition = new ArrayList<Competition<Team>>();
        this.allSportsmansInCompetition = new ArrayList<Competition<Sportsman>>();
        this.allCountries = new ArrayList<Country>();
        this.allStadiums = new ArrayList<Stadium>();
        this.allPersons = new ArrayList<Person>();
        this.allTeams = new ArrayList<Team>();
        this.winners = new String[3];
        this.listeners = new ArrayList<SystemEventsListener>();
    }

    public List<Competition<Team>> getAllTeamsInCompetition() {
        return allTeamsInCompetition;
    }

    public List<Competition<Sportsman>> getAllSportsmansInCompetition() {
        return allSportsmansInCompetition;
    }

    public void registerListener(SystemEventsListener listener) {
        listeners.add(listener);
    }

    public List<Country> getAllCountries() {
        return allCountries;
    }

    public List<Stadium> getAllStadiums() {
        return allStadiums;
    }

    public List<Person> getAllPersons() {
        return allPersons;
    }

    public List<Team> getAllTeams() {
        return allTeams;
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

    public void createPerson(Person newPerson) throws Exception {
        for (int i = 0; i < allPersons.size(); i++) {
            if (allPersons.get(i).equals(newPerson)) {
                throw new Exception("This person already exists");
            }
        }
        allPersons.add(newPerson);
        fireCreatePersonEvent(newPerson);
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

    public void determineTheWinnersInOlympicGames(Date startDate, Date endDate) throws Exception {
        if (startDate.before(endDate)) {
            if (allSportsmansInCompetition.size() + allTeamsInCompetition.size() < 1) {
                throw new Exception("It is impossible to determine the winner without competition");
            }
            if (allCountries.size() < 3) {
                throw new Exception(
                        "It is impossible It is impossible to determine the winner if there are less than 3 countries");
            }
            Collections.sort(allCountries, new CompareCountryByMedals());
            for (int i = 0; i < winners.length; i++) {
                winners[i] = allCountries.get(i).getName();
                System.out.println(winners[i] + " " + allCountries.get(i).getNumOfMedals());
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

    private void fireCreatePersonEvent(Person newPerson) {
        for (SystemEventsListener l : listeners) {
            l.createPersonModelEvent(newPerson);
        }

    }

    private void fireCreateStadiumEvent(Stadium newStadium) {
        for (SystemEventsListener l : listeners) {
            l.createStadiumModelEvent(newStadium);
        }

    }

}
