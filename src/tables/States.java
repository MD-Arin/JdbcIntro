/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author arin
 */
public class States {
    
    public static void displayData(ResultSet rs) throws SQLException{
        while(rs.next()){
            String stateFullName = rs.getString("stateId") + ": " + rs.getString("stateName");
            
            System.out.println(stateFullName);
        }
    }
    
}
