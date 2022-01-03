package org.afeka.oop.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.afeka.oop.listeners.SystemUIEventsListener;
import org.afeka.oop.model.*;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class SystemJavaFX implements AbstractSystemView {
    private final ArrayList<SystemUIEventsListener> allListeners = new ArrayList<>();

    private final ScrollPane scrollRoot = new ScrollPane();

    private final TabPane tabPane = new TabPane();
    private final Tab tab1 = new Tab("Country");
    private final Tab tab2 = new Tab("Stadium");
    private final Tab tab3 = new Tab("Person");
    private final Tab tab4 = new Tab("Team");
    private final Tab tab5 = new Tab("Competition");
    private final Tab tab6 = new Tab("Olympic Games");

    private final VBox vbCountry = new VBox();
    private final HBox hbCountry = new HBox();
    private final Label lblNameCountry = new Label("Name");
    private final TextField tfNameCountry = new TextField();
    private final Button btnCreateCountry = new Button("Create Country");
    private final ComboBox<Country> cmbAllCountry = new ComboBox<>();

    private final VBox vbStadium = new VBox();
    private final HBox hbNameStadium = new HBox();
    private final HBox hbAddressStadium = new HBox();
    private final HBox hbCapacityStadium = new HBox();
    private final Label lblNameStadium = new Label("Name    ");
    private final Label lblAddressStadium = new Label("Address ");
    private final Label lblCapacityStadium = new Label("Capacity");
    private final TextField tfNameStadium = new TextField();
    private final TextField tfAddressStadium = new TextField();
    private final TextField tfCapacityStadium = new TextField();
    private final Button btnCreateStadium = new Button("Create Stadium");
    private final ComboBox<Stadium> cmbALlStadiums = new ComboBox<>();

    private final VBox vbPerson = new VBox();
    private final GridPane gpPerson = new GridPane();
    private final Button btnCreatePerson = new Button("Create Person");
    private final RadioButton rdoCreateSportsman = new RadioButton("Sportsman");
    private final RadioButton rdoCreateReferee = new RadioButton("Referee");
    private final ToggleGroup tglCreatePerson = new ToggleGroup();
    private final Label lblNamePerson = new Label("Name");
    private final Label lblCountryPerson = new Label("Country");
    private final Label lblSportTypePerson = new Label("Sport Type");
    private final TextField tfNamePerson = new TextField();
    private final ComboBox<Country> cmbAllPersonCountry = new ComboBox<>();
    private final ToggleGroup tglPersonSportType = new ToggleGroup();
    private final RadioButton rdoPersonTypeRunner = new RadioButton("Runner");
    private final RadioButton rdoPersonTypeJumping = new RadioButton("Jumper");
    private final RadioButton rdoPersonTypeBoth = new RadioButton("Both");


    private final VBox vbTeam = new VBox();
    private final HBox hbCreateTeamClick = new HBox();
    private final HBox hbCreateTeam = new HBox();
    private final Button btnCreateTeam = new Button("Create Team");
    private final Button btnAddToTeam = new Button("add to Team");

    private final VBox vbCreateTeam = new VBox();
    private final Button btnChooseCreateTeam = new Button("Create Team");
    private final Label lblTypeOfTeam = new Label("Team Type");
    private final Label lblTeamCountry = new Label("Team country");
    private final ToggleGroup tglTeamType = new ToggleGroup();
    private final RadioButton rdoTeamTypeRunner = new RadioButton("Runner");
    private final RadioButton rdoTeamTypeJumping = new RadioButton("Jumper");
    private final ComboBox<Country> cmbTeamCountry = new ComboBox<>();

    private final VBox vbAddSportsmanToTeam = new VBox();
    private final Button btnChooseAddSportsmanToTeam = new Button("Add sportsman to team");
    private final Label lblListSportsman = new Label("Sportsman");
    private final Label lblListTeam = new Label("Team");
    private final ComboBox<Sportsman> cmbListSportsman = new ComboBox<>();
    private final ComboBox<Team> cmbListTeam = new ComboBox<>();

    private final VBox vbCompetition = new VBox();
    private final HBox hbCreateCompetition = new HBox();
    private final HBox hbCreateCompetitionClick = new HBox();
    private final Button btnCreateCompetition = new Button("Create Competition");
    private final Button btnAddCompetitorsToCompetition = new Button("Add competitors to competition");
    private final Button btnHoldCompetition = new Button("Hold Competition");
    private final ToggleGroup tglCompetition = new ToggleGroup();
    private final RadioButton rdoSingleComp = new RadioButton("Single Competition");
    private final RadioButton rdoTeamComp = new RadioButton("Team Competition");

    private final VBox vbCreateCompetition = new VBox();
    private final Button btnChooseCreateCompetition = new Button("Create Competition");
    private final Label lblCompetitionSportType = new Label("Competition Sport Type");
    private final Label lblCompetitionStadium = new Label("Stadium");
    private final Label lblCompetitionReferee = new Label("Referee");
    private final ComboBox<Stadium> cmbCompetitionStadiums = new ComboBox<>();
    private final ComboBox<Referee> cmbCompetitionReferee = new ComboBox<>();
    private final ToggleGroup tglCompetitionType = new ToggleGroup();
    private final RadioButton rdoCompetitionTypeRunner = new RadioButton("Runner");
    private final RadioButton rdoCompetitionTypeJumping = new RadioButton("Jumper");

    private final VBox vbHoldCompetition = new VBox();
    private final GridPane gpHoldCompetition = new GridPane();
    private final Button btnCompetitionOptions = new Button("Competition Options");
    private final ToggleGroup tglTypeCompetitors = new ToggleGroup();
    private final RadioButton rdoSingle = new RadioButton("Single");
    private final RadioButton rdoTeam = new RadioButton("Team");
    private final Label lblSingleCompetitions = new Label("Single competitions");
    private final Label lblTeamCompetitions = new Label("Team competitions");
    private final Label lblAllSportsmans = new Label("Sportsmans");
    private final Label lblAllTeams = new Label("Teams");
    private final ComboBox<Competition<Team>> cmbTeamCompetitions = new ComboBox<>();
    private final ComboBox<Competition<Sportsman>> cmbSingleCompetitions = new ComboBox<>();
    private final ComboBox<Sportsman> cmbAllSportsmans = new ComboBox<>();
    private final ComboBox<Team> cmbAllTeams = new ComboBox<>();

    private final VBox vbOlympicGames = new VBox();
    private final Label lblStartDate = new Label(" Start date of the Olympiad");
    private final Label lblEndDate = new Label("End date of the Olympiad");
    private final TilePane tlStartDate = new TilePane();
    private final TilePane tlEndDate = new TilePane();
    private final Label lblNoDateSelectedSD = new Label("No date selected");
    private final Label lblNoDateSelectedED = new Label("No date selected");
    private final DatePicker dpStartDate = new DatePicker();
    private final DatePicker dpEndDate = new DatePicker();
    private final Button btnDetermineWinners = new Button("Determine Winners in Olympic Games");

    private SPORT_TYPE otherSportType;
    private Sportsman Sportsman;
    private Referee Referee;

    public SystemJavaFX(Stage theStage) {
        theStage.setTitle("Olympic Games");

        hbCountry.getChildren().addAll(lblNameCountry, tfNameCountry, btnCreateCountry);
        hbCountry.setSpacing(20);
        cmbAllCountry.setMaxWidth(100);
        cmbAllCountry.setMinWidth(100);
        vbCountry.getChildren().addAll(hbCountry, cmbAllCountry);
        vbCountry.setAlignment(Pos.TOP_LEFT);
        vbCountry.setSpacing(30);
        vbCountry.setPadding(new Insets(20));

        hbNameStadium.getChildren().addAll(lblNameStadium, tfNameStadium);
        hbNameStadium.setSpacing(20);
        hbAddressStadium.getChildren().addAll(lblAddressStadium, tfAddressStadium);
        hbAddressStadium.setSpacing(20);
        hbCapacityStadium.getChildren().addAll(lblCapacityStadium, tfCapacityStadium);
        hbCapacityStadium.setSpacing(20);
        cmbALlStadiums.setMinWidth(100);
        cmbALlStadiums.setMaxWidth(100);
        vbStadium.getChildren().addAll(hbNameStadium, hbAddressStadium, hbCapacityStadium, btnCreateStadium, cmbALlStadiums);
        vbStadium.setAlignment(Pos.TOP_LEFT);
        vbStadium.setSpacing(30);
        vbStadium.setPadding(new Insets(20));

        cmbAllPersonCountry.setMaxWidth(200);
        cmbAllPersonCountry.setMinWidth(200);

        rdoPersonTypeBoth.setToggleGroup(tglPersonSportType);
        rdoPersonTypeJumping.setToggleGroup(tglPersonSportType);
        rdoPersonTypeRunner.setToggleGroup(tglPersonSportType);
        tglPersonSportType.selectToggle(rdoPersonTypeRunner);

        rdoCreateSportsman.setToggleGroup(tglCreatePerson);
        rdoCreateReferee.setToggleGroup(tglCreatePerson);
        tglCreatePerson.selectToggle(rdoCreateSportsman);

        gpPerson.add(rdoCreateSportsman, 0, 0);
        gpPerson.add(rdoCreateReferee, 1, 0);
        gpPerson.add(lblNamePerson, 0, 1);
        gpPerson.add(tfNamePerson, 1, 1);
        gpPerson.add(lblCountryPerson, 0, 2);
        gpPerson.add(cmbAllPersonCountry, 1, 2);
        gpPerson.add(lblSportTypePerson, 0, 3);
        gpPerson.add(rdoPersonTypeRunner, 1, 3);
        gpPerson.add(rdoPersonTypeJumping, 1, 4);
        gpPerson.add(rdoPersonTypeBoth, 1, 5);
        gpPerson.add(btnCreatePerson, 0, 6);
        gpPerson.setVgap(10);
        gpPerson.setHgap(10);
        vbPerson.getChildren().add(gpPerson);
        vbPerson.setSpacing(30);
        vbPerson.setPadding(new Insets(20));

        cmbListTeam.setMaxWidth(200);
        cmbListTeam.setMinWidth(200);
        cmbListSportsman.setMinWidth(200);
        cmbListSportsman.setMaxWidth(200);
        cmbTeamCountry.setMaxWidth(100);
        cmbTeamCountry.setMinWidth(100);

        rdoTeamTypeRunner.setToggleGroup(tglTeamType);
        rdoTeamTypeJumping.setToggleGroup(tglTeamType);
        tglTeamType.selectToggle(rdoTeamTypeRunner);

        vbCreateTeam.getChildren().addAll(lblTypeOfTeam, rdoTeamTypeRunner, rdoTeamTypeJumping, lblTeamCountry, cmbTeamCountry, btnCreateTeam);
        vbCreateTeam.setSpacing(10);
        vbCreateTeam.setVisible(false);
        vbAddSportsmanToTeam.getChildren().addAll(lblListSportsman, cmbListSportsman, lblListTeam, cmbListTeam, btnAddToTeam);
        vbAddSportsmanToTeam.setSpacing(10);
        vbAddSportsmanToTeam.setVisible(false);
        hbCreateTeam.getChildren().addAll(vbCreateTeam, vbAddSportsmanToTeam);
        hbCreateTeam.setSpacing(300);
        hbCreateTeamClick.getChildren().addAll(btnChooseCreateTeam, btnChooseAddSportsmanToTeam);
        hbCreateTeamClick.setSpacing(300);
        vbTeam.getChildren().addAll(hbCreateTeamClick, hbCreateTeam);
        vbTeam.setSpacing(30);
        vbTeam.setPadding(new Insets(20));

        cmbCompetitionStadiums.setMaxWidth(200);
        cmbCompetitionStadiums.setMinWidth(200);
        cmbTeamCompetitions.setMinWidth(100);
        cmbTeamCompetitions.setMaxWidth(100);
        cmbSingleCompetitions.setMinWidth(100);
        cmbSingleCompetitions.setMaxWidth(100);
        cmbAllSportsmans.setMinWidth(100);
        cmbAllSportsmans.setMaxWidth(100);
        cmbAllTeams.setMinWidth(100);
        cmbAllTeams.setMaxWidth(100);
        cmbCompetitionReferee.setMinWidth(200);
        cmbCompetitionReferee.setMaxWidth(200);

        rdoSingleComp.setToggleGroup(tglCompetition);
        rdoTeamComp.setToggleGroup(tglCompetition);
        tglCompetition.selectToggle(rdoSingleComp);

        rdoSingle.setToggleGroup(tglTypeCompetitors);
        rdoTeam.setToggleGroup(tglTypeCompetitors);
        tglTypeCompetitors.selectToggle(rdoSingle);

        rdoCompetitionTypeJumping.setToggleGroup(tglCompetitionType);
        rdoCompetitionTypeRunner.setToggleGroup(tglCompetitionType);
        tglCompetitionType.selectToggle(rdoCompetitionTypeRunner);

        vbCreateCompetition.getChildren().addAll(rdoSingleComp, rdoTeamComp, lblCompetitionSportType, rdoCompetitionTypeRunner, rdoCompetitionTypeJumping, lblCompetitionStadium, cmbCompetitionStadiums, lblCompetitionReferee, cmbCompetitionReferee, btnCreateCompetition);
        vbCreateCompetition.setSpacing(10);
        vbCreateCompetition.setVisible(false);
        gpHoldCompetition.add(rdoSingle, 0, 0);
        gpHoldCompetition.add(lblAllSportsmans, 1, 0);
        gpHoldCompetition.add(cmbAllSportsmans, 2, 0);
        gpHoldCompetition.add(lblSingleCompetitions, 1, 1);
        gpHoldCompetition.add(cmbSingleCompetitions, 2, 1);
        gpHoldCompetition.add(rdoTeam, 0, 2);
        gpHoldCompetition.add(lblAllTeams, 1, 2);
        gpHoldCompetition.add(cmbAllTeams, 2, 2);
        gpHoldCompetition.add(lblTeamCompetitions, 1, 3);
        gpHoldCompetition.add(cmbTeamCompetitions, 2, 3);
        gpHoldCompetition.add(btnAddCompetitorsToCompetition, 0, 4);
        gpHoldCompetition.add(btnHoldCompetition, 1, 4);
        gpHoldCompetition.setVgap(10);
        gpHoldCompetition.setHgap(10);
        gpHoldCompetition.setVisible(false);
        hbCreateCompetition.getChildren().addAll(vbCreateCompetition, gpHoldCompetition);
        hbCreateCompetitionClick.getChildren().addAll(btnChooseCreateCompetition, btnCompetitionOptions);
        vbCompetition.getChildren().addAll(hbCreateCompetitionClick, hbCreateCompetition);
        vbCompetition.setSpacing(30);
        vbCompetition.setPadding(new Insets(20));

        dpStartDate.setShowWeekNumbers(false);
        dpEndDate.setShowWeekNumbers(false);

        theStage.setOnCloseRequest(action -> {
            for (SystemUIEventsListener l : allListeners)
                l.resetNumOfMedalsAndDeleteOlympiadDate();
        });

        EventHandler<ActionEvent> eventStartDate = e -> {
            // get the date picker value
            LocalDate i = dpStartDate.getValue();

            // get the selected date
            lblNoDateSelectedSD.setText("Date :" + i);
        };

        EventHandler<ActionEvent> eventEndDate = e -> {
            // get the date picker value
            LocalDate i = dpEndDate.getValue();

            // get the selected date
            lblNoDateSelectedED.setText("Date :" + i);
        };
        dpStartDate.setOnAction(eventStartDate);
        dpEndDate.setOnAction(eventEndDate);

        tlStartDate.getChildren().addAll(lblStartDate, dpStartDate, lblNoDateSelectedSD);
        tlEndDate.getChildren().addAll(lblEndDate, dpEndDate, lblNoDateSelectedED);
        vbOlympicGames.getChildren().addAll(tlStartDate, tlEndDate, btnDetermineWinners);
        vbOlympicGames.setAlignment(Pos.TOP_LEFT);
        vbOlympicGames.setSpacing(30);
        vbOlympicGames.setPadding(new Insets(20));


        btnChooseCreateTeam.setOnAction(action -> {
            vbCreateTeam.setVisible(true);
            vbAddSportsmanToTeam.setVisible(false);
        });

        btnChooseAddSportsmanToTeam.setOnAction(action -> {
            vbCreateTeam.setVisible(false);
            vbAddSportsmanToTeam.setVisible(true);
        });

        btnChooseCreateCompetition.setOnAction(action -> {
            vbCreateCompetition.setVisible(true);
            gpHoldCompetition.setVisible(false);
        });

        btnCompetitionOptions.setOnAction(action -> {
            vbCreateCompetition.setVisible(false);
            gpHoldCompetition.setVisible(true);
        });

        btnCreateCountry.setOnAction(action -> {
            for (SystemUIEventsListener l : allListeners)
                l.createCountryViewEvent(tfNameCountry.getText());
            tfNameCountry.clear();
        });

        btnCreateStadium.setOnAction(action -> {
            for (SystemUIEventsListener l : allListeners)
                l.createStadiumViewEvent(tfNameStadium.getText(), tfAddressStadium.getText(), tfCapacityStadium.getText());
            tfNameStadium.clear();
            tfAddressStadium.clear();
            tfCapacityStadium.clear();
        });

        btnCreatePerson.setOnAction(action -> {
            if (tglPersonSportType.getSelectedToggle().equals(rdoPersonTypeRunner)) {
                otherSportType = SPORT_TYPE.RUNNING;
            } else if (tglPersonSportType.getSelectedToggle().equals(rdoPersonTypeJumping)) {
                otherSportType = SPORT_TYPE.JUMPING;
            } else {
                otherSportType = SPORT_TYPE.BOTH;
            }
            for (SystemUIEventsListener l : allListeners) {
                if (tglCreatePerson.getSelectedToggle().equals(rdoCreateSportsman)) {
                    l.createSportsmanViewEvent(tfNamePerson.getText(), cmbAllPersonCountry.getValue(), Sportsman, otherSportType);
                } else {
                    l.createRefereeViewEvent(tfNamePerson.getText(), cmbAllPersonCountry.getValue(), Referee, otherSportType);
                }
            }
            tfNamePerson.clear();
        });

        btnCreateTeam.setOnAction(action -> {
            if (tglTeamType.getSelectedToggle().equals(rdoTeamTypeRunner)) {
                otherSportType = SPORT_TYPE.RUNNING;
            } else {
                otherSportType = SPORT_TYPE.JUMPING;
            }
            for (SystemUIEventsListener l : allListeners) {
                l.createTeamViewEvent(cmbTeamCountry.getValue(), otherSportType);
            }
        });

        btnAddToTeam.setOnAction(action -> {
            for (SystemUIEventsListener l : allListeners) {
                l.addSportsmanToTeamViewEvent(cmbListSportsman.getValue(), cmbListTeam.getValue());
            }
        });

        btnCreateCompetition.setOnAction(action -> {
            if (tglCompetitionType.getSelectedToggle().equals(rdoCompetitionTypeRunner)) {
                otherSportType = SPORT_TYPE.RUNNING;
            } else {
                otherSportType = SPORT_TYPE.JUMPING;
            }
            for (SystemUIEventsListener l : allListeners) {
                if (tglCompetition.getSelectedToggle().equals(rdoSingleComp)) {
                    l.createSingleCompetitionViewEvent(otherSportType, cmbCompetitionStadiums.getValue(), cmbCompetitionReferee.getValue(), Sportsman.class);
                } else {
                    l.createTeamCompetitionViewEvent(otherSportType, cmbCompetitionStadiums.getValue(), cmbCompetitionReferee.getValue(), Team.class);
                }
            }
        });

        btnAddCompetitorsToCompetition.setOnAction(action -> {
            for (SystemUIEventsListener l : allListeners) {
                if (tglTypeCompetitors.getSelectedToggle().equals(rdoSingle)) {
                    l.addSportsmanToCompetitionViewEvent(cmbAllSportsmans.getValue(), cmbSingleCompetitions.getValue());
                } else {
                    l.addTeamToCompetitionViewEvent(cmbAllTeams.getValue(), cmbTeamCompetitions.getValue());
                }
            }
        });

        btnHoldCompetition.setOnAction(action -> {
            for (SystemUIEventsListener l : allListeners) {
                if (tglTypeCompetitors.getSelectedToggle().equals(rdoSingle)) {
                    l.determineTheWinnersInSingleCompetition(cmbSingleCompetitions.getValue());
                } else {
                    l.determineTheWinnersInTeamCompetition(cmbTeamCompetitions.getValue());
                }
            }
        });

        btnDetermineWinners.setOnAction(action -> {
            for (SystemUIEventsListener l : allListeners) {
                l.determineTheWinnersInOlympicGames(dpStartDate.getValue(), dpEndDate.getValue());
            }
        });


        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tab1.setContent(vbCountry);
        tab2.setContent(vbStadium);
        tab3.setContent(vbPerson);
        tab4.setContent(vbTeam);
        tab5.setContent(vbCompetition);
        tab6.setContent(vbOlympicGames);
        tabPane.getTabs().addAll(tab1, tab2, tab3, tab4, tab5, tab6);

        scrollRoot.fitToHeightProperty().set(true);
        scrollRoot.fitToWidthProperty().set(true);
        scrollRoot.setContent(tabPane);
        theStage.setScene(new Scene(scrollRoot, 750, 420));
        theStage.show();
    }

    @Override
    public void registerListener(SystemUIEventsListener newListener) {
        allListeners.add(newListener);
    }

    @Override
    public void createCountryViewEvent(Country country) {
        cmbAllCountry.getItems().add(country);
        cmbAllPersonCountry.getItems().add(country);
        cmbTeamCountry.getItems().add(country);

    }

    @Override
    public void createSportsmanViewEvent(Sportsman sportsman) {
        cmbListSportsman.getItems().add(sportsman);
        cmbAllSportsmans.getItems().add(sportsman);
    }


    @Override
    public void createRefereeViewEvent(Referee referee) {
        cmbCompetitionReferee.getItems().add(referee);
    }


    @Override
    public void createStadiumViewEvent(Stadium stadium) {
        cmbALlStadiums.getItems().add(stadium);
        cmbCompetitionStadiums.getItems().add(stadium);
    }

    @Override
    public void createTeamViewEvent(Team team) {
        cmbListTeam.getItems().add(team);
        cmbAllTeams.getItems().add(team);
    }

    @Override
    public void createTeamCompetitionViewEvent(Competition<Team> competition) {
        cmbTeamCompetitions.getItems().add(competition);
    }

    @Override
    public void createSingleCompetitionViewEvent(Competition<Sportsman> competition) {
        cmbSingleCompetitions.getItems().add(competition);
    }

    @Override
    public void successfulMessage(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    @Override
    public void exceptionMessage(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
}