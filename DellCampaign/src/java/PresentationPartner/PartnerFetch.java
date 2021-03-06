/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationPartner;

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
public class PartnerFetch extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // retreives all ongoing and completed campaigns in 2 attributes for a specific partner
            CampaignController cc = new CampaignController();
            String id = request.getSession().getAttribute("id").toString();
            request.getSession().setAttribute("allCamp", cc.fetchCampaigns("ongoing", id));
            request.getSession().setAttribute("doneCamp", cc.fetchCampaigns("partcompleted", id));
            response.sendRedirect("Partner.jsp");
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
