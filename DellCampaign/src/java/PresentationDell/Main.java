/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationDell;

import Domain.CampaignController;
import Domain.LogInController;
import Domain.Partner;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author butwhole
 */
public class Main extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LogInController lc = new LogInController();
        CampaignController cc = new CampaignController();
        String part = "";

        try {
            
            part = lc.FetchPartners(request.getParameter("lid"), request.getParameter("pass"));
            String dell = lc.FetchDell(request.getParameter("lid"), request.getParameter("pass"));
            String finan = lc.FetchFinance(request.getParameter("lid"), request.getParameter("pass"));
            request.getSession().setAttribute("Selected", "null");
            if (part != null) {
                if (cc.CheckPartner(part)) {
                    request.getSession().setAttribute("id", part);
                    response.sendRedirect("PartnerFetch");
                } else {
                    Partner p = cc.GetPartner(part);
                    request.getSession().setAttribute("id", part);
                    request.getSession().setAttribute("part", p);
                    response.sendRedirect("EditPartner.jsp");
                }
            } else if (dell != null) {
                request.getSession().setAttribute("id", dell);
                response.sendRedirect("DellFetch");
            } else if (finan != null) {
                request.getSession().setAttribute("id", finan);
                response.sendRedirect("FinanceFetch");
            } else {
                request.getSession().setAttribute("errUP", "Incorrect username or password");
                response.sendRedirect("index.jsp");
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
