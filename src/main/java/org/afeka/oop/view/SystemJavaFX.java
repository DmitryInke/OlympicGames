package org.afeka.oop.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.afeka.oop.listeners.SystemUIEventsListener;
import org.afeka.oop.model.*;

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
    private HBox hbCreatePersonClick = new HBox();
    private HBox hbCreatePerson = new HBox();
    private Button btnCreateSportsman = new Button("Create Sportsman");
    private Button btnCreateReferee = new Button("Create Referee");

    private VBox vbCreateSportsman = new VBox();
    private Button btnChooseCreateSportsman = new Button("Sportsman");
    private Label lblNameSportsman = new Label("Name");
    private Label lblCountrySportsman = new Label("Country");
    private Label lblSportTypeSportsman = new Label("Sport Type");
    private TextField tfNameSportsman = new TextField();
    private ComboBox<Country> cmbAllSportsmanCountry = new ComboBox<Country>();
    private ComboBox<SPORT_TYPE> cmbSportsmanSport_Type = new ComboBox<SPORT_TYPE>();
    private Button getBtnChooseCreateSportsman = new Button("Create Sportsman");

    private VBox vbCreateReferee = new VBox();
    private Button btnChooseCreateReferee = new Button("Referee");
    private Label lblNameReferee = new Label("Name");
    private Label lblCountryReferee = new Label("Country");
    private Label lblSportTypeReferee = new Label("Sport Type");
    private TextField tfNameReferee = new TextField();
    private ComboBox<Country> cmbAllRefereeCountry = new ComboBox<Country>();
    private ComboBox<SPORT_TYPE> cmbRefereeSport_Type = new ComboBox<SPORT_TYPE>();
    private Button getBtnChooseCreateReferee = new Button("Create Referee");

    private VBox vbTeam = new VBox();
    private HBox hbCreateTeamClick = new HBox();
    private HBox hbCreateTeam = new HBox();
    private Button btnCreateTeam = new Button("Create Team");
    private Button btnAddToTeam = new Button("add to Team");

    private VBox vbCreateTeam = new VBox();
    private Button btnChooseCreateTeam = new Button("Create Team");
    private Label lblTypeOfTeam = new Label("Team Type");
    private Label lblTeamCountry = new Label("Team country");
    private ComboBox<SPORT_TYPE> cmbTeamType = new ComboBox<SPORT_TYPE>();
    private ComboBox<Country> cmbTeamCountry = new ComboBox<Country>();

    private VBox vbAddSportsmanToTeam = new VBox();
    private Button btnChooseAddSportsmanToTeam = new Button("Add sportsman to team");
    private Label lblListSportsman = new Label("Sportsman");
    private Label lblListTeam = new Label("Team");
    private ComboBox<Sportsman> cmbListSportsman = new ComboBox<Sportsman>();
    private ComboBox<Team> cmbListTeam = new ComboBox<Team>();



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

        cmbAllSportsmanCountry.setMaxWidth(100);
        cmbAllSportsmanCountry.setMinWidth(100);
        cmbSportsmanSport_Type.setMinWidth(100);
        cmbSportsmanSport_Type.setMaxWidth(100);
        cmbAllRefereeCountry.setMaxWidth(100);
        cmbAllRefereeCountry.setMinWidth(100);
        cmbRefereeSport_Type.setMinWidth(100);
        cmbRefereeSport_Type.setMaxWidth(100);

        vbCreateSportsman.getChildren().addAll(lblNameSportsman, tfNameSportsman, lblCountrySportsman, cmbAllSportsmanCountry, lblSportTypeSportsman, cmbSportsmanSport_Type, btnCreateSportsman);
        vbCreateSportsman.setSpacing(10);
        vbCreateSportsman.setVisible(false);
        vbCreateReferee.getChildren().addAll(lblNameReferee, tfNameReferee, lblCountryReferee, cmbAllRefereeCountry, lblSportTypeReferee, cmbRefereeSport_Type, btnCreateReferee);
        vbCreateReferee.setSpacing(10);
        vbCreateReferee.setVisible(false);
        hbCreatePerson.getChildren().addAll(vbCreateSportsman, vbCreateReferee);
        hbCreatePerson.setSpacing(300);
        hbCreatePersonClick.getChildren().addAll(btnChooseCreateSportsman, btnChooseCreateReferee);
        hbCreatePersonClick.setSpacing(382);
        vbPerson.getChildren().addAll(hbCreatePersonClick, hbCreatePerson);
        vbPerson.setSpacing(30);
        vbPerson.setPadding(new Insets(20));

        cmbListTeam.setMaxWidth(100);
        cmbListTeam.setMinWidth(100);
        cmbListSportsman.setMinWidth(100);
        cmbListSportsman.setMaxWidth(100);
        cmbTeamCountry.setMaxWidth(100);
        cmbTeamCountry.setMinWidth(100);
        cmbTeamType.setMinWidth(100);
        cmbTeamType.setMaxWidth(100);

        vbCreateTeam.getChildren().addAll(lblTypeOfTeam, cmbTeamType, lblTeamCountry, cmbTeamCountry, btnCreateTeam);
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

        btnChooseCreateSportsman.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent action) {
                vbCreateSportsman.setVisible(true);
                vbCreateReferee.setVisible(false);
            }
        });

        btnChooseCreateReferee.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent action) {
                vbCreateSportsman.setVisible(false);
                vbCreateReferee.setVisible(true);
            }
        });

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

        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tab1.setContent(vbCountry);
        tab2.setContent(vbStadium);
        tab3.setContent(vbPerson);
        tab4.setContent(vbTeam);
        tabPane.getTabs().addAll(tab1, tab2, tab3, tab4, tab5, tab6);

        scrollRoot.fitToHeightProperty().set(true);
        scrollRoot.fitToWidthProperty().set(true);
        scrollRoot.setContent(tabPane);
        theStage.setScene(new Scene(scrollRoot, 700, 400));
        theStage.show();
    }

    @Override
    public void registerListener(SystemUIEventsListener newListener) {
        allListeners.add(newListener);
    }

    @Override
    public void createCountryViewEvent(Country country) {

    }

    @Override
    public void createPersonViewEvent(Person person) {

    }

    @Override
    public void createStadiumViewEvent(Stadium stadium) {

    }

    @Override
    public void createTeamViewEvent(Team team) {

    }

    @Override
    public void addSportsmanToTeamViewEvent(Sportsman newSportsman, Team team) {

    }

    @Override
    public void addDetermineTheWinnersInTeamCompetitionViewEvent(Competition<Team> competition) {

    }

    @Override
    public void addDetermineTheWinnersInSingleCompetitionViewEvent(Competition<Sportsman> competition) {

    }

    @Override
    public void determineTheWinnersInOlympicGamesViewEvent(String[] winners) {

    }

    @Override
    public void addTeamToCompetitionViewEvent(Team team, Competition<Team> competition) {

    }

    @Override
    public void addSportsmanToCompetitionViewEvent(Sportsman sportsman, Competition<Sportsman> competition) {

    }

    @Override
    public void createTeamCompetitionViewEvent(Competition<Team> competition) {

    }

    @Override
    public void createSingleCompetitionViewEvent(Competition<Sportsman> competition) {

    }

    @Override
    public void successfulMessage(String msg) {

    }

    @Override
    public void exceptionMessage(String msg) {

    }
}