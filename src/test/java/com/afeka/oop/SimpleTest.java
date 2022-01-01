package com.afeka.oop;

import org.afeka.oop.dao.MySQL;
import org.afeka.oop.model.Country;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class SimpleTest {

    @Test
    public void testSomething() throws SQLException {
        List<Country> result = MySQL.loadAllCountries();
        for(Country cr : result) {
            System.out.println(String.format("Country: id:%d | name:%s | medals:%d",cr.getCid(),
                    cr.getName(),cr.getNumOfMedals()));
        }
    }
}
