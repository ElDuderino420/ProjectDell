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
            //the string will be made if there is a user with that id and password
            part = lc.FetchPartners(request.getParameter("lid"), request.getParameter("pass"));
            String dell = lc.FetchDell(request.getParameter("lid"), request.getParameter("pass"));
            String finan = lc.FetchFinance(request.getParameter("lid"), request.getParameter("pass"));
            request.getSession().setAttribute("Selected", "null");
            
            // checks if user is a partner
            if (part != null) {
                // checks if the user has all informations on their profile
                if (cc.checkPartner(part)) {
                    request.getSession().setAttribute("id", part);
                    response.sendRedirect("PartnerFetch");
                } else {
                    Partner p = cc.getPartner(part);
                    request.getSession().setAttribute("id", part);
                    request.getSession().setAttribute("part", p);
                    response.sendRedirect("EditPartner.jsp");
                }
            } 
            // checks if the user is a Dell employee
            else if (dell != null) {
                request.getSession().setAttribute("id", dell);
                response.sendRedirect("DellFetch");
            } 
            // checks if the user is a finance employee
            else if (finan != null) {
                request.getSession().setAttribute("id", finan);
                response.sendRedirect("FinanceFetch");
            } 
            // if a user does not exist with that id and password returns to login with eror message
            else {
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
