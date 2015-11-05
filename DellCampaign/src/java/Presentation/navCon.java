/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Domain.CampaignController;
import java.io.IOException;
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
            request.getSession().setAttribute("motherPath", request.getContextPath());
            request.getSession().setAttribute("CampId", request.getParameter("CampId"));
            request.getSession().setAttribute("Comment", request.getParameter("Comment"));
            request.getSession().setAttribute("Path", request.getContextPath());
            String derp = request.getParameter("nav").toString();
            CampaignController cc = new CampaignController();

            // click new campaign
            if (derp.equals("NC")) {
                response.sendRedirect("MDFRequest.jsp");
            }

            // click approve campaign
            if (derp.equals("AC")) {
                cc.campApprove(request.getSession().getAttribute("CampId").toString(),
                        request.getSession().getAttribute("Comment").toString());
                cc.LastChange(request.getSession().getAttribute("CampId").toString());
                response.sendRedirect("FetchCampaigns");
            }

            // click Reject Campaign
            if (derp.equals("RC")) {
                cc.campReject(request.getSession().getAttribute("CampId").toString(),
                        request.getSession().getAttribute("Comment").toString());
                cc.LastChange(request.getSession().getAttribute("CampId").toString());
                response.sendRedirect("FetchCampaigns");
            }

            // click Upload POE
            if (derp.equals("UP")) {
                request.getSession().setAttribute("motherPath", request.getContextPath());
                response.sendRedirect("POEUpload.jsp");
            }

            // click Approve POE
            if (derp.equals("AP")) {
                if (cc.POECheckUpload(request.getSession().getAttribute("CampId").toString())) {
                    cc.POEApprove(request.getSession().getAttribute("CampId").toString(),
                            request.getSession().getAttribute("Comment").toString());
                    cc.LastChange(request.getSession().getAttribute("CampId").toString());
                    response.sendRedirect("FetchCampaigns");
                }else{
                response.sendRedirect("FetchCampaigns?msg=No POE exists for the selected campaign");
                }
            }

            // click Reject POE
            if (derp.equals("RP")) {
                if (cc.POECheckUpload(request.getSession().getAttribute("CampId").toString())) {
                    cc.POEReject(request.getSession().getAttribute("CampId").toString(),
                            request.getSession().getAttribute("Comment").toString());
                    cc.LastChange(request.getSession().getAttribute("CampId").toString());
                    response.sendRedirect("FetchCampaigns");
                }else{
                response.sendRedirect("FetchCampaigns?msg=No POE exists for the selected campaign");
            }
            }

            // click Change Comment
            if (derp.equals("CC")) {
                cc.campChangeComment(request.getSession().getAttribute("CampId").toString(),
                        request.getSession().getAttribute("Comment").toString());
                cc.LastChange(request.getSession().getAttribute("CampId").toString());
                response.sendRedirect("FetchCampaigns");
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
