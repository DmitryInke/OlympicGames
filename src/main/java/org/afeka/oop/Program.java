package org.afeka.oop;

import javafx.application.Application;
import javafx.stage.Stage;
import org.afeka.oop.controller.SystemController;
import org.afeka.oop.model.*;
import org.afeka.oop.view.AbstractSystemView;
import org.afeka.oop.view.SystemJavaFX;

public class Program extends Application {
    public static IOlympicGames system;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        IOlympicGames theModel = new OlympicGames();
        AbstractSystemView theView = new SystemJavaFX(primaryStage);
        SystemController controller = new SystemController(theModel, theView);

        // For Debug
        // Countries
        Country c1 = new Country("Israel");
        Country c2 = new Country("Russia");
        Country c3 = new Country("USA");
        Country c4 = new Country("Canada");
        Country c5 = new Country("Egypt");
        Country c6 = new Country("France");
        Country c7 = new Country("Italian");
        theModel.createCountry(c1);
        theModel.createCountry(c2);
        theModel.createCountry(c3);
        theModel.createCountry(c4);
        theModel.createCountry(c5);
        theModel.createCountry(c6);
        theModel.createCountry(c7);

        // Stadiums
        theModel.createStadium(new Stadium("Makabi", "TA", 20000));
        theModel.createStadium(new Stadium("Lokomotiv", "Moscow", 30000));
        theModel.createStadium(new Stadium("GrandOlympic", "LA", 40000));
        theModel.createStadium(new Stadium("Orbgame", "Toronto", 10000));
        theModel.createStadium(new Stadium("ArabicDesert", "Sinai", 25000));
        theModel.createStadium(new Stadium("Bagguete", "Paris", 20000));
        theModel.createStadium(new Stadium("Pizza", "Milano", 20000));
        // Persons
        // Sportsmans
        theModel.createSportsman(new Sportsman("Dima", c1, SPORT_TYPE.BOTH));
        theModel.createSportsman(new Sportsman("Ben", c1, SPORT_TYPE.BOTH));
        theModel.createSportsman(new Sportsman("Yosi", c1, SPORT_TYPE.RUNNING));
        theModel.createSportsman(new Sportsman("Shmoel", c2, SPORT_TYPE.RUNNING));
        theModel.createSportsman(new Sportsman("Vladik", c2, SPORT_TYPE.JUMPING));
        theModel.createSportsman(new Sportsman("Rinat", c2, SPORT_TYPE.RUNNING));
        theModel.createSportsman(new Sportsman("Matan", c3, SPORT_TYPE.JUMPING));
        theModel.createSportsman(new Sportsman("Alon", c3, SPORT_TYPE.BOTH));
        theModel.createSportsman(new Sportsman("Timur", c3, SPORT_TYPE.BOTH));
        theModel.createSportsman(new Sportsman("Ofek", c4, SPORT_TYPE.RUNNING));
        theModel.createSportsman(new Sportsman("Elad", c4, SPORT_TYPE.JUMPING));
        theModel.createSportsman(new Sportsman("Oz", c4, SPORT_TYPE.RUNNING));
        theModel.createSportsman(new Sportsman("Hana", c5, SPORT_TYPE.BOTH));
        theModel.createSportsman(new Sportsman("Dana", c5, SPORT_TYPE.JUMPING));
        theModel.createSportsman(new Sportsman("Danit", c5, SPORT_TYPE.RUNNING));
        theModel.createSportsman(new Sportsman("Daniele", c6, SPORT_TYPE.JUMPING));
        theModel.createSportsman(new Sportsman("Or", c6, SPORT_TYPE.BOTH));
        theModel.createSportsman(new Sportsman("Ortal", c6, SPORT_TYPE.BOTH));
        theModel.createSportsman(new Sportsman("Ron", c7, SPORT_TYPE.JUMPING));
        theModel.createSportsman(new Sportsman("Boaz", c7, SPORT_TYPE.RUNNING));
        theModel.createSportsman(new Sportsman("Bar", c7, SPORT_TYPE.BOTH));
        // Referee
        theModel.createReferee(new Referee("Lior", c1, SPORT_TYPE.BOTH));
        theModel.createReferee(new Referee("Keren", c2, SPORT_TYPE.BOTH));
        theModel.createReferee(new Referee("Moshe", c3, SPORT_TYPE.JUMPING));
        theModel.createReferee(new Referee("Efrat", c4, SPORT_TYPE.RUNNING));
        theModel.createReferee(new Referee("David", c5, SPORT_TYPE.RUNNING));
        theModel.createReferee(new Referee("Stefania", c6, SPORT_TYPE.JUMPING));
        theModel.createReferee(new Referee("Michael", c7, SPORT_TYPE.BOTH));
        // Team
        theModel.createTeam(new Team(SPORT_TYPE.RUNNING, c1));
        theModel.createTeam(new Team(SPORT_TYPE.JUMPING, c2));
        theModel.createTeam(new Team(SPORT_TYPE.RUNNING, c3));
        theModel.createTeam(new Team(SPORT_TYPE.RUNNING, c4));
        theModel.createTeam(new Team(SPORT_TYPE.JUMPING, c5));
        theModel.createTeam(new Team(SPORT_TYPE.JUMPING, c6));
        theModel.createTeam(new Team(SPORT_TYPE.RUNNING, c7));
        // End Debug
    }
}
