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
public class CampaignDetails {
    
    private String programDate, startTime, endTime, id, dateCreated, contactName, companyName, companyAddress, contactEmail, venueName, venueAddress, programDescription, softwareComponent, reimbursement, technologyPartners;
    private boolean faceToFace, tradeShows, multiTouch, doorOpener, thirdParty, directMail, blitz, sc4000, ps4210, dellStorageSol, flashPriceDisk, fluidCache, dataProtection, powerEdgeServers, windowsServer, x86Server, powerEdgeVRTX, sdn, userCentric, cloudClientComputing, infrastructureHardware, bladeDataCenter, optimizedEnterprise, powerEdgeFX, sds, smb, le, pub;
    private int contactPhone, estimatedAttendees, totalProjectedCost, mdfRequest, totalMDFContribution, estimatedOpportunities, estimatedRevenue;
    
    
    public String getProgramDate() {
        return programDate;
    }

    public void setProgramDate(String programDate) {
        this.programDate = programDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public int getEstimatedAttendees() {
        return estimatedAttendees;
    }

    public void setEstimatedAttendees(int estimatedAttendees) {
        this.estimatedAttendees = estimatedAttendees;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public CampaignDetails(String id, String startTime, String endTime, String programDate, String dateCreated, String contactName, String companyName, String companyAddress, String contactEmail, String venueName, String venueAddress, String programDescription, String softwareComponent, String reimbursement, String technologyPartners, boolean faceToFace, boolean tradeShows, boolean multiTouch, boolean doorOpener, boolean thirdParty, boolean directMail, boolean blitz, boolean sc4000, boolean ps4210, boolean dellStorageSol, boolean flashPriceDisk, boolean fluidCache, boolean dataProtection, boolean powerEdgeServers, boolean windowsServer, boolean x86Server, boolean powerEdgeVRTX, boolean sdn, boolean userCentric, boolean cloudClientComputing, boolean infrastructureHardware, boolean bladeDataCenter, boolean optimizedEnterprise, boolean powerEdgeFX, boolean sds, boolean smb, boolean le, boolean pub, int contactPhone, int totalProjectedCost, int mdfRequest, int totalMDFContribution, int estimatedOpportunities, int estimatedRevenue, int estimatedAttendees) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.programDate = programDate;
        this.dateCreated = dateCreated;
        this.contactName = contactName;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.contactEmail = contactEmail;
        this.venueName = venueName;
        this.venueAddress = venueAddress;
        this.programDescription = programDescription;
        this.softwareComponent = softwareComponent;
        this.reimbursement = reimbursement;
        this.technologyPartners = technologyPartners;
        this.faceToFace = faceToFace;
        this.tradeShows = tradeShows;
        this.multiTouch = multiTouch;
        this.doorOpener = doorOpener;
        this.thirdParty = thirdParty;
        this.directMail = directMail;
        this.blitz = blitz;
        this.sc4000 = sc4000;
        this.ps4210 = ps4210;
        this.dellStorageSol = dellStorageSol;
        this.flashPriceDisk = flashPriceDisk;
        this.fluidCache = fluidCache;
        this.dataProtection = dataProtection;
        this.powerEdgeServers = powerEdgeServers;
        this.windowsServer = windowsServer;
        this.x86Server = x86Server;
        this.powerEdgeVRTX = powerEdgeVRTX;
        this.sdn = sdn;
        this.userCentric = userCentric;
        this.cloudClientComputing = cloudClientComputing;
        this.infrastructureHardware = infrastructureHardware;
        this.bladeDataCenter = bladeDataCenter;
        this.optimizedEnterprise = optimizedEnterprise;
        this.powerEdgeFX = powerEdgeFX;
        this.sds = sds;
        this.smb = smb;
        this.le = le;
        this.pub = pub;
        this.contactPhone = contactPhone;
        this.totalProjectedCost = totalProjectedCost;
        this.mdfRequest = mdfRequest;
        this.totalMDFContribution = totalMDFContribution;
        this.estimatedOpportunities = estimatedOpportunities;
        this.estimatedRevenue = estimatedRevenue;
        this.estimatedAttendees = estimatedAttendees;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueAddress() {
        return venueAddress;
    }

    public void setVenueAddress(String venueAddress) {
        this.venueAddress = venueAddress;
    }

    public String getProgramDescription() {
        return programDescription;
    }

    public void setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
    }

    public String getSoftwareComponent() {
        return softwareComponent;
    }

    public void setSoftwareComponent(String softwareComponent) {
        this.softwareComponent = softwareComponent;
    }

    public String getReimbursement() {
        return reimbursement;
    }

    public void setReimbursement(String reimbursement) {
        this.reimbursement = reimbursement;
    }

    public String getTechnologyPartners() {
        return technologyPartners;
    }

    public void setTechnologyPartners(String technologyPartners) {
        this.technologyPartners = technologyPartners;
    }

    public boolean isFaceToFace() {
        return faceToFace;
    }

    public void setFaceToFace(boolean faceToFace) {
        this.faceToFace = faceToFace;
    }

    public boolean isTradeShows() {
        return tradeShows;
    }

    public void setTradeShows(boolean tradeShows) {
        this.tradeShows = tradeShows;
    }

    public boolean isMultiTouch() {
        return multiTouch;
    }

    public void setMultiTouch(boolean multiTouch) {
        this.multiTouch = multiTouch;
    }

    public boolean isDoorOpener() {
        return doorOpener;
    }

    public void setDoorOpener(boolean doorOpener) {
        this.doorOpener = doorOpener;
    }

    public boolean isThirdParty() {
        return thirdParty;
    }

    public void setThirdParty(boolean thirdParty) {
        this.thirdParty = thirdParty;
    }

    public boolean isDirectMail() {
        return directMail;
    }

    public void setDirectMail(boolean directMail) {
        this.directMail = directMail;
    }

    public boolean isBlitz() {
        return blitz;
    }

    public void setBlitz(boolean blitz) {
        this.blitz = blitz;
    }

    public boolean isSc4000() {
        return sc4000;
    }

    public void setSc4000(boolean sc4000) {
        this.sc4000 = sc4000;
    }

    public boolean isPs4210() {
        return ps4210;
    }

    public void setPs4210(boolean ps4210) {
        this.ps4210 = ps4210;
    }

    public boolean isDellStorageSol() {
        return dellStorageSol;
    }

    public void setDellStorageSol(boolean dellStorageSol) {
        this.dellStorageSol = dellStorageSol;
    }

    public boolean isFlashPriceDisk() {
        return flashPriceDisk;
    }

    public void setFlashPriceDisk(boolean flashPriceDisk) {
        this.flashPriceDisk = flashPriceDisk;
    }

    public boolean isFluidCache() {
        return fluidCache;
    }

    public void setFluidCache(boolean fluidCache) {
        this.fluidCache = fluidCache;
    }

    public boolean isDataProtection() {
        return dataProtection;
    }

    public void setDataProtection(boolean dataProtection) {
        this.dataProtection = dataProtection;
    }

    public boolean isPowerEdgeServers() {
        return powerEdgeServers;
    }

    public void setPowerEdgeServers(boolean powerEdgeServers) {
        this.powerEdgeServers = powerEdgeServers;
    }

    public boolean isWindowsServer() {
        return windowsServer;
    }

    public void setWindowsServer(boolean windowsServer) {
        this.windowsServer = windowsServer;
    }

    public boolean isX86Server() {
        return x86Server;
    }

    public void setX86Server(boolean x86Server) {
        this.x86Server = x86Server;
    }

    public boolean isPowerEdgeVRTX() {
        return powerEdgeVRTX;
    }

    public void setPowerEdgeVRTX(boolean powerEdgeVRTX) {
        this.powerEdgeVRTX = powerEdgeVRTX;
    }

    public boolean isSdn() {
        return sdn;
    }

    public void setSdn(boolean sdn) {
        this.sdn = sdn;
    }

    public boolean isUserCentric() {
        return userCentric;
    }

    public void setUserCentric(boolean userCentric) {
        this.userCentric = userCentric;
    }

    public boolean isCloudClientComputing() {
        return cloudClientComputing;
    }

    public void setCloudClientComputing(boolean cloudClientComputing) {
        this.cloudClientComputing = cloudClientComputing;
    }

    public boolean isInfrastructureHardware() {
        return infrastructureHardware;
    }

    public void setInfrastructureHardware(boolean infrastructureHardware) {
        this.infrastructureHardware = infrastructureHardware;
    }

    public boolean isBladeDataCenter() {
        return bladeDataCenter;
    }

    public void setBladeDataCenter(boolean bladeDataCenter) {
        this.bladeDataCenter = bladeDataCenter;
    }

    public boolean isOptimizedEnterprise() {
        return optimizedEnterprise;
    }

    public void setOptimizedEnterprise(boolean optimizedEnterprise) {
        this.optimizedEnterprise = optimizedEnterprise;
    }

    public boolean isPowerEdgeFX() {
        return powerEdgeFX;
    }

    public void setPowerEdgeFX(boolean powerEdgeFX) {
        this.powerEdgeFX = powerEdgeFX;
    }

    public boolean isSds() {
        return sds;
    }

    public void setSds(boolean sds) {
        this.sds = sds;
    }

    public boolean isSmb() {
        return smb;
    }

    public void setSmb(boolean smb) {
        this.smb = smb;
    }

    public boolean isLe() {
        return le;
    }

    public void setLe(boolean le) {
        this.le = le;
    }

    public boolean isPub() {
        return pub;
    }

    public void setPub(boolean pub) {
        this.pub = pub;
    }

    public int getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(int contactPhone) {
        this.contactPhone = contactPhone;
    }

    public int getTotalProjectedCost() {
        return totalProjectedCost;
    }

    public void setTotalProjectedCost(int totalProjectedCost) {
        this.totalProjectedCost = totalProjectedCost;
    }

    public int getMdfRequest() {
        return mdfRequest;
    }

    public void setMdfRequest(int mdfRequest) {
        this.mdfRequest = mdfRequest;
    }

    public int getTotalMDFContribution() {
        return totalMDFContribution;
    }

    public void setTotalMDFContribution(int totalMDFContribution) {
        this.totalMDFContribution = totalMDFContribution;
    }

    public int getEstimatedOpportunities() {
        return estimatedOpportunities;
    }

    public void setEstimatedOpportunities(int estimatedOpportunities) {
        this.estimatedOpportunities = estimatedOpportunities;
    }

    public int getEstimatedRevenue() {
        return estimatedRevenue;
    }

    public void setEstimatedRevenue(int estimatedRevenue) {
        this.estimatedRevenue = estimatedRevenue;
    }
    
    
}
