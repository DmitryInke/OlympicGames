package com.afeka.oop;

import org.afeka.oop.dao.MySQL;
import org.afeka.oop.model.*;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class SimpleTest {

    @Test
    public void testSomething() throws SQLException {
//        List<Country> result = MySQL.loadAllCountries();
//        for(Country cr : result) {
//            System.out.println(String.format("Country: id:%d | name:%s | medals:%d",cr.getCid(),
//                    cr.getName(),cr.getNumOfMedals()));
//
//        }
//        System.out.println(this.getClass().getSimpleName());
        Country c1 = new Country("Russia");
        MySQL.addCountry(c1);
        c1.setCid(MySQL.getCountryId(c1));
        Referee r1 = new Referee("Lior", c1, SPORT_TYPE.BOTH);
        System.out.println(c1.getCid());
        r1.setPid(5);
        Stadium s1 = new Stadium("Makabi", "TA", 20000);
        s1.setSid(1);
        Competition cc1 = new Competition<Team>(SPORT_TYPE.RUNNING, s1, r1, Team.class);
        System.out.println(SPORT_TYPE.valueOf(cc1.getSportType().toString()).ordinal());
        System.out.println(SPORT_TYPE.values()[SPORT_TYPE.valueOf(cc1.getSportType().toString()).ordinal()]);

        MySQL.addCompetition(cc1);
    }
}
