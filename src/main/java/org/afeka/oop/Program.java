package org.afeka.oop;

import javafx.application.Application;
import javafx.stage.Stage;
import org.afeka.oop.controller.SystemController;
import org.afeka.oop.model.IOlympicGames;
import org.afeka.oop.model.OlympicGames;
import org.afeka.oop.view.AbstractSystemView;
import org.afeka.oop.view.SystemJavaFX;

public class Program extends Application {
    public static IOlympicGames system;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        IOlympicGames theModel = new OlympicGames();
        AbstractSystemView theView = new SystemJavaFX(primaryStage);
        SystemController controller = new SystemController(theModel, theView);
    }
}
