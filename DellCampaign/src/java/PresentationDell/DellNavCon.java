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
            String derp = request.getParameter("DNC");
            if (derp.equals("CD")) {

                request.getSession().setAttribute("currentCD", (CampaignDetails) cc.getCampDetail(request.getParameter("Cid")));
                response.sendRedirect("CampDetails.jsp");
            }
            if (derp.equals("PD")) {
                request.getSession().setAttribute("CID", request.getParameter("Cid2"));
                List<POEDetails> list = cc.ViewPOE(request.getSession().getAttribute("CID").toString());
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
                request.getSession().setAttribute("currentCD", (CampaignDetails) cc.getCampDetail(request.getParameter("id")));
                response.sendRedirect("nerd.jsp");

            }
            if (derp.equals("back")) {
                
                response.sendRedirect("DellFetch");

            }
            if (derp.equals("viewpoe")) {
                request.getSession().setAttribute("campIDDD", request.getParameter("id"));
                List<POEDetails> list = cc.ViewPOE(request.getSession().getAttribute("campIDDD").toString());
                request.getSession().setAttribute("lust", list);
                response.sendRedirect("nerdPOE.jsp");

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
