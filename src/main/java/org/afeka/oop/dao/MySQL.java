package org.afeka.oop.dao;

import org.afeka.oop.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQL {
    public MySQL() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }
    public static int addCountries(List<Country> countries) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics","root","ROOT");
            Statement stm = conn.createStatement();
            int result = 0;
            for (Country ctr : countries) {
                String sql = String.format("insert into Country values ( %s, %d)",ctr.getName(),ctr.getNumOfMedals());
                result += stm.executeUpdate(sql);
            }
            return result;
        }
        finally {
            conn.close();
        }
    }

    public static int addStadium(List<Stadium> stadiums) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics","root","ROOT");
            Statement stm = conn.createStatement();
            int result = 0;
            for (Stadium stdm : stadiums) {
                String sql = String.format("insert into Stadium values ( %s, %s, %d)",stdm.getName(),
                        stdm.getAddress(),stdm.getCapacity());
                result += stm.executeUpdate(sql);
            }
            return result;
        }
        finally {
            conn.close();
        }
    }

    public static int addSportsmen(List<Sportsman> sportsmen) throws SQLException{
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics","root","ROOT");
            Statement stm = conn.createStatement();
            int result = 0;
            for (Sportsman sprts : sportsmen) {
                String sql = String.format("insert into Sportsman values ( %s, %d, %d)",sprts.getName(),
                        sprts.getCountry(),sprts.getSportType());
                result += stm.executeUpdate(sql);
            }
            return result;
        }
        finally {
            conn.close();
        }
    }

    public static int addReferees(List<Referee> referees) throws SQLException{
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics","root","ROOT");
            Statement stm = conn.createStatement();
            int result = 0;
            for (Referee referee : referees) {
                String sql = String.format("insert into Referee values ( %s, %d, %d)",referee.getName(),
                        referee.getCountry(),referee.getSportType());
                result += stm.executeUpdate(sql);
            }
            return result;
        }
        finally {
            conn.close();
        }
    }

    public static int addTeam(Team team) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics","root","ROOT");
            Statement stm = conn.createStatement();
            String sql = String.format("insert into Team values (%d, %d, %d)",team.getSportType(),
                    null,team.getCountry().getCid());
            return stm.executeUpdate(sql);
        }
        finally {
            conn.close();
        }
    }

    public static int addSportsmanToTeam(Team team, Sportsman sportsman) throws SQLException{
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics","root","ROOT");
            Statement stm = conn.createStatement();
            String sql = String.format("insert into Team values (%d, %d, %d)",team.getSportType(),
                    null,sportsman.getPid());
            return stm.executeUpdate(sql);
        }
        finally {
            conn.close();
        }
    }

    public static <T extends CompetitorsDetails> int  addCompetition(Competition<T> competition) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics","root","ROOT");
            Statement stm = conn.createStatement();
            String sql = String.format("insert into Competition values (%d, %d, %d)",competition.getSportType(),
                    competition.getStadium().getSid(), competition.getReferee().getPid());
            return stm.executeUpdate(sql);
        }
        finally {
            conn.close();
        }
    }

    public static int updateCompatitionWithSportsman(Competition competition, Sportsman sportsman) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics","root","ROOT");
            Statement stm = conn.createStatement();
            String sql = String.format("insert into CompatitionToSportsman (competition_id,sportsman_id) values (%d,%d)",
                    competition.getCid(),sportsman.getPid());
            return stm.executeUpdate(sql);
        }
        finally {
            conn.close();
        }
    }

    public static int updateCompatitionWithTeam(Competition competition, Team team) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics","root","ROOT");
            Statement stm = conn.createStatement();
            String sql = String.format("insert into CompatitionToTeams (%d,%d)", competition.getCid(),team.getTid());
            return stm.executeUpdate(sql);
        }
        finally {
            conn.close();
        }
    }

    public static List<Country> loadAllCountries() throws SQLException{
        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/olympics","root","ROOT");
            Statement stm = conn.createStatement();
            String query = "select * from Country";
            ResultSet rs =  stm.executeQuery(query);
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
        }
        finally {
            conn.close();
        }
    }

}
