/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author butwhole
 */
public class Campaign {
    private String poeApproved,campApproved,id,pid,did,comment;
    private boolean dismissed;
    private String  dateChanged;

    /*
    Campaing Claas for Campaing Objects
    id: Campaing ID for the campaing primary key
    pid: Partner ID
    did: Dell ID
    poeApproved: status on POE
    campApproved: status on campaing approval
    dismissed: notification dismissed
    comment: optional comment on status
    dateChanged: last date changed
    */
    
    
    public Campaign(String id) {
        this.id = id;
    }

    public Campaign(String id, String dateChanged, String campApproved, String poeApproved, String pid, String did, boolean dismissed,String comment) {
        this.id = id;
        this.pid = pid;
        this.did = did;
        this.comment = comment;
        this.poeApproved = poeApproved;
        this.campApproved = campApproved;
        this.dismissed = dismissed;
        this.dateChanged = dateChanged;
    }

    public String getId() {
        return id;
    }

    

    

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPoeApproved() {
        return poeApproved;
    }

    public void setPoeApproved(String poeApproved) {
        this.poeApproved = poeApproved;
    }

    public String getCampApproved() {
        return campApproved;
    }

    public void setCampApproved(String campApproved) {
        this.campApproved = campApproved;
    }

    public boolean isDismissed() {
        return dismissed;
    }

    public void setDismissed(boolean dismissed) {
        this.dismissed = dismissed;
    }

    
    

    public String getDateChanged() {
        return dateChanged;
    }

    public void setDateChanged(String dateChanged) {
        this.dateChanged = dateChanged;
    }
    
    
}
