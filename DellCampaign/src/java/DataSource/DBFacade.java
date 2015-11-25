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
import java.util.List;

/**
 *
 * @author David
 */
public class DBFacade {
    
    private CampMapper cm;
    private POEMapper poem;
    private UserMapper um;

    public DBFacade() {
        this.cm = new CampMapper();
        this.poem = new POEMapper();
        this.um = new UserMapper();
    }
    
    public List<Campaign> FetchCampaigns(String s, String id) throws Exception {
        return cm.FetchCampaigns(s, id);
    }
    
    // sets poe status to Pending and changes comment
    public void CompleteCamp(String id, String comment) throws Exception {
        cm.CompleteCamp(id, comment);
    }

    public void createPartner(Partner p) throws Exception{
        um.CreatePartner(p);
    }
    
    // CreateCampaign takes a campaigndetail and inserts it into the campaign table and the campaigndetails table
    public void CreateCampaign(CampaignDetails cp, String pid, String derp, String comment) throws Exception {
        cm.CreateCampaign(cp, pid, derp, comment);
    }

    // returns a campaign details with the specifik id
    public CampaignDetails getCampDetail(String id) throws Exception {
        return cm.getCampDetail(id);
    }

    // marks a campaign for deleting
    public void deleteCamp(String id, String Comment) throws Exception {
        poem.deleteCamp(id, Comment);
    }

    // completely deletes a specefik campaign from database as well as any poe on the server
    public void nukeCamp(String id, String path) throws Exception {
        poem.nukeCamp(id, path);
    }

    // returns a boolean if an campaign exists with that id
    public boolean checkID(String id) throws Exception {
        return cm.checkID(id);
    }

    //getNextId returns the next string needed for the campaign id by adding 1 to the newest campaign in the database
    public String getNextId() throws Exception {
        return cm.getNextId();
    }

    // campApprove takes a campaign id and comment and sets the campapproved status to approved and sets the comment to capaign has been approved
    public void campApprove(String id, String Comment, String did) throws Exception {
        cm.campApprove(id, Comment, did);
    }

    // campReject takes the campaign id and a comment of a campaign and sets the campapproved status to rejected and the comment to campaign has been rejected
    public void campReject(String id, String Comment, String did) throws Exception {
        cm.campReject(id, Comment, did);
    }

    // POEApprove sets the POEApproved status to approved for a given campaign id and sets its comment to poe has been approved
    public void POEApprove(String id, String Comment) throws Exception {
        poem.POEApprove(id, Comment);
    }

    // POEReject sets the poeapproved status to rejected for a given campaign id and changes the comment to poe has been rejected
    public void POEReject(String id, String Comment) throws Exception {
        poem.POEReject(id, Comment);
    }

    // creates a poe detail in the database and changes comment
    public void createPOE(String id, String path, String Comment) throws Exception {
        poem.createPOE(id, path, Comment);
    }

    // returns a boolean if a specific campaign has an Invoice.pdf in their poe folder
    public boolean InvoiceCheck(String id) throws Exception {
        return poem.InvoiceCheck(id);
    }

    public boolean CheckApproved(String id) throws Exception{
        return poem.CheckApproved(id);
    }
    
    // returns a list of POEs for a campaign
    public List<POEDetails> ViewPOE(String id) throws Exception {
        return poem.ViewPOE(id);
    }

    // campChangeComment changes the comment of a given campaign id to a given comment
    public void campChangeComment(String id, String Comment) throws Exception {
        cm.campChangeComment(id, Comment);
    }
    
    // LastChange updates the date of a given campaign id to todays date
    public void LastChange(String id) throws Exception {
        cm.LastChange(id);
    }

    // checks if a campaign has been completed
    public boolean POECheckUpload(String id) throws Exception {
        return poem.POECheckUpload(id);
    }
    
    public boolean CheckPartner(String id) throws Exception{
        return um.CheckPartner(id);
    }
    
    public Partner GetPartner(String id) throws Exception{
        return um.GetPartner(id);
    }
   
    public void EditPartner(Partner p) throws Exception{
        um.EditPartner(p);
    } 
    
    
    
    
}
