/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import DataSource.DBFacade;
import java.util.List;

/**
 *
 * @author butwhole
 */
public class CampaignController {
    private DBFacade dbf = new DBFacade();

    // FetchCampaigns selects all the campaigns from the database and puts them into a list of campaigns and returns it
    public List<Campaign> fetchCampaigns(String s, String id) throws Exception {
        return dbf.fetchCampaigns(s, id);
    }
    
    // sets poe status to Pending and changes comment
    public void completeCamp(String id, String comment) throws Exception {
        dbf.completeCamp(id, comment);
    }

    // creates a partner in the database
    public void createPartner(Partner p) throws Exception{
        dbf.createPartner(p);
    }
    
    // CreateCampaign takes a campaigndetail and inserts it into the campaign table and the campaigndetails table
    public void createCampaign(CampaignDetails cd, String pid, String command, String comment) throws Exception {
        dbf.createCampaign(cd, pid, command, comment);
    }

    // returns a campaign details with the specifik id
    public CampaignDetails getCampDetail(String id) throws Exception {
        return dbf.getCampDetail(id);
    }

    // marks a campaign for deleting
    public void deleteCamp(String id, String Comment) throws Exception {
        dbf.deleteCamp(id, Comment);
    }

    // completely deletes a specefik campaign from database as well as any poe on the server
    public void nukeCamp(String id, String path) throws Exception {
        dbf.nukeCamp(id, path);
    }

    // returns a boolean if an campaign exists with that id
    public boolean checkID(String id) throws Exception {
        return dbf.checkID(id);
    }

    //getNextId returns the next string needed for the campaign id by adding 1 to the newest campaign in the database
    public String getNextId() throws Exception {
        return dbf.getNextId();
    }
    
    // returns a boolean if a checkbox has been checked or not
    public boolean getChecked(String s) {
        if (s == null || s.equals("null") || s.equals("") || s.startsWith(" ")) {
            return false;
        }
        return true;
    }

    // returns a boolean if the string is in proper time format for database entry
    public boolean checkTime(String s) {

        String timeformat
                = "([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";

        return s.matches(timeformat);

    }

    // returns a boolean if the string is in proper date format for database entry
    public boolean checkDate(String s) {

        String dateformat
                = "20[0-9][0-9]-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";

        return s.matches(dateformat);

    }

    // campApprove takes a campaign id and comment and sets the campapproved status to approved and sets the comment to capaign has been approved
    public void campApprove(String id, String Comment, String did) throws Exception {
        dbf.campApprove(id, Comment, did);
    }

    // campReject takes the campaign id and a comment of a campaign and sets the campapproved status to rejected and the comment to campaign has been rejected
    public void campReject(String id, String Comment, String did) throws Exception {
        dbf.campReject(id, Comment, did);
    }

    // POEApprove sets the POEApproved status to approved for a given campaign id and sets its comment to poe has been approved
    public void poeApprove(String id, String Comment) throws Exception {
        dbf.poeApprove(id, Comment);
    }

    // POEReject sets the poeapproved status to rejected for a given campaign id and changes the comment to poe has been rejected
    public void poeReject(String id, String Comment) throws Exception {
        dbf.poeReject(id, Comment);
    }

    // creates a poe detail in the database and changes comment
    public void createPOE(String id, String path, String Comment) throws Exception {
        dbf.createPOE(id, path, Comment);
    }
    
    // deletes a poe detail in the database
    public void deletePOE(String id, String path) throws Exception {
        dbf.deletePOE(id, path);
    }

    // returns a boolean if a specific campaign has an Invoice.pdf in their poe folder
    public boolean invoiceCheck(String id) throws Exception {
        return dbf.invoiceCheck(id);
    }

    public boolean checkApproved(String id) throws Exception{
        return dbf.checkApproved(id);
    }
    
    // returns a list of POEs for a campaign
    public List<POEDetails> viewPOE(String id) throws Exception {
        return dbf.viewPOE(id);
    }

    // campChangeComment changes the comment of a given campaign id to a given comment
    public void campChangeComment(String id, String Comment) throws Exception {
        dbf.campChangeComment(id, Comment);
    }
    
    // LastChange updates the date of a given campaign id to todays date
    public void lastChange(String id) throws Exception {
        dbf.lastChange(id);
    }

    // checks if a campaign has been completed
    public boolean poeCheckUpload(String id) throws Exception {
        return dbf.poeCheckUpload(id);
    }
    
    // returns false if the partner is missing information
    public boolean checkPartner(String id) throws Exception{
        return dbf.checkPartner(id);
    }
    
    // returns a partner from the database
    public Partner getPartner(String id) throws Exception{
        return dbf.getPartner(id);
    }
   
    // edits information about a partner
    public void editPartner(Partner p) throws Exception{
        dbf.editPartner(p);
    } 
    
    // returns true if the campaigns poe has been approved
    public boolean poeCheckApproved(String id) throws Exception {
        return dbf.poeCheckApproved(id);
    }
    
    // returns true if campaign is marked DELETED
    public boolean checkDeleted(String id) throws Exception {
        return dbf.checkDeleted(id);
    }
    
    // returns a String with a viable campaign id
    public String getNextPartId() throws Exception {
        return dbf.getNextPartId();
    }
    
    // returns a list of all partners (excluding passwords)
    public List<Partner> fetchAllPartners() throws Exception {
        return dbf.fetchAllPartners();
    }
    
    // iterates a list of campaign ids from a partner for nuking, then deletes the partner
    public void deletePart(String id,String path) throws Exception {
        List<String> list = dbf.fetchAllCampaigns(id);
        for (String camp : list) {
            dbf.nukeCamp(camp, path);
        }
        dbf.deletePart(id);
    }
}
