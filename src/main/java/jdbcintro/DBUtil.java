/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcintro;

import java.sql.Connection;
import java.sql.Driver;
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
    private static final String PASSWORD = "wamatu";
    private static final String O_Username ="hr";
    private static final String O_Password="hr";
    private static final String M_CONN_STRING = "jdbc:mysql://localhost/explorecalifornia";
    private static final String Oracle_Conn_String= "jdbc:oracle:thin:@localhost:1521:xe";

    public static Connection getConnection(DBType dbType) throws SQLException{
        
        switch(dbType){
            case MYSQL:
                return DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);              
            case HSQLDB:
                return null;
            case ORACLE:
                return DriverManager.getConnection(Oracle_Conn_String,O_Username,O_Password);

            default:
                return null;
        }
        
    }
    
}
