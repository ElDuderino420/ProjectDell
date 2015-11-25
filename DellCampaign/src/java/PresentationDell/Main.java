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
public class Main extends HttpServlet{

    
    
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         LogInController lc = new LogInController();
         CampaignController cc = new CampaignController();
         
         
        try
        {
            String derp = lc.FetchPartners(request.getParameter("lid"), request.getParameter("pass"));
            String herp = lc.FetchDell(request.getParameter("lid"), request.getParameter("pass"));
            String herpderp = lc.FetchFinance(request.getParameter("lid"), request.getParameter("pass"));
            request.getSession().setAttribute("Selected", "null");
            if(derp != null){
                if(cc.CheckPartner(derp)){
                request.getSession().setAttribute("id", derp);
                response.sendRedirect("PartnerFetch");
                }else{
                    Partner p = cc.GetPartner(derp);
                    request.getSession().setAttribute("part", p);
                    response.sendRedirect("EditPartner.jsp");}
            }
            else if(herp != null){
                request.getSession().setAttribute("id", herp);
                response.sendRedirect("DellFetch");
            }
            else if(herpderp != null){
                request.getSession().setAttribute("id", herpderp);
                response.sendRedirect("FinanceFetch");
            }
            else{
                response.sendRedirect("index.jsp?msg=Incorrect username or password");
            }
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
