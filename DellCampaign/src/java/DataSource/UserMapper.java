/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSource;

import Domain.Partner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author David
 */
public class UserMapper {
    
    
    
    public boolean CheckPartner(String id) throws Exception {
        Connection con = null;
        Statement check = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            
            check = con.createStatement();
            
            ResultSet rs = check.executeQuery("SELECT * FROM Partner where id ='" + id + "';");

            rs.next();
            if (rs.getString(5).equals("")|| rs.getString(6).equals("")) {
                return false;
            }

        }
        
        finally {
            if(check!=null){
            check.close();
            }
        }

        return true;
    }

    public void CreatePartner(Partner p) throws Exception {
        Connection con = null;
        PreparedStatement newPartner = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            con.setAutoCommit(false);

            newPartner = con.prepareStatement("Insert into Partner Values(?,?,?,?,?,?);");

            newPartner.setString(1, p.getId());
            newPartner.setString(2, p.getName());
            newPartner.setString(3, p.getDateCreated());
            newPartner.setString(4, p.getPassword());
            newPartner.setString(5, "");
            newPartner.setString(6, "");

            newPartner.executeUpdate();
            con.commit();

        } finally {
            if (newPartner != null) {
                newPartner.close();
            }
        }
        con.setAutoCommit(true);
    }

    public Partner GetPartner(String id) throws Exception {
        Connection con = null;
        Statement part = null;
        try {
            con = DatabaseCon.getInstance().getConnection();

            part = con.createStatement();
            
            ResultSet rs = part.executeQuery("SELECT * FROM Partner where id ='" + id + "';");
            rs.next();
            Partner p = new Partner(rs.getString(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4));
            
            p.setEmail(rs.getString(5));
            p.setPhone(rs.getString(6));

            return p;
            
        } finally {
            if (part != null) {
                part.close();
            }
        }
        
    }
    
    public void EditPartner(Partner p) throws Exception{
        Connection con = null;
        PreparedStatement part = null;
        
        try{
            con = DatabaseCon.getInstance().getConnection();
            con.setAutoCommit(false);
            part = con.prepareStatement("Update Partner set Pname= '" + p.getName() + "' where id = '"+ p.getId() +"';");
            part.executeUpdate();
            part = con.prepareStatement("Update Partner set pass= '" + p.getPassword() + "' where id = '"+ p.getId() +"';");
            part.executeUpdate();
            part = con.prepareStatement("Update Partner set email= '" + p.getEmail() + "' where id = '"+ p.getId() +"';");
            part.executeUpdate();
            part = con.prepareStatement("Update Partner set phone= '" + p.getPhone() + "' where id = '"+ p.getId() +"';");
            part.executeUpdate();
    
            con.commit();
                        
        }
        finally{
            if(part!=null){
                part.close();
            }
        }
        con.setAutoCommit(true);
    }

        // checks if user login is a partner
    public String FetchPartners(String id, String pass) throws Exception {
        String Partner = null;
        Connection con = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery("SELECT * FROM Partner where pass = '" + pass + "' and id = '" + id + "';");
            if (rs.next()) {
                Partner = rs.getString(1);
            }

        } finally {

        }
        return Partner;

    }

    // checks if user login is a Dell employee
    public String FetchDell(String id, String pass) throws Exception {
        String Dell = null;
        Connection con = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery("SELECT * FROM Dell where pass = '" + pass + "' and id = '" + id + "';");
            if (rs.next()) {
                Dell = rs.getString(1);
            }

        } finally {

        }
        return Dell;

    }

    // checks if user login is a finance member
    public String FetchFinance(String id, String pass) throws Exception {
        String Finance = null;
        Connection con = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery("SELECT * FROM Finance where pass = '" + pass + "' and id = '" + id + "';");
            if (rs.next()) {
                Finance = rs.getString(1);
            }

        } finally {

        }
        return Finance;

    }

}
