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
        um.createPartner(p);
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
        poem.poeApprove(id, Comment);
    }

    
    public void poeReject(String id, String Comment) throws Exception {
        poem.poeReject(id, Comment);
    }

    
    public void createPOE(String id, String path, String Comment) throws Exception {
        poem.createPOE(id, path, Comment);
    }
    
    
    public void deletePOE(String id, String path) throws Exception {
        poem.deletePOE(id, path);
    }

    
    public boolean invoiceCheck(String id) throws Exception {
        return poem.invoiceCheck(id);
    }

    public boolean checkApproved(String id) throws Exception{
        return poem.checkApproved(id);
    }
    
    
    public List<POEDetails> viewPOE(String id) throws Exception {
        return poem.viewPOE(id);
    }

    
    public void campChangeComment(String id, String Comment) throws Exception {
        cm.campChangeComment(id, Comment);
    }
    
    
    public void lastChange(String id) throws Exception {
        cm.lastChange(id);
    }

    
    public boolean poeCheckUpload(String id) throws Exception {
        return poem.poeCheckUpload(id);
    }
    
    public boolean checkPartner(String id) throws Exception{
        return um.checkPartner(id);
    }
    
    public Partner getPartner(String id) throws Exception{
        return um.getPartner(id);
    }
   
    public void editPartner(Partner p) throws Exception{
        um.editPartner(p);
    } 
    
    public boolean poeCheckApproved(String id) throws Exception {
        return poem.poeCheckApproved(id);
    }
    
    public boolean checkDeleted(String id) throws Exception {
        return cm.checkDeleted(id);
    }
    
    public String getNextPartId() throws Exception {
        return um.getNextPartId();
    }
    
    public List<Partner> fetchAllPartners() throws Exception {
        return um.fetchAllPartners();
    }
    
    
    public void deletePart(String id) throws Exception {
        um.deletePart(id);
    }
    
        // FetchPartners checks if there is a partner with the given id and password, if so will return true else returns false
    public String fetchPartners(String id,String pass) throws Exception {
        return um.fetchPartners(id, pass);
    }
    
    // FetchPartners checks if there is a partner with the given id and password, if so will return true else returns false
    public String fetchDell(String id,String pass) throws Exception {
        return um.fetchDell(id, pass);
    }

    // FetchPartners checks if there is a partner with the given id and password, if so will return true else returns false    
    public String fetchFinance(String id,String pass) throws Exception {
        return um.fetchFinance(id, pass);
    }
}
