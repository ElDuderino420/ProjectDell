/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSource;

import Domain.Campaign;
import Domain.CampaignDetails;
import Domain.POEDetails;
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
 * @author David
 */
public class CampMapper {
    
    
    public List<Campaign> FetchCampaigns(String s, String id) throws Exception {
        List<Campaign> result = new ArrayList<>();
        Connection con = null;
        switch (s) {
            case "ongoing":
                s = "  where POEApproved != 'Approved' and PartnerId = '" + id + "' and CampApproved != 'DELETED' order by LastChange DESC;";
                break;
            case "completed":
                s = " where POEApproved = 'Approved' and CampApproved != 'DELETED' order by LastChange DESC;";
                break;
            case "poe":
                s = " where POEApproved = 'Pending' and DellId = '" + id + "' and CampApproved != 'DELETED' order by LastChange DESC;";
                break;
            case "camp":
                s = " where CampApproved = 'Pending' order by LastChange DESC;";
                break;
            case "deleted":
                s = " where CampApproved = 'DELETED' order by LastChange DESC;";
                break;

        }
        con = DatabaseCon.getInstance().getConnection();
        Statement ps = con.createStatement();
        try {

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

        } finally {

        }
        ps.close();
        return result;
    }

    public void CompleteCamp(String id, String comment) throws Exception {

        Connection con = null;

        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();
            if (comment == null || comment.equals("")) {
                comment = "POE has been completed";
            }
            ps.executeUpdate("update Campaign set POEApproved = 'Pending' where id = '" + id + "';");
            ps.executeUpdate("update Campaign set CampComment = '" + comment + "' where id = '" + id + "';");
            ps.close();
        } finally {

        }
    }

    public void CreateCampaign(CampaignDetails cd, String pid, String derp, String comment) throws Exception {

        Connection con = null;
        PreparedStatement camp = null;
        PreparedStatement campDeets = null;
        PreparedStatement camp2 = null;
        PreparedStatement poeDeets = null;
        PreparedStatement campDeets2 = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            con.setAutoCommit(false);

            if (comment == null || comment.equals("")) {
                comment = "Waiting for Approval";
            }

            if (derp.equals("edit")) {
                campDeets2 = con.prepareStatement("Delete from CampaignDetails where id = '" + cd.getId() + "';");
                poeDeets = con.prepareStatement("Delete From POEDetails where Cid ='" + cd.getId() + "';");
                camp2 = con.prepareStatement("Delete From Campaign where id= '" + cd.getId() + "';");
                poeDeets.executeUpdate();
                camp2.executeUpdate();
                campDeets2.executeUpdate();

            }

            camp = con.prepareStatement("Insert into Campaign values(?,?,?,?,?,?,?,?);");
            campDeets = con.prepareStatement("Insert into CampaignDetails values(?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?);");

            campDeets.setString(1, cd.getId());
            camp.setString(1, cd.getId());
            campDeets.setString(2, cd.getDateCreated());
            camp.setString(2, cd.getDateCreated());
            camp.setString(3, "Pending");
            camp.setString(4, "N/A");
            camp.setString(5, pid);
            camp.setString(6, null);
            camp.setBoolean(7, false);
            camp.setString(8, comment);
            campDeets.setString(3, cd.getContactName());
            campDeets.setString(4, cd.getCompanyName());
            campDeets.setString(5, cd.getCompanyAddress());
            campDeets.setString(6, cd.getContactEmail());
            campDeets.setString(7, cd.getContactPhone());
            campDeets.setString(8, cd.getProgramDate());
            campDeets.setString(9, cd.getStartTime());
            campDeets.setString(10, cd.getEndTime());
            campDeets.setInt(11, cd.getEstimatedAttendees());
            campDeets.setString(12, cd.getVenueName());
            campDeets.setString(13, cd.getVenueAddress());
            campDeets.setBoolean(14, cd.isFaceToFace());
            campDeets.setBoolean(15, cd.isTradeShows());
            campDeets.setBoolean(16, cd.isMultiTouch());
            campDeets.setBoolean(17, cd.isDoorOpener());
            campDeets.setBoolean(18, cd.isThirdParty());
            campDeets.setBoolean(19, cd.isDirectMail());
            campDeets.setBoolean(20, cd.isBlitz());
            campDeets.setString(21, cd.getProgramDescription());
            campDeets.setBoolean(22, cd.isSc4000());
            campDeets.setBoolean(23, cd.isPs4210());
            campDeets.setBoolean(24, cd.isDellStorageSol());
            campDeets.setBoolean(25, cd.isFlashPriceDisk());
            campDeets.setBoolean(26, cd.isFluidCache());
            campDeets.setBoolean(27, cd.isDataProtection());
            campDeets.setBoolean(28, cd.isPowerEdgeServers());
            campDeets.setBoolean(29, cd.isWindowsServer());
            campDeets.setBoolean(30, cd.isX86Server());
            campDeets.setBoolean(31, cd.isPowerEdgeVRTX());
            campDeets.setBoolean(32, cd.isSdn());
            campDeets.setBoolean(33, cd.isUserCentric());
            campDeets.setBoolean(34, cd.isCloudClientComputing());
            campDeets.setBoolean(35, cd.isInfrastructureHardware());
            campDeets.setBoolean(36, cd.isBladeDataCenter());
            campDeets.setBoolean(37, cd.isOptimizedEnterprise());
            campDeets.setBoolean(38, cd.isPowerEdgeFX());
            campDeets.setBoolean(39, cd.isSds());
            campDeets.setString(40, cd.getSoftwareComponent());
            campDeets.setBoolean(41, cd.isSmb());
            campDeets.setBoolean(42, cd.isLe());
            campDeets.setBoolean(43, cd.isPub());
            campDeets.setInt(44, cd.getTotalProjectedCost());
            campDeets.setInt(45, cd.getMdfRequest());
            campDeets.setString(46, cd.getReimbursement());
            campDeets.setString(47, cd.getTechnologyPartners());
            campDeets.setInt(48, cd.getTotalMDFContribution());
            campDeets.setInt(49, cd.getEstimatedOpportunities());
            campDeets.setInt(50, cd.getEstimatedRevenue());
            campDeets.executeUpdate();
            camp.executeUpdate();
            con.commit();

        } finally {

            if (campDeets != null) {
                campDeets.close();
            }
            if (camp != null) {
                camp.close();
            }
            if (campDeets2 != null) {
                campDeets2.close();
            }
            if (camp2 != null) {
                camp2.close();
            }
            if(poeDeets != null){
                poeDeets.close();
            }

            con.setAutoCommit(true);
        }
    }
    
    public CampaignDetails getCampDetail(String id) throws Exception {
        Connection con = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();
            ResultSet CampDeets = ps.executeQuery("SELECT * FROM CampaignDetails where id = '" + id + "';");
            CampDeets.next();
            CampaignDetails cd = new CampaignDetails(
                    CampDeets.getString(1),
                    CampDeets.getString(2),
                    CampDeets.getString(3),
                    CampDeets.getString(4),
                    CampDeets.getString(5),
                    CampDeets.getString(6),
                    CampDeets.getString(7),
                    CampDeets.getString(8),
                    CampDeets.getString(9),
                    CampDeets.getString(10),
                    CampDeets.getInt(11),
                    CampDeets.getString(12),
                    CampDeets.getString(13),
                    CampDeets.getBoolean(14),
                    CampDeets.getBoolean(15),
                    CampDeets.getBoolean(16),
                    CampDeets.getBoolean(17),
                    CampDeets.getBoolean(18),
                    CampDeets.getBoolean(19),
                    CampDeets.getBoolean(20),
                    CampDeets.getString(21),
                    CampDeets.getBoolean(22),
                    CampDeets.getBoolean(23),
                    CampDeets.getBoolean(24),
                    CampDeets.getBoolean(25),
                    CampDeets.getBoolean(26),
                    CampDeets.getBoolean(27),
                    CampDeets.getBoolean(28),
                    CampDeets.getBoolean(29),
                    CampDeets.getBoolean(30),
                    CampDeets.getBoolean(31),
                    CampDeets.getBoolean(32),
                    CampDeets.getBoolean(33),
                    CampDeets.getBoolean(34),
                    CampDeets.getBoolean(35),
                    CampDeets.getBoolean(36),
                    CampDeets.getBoolean(37),
                    CampDeets.getBoolean(38),
                    CampDeets.getBoolean(39),
                    CampDeets.getString(40),
                    CampDeets.getBoolean(41),
                    CampDeets.getBoolean(42),
                    CampDeets.getBoolean(43),
                    CampDeets.getInt(44),
                    CampDeets.getInt(45),
                    CampDeets.getString(46),
                    CampDeets.getString(47),
                    CampDeets.getInt(48),
                    CampDeets.getInt(49),
                    CampDeets.getInt(50)
            );

            ps.close();
            return cd;

        } finally {

        }
    }

    public boolean checkID(String id) throws Exception {

        Connection con = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery("SELECT id from Campaign where id = '" + id + "';");
            while (rs.next()) {
                return true;
            }

            ps.close();
            return false;

        } finally {

        }

    }

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

    public void campApprove(String id, String Comment, String did) throws Exception {

        Connection con = null;
        con = DatabaseCon.getInstance().getConnection();
        Statement ps = con.createStatement();
        try {

            if (Comment == null || Comment.equals("")) {
                Comment = "Campaign has been Approved";
            }

            ps.executeUpdate("update Campaign set CampApproved = 'Approved' where id = '" + id + "';");
            ps.executeUpdate("update Campaign set CampComment = '" + Comment + "' where id = '" + id + "';");
            ps.executeUpdate("update Campaign set DellId = '" + did + "' where id = '" + id + "';");

        } finally {
            ps.close();
        }
    }

    public void campReject(String id, String Comment, String did) throws Exception {

        Connection con = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();
            if (Comment == null || Comment.equals("")) {
                Comment = "Campaign has been Rejected";
            }

            ps.executeUpdate("update Campaign set CampApproved = 'Rejected' where id = '" + id + "';");
            ps.executeUpdate("update Campaign set CampComment = '" + Comment + "' where id = '" + id + "';");
            ps.executeUpdate("update Campaign set DellId = '" + did + "' where id = '" + id + "';");

            ps.close();
        } finally {

        }
    }

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
    
    public boolean CheckDeleted(String id) throws Exception {

        Connection con = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery("select CampApproved from Campaign where id = '" + id + "';");
            rs.next();
            if (rs.getString(1).equals("DELETED")) {
                return true;
            }
            ps.close();

        } finally {

        }
        return false;
    }

    
    
}
