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
    public List<Campaign> FetchCampaigns() throws Exception {
        List<Campaign> result = new ArrayList<>();
        Connection con = null;
        try {
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery("SELECT * FROM Campaign");
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

    /*
     CreateCampaign takes a campaigndetail and inserts it into the campaign table and the campaigndetails table
     */
    public void CreateCampaign(CampaignDetails cp) throws Exception {

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
            ezshit.setString(5, null);
            ezshit.setString(6, null);
            ezshit.setBoolean(7, false);
            ezshit.setString(8, "");
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

            Statement comment = con.createStatement();
            comment.executeUpdate("update Campaign set CampComment = 'Waiting for Approval' where id = '" + cp.getId() + "';");
            comment.close();

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
    
    public boolean checkDate(String s){
        
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

     /*
             public void UploadFile(String id, String path) {

             File file;
             int maxFileSize = 5000000 * 1024;
             int maxMemSize = 5000000 * 1024;
             ServletContext context = pageContext.getServletContext();
             String filePath = application.getRealPath(request.getServletPath());
             String id = request.getSession().getAttribute("CampId").toString();
             if (id == null || id.equals("")) {
             response.sendRedirect("POEUpload");
             } else {
             int derp = filePath.indexOf("\\build\\web\\");
             filePath = filePath.substring(0, derp) + "\\Poe\\" + id + "\\";
             file = new File(filePath);
             if (!file.exists()) {
             file.mkdirs();
             }

             // Verify the content type
             String contentType = request.getContentType();

             if ((contentType.indexOf("multipart/form-data") >= 0)) {

             DiskFileItemFactory factory = new DiskFileItemFactory();
             // maximum size that will be stored in memory
             factory.setSizeThreshold(maxMemSize);
             // Location to save data that is larger than maxMemSize.
             factory.setRepository(new File("C:\\temp\\"));

             // Create a new file upload handler
             ServletFileUpload upload = new ServletFileUpload(factory);
             // maximum file size to be uploaded.
             upload.setSizeMax(maxFileSize);
             try {
             // Parse the request to get file items.
             List<FileItem> fileItems = upload.parseRequest(request);

             // Process the uploaded file items
             Iterator i = fileItems.iterator();

             while (i.hasNext()) {
             FileItem fi = (FileItem) i.next();
             if (!fi.isFormField()) {
             // Get the uploaded file parameters
             String fieldName = fi.getFieldName();
             String fileName = fi.getName();
             boolean isInMemory = fi.isInMemory();
             long sizeInBytes = fi.getSize();
             // Write the file
             if (fileName.lastIndexOf("\\") >= 0) {
             file = new File(filePath
             + fileName.substring(fileName.lastIndexOf("\\")));
             } else {
             file = new File(filePath
             + fileName.substring(fileName.lastIndexOf("\\") + 1));
             }

             fi.write(file);

             request.setAttribute("Success", "Successfully Uploaded");
             response.sendRedirect("FetchCampaigns");
             }
             }

             } catch (Exception ex) {
             System.out.println(ex);
             }
             } else {
             request.setAttribute("Error", "Error!!");
             response.sendRedirect("FetchCampaigns");

             }
             }

             }
             */
}
