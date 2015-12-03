/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationPartner;

import Domain.CampaignController;
import Domain.CampaignDetails;
import Domain.POEDetails;
import Domain.Partner;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author butwhole
 */
public class NavCon extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            request.getSession().setAttribute("errIN",null);
            request.getSession().setAttribute("errMDF", null);
            String selected = request.getSession().getAttribute("Selected").toString();
            request.getSession().setAttribute("Comment", request.getParameter("Comment"));
            request.getSession().setAttribute("Path", request.getContextPath());
            request.getSession().setAttribute("msg", null);
            String nav = "";
            String sel = "";
            CampaignController cc = new CampaignController();

            // checks if the button is a select or an other type of button
            if (request.getParameter("nav") == null) {
                sel = request.getParameter("sel");
            } else {
                nav = request.getParameter("nav");
            }
            // edit profile button
            if (nav.equals("EditPartner")) {
                Partner p = (Partner) request.getSession().getAttribute("part");
                p.setName(request.getParameter("PartnerName"));
                p.setPassword(request.getParameter("Password"));
                p.setEmail(request.getParameter("Email"));
                p.setPhone(request.getParameter("Phone"));
                cc.editPartner(p);
                response.sendRedirect("PartnerFetch");
            }
            // new campaign button
            else if (nav.equals("NC")) {
                CampaignDetails cd = new CampaignDetails();
                request.getSession().setAttribute("cd", cd);
                response.sendRedirect("MDFRequest.jsp");
            }
            // edit partner button
            else if (nav.equals("EP")) {
                Partner p = cc.getPartner(request.getSession().getAttribute("id").toString());
                request.getSession().setAttribute("part", p);
                response.sendRedirect("EditPartner.jsp");
            } 
            // select button
            else if (!sel.equals("")) {
                request.getSession().setAttribute("Selected", sel);
                request.getSession().setAttribute("CampId", sel);
                response.sendRedirect("PartnerFetch");
            } 
            // checks if there is a valid campaign selected
            else if (cc.checkID(selected)) {
                // details button
                if (nav.equals("D")) {
                    request.getSession().setAttribute("currentCD", (CampaignDetails) cc.getCampDetail(selected));
                    response.sendRedirect("PartnerDetails.jsp");
                } 
                // Upload POE button
                else if (nav.equals("UP")) {
                    if(cc.checkApproved(selected)){
                    response.sendRedirect("POEUpload.jsp");
                    }else{
                        request.getSession().setAttribute("errIN","There cannot be uploaded a POE to an unapproved campaign");
                        response.sendRedirect("PartnerFetch");
                    }
                } 
                // complete button
                else if (nav.equals("Com")) {
                    // checks if the selected campaign has an invoice
                    if(cc.invoiceCheck(selected)){
                    cc.completeCamp(selected, "");
                    cc.lastChange(selected);
                    }
                    // else it goes back with an error message
                    else{
                        request.getSession().setAttribute("errIN","Please upload an Invoice before completing your campaign");
                    }
                    response.sendRedirect("PartnerFetch");
                } 
                // view poe button 
                else if (nav.equals("PD")) {
                    List<POEDetails> list = cc.viewPOE(selected);
                    request.getSession().setAttribute("lust", list);
                    response.sendRedirect("PartnerViewPOE.jsp");
                } else {
                    response.sendRedirect("PartnerFetch");
                }

            } else {
                response.sendRedirect("PartnerFetch");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("index.jsp?msg=Error: " + ex.getMessage());
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
