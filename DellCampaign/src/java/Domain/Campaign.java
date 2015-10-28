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
    private String id,pid,did,comment;
    private boolean poeApproved,campApproved,dismissed;
    private String  dateChanged;

    public Campaign(String id) {
        this.id = id;
    }

    public Campaign(String id, String dateChanged, boolean campApproved, boolean poeApproved, String pid, String did, boolean dismissed,String comment) {
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

    public boolean isPoeApproved() {
        return poeApproved;
    }

    public void setPoeApproved(boolean poeApproved) {
        this.poeApproved = poeApproved;
    }

    public boolean isCampApproved() {
        return campApproved;
    }

    public void setCampApproved(boolean campApproved) {
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
