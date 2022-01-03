package org.afeka.oop.dao;

import org.afeka.oop.model.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MySQL {

    public static int addCountry(Country country) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            PreparedStatement stm = conn.prepareStatement("insert into Country (name,num_medals) values(?,?)");
            stm.setString(1, country.getName());
            stm.setInt(2, country.getNumOfMedals());
            return stm.executeUpdate();
        } finally {
            conn.close();
        }
    }

    public static int addStadium(Stadium stadium) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            PreparedStatement stm = conn.prepareStatement("insert into Stadium (name,address,capacity) values (?,?,?)");
            stm.setString(1, stadium.getName());
            stm.setString(2, stadium.getAddress());
            stm.setInt(3, stadium.getCapacity());
            return stm.executeUpdate();
        } finally {
            conn.close();
        }
    }

    public static int addSportsmen(Sportsman sportsman) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            PreparedStatement stm = conn.prepareStatement("insert into Sportsman (name,country_id,sport_type) values (?,?,?)");
            stm.setString(1, sportsman.getName());
            stm.setInt(2, sportsman.getCountry().getCid());
            stm.setInt(3, SPORT_TYPE.valueOf(sportsman.getSportType().toString()).ordinal());
            return stm.executeUpdate();
        } finally {
            conn.close();
        }
    }

    public static int addReferee(Referee referee) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            PreparedStatement stm = conn.prepareStatement("insert into Referee (name,country_id,sport_type) values (?,?,?)");
            stm.setString(1, referee.getName());
            stm.setInt(2, referee.getCountry().getCid());
            stm.setInt(3, SPORT_TYPE.valueOf(referee.getSportType().toString()).ordinal());
            return stm.executeUpdate();
        } finally {
            conn.close();
        }
    }

    public static int addTeam(Team team) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            PreparedStatement stm = conn.prepareStatement("insert into Team (sport_type,country_id) values (?,?)");
            stm.setInt(1, SPORT_TYPE.valueOf(team.getSportType().toString()).ordinal());
            stm.setInt(2, team.getCountry().getCid());
            return stm.executeUpdate();
        } finally {
            conn.close();
        }
    }

    public static int addSportsmanToTeam(Team team, Sportsman sportsman) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            PreparedStatement stm = conn.prepareStatement("insert into SportsmenToTeam (team_id, sportsman_id) values (?,?)");
            stm.setInt(1, team.getTid());
            stm.setInt(2, sportsman.getPid());
            return stm.executeUpdate();
        } finally {
            conn.close();
        }
    }

    public static <T extends CompetitorsDetails> int addCompetition(Competition<T> competition) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            PreparedStatement stm = conn.prepareStatement("insert into Competition (sport_type,stadium_id,referee_id,type_competition) values (?,?,?,?)");
            stm.setInt(1, SPORT_TYPE.valueOf(competition.getSportType().toString()).ordinal());
            stm.setInt(2, competition.getStadium().getSid());
            stm.setInt(3, competition.getReferee().getPid());
            stm.setString(4, competition.getClazz().getSimpleName());
            return stm.executeUpdate();
        } finally {
            conn.close();
        }
    }

    public static <T extends CompetitorsDetails> int addCompetitorsToCompetition(Competition<T> competition, T competitor) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            PreparedStatement stm = conn.prepareStatement("insert into CompetitionToCompetitors (competition_id, competitor_id) values (?,?)");
            stm.setInt(1, competition.getCid());
            stm.setInt(2, competitor.getPid());
            return stm.executeUpdate();
        } finally {
            conn.close();
        }
    }

    public static int addDateOfOlympicGames(Date startDate, Date endDate) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            Statement stm = conn.createStatement();
            String query = "select if(exists(select * from OlympicGames), 0, 1) as IsEmpty";
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            String sql;
            int check = rs.getInt("isEmpty");
            if (check == 1) {
                sql = String.format("insert into OlympicGames (start_date,end_date) values ('%s', '%s')", startDate, endDate);
                return stm.executeUpdate(sql);
            } else {
                sql = String.format("update OlympicGames set start_date = '%s', end_date = '%s'", startDate, endDate);
                return stm.executeUpdate(sql);
            }
        } finally {
            conn.close();
        }
    }

    public static Date getEndDate() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            Statement stm = conn.createStatement();
            String query = String.format("select end_date from OlympicGames");
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            return rs.getDate("end_date");
        } finally {
            conn.close();
        }
    }

    public static Integer getCountryId(Country country) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            PreparedStatement stm = conn.prepareStatement("select cid from Country where name = ?");
            stm.setString(1, country.getName());
            ResultSet rs = stm.executeQuery();
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
            PreparedStatement stm = conn.prepareStatement("select sid from Stadium where name = ? and address = ?");
            stm.setString(1, stadium.getName());
            stm.setString(2, stadium.getAddress());
            ResultSet rs = stm.executeQuery();
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
            PreparedStatement stm = conn.prepareStatement("select sid from Sportsman where name = ? and country_id = ? and sport_type = ?");
            stm.setString(1, sportsman.getName());
            stm.setInt(2, sportsman.getCountry().getCid());
            stm.setInt(3, SPORT_TYPE.valueOf(sportsman.getSportType().toString()).ordinal());
            ResultSet rs = stm.executeQuery();
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
            PreparedStatement stm = conn.prepareStatement("select rid from Referee where name = ? and country_id = ? and sport_type = ?");
            stm.setString(1, referee.getName());
            stm.setInt(2, referee.getCountry().getCid());
            stm.setInt(3, SPORT_TYPE.valueOf(referee.getSportType().toString()).ordinal());
            ResultSet rs = stm.executeQuery();
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
            PreparedStatement stm = conn.prepareStatement("select tid from Team where country_id = ? and sport_type = ?");
            stm.setInt(1, team.getCountry().getCid());
            stm.setInt(2, SPORT_TYPE.valueOf(team.getSportType().toString()).ordinal());
            ResultSet rs = stm.executeQuery();
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
            PreparedStatement stm = conn.prepareStatement("select cid from Competition where stadium_id = ? and sport_type = ? and referee_id = ?");
            stm.setInt(1, competition.getStadium().getSid());
            stm.setInt(2, SPORT_TYPE.valueOf(competition.getSportType().toString()).ordinal());
            stm.setInt(3, competition.getReferee().getPid());
            ResultSet rs = stm.executeQuery();
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
            PreparedStatement stm = conn.prepareStatement("select sportsman_id from SportsmenToTeam where team_id = ?");
            stm.setInt(1, team.getTid());
            ResultSet rs = stm.executeQuery();
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
            PreparedStatement stm = conn.prepareStatement("select competitor_id,type_competition from Competition join CompetitionToCompetitors on cid=competition_id where cid = ?");
            stm.setInt(1, competition.getCid());
            ResultSet rs = stm.executeQuery();
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
            PreparedStatement stm = conn.prepareStatement("update Country set num_medals = ? where cid = ?");
            stm.setInt(1, country.getNumOfMedals());
            stm.setInt(2, country.getCid());
            return stm.executeUpdate();
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

    public static int deleteDateOfOlympiad() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics", "root", "ROOT");
            Statement stm = conn.createStatement();
            String sql = String.format("delete from OlympicGames");
            return stm.executeUpdate(sql);
        } finally {
            conn.close();
        }
    }
}
