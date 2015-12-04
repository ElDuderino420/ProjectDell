/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSource;

import Domain.Campaign;
import Domain.Partner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author David
 */
public class UserMapper {

    // returns a String with a viable campaign id
    public String getNextPartId() throws Exception {
        Connection con = null;
        Random id = new Random();
        boolean next = true;
        int result = 0;
        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery("SELECT id FROM Partner");
            while (next) {
                result = id.nextInt(89999) + 10000;
                while (rs.next()) {

                    int temp = Integer.parseInt(rs.getString(1).substring(1));
                    if (temp == result) {
                        next = true;
                        break;
                    } else {
                        next = false;
                    }
                }
            }

            ps.close();
            return "P" + result;

        } finally {

        }

    }

    // returns false if the partner is missing information
    public boolean checkPartner(String id) throws Exception {
        Connection con = null;
        Statement check = null;
        try {
            con = DatabaseCon.getInstance().getConnection();

            check = con.createStatement();

            ResultSet rs = check.executeQuery("SELECT * FROM Partner where id ='" + id + "';");

            rs.next();
            if (rs.getString(5).equals("") || rs.getString(6).equals("")) {
                return false;
            }

        } finally {
            if (check != null) {
                check.close();
            }
        }

        return true;
    }

    // creates a partner in the database
    public void createPartner(Partner p) throws Exception {
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
            newPartner.setString(5, p.getEmail());
            newPartner.setString(6, p.getPhone());

            newPartner.executeUpdate();
            con.commit();

        } finally {
            if (newPartner != null) {
                newPartner.close();
            }
        }
        con.setAutoCommit(true);
    }

    // returns a partner from the database
    public Partner getPartner(String id) throws Exception {
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

    // edits information about a partner
    public void editPartner(Partner p) throws Exception {
        Connection con = null;
        PreparedStatement part = null;

        try {
            con = DatabaseCon.getInstance().getConnection();
            con.setAutoCommit(false);
            part = con.prepareStatement("Update Partner set Pname= '" + p.getName() + "' where id = '" + p.getId() + "';");
            part.executeUpdate();
            part = con.prepareStatement("Update Partner set pass= '" + p.getPassword() + "' where id = '" + p.getId() + "';");
            part.executeUpdate();
            part = con.prepareStatement("Update Partner set email= '" + p.getEmail() + "' where id = '" + p.getId() + "';");
            part.executeUpdate();
            part = con.prepareStatement("Update Partner set phone= '" + p.getPhone() + "' where id = '" + p.getId() + "';");
            part.executeUpdate();

            con.commit();

        } finally {
            if (part != null) {
                part.close();
            }
        }
        con.setAutoCommit(true);
    }

    // checks if user login is a partner
    public String fetchPartners(String id, String pass) throws Exception {
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
    public String fetchDell(String id, String pass) throws Exception {
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
    public String fetchFinance(String id, String pass) throws Exception {
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

    // returns a list of all partners (excluding passwords)
    public List<Partner> fetchAllPartners() throws Exception {
        List<Partner> result = new ArrayList<>();
        Connection con = null;

        con = DatabaseCon.getInstance().getConnection();
        Statement ps = con.createStatement();
        try {

            ResultSet rs = ps.executeQuery("SELECT * FROM Partner;");
            while (rs.next()) {
                Partner part = new Partner(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        "");

                part.setEmail(rs.getString(5));
                part.setPhone(rs.getString(6));

                result.add(part);
            }

        } finally {

        }
        ps.close();
        return result;
    }

    // deletes a partner from the database
    public void deletePart(String id) throws Exception {
        
        Connection con = null;
        try {

            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();
            ps.executeUpdate("Delete from Partner where id = '" + id + "';");
            ps.close();
        } finally {

        }
    }
}
