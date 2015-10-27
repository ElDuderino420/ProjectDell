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
    private String id,name,pid,did,comment;
    private boolean poeApproved,campApproved,dismissed;
    private String dateCreated, dateChanged;

    public Campaign(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Campaign(String id, String name, String dateCreated, String dateChanged, boolean campApproved, boolean poeApproved, String pid, String did, boolean dismissed,String comment) {
        this.id = id;
        this.name = name;
        this.pid = pid;
        this.did = did;
        this.comment = comment;
        this.poeApproved = poeApproved;
        this.campApproved = campApproved;
        this.dismissed = dismissed;
        this.dateCreated = dateCreated;
        this.dateChanged = dateChanged;
    }

    public String getId() {
        return id;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateChanged() {
        return dateChanged;
    }

    public void setDateChanged(String dateChanged) {
        this.dateChanged = dateChanged;
    }
    
    
}
