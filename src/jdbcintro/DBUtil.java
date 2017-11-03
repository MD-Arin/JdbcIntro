/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcintro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author arin
 */
public class DBUtil {
    
    private static final Logger IntroLog = Logger.getLogger(JdbcIntro.class.getName());
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String M_CONN_STRING = "jdbc:mysql://localhost/explorecalifornia";
    
    public static Connection getConnection(DBType dbType) throws SQLException{
        
        switch(dbType){
            case MYSQL:
                return DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);              
            case HSQLDB:
                return null;
            default:
                return null;
        }
        
    }
    
}
