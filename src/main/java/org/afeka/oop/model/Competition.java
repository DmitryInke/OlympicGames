package org.afeka.oop.model;

import org.afeka.oop.dao.MySQL;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Competition<T extends CompetitorsDetails> {
    private Integer cid = null;
    private final SPORT_TYPE sportType;
    private final Stadium stadium;
    private final Referee referee;
    private final List<T> allCompetitors;
    private final T[] winners;
    private final Random rnd = new Random();
    private boolean isHoldCompetition;
    private final Class<T> clazz;

    @SuppressWarnings("unchecked")
    public Competition(SPORT_TYPE sportType, Stadium stadium, Referee referee, Class<T> clazz) {
        this.sportType = sportType;
        this.stadium = stadium;
        this.referee = referee;
        this.clazz = clazz;
        this.isHoldCompetition = false;
        this.allCompetitors = new ArrayList<T>();
        this.winners = (T[]) Array.newInstance(clazz, 3);
    }

    public SPORT_TYPE getSportType() {
        return sportType;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public Referee getReferee() {
        return referee;
    }


    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Class<T> getClazz() {
        return clazz;
    }

    public List<T> getAllCompetitors() {
        return allCompetitors;
    }

    public boolean isHoldCompetition() {
        return isHoldCompetition;
    }

    public void addCompetitorsToCompetition(T a) throws Exception {
        if ((a.getSportType() == SPORT_TYPE.BOTH || getSportType().equals(a.getSportType()))
                && !allCompetitors.contains(a)) {
            allCompetitors.add(a);
            MySQL.addCompetitorsToCompetition(this, a);
        } else {
            throw new Exception("Failed to add because it already exists/invalid credentials");
        }

    }

    public void determineTheWinners() throws Exception {
        if (allCompetitors.size() < 3) {
            throw new Exception("It is impossible to hold a competition if there are less than 3 participants");
        } else if (isHoldCompetition) {
            throw new Exception("It is impossible to hold a competition twice");
        } else {
            for (int i = 0; i < winners.length; i++) {
                T a = allCompetitors.get(rnd.nextInt(allCompetitors.size()));
                if (!winnersExists(a)) {
                    winners[i] = a;
                    a.getCountry().CalculateNumOfMedals(i);
                } else {
                    i--;
                }
            }
            isHoldCompetition = true;
        }
    }

    public boolean winnersExists(T a) {
        for (int i = 0; i < winners.length; i++) {
            if (winners[i] == a) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object other) {
        if (!(other instanceof Competition<?>))
            return false;

        Competition<?> temp = (Competition<?>) other;
        return this.clazz.equals(temp.clazz) && stadium.equals(temp.stadium) && referee.equals(temp.referee)
                && sportType.equals(temp.sportType);
    }

    @Override
    public String toString() {
        return (this.clazz.equals(Sportsman.class) ? "Single " : "Team ") + "Competition, sport type: " + sportType;
    }

}
