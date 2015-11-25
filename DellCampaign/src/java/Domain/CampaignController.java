/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import DataSource.Mapper;
import java.util.List;

/**
 *
 * @author butwhole
 */
public class CampaignController {
    Mapper map = new Mapper();

    // FetchCampaigns selects all the campaigns from the database and puts them into a list of campaigns and returns it
    public List<Campaign> FetchCampaigns(String s, String id) throws Exception {
        return map.FetchCampaigns(s, id);
    }
    
    // sets poe status to Pending and changes comment
    public void CompleteCamp(String id, String comment) throws Exception {
        map.CompleteCamp(id, comment);
    }

    public void createPartner(Partner p) throws Exception{
        map.CreatePartner(p);
    }
    
    // CreateCampaign takes a campaigndetail and inserts it into the campaign table and the campaigndetails table
    public void CreateCampaign(CampaignDetails cp, String pid, String derp, String comment) throws Exception {
        map.CreateCampaign(cp, pid, derp, comment);
    }

    // returns a campaign details with the specifik id
    public CampaignDetails getCampDetail(String id) throws Exception {
        return map.getCampDetail(id);
    }

    // marks a campaign for deleting
    public void deleteCamp(String id, String Comment) throws Exception {
        map.deleteCamp(id, Comment);
    }

    // completely deletes a specefik campaign from database as well as any poe on the server
    public void nukeCamp(String id, String path) throws Exception {
        map.nukeCamp(id, path);
    }

    // returns a boolean if an campaign exists with that id
    public boolean checkID(String id) throws Exception {
        return map.checkID(id);
    }

    //getNextId returns the next string needed for the campaign id by adding 1 to the newest campaign in the database
    public String getNextId() throws Exception {
        return map.getNextId();
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
        map.campApprove(id, Comment, did);
    }

    // campReject takes the campaign id and a comment of a campaign and sets the campapproved status to rejected and the comment to campaign has been rejected
    public void campReject(String id, String Comment, String did) throws Exception {
        map.campReject(id, Comment, did);
    }

    // POEApprove sets the POEApproved status to approved for a given campaign id and sets its comment to poe has been approved
    public void POEApprove(String id, String Comment) throws Exception {
        map.POEApprove(id, Comment);
    }

    // POEReject sets the poeapproved status to rejected for a given campaign id and changes the comment to poe has been rejected
    public void POEReject(String id, String Comment) throws Exception {
        map.POEReject(id, Comment);
    }

    // creates a poe detail in the database and changes comment
    public void createPOE(String id, String path, String Comment) throws Exception {
        map.createPOE(id, path, Comment);
    }

    // returns a boolean if a specific campaign has an Invoice.pdf in their poe folder
    public boolean InvoiceCheck(String id) throws Exception {
        return map.InvoiceCheck(id);
    }

    // returns a list of POEs for a campaign
    public List<POEDetails> ViewPOE(String id) throws Exception {
        return map.ViewPOE(id);
    }

    // campChangeComment changes the comment of a given campaign id to a given comment
    public void campChangeComment(String id, String Comment) throws Exception {
        map.campChangeComment(id, Comment);
    }
    
    // LastChange updates the date of a given campaign id to todays date
    public void LastChange(String id) throws Exception {
        map.LastChange(id);
    }

    // checks if a campaign has been completed
    public boolean POECheckUpload(String id) throws Exception {
        return map.POECheckUpload(id);
    }
    
    public boolean CheckPartner(String id) throws Exception{
        return map.CheckPartner(id);
    }
    
    public Partner GetPartner(String id) throws Exception{
        return map.GetPartner(id);
    }
   
    public void EditPartner(Partner p) throws Exception{
        map.EditPartner(p);
    } 
}
