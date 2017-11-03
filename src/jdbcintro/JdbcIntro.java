/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcintro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import tables.States;
import tables.Tours;

public class JdbcIntro {

    private static final Logger IntroLog = Logger.getLogger(JdbcIntro.class.getName());

    public static void main(String[] args) throws SQLException {

//        Tours
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//                ResultSet tourRs = stmt.executeQuery("SELECT * FROM tours;");
                ResultSet stateRs = stmt.executeQuery("SELECT stateId, stateName FROM states;");) {

            // For Java 5(1.5) and below
            // Class.forName("com.mysql.jdbc.Driver");
            IntroLog.log(Level.INFO, "Cennected!");

//            Tours.displayData(tourRs);
            
//            Moving the Cursor
            States.displayData(stateRs);
            
//            Moving to the last row
            stateRs.last();
            System.out.println("Number of Rows: " + stateRs.getRow());
            
//            Moving to the first row
            stateRs.first();
            System.out.println("The First State is " + stateRs.getString("stateName"));
            
//            Moving to the last row
            stateRs.last();
            System.out.println("The Last State is " + stateRs.getString("stateName"));
            
//            Moving to a specific row
            stateRs.absolute(10);
            System.out.println("The 10th State is " + stateRs.getString("stateName"));

        } catch (SQLException ex) {
            IntroLog.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

}
