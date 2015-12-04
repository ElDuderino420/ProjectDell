/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationDell;

import Domain.CampaignController;
import Domain.Partner;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Whalecum
 */
public class ApplyPartner extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // retuns to Dell Home if "back" is clicked
            if(request.getParameter("CreatePartner").equals("Back")){
                response.sendRedirect("DellFetch");
            }
            // creates a partner in the database from the data entered, then returns to Dell Home
            else{
            Partner p = new Partner(request.getParameter("PartnerID"),
                    request.getParameter("PartnerName"),
                    request.getParameter("DateCreated"), 
                    request.getParameter("Password"));
            CampaignController cc = new CampaignController();
            cc.createPartner(p);
            response.sendRedirect("DellFetch");
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