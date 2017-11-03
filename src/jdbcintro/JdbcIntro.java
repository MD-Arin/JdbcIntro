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

public class JdbcIntro {
    
    private static final Logger IntroLog = Logger.getLogger(JdbcIntro.class.getName());

    public static void main(String[] args) throws SQLException {
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        
        try {
            // For Java 5(1.5) and below
            // Class.forName("com.mysql.jdbc.Driver");
            conn = DBUtil.getConnection(DBType.MYSQL);
            IntroLog.log(Level.INFO, "Cennected!");
            
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM states");
            rs.last();
            System.out.println("Number of rows: " + rs.getRow());
            
        } catch (SQLException ex) {
            IntroLog.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            if(conn != null){
                conn.close();
                IntroLog.log(Level.INFO, "Connection Closed!");
            }
            if(stmt != null){
                stmt.close();
                IntroLog.log(Level.INFO, "Statement Closed!");
            }
            if(rs != null){
                rs.close();
                IntroLog.log(Level.INFO, "ResultSet Closed!");
            }
        }

    }

}
