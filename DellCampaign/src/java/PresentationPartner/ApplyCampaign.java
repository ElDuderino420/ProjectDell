/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationPartner;

import Domain.CampaignController;
import Domain.CampaignDetails;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author butwhole
 */
public class ApplyCampaign extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            request.getSession().setAttribute("errMDF", null);
            HttpSession ss = request.getSession();

            CampaignController cc = new CampaignController();
            // makes a CampaignDetail of all the information that is on site, (does not matter if it is correct or not)
            CampaignDetails cd = new CampaignDetails(
                    cc.getNextId(),
                    request.getParameter("SubmissionDate"),
                    request.getParameter("ContactName"),
                    request.getParameter("CompanyName"),
                    request.getParameter("Address"),
                    request.getParameter("ContactEmail"),
                    request.getParameter("ContactPhone"),
                    request.getParameter("ProgramDate"),
                    request.getParameter("StartTime"),
                    request.getParameter("EndTime"),
                    cc.checkInt(request.getParameter("NOAttendees").toString()),
                    request.getParameter("VenueName"),
                    request.getParameter("VenueAddress"),
                    cc.getChecked(request.getParameter("ftfevent")),
                    cc.getChecked(request.getParameter("tradeshows")),
                    cc.getChecked(request.getParameter("mtcamp")),
                    cc.getChecked(request.getParameter("dooropen")),
                    cc.getChecked(request.getParameter("3rdparty")),
                    cc.getChecked(request.getParameter("directmail")),
                    cc.getChecked(request.getParameter("blitzcamp")),
                    request.getParameter("desc"),
                    cc.getChecked(request.getParameter("SC4000")),
                    cc.getChecked(request.getParameter("PS4210")),
                    cc.getChecked(request.getParameter("storagesolutions")),
                    cc.getChecked(request.getParameter("pricedisk")),
                    cc.getChecked(request.getParameter("fluidcache")),
                    cc.getChecked(request.getParameter("dataprotec")),
                    cc.getChecked(request.getParameter("poweredgeservers")),
                    cc.getChecked(request.getParameter("winserver")),
                    cc.getChecked(request.getParameter("x86server")),
                    cc.getChecked(request.getParameter("VRTX")),
                    cc.getChecked(request.getParameter("SDN")),
                    cc.getChecked(request.getParameter("usercentric")),
                    cc.getChecked(request.getParameter("cloud")),
                    cc.getChecked(request.getParameter("infrahardware")),
                    cc.getChecked(request.getParameter("bladedatacenter")),
                    cc.getChecked(request.getParameter("optimizedenterprise")),
                    cc.getChecked(request.getParameter("poweredgefx")),
                    cc.getChecked(request.getParameter("SDS")),
                    request.getParameter("softwareComponent"),
                    cc.getChecked(request.getParameter("SMB")),
                    cc.getChecked(request.getParameter("LE")),
                    cc.getChecked(request.getParameter("PUB")),
                    cc.checkInt(request.getParameter("cost").toString()),
                    cc.checkInt(request.getParameter("requesting").toString()),
                    request.getParameter("methodofreimbursement"),
                    request.getParameter("partner"),
                    cc.checkInt(request.getParameter("partnercontribution").toString()),
                    cc.checkInt(request.getParameter("NoOpp").toString()),
                    cc.checkInt(request.getParameter("estimatedrevenue").toString()));

            String comment = request.getParameter("Comment");
            String redirect = "PartnerFetch";
            String id = request.getSession().getAttribute("id").toString();

            // apply campaign button
            if (request.getParameter("edit") == null) {
                // checks if target audience is selected if not returns with previous information and error message
                if (cd.isSmb() == false && cd.isLe() == false && cd.isPub() == false) {
                    request.getSession().setAttribute("cd", cd);
                    request.getSession().setAttribute("errMDF", "Please select atleast 1 target audience");
                    response.sendRedirect("MDFRequest.jsp");
                } // checks if time and/or date is of wrong format, returns with all informations previously typed and an error message
                else if (!cc.checkDate(cd.getProgramDate()) || !cc.checkTime(cd.getStartTime()) || !cc.checkTime(cd.getEndTime()) || !cc.checkDate(cd.getDateCreated())) {
                    request.getSession().setAttribute("cd", cd);
                    request.getSession().setAttribute("errMDF", "Please type time and/or date in the correct format");
                    response.sendRedirect("MDFRequest.jsp");
                } // checks if there are typed in integegers properly
                else if (cd.getEstimatedAttendees() == -1
                        || cd.getEstimatedOpportunities() == -1
                        || cd.getEstimatedRevenue() == -1
                        || cd.getMdfRequest() == -1
                        || cd.getTotalMDFContribution() == -1
                        || cd.getTotalProjectedCost() == -1) {
                    request.getSession().setAttribute("cd", cd);
                    request.getSession().setAttribute("errMDF", "Please type number into areas with \"-1\"");
                    response.sendRedirect("MDFRequest.jsp");
                } // the campaign and campaign detail is created in the database
                else {
                    cc.createCampaign(cd, id, "", comment);
                    response.sendRedirect("PartnerFetch");
                }
            } // if the edit button is clicked
            else {
                String submit = request.getParameter("edit");
                if (submit != null) {
                    // if delete is clicked
                    if (submit.equals("Delete")) {
                        String Campid = request.getSession().getAttribute("CampId").toString();
                        cc.deleteCamp(Campid, comment);
                    } // checks if target audience is selected if not returns with previous information and error message
                    else if (!cd.isSmb() && !cd.isPub() && !cd.isLe()) {
                        request.getSession().setAttribute("currentCD", cd);
                        request.getSession().setAttribute("errMDF", "Please select atleast 1 target audience");
                        redirect = "PartnerDetails.jsp";
                    } // checks if time and/or date is of wrong format, returns with all informations previously typed and an error message
                    else if (!cc.checkDate(cd.getProgramDate()) || !cc.checkTime(cd.getStartTime()) || !cc.checkTime(cd.getEndTime()) || !cc.checkDate(cd.getDateCreated())) {
                        request.getSession().setAttribute("currentCD", cd);
                        request.getSession().setAttribute("errMDF", "Please type time and/or date in the correct format");
                        redirect = "PartnerDetails.jsp";
                    } // checks if there are typed in integegers properly
                    else if (cd.getEstimatedAttendees() == -1
                            || cd.getEstimatedOpportunities() == -1
                            || cd.getEstimatedRevenue() == -1
                            || cd.getMdfRequest() == -1
                            || cd.getTotalMDFContribution() == -1
                            || cd.getTotalProjectedCost() == -1) {
                        request.getSession().setAttribute("cd", cd);
                        request.getSession().setAttribute("errMDF", "Please type number into areas with \"-1\"");
                        redirect = "PartnerDetails.jsp";
                    } // if the save is clicked and no error is met, overwrites the campaign in the database
                    else if (submit.equals("Save")) {
                        CampaignDetails cd2 = (CampaignDetails) request.getSession().getAttribute("currentCD");
                        cd.setId(cd2.getId());
                        cc.createCampaign(cd, id, "edit", comment);
                    }

                }
                response.sendRedirect(redirect);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("index.jsp?msg=" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

}
