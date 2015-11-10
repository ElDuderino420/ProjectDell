/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import DataSource.DatabaseCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author butwhole
 */
public class CampaignController {

    /*
     FetchCampaigns selects all the campaigns from the database and puts them into a list of campaigns and returns it
     */
    public List<Campaign> FetchCampaigns(String s, String id) throws Exception {
        List<Campaign> result = new ArrayList<>();
        Connection con = null;
        switch (s) {
            case "ongoing":
                s = "  where POEApproved != 'Approved' and PartnerId = '" + id + "' order by LastChange DESC";
                break;
            case "completed":
                s = " where POEApproved = 'Approved';";
                break;
            case "poe":
                s = " where POEApproved = 'Pending';";
                break;
            case "camp":
                s = " where CampApproved = 'Pending';";
                break;
        }

        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery("SELECT * FROM Campaign" + s);
            while (rs.next()) {
                Campaign camp = new Campaign(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getBoolean(7),
                        rs.getString(8));

                result.add(camp);
            }
            ps.close();
        } finally {

        }
        return result;
    }

    public void CompleteCamp(String id) throws Exception {
        Connection con = null;

        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();

            ps.executeUpdate("update Campaign set POEApproved = 'Pending' where id = '" + id + "';");

            ps.close();
        } finally {

        }
    }

    /*
     CreateCampaign takes a campaigndetail and inserts it into the campaign table and the campaigndetails table
     */
    public void CreateCampaign(CampaignDetails cp, String pid) throws Exception {

        Connection con = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            PreparedStatement ezshit = con.prepareStatement("Insert into Campaign values(?,?,?,?,?,?,?,?)");
            PreparedStatement fuckThis = con.prepareStatement("Insert into CampaignDetails values(?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?)");

            fuckThis.setString(1, cp.getId());
            ezshit.setString(1, cp.getId());
            fuckThis.setString(2, cp.getDateCreated());
            ezshit.setString(2, cp.getDateCreated());
            ezshit.setString(3, "Pending");
            ezshit.setString(4, "N/A");
            ezshit.setString(5, pid);
            ezshit.setString(6, null);
            ezshit.setBoolean(7, false);
            ezshit.setString(8, "Waiting for Approval");
            fuckThis.setString(3, cp.getContactName());
            fuckThis.setString(4, cp.getCompanyName());
            fuckThis.setString(5, cp.getCompanyAddress());
            fuckThis.setString(6, cp.getContactEmail());
            fuckThis.setString(7, cp.getContactPhone());
            fuckThis.setString(8, cp.getProgramDate());
            fuckThis.setString(9, cp.getStartTime());
            fuckThis.setString(10, cp.getEndTime());
            fuckThis.setInt(11, cp.getEstimatedAttendees());
            fuckThis.setString(12, cp.getVenueName());
            fuckThis.setString(13, cp.getVenueAddress());
            fuckThis.setBoolean(14, cp.isFaceToFace());
            fuckThis.setBoolean(15, cp.isTradeShows());
            fuckThis.setBoolean(16, cp.isMultiTouch());
            fuckThis.setBoolean(17, cp.isDoorOpener());
            fuckThis.setBoolean(18, cp.isThirdParty());
            fuckThis.setBoolean(19, cp.isDirectMail());
            fuckThis.setBoolean(20, cp.isBlitz());
            fuckThis.setString(21, cp.getProgramDescription());
            fuckThis.setBoolean(22, cp.isSc4000());
            fuckThis.setBoolean(23, cp.isPs4210());
            fuckThis.setBoolean(24, cp.isDellStorageSol());
            fuckThis.setBoolean(25, cp.isFlashPriceDisk());
            fuckThis.setBoolean(26, cp.isFluidCache());
            fuckThis.setBoolean(27, cp.isDataProtection());
            fuckThis.setBoolean(28, cp.isPowerEdgeServers());
            fuckThis.setBoolean(29, cp.isWindowsServer());
            fuckThis.setBoolean(30, cp.isX86Server());
            fuckThis.setBoolean(31, cp.isPowerEdgeVRTX());
            fuckThis.setBoolean(32, cp.isSdn());
            fuckThis.setBoolean(33, cp.isUserCentric());
            fuckThis.setBoolean(34, cp.isCloudClientComputing());
            fuckThis.setBoolean(35, cp.isInfrastructureHardware());
            fuckThis.setBoolean(36, cp.isBladeDataCenter());
            fuckThis.setBoolean(37, cp.isOptimizedEnterprise());
            fuckThis.setBoolean(38, cp.isPowerEdgeFX());
            fuckThis.setBoolean(39, cp.isSds());
            fuckThis.setString(40, cp.getSoftwareComponent());
            fuckThis.setBoolean(41, cp.isSmb());
            fuckThis.setBoolean(42, cp.isLe());
            fuckThis.setBoolean(43, cp.isPub());
            fuckThis.setInt(44, cp.getTotalProjectedCost());
            fuckThis.setInt(45, cp.getMdfRequest());
            fuckThis.setString(46, cp.getReimbursement());
            fuckThis.setString(47, cp.getTechnologyPartners());
            fuckThis.setInt(48, cp.getTotalMDFContribution());
            fuckThis.setInt(49, cp.getEstimatedOpportunities());
            fuckThis.setInt(50, cp.getEstimatedRevenue());

            fuckThis.executeUpdate();
            fuckThis.close();
            ezshit.executeUpdate();
            ezshit.close();

        } finally {

        }

    }

    public CampaignDetails getCampDetail(String id) throws Exception {
        Connection con = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();
            ResultSet fuckThis = ps.executeQuery("SELECT * FROM CampaignDetails where id = '" + id + "';");
            fuckThis.next();
            CampaignDetails cd = new CampaignDetails(
                    fuckThis.getString(1),
                    fuckThis.getString(2),
                    fuckThis.getString(3),
                    fuckThis.getString(4),
                    fuckThis.getString(5),
                    fuckThis.getString(6),
                    fuckThis.getString(7),
                    fuckThis.getString(8),
                    fuckThis.getString(9),
                    fuckThis.getString(10),
                    fuckThis.getInt(11),
                    fuckThis.getString(12),
                    fuckThis.getString(13),
                    fuckThis.getBoolean(14),
                    fuckThis.getBoolean(15),
                    fuckThis.getBoolean(16),
                    fuckThis.getBoolean(17),
                    fuckThis.getBoolean(18),
                    fuckThis.getBoolean(19),
                    fuckThis.getBoolean(20),
                    fuckThis.getString(21),
                    fuckThis.getBoolean(22),
                    fuckThis.getBoolean(23),
                    fuckThis.getBoolean(24),
                    fuckThis.getBoolean(25),
                    fuckThis.getBoolean(26),
                    fuckThis.getBoolean(27),
                    fuckThis.getBoolean(28),
                    fuckThis.getBoolean(29),
                    fuckThis.getBoolean(30),
                    fuckThis.getBoolean(31),
                    fuckThis.getBoolean(32),
                    fuckThis.getBoolean(33),
                    fuckThis.getBoolean(34),
                    fuckThis.getBoolean(35),
                    fuckThis.getBoolean(36),
                    fuckThis.getBoolean(37),
                    fuckThis.getBoolean(38),
                    fuckThis.getBoolean(39),
                    fuckThis.getString(40),
                    fuckThis.getBoolean(41),
                    fuckThis.getBoolean(42),
                    fuckThis.getBoolean(43),
                    fuckThis.getInt(44),
                    fuckThis.getInt(45),
                    fuckThis.getString(46),
                    fuckThis.getString(47),
                    fuckThis.getInt(48),
                    fuckThis.getInt(49),
                    fuckThis.getInt(50)
            );

            ps.close();
            return cd;

        } finally {

        }
    }
    /*
     getNextId returns the next string needed for the campaign id by adding 1 to the newest campaign in the database
     */

    public String getNextId() throws Exception {
        int result = 0;
        Connection con = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery("SELECT id FROM Campaign");
            while (rs.next()) {
                int temp = Integer.parseInt(rs.getString(1).substring(1));
                if (result < temp) {
                    result = temp;
                }
            }
            result = result + 1;
            ps.close();
            return "C" + result;

        } finally {

        }

    }

    /*
     getChecked returns a boolean if a checkbox has been checked or not
     */
    public boolean getChecked(String s) {
        if (s == null || s.equals("null") || s.equals("") || s.startsWith(" ")) {
            return false;
        }
        return true;
    }

    public boolean checkTime(String s) {

        String timeformat
                = "([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";

        return s.matches(timeformat);

    }

    public boolean checkDate(String s) {

        String dateformat
                = "20[0-9][0-9]-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";

        return s.matches(dateformat);

    }

    /*
     campApprove takes a campaign id and comment and sets the campapproved status to approved and sets the comment to capaign has been approved
     */
    public void campApprove(String id, String Comment) throws Exception {

        Connection con = null;
        try {
            if (Comment == null || Comment.equals("")) {
                Comment = "Campaign has been Approved";
            }
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();
            ps.executeUpdate("update Campaign set CampApproved = 'Approved' where id = '" + id + "';");
            ps.executeUpdate("update Campaign set CampComment = '" + Comment + "' where id = '" + id + "';");
            ps.close();
        } finally {

        }
    }

    /*
     campReject takes the campaign id and a comment of a campaign and sets the campapproved status to rejected and the comment to campaign has been rejected
     */
    public void campReject(String id, String Comment) throws Exception {

        Connection con = null;
        try {
            if (Comment == null || Comment.equals("")) {
                Comment = "Campaign has been Rejected";
            }

            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();
            ps.executeUpdate("update Campaign set CampApproved = 'Rejected' where id = '" + id + "';");
            ps.executeUpdate("update Campaign set CampComment = '" + Comment + "' where id = '" + id + "';");
            ps.close();

        } finally {

        }
    }

    /*
     POEApprove sets the POEApproved status to approved for a given campaign id and sets its comment to poe has been approved
     */
    public void POEApprove(String id, String Comment) throws Exception {

        Connection con = null;
        try {
            if (Comment == null || Comment.equals("")) {
                Comment = "POE has been Approved";
            }
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();
            ps.executeUpdate("update Campaign set POEApproved = 'Approved' where id = '" + id + "';");
            ps.executeUpdate("update Campaign set CampComment = '" + Comment + "' where id = '" + id + "';");

        } finally {

        }
    }

    /*
     POEReject sets the poeapproved status to rejected for a given campaign id and changes the comment to poe has been rejected
     */
    public void POEReject(String id, String Comment) throws Exception {

        Connection con = null;
        try {
            if (Comment == null || Comment.equals("")) {
                Comment = "POE has been Rejected";
            }
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();
            ps.executeUpdate("update Campaign set POEApproved = 'Rejected' where id = '" + id + "';");
            ps.executeUpdate("update Campaign set CampComment = '" + Comment + "' where id = '" + id + "';");
            ps.close();

        } finally {

        }
    }

    /*
     NewPOE updates the poeapproved status to pending and comments that a poe has been uploaded
     */
    public void NewPOE(String id, String Comment) throws Exception {

        Connection con = null;
        try {
            if (Comment == null || Comment.equals("")) {
                Comment = "POE has been uploaded";
            }

            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();
            ps.executeUpdate("update Campaign set POEApproved = 'Pending' where id = '" + id + "';");
            ps.executeUpdate("update Campaign set CampComment = '" + Comment + "' where id = '" + id + "';");
            ps.close();

        } finally {

        }
    }

    /*
     campChangeComment changes the comment of a given campaign id to a given comment
     */
    public void campChangeComment(String id, String Comment) throws Exception {

        Connection con = null;
        try {
            if (Comment == null || Comment.equals("")) {
                Comment = "";
            }
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();

            ps.executeUpdate("update Campaign set CampComment = '" + Comment + "' where id = '" + id + "';");
            ps.close();

        } finally {

        }
    }

    /*
     LastChange updates the date of a given campaign id to todays date
     */
    public void LastChange(String id) throws Exception {
        Connection con = null;
        try {

            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();
            String Date = LocalDateTime.now().toString().substring(0, 10);
            ps.executeUpdate("update Campaign set LastChange = '" + Date + "' where id = '" + id + "';");
            ps.close();

        } finally {

        }
    }

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

    }
