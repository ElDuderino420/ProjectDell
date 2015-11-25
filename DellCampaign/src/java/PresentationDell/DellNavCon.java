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
            String derp = "";
            if (request.getParameter("DNC") == null) {
                sel = request.getParameter("sel");
            } else{
                derp = request.getParameter("DNC");
            }
            if(derp.equals("") ){
                request.getSession().setAttribute("Selected", sel);
                request.getSession().setAttribute("CampId", sel);
                response.sendRedirect("DellFetch");
            }
            else{
            if (derp.equals("CP")){
                response.sendRedirect("CreatePartner.jsp");
            }    
            if (derp.equals("CD")) {

                request.getSession().setAttribute("currentCD", (CampaignDetails) cc.getCampDetail(selected));
                response.sendRedirect("CampDetails.jsp");
            }
            if (derp.equals("PD")) {
                request.getSession().setAttribute("CID", selected);
                List<POEDetails> list = cc.ViewPOE(selected);
                request.getSession().setAttribute("lust", list);
                response.sendRedirect("DellViewPOE.jsp");

            }
            if (derp.equals("nuke")) {
                String path = request.getSession().getAttribute("filepath").toString();
                cc.nukeCamp(request.getParameter("id2"), path);
                derp = "DC";
            }
            if (derp.equals("DC")) {
                request.getSession().setAttribute("deletedCamp", cc.FetchCampaigns("deleted", ""));
                request.getSession().setAttribute("doneCamp", cc.FetchCampaigns("completed", ""));
                response.sendRedirect("DCComics.jsp");
            }

            if (derp.equals("nerd")) {
                request.getSession().setAttribute("currentCD", (CampaignDetails) cc.getCampDetail(selected));
                response.sendRedirect("nerd.jsp");

            }
            if (derp.equals("back")) {

                response.sendRedirect("DellFetch");

            }
            if (derp.equals("viewpoe")) {
                request.getSession().setAttribute("campIDDD", selected);
                List<POEDetails> list = cc.ViewPOE(request.getSession().getAttribute("campIDDD").toString());
                request.getSession().setAttribute("lust", list);
                response.sendRedirect("nerdPOE.jsp");

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
