/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import DataSource.DatabaseCon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author butwhole
 */
public class PartnerController {
    
    public String FetchPartners(String id,String pass) throws Exception {
        String accepted = "false";
        Connection con = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery("SELECT * FROM Partner where pass = '" + pass + "' and id = '" + id + "';");
            if (rs.next()){
                accepted = "true";
            }
        } finally {
            
        }
        return accepted;
        
    }
    
}
