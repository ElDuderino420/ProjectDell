/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSource;

import Domain.Campaign;
import Domain.CampaignDetails;
import Domain.POEDetails;
import Domain.Partner;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Warco
 */
public class POEMapper {
    
    // marks a campaign for deleting
    public void deleteCamp(String id, String Comment) throws Exception {

        Connection con = null;
        try {
            if (Comment == null || Comment.equals("")) {
                Comment = "Campaign has been DELETED";
            }
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();
            ps.executeUpdate("update Campaign set CampApproved = 'DELETED' where id = '" + id + "';");
            ps.executeUpdate("update Campaign set CampComment = '" + Comment + "' where id = '" + id + "';");
            ps.close();
        } finally {

        }

    }

    // completely deletes a specific campaign from database as well as any poe on the server
    public void nukeCamp(String id, String path) throws Exception {
        Connection con = null;

        try {

            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();

            nukeFolder(id, path);
            ps.executeUpdate("delete from POEDetails where Cid = '" + id + "';");
            ps.executeUpdate("delete from Campaign where id = '" + id + "';");
            ps.executeUpdate("delete from CampaignDetails where id = '" + id + "';");

            ps.close();
        } finally {

        }
    }
    
    // builds a path to the poe folder (runned through nukeCamp)
    private void nukeFolder(String id, String path) {
        File file;
        int derp = path.indexOf("/build/web/");
        String f = "/";

        if (derp == -1) {
            f = "\\";
            derp = path.indexOf("\\build\\web\\");
        }
        path = path.substring(0, derp) + f + "Poe" + f + id;
        file = new File(path);
        DeleteFileFolder(file);
    }

    // runs a loop which calls delte method (runned through nukeFolder)
    private void DeleteFileFolder(File file) {

        if (file.exists()) {
            do {
                delete(file);
            } while (file.exists());
        } 
    }

    // iterates a folder deleting every file one by one (runned through DeleteFileFolder)
    private void delete(File file) {
        if (file.isDirectory()) {
            String fileList[] = file.list();
            if (fileList.length == 0) {
                file.delete();
            } else {
                int size = fileList.length;
                for (int i = 0; i < size; i++) {
                    String fileName = fileList[i];
                    String fullPath = file.getPath() + "/" + fileName;
                    File fileOrFolder = new File(fullPath);
                    delete(fileOrFolder);
                }
            }
        } else {
            file.delete();
        }
    }

    // POEApprove sets the POEApproved status to approved for a given campaign id and sets its comment to poe has been approved
    public void POEApprove(String id, String Comment) throws Exception {

        Connection con = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();
            if (Comment == null || Comment.equals("")) {
                Comment = "POE has been Approved";
            }

            ps.executeUpdate("update Campaign set POEApproved = 'Approved' where id = '" + id + "';");
            ps.executeUpdate("update Campaign set CampComment = '" + Comment + "' where id = '" + id + "';");

            ps.close();
        } finally {

        }
    }

    // POEReject sets the poeapproved status to rejected for a given campaign id and changes the comment to poe has been rejected
    public void POEReject(String id, String Comment) throws Exception {
        Connection con = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();
            if (Comment == null || Comment.equals("")) {
                Comment = "POE has been Rejected";
            }

            ps.executeUpdate("update Campaign set POEApproved = 'Rejected' where id = '" + id + "';");
            ps.executeUpdate("update Campaign set CampComment = '" + Comment + "' where id = '" + id + "';");

            ps.close();
        } finally {

        }
    }

    // creates a poe detail in the database and changes comment
    public void createPOE(String id, String path, String Comment) throws Exception {

        Connection con = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();
            if (Comment == null || Comment.equals("")) {
                Comment = "POE has been Uploaded";
            }
            ps.executeUpdate("Insert into POEDetails values('" + path + "','" + id + "');");
            ps.executeUpdate("update Campaign set CampComment = '" + Comment + "' where id = '" + id + "';");
            ps.close();

        } finally {

        }

    }

    // deletes a poe detail in the database
    public void deletePOE(String id, String path) throws Exception {

        Connection con = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();
            ps.executeUpdate("delete from POEDetails where DL = '" + path + "' and Cid = '" + id + "';");
            ps.close();

        } finally {

        }

    }
    
    // returns true if a specific campaign has been approved
    public boolean CheckApproved(String id) throws Exception {
        Connection con = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery("select CampApproved from Campaign where id = '" + id + "';");
            rs.next();
            if (rs.getString(1).equals("Approved")) {
                return true;
            }
            ps.close();

        } finally {

        }
        return false;
    }
    
// returns a boolean if a specific campaign has an Invoice.pdf in their poe folder
    public boolean InvoiceCheck(String id) throws Exception {

        Connection con = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery("select * from POEDetails where Cid = '" + id + "' and DL = 'invoice.pdf';");
            if (rs.next()) {
                return true;
            }
            ps.close();

        } finally {

        }
        return false;

    }

    // returns a list of POEs for a campaign
    public List<POEDetails> ViewPOE(String id) throws Exception {

        Connection con = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();
            ArrayList<POEDetails> list = null;

            ResultSet rs = ps.executeQuery("select * from POEDetails where Cid = '" + id + "';");

            list = new ArrayList();

            while (rs.next()) {
                list.add(new POEDetails(rs.getString(1)));
            }

            ps.close();
            return list;
        } finally {

        }

    }

    // returns true if the campaign has been marked completed
    public boolean POECheckUpload(String id) throws Exception {

        Connection con = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery("select POEApproved from Campaign where id = '" + id + "';");
            rs.next();
            if (rs.getString(1).equals("Pending")) {
                return true;
            }
            ps.close();

        } finally {

        }
        return false;
    }

    // returns true if the campaigns poe has been approved
    public boolean POECheckApproved(String id) throws Exception {

        Connection con = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery("select POEApproved from Campaign where id = '" + id + "';");
            rs.next();
            if (rs.getString(1).equals("Approved")) {
                return true;
            }
            ps.close();

        } finally {

        }
        return false;
    }

}
