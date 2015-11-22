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
            HttpSession ss = request.getSession();

            CampaignController cc = new CampaignController();

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
                    Integer.parseInt(request.getParameter("NOAttendees").toString()),
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
                    Integer.parseInt(request.getParameter("cost").toString()),
                    Integer.parseInt(request.getParameter("requesting").toString()),
                    request.getParameter("methodofreimbursement"),
                    request.getParameter("partner"),
                    Integer.parseInt(request.getParameter("partnercontribution").toString()),
                    Integer.parseInt(request.getParameter("NoOpp").toString()),
                    Integer.parseInt(request.getParameter("estimatedrevenue").toString()));
            
            if (cd.isSmb() == false && cd.isLe() == false && cd.isPub() == false && request.getParameter("edit") == null) {
                request.getSession().setAttribute("cd", cd);
                response.sendRedirect("MDFRequest.jsp?msg=please select atleast 1 target audience");
            } else if (!cc.checkDate(cd.getProgramDate()) || !cc.checkTime(cd.getStartTime()) || !cc.checkTime(cd.getEndTime()) || !cc.checkDate(cd.getDateCreated())){
                request.getSession().setAttribute("cd", cd);
                response.sendRedirect("MDFRequest.jsp?msg=time and/or date incorrect");
            } else {
                String id = request.getSession().getAttribute("id").toString();
                String Campid = request.getSession().getAttribute("CampId").toString();

                String submit = request.getParameter("edit");
                String comment = request.getParameter("Comment");
                String redirect = "PartnerFetch";
                if (submit != null) {
                    if (!cd.isSmb() && !cd.isPub() && !cd.isLe()) {
                        request.getSession().setAttribute("currentCD", cd);
                        redirect = "PartnerDetails.jsp";
                    } else if (submit.equals("Save")) {
                        CampaignDetails cd2 = (CampaignDetails) request.getSession().getAttribute("currentCD");
                        cd.setId(cd2.getId());
                        cc.CreateCampaign(cd, id, "edit", comment);
                    }
                    if (submit.equals("Delete")) {
                        cc.deleteCamp(Campid, comment);
                    }
                } else {
                    cc.CreateCampaign(cd, id, "Create", null);
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
