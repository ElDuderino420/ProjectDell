/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import DataSource.DatabaseCon;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

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
            comment.executeUpdate("update campaign set CampComment = 'Waiting for Approval' where id = '" + cp.getId() + "';");
            comment.close();

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

    public boolean getChecked(String s) {
        if (s == null || s.equals(null) || s.equals("null")) {
            return false;
        }
        return true;
    }

    public void campApprove(String id, String Comment) throws Exception {

        Connection con = null;
        try {
            if (Comment == null || Comment.equals("")) {
                Comment = "Campaign has been Approved";
            }
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();
            ps.executeUpdate("update campaign set CampApproved = 'Approved' where id = '" + id + "';");
            ps.executeUpdate("update campaign set CampComment = '" + Comment + "' where id = '" + id + "';");
            ps.close();
        } finally {

        }
    }

    public void campReject(String id, String Comment) throws Exception {

        Connection con = null;
        try {
            if (Comment == null || Comment.equals("")) {
                Comment = "Campaign has been Rejected";
            }

            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();
            ps.executeUpdate("update campaign set CampApproved = 'Rejected' where id = '" + id + "';");
            ps.executeUpdate("update campaign set CampComment = '" + Comment + "' where id = '" + id + "';");
            ps.close();

        } finally {

        }
    }

    public void POEApprove(String id, String Comment) throws Exception {

        Connection con = null;
        try {
            if (Comment == null || Comment.equals("")) {
                Comment = "POE has been Approved";
            }
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();
            ps.executeUpdate("update campaign set POEApproved = 'Approved' where id = '" + id + "';");
            ps.executeUpdate("update campaign set CampComment = '" + Comment + "' where id = '" + id + "';");

        } finally {

        }
    }

    public void POEReject(String id, String Comment) throws Exception {

        Connection con = null;
        try {
            if (Comment == null || Comment.equals("")) {
                Comment = "POE has been Rejected";
            }
            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();
            ps.executeUpdate("update campaign set POEApproved = 'Rejected' where id = '" + id + "';");
            ps.executeUpdate("update campaign set CampComment = '" + Comment + "' where id = '" + id + "';");
            ps.close();

        } finally {

        }
    }

    public void NewPOE(String id, String Comment) throws Exception {

        Connection con = null;
        try {
            if (Comment == null || Comment.equals("")) {
                Comment = "POE has been uploaded";
            }

            con = DatabaseCon.getInstance().getConnection();
            Statement ps = con.createStatement();
            ps.executeUpdate("update campaign set POEApproved = 'Pending' where id = '" + id + "';");
            ps.executeUpdate("update campaign set CampComment = '" + Comment + "' where id = '" + id + "';");
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

            ps.executeUpdate("update campaign set CampComment = '" + Comment + "' where id = '" + id + "';");
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
            ps.executeUpdate("update campaign set LastChange = '" + Date + "' where id = '" + id + "';");
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
