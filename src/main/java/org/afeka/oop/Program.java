package org.afeka.oop;

import org.afeka.oop.model.Country;
import org.afeka.oop.model.OlympicGames;
import org.afeka.oop.model.Referee;
import org.afeka.oop.model.SPORT_TYPE;
import org.afeka.oop.model.Sportsman;
import org.afeka.oop.model.Stadium;
import org.afeka.oop.model.Team;

public class Program {

	public static void main(String[] args) throws Exception {
	
	  Country c1 = new Country("ISR");
	  Country c2 = new Country("Russia");
	  Country c3 = new Country("Egypt");
	
	  Sportsman s1 = new Sportsman("GOGO", c1, SPORT_TYPE.BOTH);
	  Sportsman s2 = new Sportsman("GOG", c2, SPORT_TYPE.BOTH);
	  Sportsman s3 = new Sportsman("GOG", c3, SPORT_TYPE.BOTH);
	  Referee r1 = new Referee("GOGO", c1, SPORT_TYPE.BOTH); 
	  
	  Team t1 = new Team(SPORT_TYPE.BOTH, c1);
	  Team t2 = new Team(SPORT_TYPE.BOTH, c2);
	  Team t3 = new Team(SPORT_TYPE.BOTH, c3);

	  
	  System.out.println(c1.getName() + " " + c1.getNumOfMedals());
	  System.out.println(c2.getName() + " " + c2.getNumOfMedals());
	  System.out.println(c3.getName() + " " + c3.getNumOfMedals());
	  
	  Sportsman s4 = new Sportsman("GOGO", c1, SPORT_TYPE.JUMPING);
	  Sportsman s5 = new Sportsman("GOG", c2, SPORT_TYPE.JUMPING);
	  Sportsman s6 = new Sportsman("GOG", c3, SPORT_TYPE.JUMPING);
	  

	  
	  System.out.println();
	  System.out.println(c1.getName() + " " + c1.getNumOfMedals());
	  System.out.println(c2.getName() + " " + c2.getNumOfMedals());
	  System.out.println(c3.getName() + " " + c3.getNumOfMedals());
	  

	  
	  System.out.println();
	  System.out.println(c1.getName() + " " + c1.getNumOfMedals());
	  System.out.println(c2.getName() + " " + c2.getNumOfMedals());
	  System.out.println(c3.getName() + " " + c3.getNumOfMedals());
	  
	  OlympicGames oly1 = new OlympicGames();
	  oly1.createCountry(c1);
	  oly1.createCountry(c2);
	  oly1.createCountry(c3);
	  

	  System.out.println();
	  oly1.determineTheWinnersInOlympicGames();
	}

}
