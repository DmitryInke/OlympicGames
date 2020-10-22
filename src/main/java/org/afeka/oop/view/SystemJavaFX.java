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
    private ArrayList<SystemUIEventsListener> allListeners = new ArrayList<SystemUIEventsListener>();

    private ScrollPane scrollRoot = new ScrollPane();

    private TabPane tabPane = new TabPane();
    private Tab tab1 = new Tab("Country");
    private Tab tab2 = new Tab("Stadium");
    private Tab tab3 = new Tab("Person");
    private Tab tab4 = new Tab("Team");
    private Tab tab5 = new Tab("Competition");
    private Tab tab6 = new Tab("Olympic Games");

    private VBox vbCountry = new VBox();
    private HBox hbCountry = new HBox();
    private Label lblNameCountry = new Label("Name");
    private TextField tfNameCountry = new TextField();
    private Button btnCreateCountry = new Button("Create Country");
    private ComboBox<Country> cmbAllCountry = new ComboBox<Country>();

    private VBox vbStadium = new VBox();
    private HBox hbNameStadium = new HBox();
    private HBox hbAddressStadium = new HBox();
    private HBox hbCapacityStadium = new HBox();
    private Label lblNameStadium = new Label("Name    ");
    private Label lblAddressStadium = new Label("Address ");
    private Label lblCapacityStadium = new Label("Capacity");
    private TextField tfNameStadium = new TextField();
    private TextField tfAddressStadium = new TextField();
    private TextField tfCapacityStadium = new TextField();
    private Button btnCreateStadium = new Button("Create Stadium");
    private ComboBox<Stadium> cmbALlStadiums = new ComboBox<Stadium>();

    private VBox vbPerson = new VBox();
    private GridPane gpPerson = new GridPane();
    private Button btnCreatePerson = new Button("Create Person");
    private RadioButton rdoCreateSportsman = new RadioButton("Sportsman");
    private RadioButton rdoCreateReferee = new RadioButton("Referee");
    private ToggleGroup tglCreatePerson = new ToggleGroup();
    private Label lblNamePerson = new Label("Name");
    private Label lblCountryPerson = new Label("Country");
    private Label lblSportTypePerson = new Label("Sport Type");
    private TextField tfNamePerson = new TextField();
    private ComboBox<Country> cmbAllPersonCountry = new ComboBox<Country>();
    private ToggleGroup tglPersonSportType = new ToggleGroup();
    private RadioButton rdoPersonTypeRunner = new RadioButton("Runner");
    private RadioButton rdoPersonTypeJumping = new RadioButton("Jumper");
    private RadioButton rdoPersonTypeBoth = new RadioButton("Both");


    private VBox vbTeam = new VBox();
    private HBox hbCreateTeamClick = new HBox();
    private HBox hbCreateTeam = new HBox();
    private Button btnCreateTeam = new Button("Create Team");
    private Button btnAddToTeam = new Button("add to Team");

    private VBox vbCreateTeam = new VBox();
    private Button btnChooseCreateTeam = new Button("Create Team");
    private Label lblTypeOfTeam = new Label("Team Type");
    private Label lblTeamCountry = new Label("Team country");
    private ToggleGroup tglTeamType = new ToggleGroup();
    private RadioButton rdoTeamTypeRunner = new RadioButton("Runner");
    private RadioButton rdoTeamTypeJumping = new RadioButton("Jumper");
    private ComboBox<Country> cmbTeamCountry = new ComboBox<Country>();

    private VBox vbAddSportsmanToTeam = new VBox();
    private Button btnChooseAddSportsmanToTeam = new Button("Add sportsman to team");
    private Label lblListSportsman = new Label("Sportsman");
    private Label lblListTeam = new Label("Team");
    private ComboBox<Sportsman> cmbListSportsman = new ComboBox<Sportsman>();
    private ComboBox<Team> cmbListTeam = new ComboBox<Team>();

    private VBox vbCompetition = new VBox();
    private HBox hbCreateCompetition = new HBox();
    private HBox hbCreateCompetitionClick = new HBox();
    private Button btnCreateCompetition = new Button("Create Competition");
    private Button btnAddCompetitorsToCompetition = new Button("Add competitors to competition");
    private Button btnHoldCompetition = new Button("Hold Competition");
    private ToggleGroup tglCompetition = new ToggleGroup();
    private RadioButton rdoSingleComp = new RadioButton("Single Competition");
    private RadioButton rdoTeamComp = new RadioButton("Team Competition");

    private VBox vbCreateCompetition = new VBox();
    private Button btnChooseCreateCompetition = new Button("Create Competition");
    private Label lblCompetitionSportType = new Label("Competition Sport Type");
    private Label lblCompetitionStadium = new Label("Stadium");
    private Label lblCompetitionReferee = new Label("Referee");
    private ComboBox<Stadium> cmbCompetitionStadiums = new ComboBox<Stadium>();
    private ComboBox<Referee> cmbCompetitionReferee = new ComboBox<Referee>();
    private ToggleGroup tglCompetitionType = new ToggleGroup();
    private RadioButton rdoCompetitionTypeRunner = new RadioButton("Runner");
    private RadioButton rdoCompetitionTypeJumping = new RadioButton("Jumper");

    private VBox vbHoldCompetition = new VBox();
    private GridPane gpHoldCompetition = new GridPane();
    private Button btnCompetitionOptions = new Button("Competition Options");
    private ToggleGroup tglTypeCompetitors = new ToggleGroup();
    private RadioButton rdoSingle = new RadioButton("Single");
    private RadioButton rdoTeam = new RadioButton("Team");
    private Label lblSingleCompetitions = new Label("Single competitions");
    private Label lblTeamCompetitions = new Label("Team competitions");
    private Label lblAllSportsmans = new Label("Sportsmans");
    private Label lblAllTeams = new Label("Teams");
    private ComboBox<Competition<Team>> cmbTeamCompetitions = new ComboBox<Competition<Team>>();
    private ComboBox<Competition<Sportsman>> cmbSingleCompetitions = new ComboBox<Competition<Sportsman>>();
    private ComboBox<Sportsman> cmbAllSportsmans = new ComboBox<Sportsman>();
    private ComboBox<Team> cmbAllTeams = new ComboBox<Team>();

    private VBox vbOlympicGames = new VBox();
    private Label lblStartDate = new Label(" Start date of the Olympiad");
    private Label lblEndDate = new Label("End date of the Olympiad");
    private TilePane tlStartDate = new TilePane();
    private TilePane tlEndDate = new TilePane();
    private Label lblNoDateSelectedSD = new Label("No date selected");
    private Label lblNoDateSelectedED = new Label("No date selected");
    private DatePicker dpStartDate = new DatePicker();
    private DatePicker dpEndDate = new DatePicker();
    private Button btnDetermineWinners = new Button("Determine Winners in Olympic Games");

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
        EventHandler<ActionEvent> eventStartDate = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                // get the date picker value
                LocalDate i = dpStartDate.getValue();

                // get the selected date
                lblNoDateSelectedSD.setText("Date :" + i);
            }
        };

        EventHandler<ActionEvent> eventEndDate = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                // get the date picker value
                LocalDate i = dpEndDate.getValue();

                // get the selected date
                lblNoDateSelectedED.setText("Date :" + i);
            }
        };
        dpStartDate.setOnAction(eventStartDate);
        dpEndDate.setOnAction(eventEndDate);

        tlStartDate.getChildren().addAll(lblStartDate, dpStartDate, lblNoDateSelectedSD);
        tlEndDate.getChildren().addAll(lblEndDate, dpEndDate, lblNoDateSelectedED);
        vbOlympicGames.getChildren().addAll(tlStartDate, tlEndDate, btnDetermineWinners);
        vbOlympicGames.setAlignment(Pos.TOP_LEFT);
        vbOlympicGames.setSpacing(30);
        vbOlympicGames.setPadding(new Insets(20));


        btnChooseCreateTeam.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent action) {
                vbCreateTeam.setVisible(true);
                vbAddSportsmanToTeam.setVisible(false);
            }
        });

        btnChooseAddSportsmanToTeam.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent action) {
                vbCreateTeam.setVisible(false);
                vbAddSportsmanToTeam.setVisible(true);
            }
        });

        btnChooseCreateCompetition.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent action) {
                vbCreateCompetition.setVisible(true);
                gpHoldCompetition.setVisible(false);
            }
        });

        btnCompetitionOptions.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent action) {
                vbCreateCompetition.setVisible(false);
                gpHoldCompetition.setVisible(true);
            }
        });

        btnCreateCountry.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent action) {
                for (SystemUIEventsListener l : allListeners)
                    l.createCountryViewEvent(tfNameCountry.getText());
                tfNameCountry.clear();
            }
        });

        btnCreateStadium.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent action) {
                for (SystemUIEventsListener l : allListeners)
                    l.createStadiumViewEvent(tfNameStadium.getText(), tfAddressStadium.getText(), tfCapacityStadium.getText());
                tfNameStadium.clear();
                tfAddressStadium.clear();
                tfCapacityStadium.clear();
            }
        });

        btnCreatePerson.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent action) {
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
            }
        });

        btnCreateTeam.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent action) {
                if (tglTeamType.getSelectedToggle().equals(rdoTeamTypeRunner)) {
                    otherSportType = SPORT_TYPE.RUNNING;
                } else {
                    otherSportType = SPORT_TYPE.JUMPING;
                }
                for (SystemUIEventsListener l : allListeners) {
                    l.createTeamViewEvent(cmbTeamCountry.getValue(), otherSportType);
                }
            }
        });

        btnAddToTeam.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent action) {
                for (SystemUIEventsListener l : allListeners) {
                    l.addSportsmanToTeamViewEvent(cmbListSportsman.getValue(), cmbListTeam.getValue());
                }
            }
        });

        btnCreateCompetition.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent action) {
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
            }
        });

        btnAddCompetitorsToCompetition.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent action) {
                for (SystemUIEventsListener l : allListeners) {
                    if (tglTypeCompetitors.getSelectedToggle().equals(rdoSingle)) {
                        l.addSportsmanToCompetitionViewEvent(cmbAllSportsmans.getValue(), cmbSingleCompetitions.getValue());
                    } else {
                        l.addTeamToCompetitionViewEvent(cmbAllTeams.getValue(), cmbTeamCompetitions.getValue());
                    }
                }
            }
        });

        btnHoldCompetition.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent action) {
                for (SystemUIEventsListener l : allListeners) {
                    if (tglTypeCompetitors.getSelectedToggle().equals(rdoSingle)) {
                        l.determineTheWinnersInSingleCompetition(cmbSingleCompetitions.getValue());
                    } else {
                        l.determineTheWinnersInTeamCompetition(cmbTeamCompetitions.getValue());
                    }
                }
            }
        });

        btnDetermineWinners.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent action) {
                for (SystemUIEventsListener l : allListeners) {
                    l.determineTheWinnersInOlympicGames(dpStartDate.getValue(), dpEndDate.getValue());
                }
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