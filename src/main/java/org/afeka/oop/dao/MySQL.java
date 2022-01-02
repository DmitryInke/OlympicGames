package org.afeka.oop.dao;

import org.afeka.oop.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQL {

    public static int addCountry(Country country) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            Statement stm = conn.createStatement();
            String sql = String.format("insert into Country (name,num_medals) values ('%s', %d)", country.getName(), country.getNumOfMedals());
            return stm.executeUpdate(sql);
        } finally {
            conn.close();
        }
    }

    public static int addStadium(Stadium stadium) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            Statement stm = conn.createStatement();
            String sql = String.format("insert into Stadium (name,address,capacity) values ('%s', '%s', %d)", stadium.getName(),
                    stadium.getAddress(), stadium.getCapacity());
            return stm.executeUpdate(sql);
        } finally {
            conn.close();
        }
    }

    public static int addSportsmen(Sportsman sportsman) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            Statement stm = conn.createStatement();
            String sql = String.format("insert into Sportsman (name,country_id,sport_type) values ( '%s', %d, %d)", sportsman.getName(),
                    sportsman.getCountry().getCid(), SPORT_TYPE.valueOf(sportsman.getSportType().toString()).ordinal());
            return stm.executeUpdate(sql);
        } finally {
            conn.close();
        }
    }

    public static int addReferee(Referee referee) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            Statement stm = conn.createStatement();
            String sql = String.format("insert into Referee (name,country_id,sport_type) values ( '%s', %d, %d)", referee.getName(),
                    referee.getCountry().getCid(), SPORT_TYPE.valueOf(referee.getSportType().toString()).ordinal());
            return stm.executeUpdate(sql);

        } finally {
            conn.close();
        }
    }

    public static int addTeam(Team team) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            Statement stm = conn.createStatement();
            String sql = String.format("insert into Team (sport_type,country_id) values (%d, %d)", SPORT_TYPE.valueOf(team.getSportType().toString()).ordinal(),
                    team.getCountry().getCid());
            return stm.executeUpdate(sql);
        } finally {
            conn.close();
        }
    }

    public static int addSportsmanToTeam(Team team, Sportsman sportsman) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            Statement stm = conn.createStatement();
            String sql = String.format("insert into SportsmenToTeam (team_id, sportsman_id) values (%d, %d)", team.getTid(),
                    sportsman.getPid());
            return stm.executeUpdate(sql);
        } finally {
            conn.close();
        }
    }

    public static <T extends CompetitorsDetails> int addCompetition(Competition<T> competition) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            Statement stm = conn.createStatement();
            String sql = String.format("insert into Competition (sport_type,stadium_id,referee_id,type_competition) values (%d, %d, %d, '%s')", SPORT_TYPE.valueOf(competition.getSportType().toString()).ordinal(),
                    competition.getStadium().getSid(), competition.getReferee().getPid(), competition.getClazz().getSimpleName());
            return stm.executeUpdate(sql);
        } finally {
            conn.close();
        }
    }

    public static <T extends CompetitorsDetails> int addCompetitorsToCompetition(Competition<T> competition, T competitor) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            Statement stm = conn.createStatement();
            String sql = String.format("insert into CompetitionToCompetitors (competition_id, competitor_id) values (%d, %d)", competition.getCid(),
                    competitor.getPid());
            return stm.executeUpdate(sql);
        } finally {
            conn.close();
        }
    }

    public static Integer getCountryId(Country country) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            Statement stm = conn.createStatement();
            String query = String.format("select cid from Country where name = '%s'", country.getName());
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            return rs.getInt("cid");
        } finally {
            conn.close();
        }
    }

    public static Integer getStadiumId(Stadium stadium) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            Statement stm = conn.createStatement();
            String query = String.format("select sid from Stadium where name = '%s' and address = '%s'", stadium.getName(), stadium.getAddress());
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            return rs.getInt("sid");
        } finally {
            conn.close();
        }
    }

    public static Integer getSportsmanId(Sportsman sportsman) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            Statement stm = conn.createStatement();
            String query = String.format("select sid from Sportsman where name = '%s' and country_id = %d and sport_type = %d", sportsman.getName(),
                    sportsman.getCountry().getCid(), SPORT_TYPE.valueOf(sportsman.getSportType().toString()).ordinal());
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            return rs.getInt("sid");
        } finally {
            conn.close();
        }
    }

    public static Integer getRefereeId(Referee referee) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            Statement stm = conn.createStatement();
            String query = String.format("select rid from Referee where name = '%s' and country_id = %d and sport_type = %d", referee.getName(),
                    referee.getCountry().getCid(), SPORT_TYPE.valueOf(referee.getSportType().toString()).ordinal());
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            return rs.getInt("rid");
        } finally {
            conn.close();
        }
    }

    public static Integer getTeamId(Team team) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            Statement stm = conn.createStatement();
            String query = String.format("select tid from Team where country_id = %d and sport_type = %d",
                    team.getCountry().getCid(), SPORT_TYPE.valueOf(team.getSportType().toString()).ordinal());
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            return rs.getInt("tid");
        } finally {
            conn.close();
        }
    }

    public static Integer getCompetitionById(Competition<?> competition) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            Statement stm = conn.createStatement();
            String query = String.format("select cid from Competition where stadium_id = %d and sport_type = %d and referee_id = %d",
                    competition.getStadium().getSid(), SPORT_TYPE.valueOf(competition.getSportType().toString()).ordinal(), competition.getReferee().getPid());
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            return rs.getInt("cid");
        } finally {
            conn.close();
        }
    }

    public static List<Country> loadAllCountries() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            Statement stm = conn.createStatement();
            String query = "select * from Country";
            ResultSet rs = stm.executeQuery(query);
            List<Country> l = new ArrayList<>();
            while (rs.next()) {
                Integer id = rs.getInt("cid");
                String name = rs.getString("name");
                int numMedals = rs.getInt("num_medals");
                Country c = new Country(name);
                c.setCid(id);
                c.setNumOfMedals(numMedals);
                l.add(c);
            }
            return l;
        } finally {
            conn.close();
        }
    }

    public static List<Stadium> loadAllStadiums() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            Statement stm = conn.createStatement();
            String query = "select * from Stadium";
            ResultSet rs = stm.executeQuery(query);
            List<Stadium> l = new ArrayList<>();
            while (rs.next()) {
                Integer id = rs.getInt("sid");
                String name = rs.getString("name");
                String address = rs.getString("address");
                int capacity = rs.getInt("capacity");
                Stadium s = new Stadium(name, address, capacity);
                s.setSid(id);
                l.add(s);
            }
            return l;
        } finally {
            conn.close();
        }
    }

    public static List<Sportsman> loadAllSportsmans(IOlympicGames theModel) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            Statement stm = conn.createStatement();
            String query = "select * from Sportsman";
            ResultSet rs = stm.executeQuery(query);
            List<Sportsman> l = new ArrayList<>();
            while (rs.next()) {
                Integer id = rs.getInt("sid");
                String name = rs.getString("name");
                Integer cid = rs.getInt("country_id");
                int sportType = rs.getInt("sport_type");
                Sportsman s = new Sportsman(name, theModel.getCountryById(cid), SPORT_TYPE.values()[sportType]);
                s.setPid(id);
                l.add(s);
            }
            return l;
        } finally {
            conn.close();
        }
    }

    public static List<Referee> loadAllReferees(IOlympicGames theModel) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            Statement stm = conn.createStatement();
            String query = "select * from Referee";
            ResultSet rs = stm.executeQuery(query);
            List<Referee> l = new ArrayList<>();
            while (rs.next()) {
                Integer id = rs.getInt("rid");
                String name = rs.getString("name");
                Integer cid = rs.getInt("country_id");
                int sportType = rs.getInt("sport_type");
                Referee r = new Referee(name, theModel.getCountryById(cid), SPORT_TYPE.values()[sportType]);
                r.setPid(id);
                l.add(r);
            }
            return l;
        } finally {
            conn.close();
        }
    }

    public static List<Team> loadAllTeams(IOlympicGames theModel) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            Statement stm = conn.createStatement();
            String query = "select * from Team";
            ResultSet rs = stm.executeQuery(query);
            List<Team> l = new ArrayList<>();
            while (rs.next()) {
                Integer id = rs.getInt("tid");
                Integer cid = rs.getInt("country_id");
                int sportType = rs.getInt("sport_type");
                Team r = new Team(SPORT_TYPE.values()[sportType], theModel.getCountryById(cid));
                r.setTid(id);
                l.add(r);
            }
            return l;
        } finally {
            conn.close();
        }
    }

    public static List<Sportsman> loadSportsmenToTeams(IOlympicGames theModel, Team team) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            Statement stm = conn.createStatement();
            String query = String.format("select sportsman_id from SportsmenToTeam where team_id = %d", team.getTid());
            ResultSet rs = stm.executeQuery(query);
            List<Sportsman> l = new ArrayList<>();
            while (rs.next()) {
                Integer id = rs.getInt("sportsman_id");
                l.add(theModel.getSportsmanById(id));
            }
            return l;
        } finally {
            conn.close();
        }
    }

    public static <T extends CompetitorsDetails> List<Competition<T>> loadAllCompetition(IOlympicGames theModel) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            Statement stm = conn.createStatement();
            String query = "select * from competition";
            ResultSet rs = stm.executeQuery(query);
            List<Competition<T>> l = new ArrayList<>();
            while (rs.next()) {
                Integer id = rs.getInt("cid");
                Integer rid = rs.getInt("referee_id");
                Integer sid = rs.getInt("stadium_id");
                int sportType = rs.getInt("sport_type");
                String competitionType = rs.getString("type_competition");
                Competition<T> c;
                if (competitionType.equals("Team")) {
                    c = (Competition<T>) new Competition<Team>(SPORT_TYPE.values()[sportType], theModel.getStadiumById(sid), theModel.getRefereeById(rid), Team.class);
                } else {
                    c = (Competition<T>) new Competition<Sportsman>(SPORT_TYPE.values()[sportType], theModel.getStadiumById(sid), theModel.getRefereeById(rid), Sportsman.class);
                }
                c.setCid(id);
                l.add(c);
            }
            return l;
        } finally {
            conn.close();
        }
    }

    public static <T extends CompetitorsDetails> List<T> loadCompetitorsToCompetition(IOlympicGames theModel, Competition<T> competition) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            Statement stm = conn.createStatement();

            String query = String.format("select competitor_id,type_competition from Competition join CompetitionToCompetitors on cid=competition_id where cid = %d; ", competition.getCid());
            ResultSet rs = stm.executeQuery(query);
            List<T> l = new ArrayList<>();
            while (rs.next()) {
                Integer id = rs.getInt("competitor_id");
                String competitionType = rs.getString("type_competition");
                if (competitionType.equals("Team")) {
                    l.add((T) theModel.getTeamById(id));
                } else {
                    l.add((T) theModel.getSportsmanById(id));
                }
            }
            return l;
        } finally {
            conn.close();
        }
    }

    public static int updateNumOfMedals(Country country) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            Statement stm = conn.createStatement();
            String sql = String.format("update Country set num_medals = %d where cid = %d", country.getNumOfMedals(), country.getCid());
            return stm.executeUpdate(sql);
        } finally {
            conn.close();
        }
    }

    public static int resetNumOfMedals() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            Statement stm = conn.createStatement();
            String sql = String.format("update Country set num_medals = 0");
            return stm.executeUpdate(sql);
        } finally {
            conn.close();
        }
    }


}
