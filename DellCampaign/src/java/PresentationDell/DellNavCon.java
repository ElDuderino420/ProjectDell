/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationDell;

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
public class DellNavCon extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            CampaignController cc = new CampaignController();
            String selected = request.getSession().getAttribute("Selected").toString();
            String sel = "";
            String sel2 = "";
            String DNC = "";
            // retreives the button pressed
            if (request.getParameter("DNC") == null && request.getParameter("sel2") == null) {
                sel = request.getParameter("sel");
            }
            else if (request.getParameter("DNC") == null && request.getParameter("sel") == null) {
                sel2 = request.getParameter("sel2");
            } else {
                DNC = request.getParameter("DNC");
            }
            // if the select is pressed in Dell Home
            if (DNC.equals("") && sel2.equals("")) {
                request.getSession().setAttribute("Selected", sel);
                request.getSession().setAttribute("CampId", sel);
                response.sendRedirect("DellFetch");
            }
            // if the select is pressed in Deleted and Completed
            if (DNC.equals("") && sel.equals("")) {
                request.getSession().setAttribute("Selected", sel2);
                request.getSession().setAttribute("CampId", sel2);
                response.sendRedirect("DCComics.jsp");
            } else {
                // Create Partner Button
                if (DNC.equals("CP")) {
                    request.getSession().setAttribute("Selected", "null");
                    request.getSession().setAttribute("PartId", cc.getNextPartId());
                    response.sendRedirect("CreatePartner.jsp");

                }
                // Campaign Detail Button
                // checks if campaign is applicable (campaign status = Pending)
                if (DNC.equals("CD")) {
                    if (!selected.equals("null") && !cc.poeCheckUpload(selected)) {

                        request.getSession().setAttribute("currentCD", (CampaignDetails) cc.getCampDetail(selected));
                        response.sendRedirect("CampDetails.jsp");
                    } else {
                        response.sendRedirect("DellFetch");
                    }
                }
                
                // view partner button
                if(DNC.equals("VP")){
                    request.getSession().setAttribute("Partners", cc.fetchAllPartners());
                    response.sendRedirect("ViewPartners.jsp");
                }
                // detail button on the poe table
                // checks if a campaign is selected and if that campaign has poe status "Pending"
                if (DNC.equals("PD")){
                    if (!selected.equals("null") && cc.poeCheckUpload(selected)) {
                        request.getSession().setAttribute("CID", selected);
                        List<POEDetails> list = cc.viewPOE(selected);
                        request.getSession().setAttribute("lust", list);
                        response.sendRedirect("DellViewPOE.jsp");
                    } else {
                        response.sendRedirect("DellFetch");
                    }
                }
                // Permanent delete button
                // checks if a campaign is selected and if that campaign has status "DELETED"
                if (DNC.equals("nuke")) {
                    if (!selected.equals("null") && cc.checkDeleted(selected)) {
                        String path = request.getSession().getAttribute("filepath").toString();
                        cc.nukeCamp(selected, path);
                        DNC = "DC";
                    } else {
                        response.sendRedirect("DCComics.jsp");
                    }
                }
                // Deleted and Completed button
                // sets campaigns marked as poe status "approved" / "DELETED"
                if (DNC.equals("DC")) {
                    request.getSession().setAttribute("Selected", "null");
                    request.getSession().setAttribute("deletedCamp", cc.fetchCampaigns("deleted", ""));
                    request.getSession().setAttribute("doneCamp", cc.fetchCampaigns("completed", ""));
                    response.sendRedirect("DCComics.jsp");

                }
                // detail button from Completed Campaigns
                // checks if a campaign is selected and if that campaign has poe status Approved
                if (DNC.equals("nerd")) {
                    if (!selected.equals("null") && cc.poeCheckApproved(selected)) {
                        request.getSession().setAttribute("currentCD", (CampaignDetails) cc.getCampDetail(selected));
                        response.sendRedirect("Nerd.jsp");
                    } else {
                        response.sendRedirect("DCComics.jsp");
                    }
                }
                // back button
                if (DNC.equals("back")) {

                    response.sendRedirect("DellFetch");

                }
                // view poe on deleted and completed
                // checks if a campaign is selected and if that campaign has poe status Approved
                if (DNC.equals("viewpoe")) {
                    if (!selected.equals("null") && cc.poeCheckApproved(selected)) {
                        request.getSession().setAttribute("campIDDD", selected);
                        List<POEDetails> list = cc.viewPOE(request.getSession().getAttribute("campIDDD").toString());
                        request.getSession().setAttribute("lust", list);
                        response.sendRedirect("NerdPOE.jsp");
                    }
                    else{
                        response.sendRedirect("DCComics.jsp");
                    }
                }
                
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
