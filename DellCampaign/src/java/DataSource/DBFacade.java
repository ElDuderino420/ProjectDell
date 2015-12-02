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
    
    public List<String> fetchAllCampaigns(String id) throws Exception{
        return cm.fetchAllCampaigns(id);
    }
    public List<Campaign> fetchCampaigns(String s, String id) throws Exception {
        return cm.fetchCampaigns(s, id);
    }
    
    
    public void completeCamp(String id, String comment) throws Exception {
        cm.completeCamp(id, comment);
    }

    public void createPartner(Partner p) throws Exception{
        um.CreatePartner(p);
    }
    
    
    public void createCampaign(CampaignDetails cd, String pid, String command, String comment) throws Exception {
        cm.createCampaign(cd, pid, command, comment);
    }

    
    public CampaignDetails getCampDetail(String id) throws Exception {
        return cm.getCampDetail(id);
    }

   
    public void deleteCamp(String id, String Comment) throws Exception {
        poem.deleteCamp(id, Comment);
    }

    
    public void nukeCamp(String id, String path) throws Exception {
        poem.nukeCamp(id, path);
    }

    
    public boolean checkID(String id) throws Exception {
        return cm.checkID(id);
    }

    
    public String getNextId() throws Exception {
        return cm.getNextId();
    }

    public void campApprove(String id, String Comment, String did) throws Exception {
        cm.campApprove(id, Comment, did);
    }

    
    public void campReject(String id, String Comment, String did) throws Exception {
        cm.campReject(id, Comment, did);
    }

    
    public void poeApprove(String id, String Comment) throws Exception {
        poem.POEApprove(id, Comment);
    }

    
    public void poeReject(String id, String Comment) throws Exception {
        poem.POEReject(id, Comment);
    }

    
    public void createPOE(String id, String path, String Comment) throws Exception {
        poem.createPOE(id, path, Comment);
    }
    
    
    public void deletePOE(String id, String path) throws Exception {
        poem.deletePOE(id, path);
    }

    
    public boolean invoiceCheck(String id) throws Exception {
        return poem.InvoiceCheck(id);
    }

    public boolean checkApproved(String id) throws Exception{
        return poem.CheckApproved(id);
    }
    
    
    public List<POEDetails> viewPOE(String id) throws Exception {
        return poem.ViewPOE(id);
    }

    
    public void campChangeComment(String id, String Comment) throws Exception {
        cm.campChangeComment(id, Comment);
    }
    
    
    public void lastChange(String id) throws Exception {
        cm.lastChange(id);
    }

    
    public boolean poeCheckUpload(String id) throws Exception {
        return poem.POECheckUpload(id);
    }
    
    public boolean checkPartner(String id) throws Exception{
        return um.CheckPartner(id);
    }
    
    public Partner getPartner(String id) throws Exception{
        return um.GetPartner(id);
    }
   
    public void editPartner(Partner p) throws Exception{
        um.EditPartner(p);
    } 
    
    public boolean poeCheckApproved(String id) throws Exception {
        return poem.POECheckApproved(id);
    }
    
    public boolean checkDeleted(String id) throws Exception {
        return cm.checkDeleted(id);
    }
    
    public String getNextPartId() throws Exception {
        return um.getNextPartId();
    }
    
    public List<Partner> fetchAllPartners() throws Exception {
        return um.FetchAllPartners();
    }
    
    
    public void deletePart(String id) throws Exception {
        um.deletePart(id);
    }
    
}
