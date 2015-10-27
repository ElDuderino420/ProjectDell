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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author butwhole
 */
public class PartnerController {
    List<Partner> result = new ArrayList();
    public List<Partner> FetchPartners() throws Exception {
        result = new ArrayList<>();
        Connection con = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery("SELECT * FROM partner");
            while (rs.next()) {
                Partner part = new Partner(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6));

                
                result.add(part);
            }
        } finally {
            
        }
        return result;
    }
    public boolean checkValidity(String id,String pass){
        for (Partner part : result) {
            if(part.getId().equals(id) && part.getPassword().equals(pass)){
                return true;
            }
        }
        return false;
    }
}
