package org.afeka.oop.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Competition<T extends CompetitorsDetails> {
	private SPORT_TYPE sportType;
	private Stadium stadium;
	private Referee referee;
	private List<T> allCompetitors;
	private T[] winners;
	private Random rnd = new Random();
	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public Competition(SPORT_TYPE sportType, Stadium stadium, Referee referee, Class<T> clazz) {
		this.sportType = sportType;
		this.stadium = stadium;
		this.referee = referee;
		this.clazz = clazz;
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

	public void addCompetitorsToCompetition(T a) throws Exception {
		if (a.getSportType() != getSportType()) {
			throw new Exception("This team is not fit in the competition");
		} else {
			for (int i = 0; i < allCompetitors.size(); i++) {
				if (allCompetitors.get(i).equals(a)) {
					throw new Exception("This team already exists in competition");
				}
			}
			allCompetitors.add(a);
		}
	}

	public void determineTheWinners() throws Exception {
		if (allCompetitors.size() < 3) {
			throw new Exception("It is impossible to hold a competition if there are less than 3 participants");
		}
		for (int i = 0; i < winners.length; i++) {
			T a = allCompetitors.get(rnd.nextInt(allCompetitors.size()));
			if (!winnersExists(a)) {
				winners[i] = a;
				a.getCountry().CalculateNumOfMedals(i);
			} else {
				i--;
			}
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
		return this.clazz.equals(temp.clazz) && stadium.equals(temp.stadium) && referee.equals(temp.referee) && sportType.equals(temp.sportType);
	}

}
