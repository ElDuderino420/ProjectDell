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
public class CampaignController {

    public List<Campaign> FetchCampaigns() throws Exception {
        List<Campaign> result = new ArrayList<>();
        Connection con = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery("SELECT * FROM campaign");
            while (rs.next()) {
                Campaign camp = new Campaign(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getBoolean(5),
                        rs.getBoolean(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getBoolean(9),
                        rs.getString(10));
                
                result.add(camp);
            }
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
}
