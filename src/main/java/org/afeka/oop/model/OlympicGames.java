package org.afeka.oop.model;

import org.afeka.oop.dao.MySQL;
import org.afeka.oop.listeners.SystemEventsListener;

import java.sql.SQLException;
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
    private List<Referee> allReferees;
    private List<Team> allTeams;
    private String[] winners;
    private ArrayList<SystemEventsListener> listeners;

    public OlympicGames() {
        this.allTeamsInCompetition = new ArrayList<>();
        this.allSportsmansInCompetition = new ArrayList<>();
        this.allCountries = new ArrayList<>();
        this.allStadiums = new ArrayList<>();
        this.allSportsmans = new ArrayList<>();
        this.allReferees = new ArrayList<>();
        this.allTeams = new ArrayList<>();
        this.winners = new String[3];
        this.listeners = new ArrayList<>();
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
        MySQL.addCompetition(newCompetition);
        newCompetition.setCid(MySQL.getCompetitionById(newCompetition));
        fireCreateTeamCompetitionEvent(newCompetition);
    }

    public void createSingleCompetition(Competition<Sportsman> newCompetition) throws Exception {
        for (int i = 0; i < allSportsmansInCompetition.size(); i++) {
            if (allSportsmansInCompetition.get(i).equals(newCompetition)) {
                throw new Exception("This competition already exists");
            }
        }
        allSportsmansInCompetition.add(newCompetition);
        MySQL.addCompetition(newCompetition);
        newCompetition.setCid(MySQL.getCompetitionById(newCompetition));
        fireCreateSingleCompetitionEvent(newCompetition);
    }

    public void createCountry(Country newCountry) throws Exception {
        for (int i = 0; i < allCountries.size(); i++) {
            if (allCountries.get(i).equals(newCountry)) {
                throw new Exception("This country already exists");
            }
        }
        allCountries.add(newCountry);
        MySQL.addCountry(newCountry);
        newCountry.setCid(MySQL.getCountryId(newCountry));
        fireCreateCountryEvent(newCountry);
    }

    public void createStadium(Stadium newStadium) throws Exception {
        for (int i = 0; i < allStadiums.size(); i++) {
            if (allStadiums.get(i).equals(newStadium)) {
                throw new Exception("This stadium already exists");
            }
        }
        allStadiums.add(newStadium);
        MySQL.addStadium(newStadium);
        newStadium.setSid(MySQL.getStadiumId(newStadium));
        fireCreateStadiumEvent(newStadium);
    }

    public void createSportsman(Sportsman newSportsman) throws Exception {
        for (int i = 0; i < allSportsmans.size(); i++) {
            if (allSportsmans.get(i).equals(newSportsman)) {
                throw new Exception("This sportsman already exists");
            }
        }
        allSportsmans.add(newSportsman);
        MySQL.addSportsmen(newSportsman);
        newSportsman.setPid(MySQL.getSportsmanId(newSportsman));
        fireCreateSportsmanEvent(newSportsman);
    }

    public void createReferee(Referee newReferee) throws Exception {
        for (int i = 0; i < allReferees.size(); i++) {
            if (allReferees.get(i).equals(newReferee)) {
                throw new Exception("This referee already exists");
            }
        }
        allReferees.add(newReferee);
        MySQL.addReferee(newReferee);
        newReferee.setPid(MySQL.getRefereeId(newReferee));
        fireCreateRefereeEvent(newReferee);
    }

    public void createTeam(Team newTeam) throws Exception {
        for (int i = 0; i < allTeams.size(); i++) {
            if (allTeams.get(i).equals(newTeam)) {
                throw new Exception("This team already exists");
            }
        }
        allTeams.add(newTeam);
        MySQL.addTeam(newTeam);
        newTeam.setTid(MySQL.getTeamId(newTeam));
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


    public <T extends CompetitorsDetails> void loadFromDB() throws SQLException {
        List<Country> tempCountry = MySQL.loadAllCountries();
        for (Country ctr : tempCountry) {
            allCountries.add(ctr);
            fireCreateCountryEvent(ctr);
        }

        List<Stadium> tempStadium = MySQL.loadAllStadiums();
        for (Stadium std : tempStadium) {
            allStadiums.add(std);
            fireCreateStadiumEvent(std);
        }

        List<Sportsman> tempSportsman = MySQL.loadAllSportsmans(this);
        for (Sportsman spr : tempSportsman) {
            allSportsmans.add(spr);
            fireCreateSportsmanEvent(spr);
        }

        List<Referee> tempReferee = MySQL.loadAllReferees(this);
        for (Referee rf : tempReferee) {
            allReferees.add(rf);
            fireCreateRefereeEvent(rf);
        }

        List<Team> tempTeam = MySQL.loadAllTeams(this);
        for (Team tm : tempTeam) {
            List<Sportsman> tempSportsmen = MySQL.loadSportsmenToTeams(this, tm);
            for (Sportsman sp : tempSportsmen) {
                tm.getAllSportsmans().add(sp);
            }
            allTeams.add(tm);
            fireCreateTeamEvent(tm);
        }


        List<Competition<T>> tempCompetition = MySQL.loadAllCompetition(this);
        for (Competition<T> cmp : tempCompetition) {
            List<T> tempCompetitors = (List<T>) MySQL.loadCompetitorsToCompetition(this, cmp);
            for (T comp : tempCompetitors) {
                cmp.getAllCompetitors().add(comp);
            }
            if (cmp.getClazz().getSimpleName().equals("Team")) {
                allTeamsInCompetition.add((Competition<Team>) cmp);
                fireCreateTeamCompetitionEvent((Competition<Team>) cmp);
            } else {
                allSportsmansInCompetition.add((Competition<Sportsman>) cmp);
                fireCreateSingleCompetitionEvent((Competition<Sportsman>) cmp);
            }

        }
    }

    public Country getCountryById(Integer cid) {
        for (Country ctr : allCountries) {
            if (ctr.getCid() == cid) {
                return ctr;
            }
        }
        return null;
    }

    public Sportsman getSportsmanById(Integer sid) {
        if (sid != null) {
            for (Sportsman spr : allSportsmans) {
                if (spr.getPid() == sid) {
                    return spr;
                }
            }
        }
        return null;
    }

    public Stadium getStadiumById(Integer sid) {
        for (Stadium std : allStadiums) {
            if (std.getSid() == sid) {
                return std;
            }
        }
        return null;
    }

    public Referee getRefereeById(Integer rid) {
        for (Referee rtd : allReferees) {
            if (rtd.getPid() == rid) {
                return rtd;
            }
        }
        return null;
    }

    public Team getTeamById(Integer tid) {
        for (Team tm : allTeams) {
            if (tm.getTid() == tid) {
                return tm;
            }
        }
        return null;
    }


    public void addSportsmanToTeam(Sportsman newSportsman, Team team) throws Exception {
        team.addSportsmanToTeam(newSportsman);
    }

    public void addTeamToCompetition(Team team, Competition<Team> competition) throws Exception {
        if(!team.getAllSportsmans().isEmpty() && team.getAllSportsmans().size() > 1){
            competition.addCompetitorsToCompetition(team);
        }else{
            throw new Exception("Can not add a team with less than two players to the competition");
        }

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
