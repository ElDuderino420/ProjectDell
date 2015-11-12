/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationPartner;

import Domain.CampaignController;
import Domain.CampaignDetails;
import Domain.POEDetails;
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
public class navCon extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // set 

            request.getSession().setAttribute("CampId", request.getParameter("Cid"));
            String suckABigDick = request.getSession().getAttribute("CampId").toString();
            request.getSession().setAttribute("Comment", request.getParameter("Comment"));
            request.getSession().setAttribute("Path", request.getContextPath());
            String derp = request.getParameter("nav");

            CampaignController cc = new CampaignController();

            // click new campaign
            if (derp.equals("NC")) {
                CampaignDetails cd = new CampaignDetails();
                request.getSession().setAttribute("cd", cd);
                response.sendRedirect("MDFRequest.jsp");
            }
            else if (cc.checkID(suckABigDick)) {
                if (derp.equals("D")) {
                    request.getSession().setAttribute("currentCD", (CampaignDetails) cc.getCampDetail(request.getParameter("Cid")));
                    response.sendRedirect("PartnerDetails.jsp");
                }
                // click Upload POE
                if (derp.equals("UP")) {
                    response.sendRedirect("POEUpload.jsp");

                }
                if (derp.equals("C")) {
                    cc.CompleteCamp("CampId");
                    response.sendRedirect("CompletePoe");
                }

                if (derp.equals("PD")) {
                    List<POEDetails> list = cc.ViewPOE(request.getSession().getAttribute("CampId").toString());
                    request.getSession().setAttribute("lust", list);
                    response.sendRedirect("PartnerViewPOE.jsp");
                }

            } else {
                response.sendRedirect("Partner.jsp");
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