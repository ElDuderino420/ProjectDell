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
public class LogInController {
    
    
    /*
    FetchPartners checks if there is a partner with the given id and password, if so will return true else returns false
    */
    public String FetchPartners(String id,String pass) throws Exception {
        String Partner = null;
        Connection con = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery("SELECT * FROM Partner where pass = '" + pass + "' and id = '" + id + "';");
            if (rs.next()){
                Partner = rs.getString(1);
            }
            
        } finally {
            
        }
        return Partner;
        
    }
    
    public String FetchDell(String id,String pass) throws Exception {
        String Dell = null;
        Connection con = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery("SELECT * FROM Dell where pass = '" + pass + "' and id = '" + id + "';");
            if (rs.next()){
                Dell = rs.getString(1);
            }
            
        } finally {
            
        }
        return Dell;
        
    }
    
    public String FetchFinance(String id,String pass) throws Exception {
        String Finance = null;
        Connection con = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery("SELECT * FROM Finance where pass = '" + pass + "' and id = '" + id + "';");
            if (rs.next()){
                Finance = rs.getString(1);
            }
            
        } finally {
            
        }
        return Finance;
        
    }
    
}
