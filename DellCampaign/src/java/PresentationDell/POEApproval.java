/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationDell;

import Domain.CampaignController;
import Domain.CampaignDetails;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David
 */
public class POEApproval extends HttpServlet{

    
    
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try
        {
            
            CampaignController cc = new CampaignController();
            String id = request.getSession().getAttribute("CID").toString();
            String comment = request.getParameter("comment");
            // changes poe status to "Approved"
            if(request.getParameter("poe").equals("Approve")){
                cc.lastChange(id);
                cc.poeApprove(id, comment);
            }
            // changes poe status to "Rejected"
            if(request.getParameter("poe").equals("Reject")){
                cc.lastChange(id);
                cc.poeReject(id, comment);
            }
            response.sendRedirect("DellFetch");
        }
        catch (Exception ex) 
        {
            ex.printStackTrace();
            response.sendRedirect("index.jsp?msg=Error: "+ex.getMessage());
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
