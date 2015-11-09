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
            if (!cc.getChecked(request.getParameter("StartTime"))
                    || !cc.getChecked(request.getParameter("EndTime"))
                    || !cc.getChecked(request.getParameter("ProgramDate"))
                    || !cc.getChecked(request.getParameter("SubmissionDate"))
                    || !cc.getChecked(request.getParameter("ContactName"))
                    || !cc.getChecked(request.getParameter("CompanyName"))
                    || !cc.getChecked(request.getParameter("Address"))
                    || !cc.getChecked(request.getParameter("ContactEmail"))
                    || !cc.getChecked(request.getParameter("VenueName"))
                    || !cc.getChecked(request.getParameter("VenueAddress"))
                    || !cc.getChecked(request.getParameter("desc"))
                    || !cc.getChecked(request.getParameter("methodofreimbursement"))
                    || !cc.getChecked(request.getParameter("partner"))
                    || !cc.getChecked(request.getParameter("ContactPhone"))
                    || !cc.getChecked(request.getParameter("cost"))
                    || !cc.getChecked(request.getParameter("requesting"))
                    || !cc.getChecked(request.getParameter("partnercontribution"))
                    || !cc.getChecked(request.getParameter("NoOpp"))
                    || !cc.getChecked(request.getParameter("estimatedrevenue"))
                    || !cc.getChecked(request.getParameter("NOAttendees")) 
                    || !cc.checkDate(request.getParameter("SubmissionDate"))
                    || !cc.checkDate(request.getParameter("ProgramDate"))
                    || !cc.checkTime(request.getParameter("EndTime"))
                    || !cc.checkTime(request.getParameter("StartTime"))){
                response.sendRedirect("MDFREquest");
            }

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
                    request.getParameter("desc"),cc.getChecked(request.getParameter("SC4000")),
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

            cc.CreateCampaign(cd);

            response.sendRedirect("FetchCampaigns");
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
