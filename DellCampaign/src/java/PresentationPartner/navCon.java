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
public class navCon extends HttpServlet{

    
    
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try
        {
            // set 
            
            request.getSession().setAttribute("CampId", request.getParameter("Cid"));
            request.getSession().setAttribute("Comment", request.getParameter("Comment"));
            request.getSession().setAttribute("Path", request.getContextPath());
            String derp = request.getParameter("nav");
            CampaignController cc = new CampaignController();
            
            // click new campaign
            if(derp.equals("NC")){
                response.sendRedirect("MDFRequest.jsp");
            }
            if(derp.equals("D")){
                response.sendRedirect("PartnerDetails");
            }
            // click approve campaign
            /*
            if(derp.equals("")){
            cc.campApprove(request.getSession().getAttribute("CampId").toString(),
                           request.getSession().getAttribute("Comment").toString());
            cc.LastChange(request.getSession().getAttribute("CampId").toString());
            response.sendRedirect("FetchCampaigns");
            }
            
            // click Reject Campaign
            if(derp.equals("RC")){
            cc.campReject(request.getSession().getAttribute("CampId").toString(),
                          request.getSession().getAttribute("Comment").toString());
            cc.LastChange(request.getSession().getAttribute("CampId").toString());
            response.sendRedirect("FetchCampaigns");
            }
                    */
            
            // click Upload POE
            if(derp.equals("UP")){
                    
                    response.sendRedirect("POEUpload.jsp");
            }
            if(derp.equals("C")){
                cc.CompleteCamp("CampId");
                response.sendRedirect("Partner.jsp");
            }
            /*
            // click Approve POE
            if(derp.equals("AP")){
            cc.POEApprove(request.getSession().getAttribute("CampId").toString(),
                          request.getSession().getAttribute("Comment").toString());
            cc.LastChange(request.getSession().getAttribute("CampId").toString());
            response.sendRedirect("FetchCampaigns");
            }
            
            // click Reject POE
            if(derp.equals("RP")){
            cc.POEReject(request.getSession().getAttribute("CampId").toString(),
                         request.getSession().getAttribute("Comment").toString());
            cc.LastChange(request.getSession().getAttribute("CampId").toString());
            response.sendRedirect("FetchCampaigns");
            }
                    
            
            // click Change Comment
            if(derp.equals("CC")){
            cc.campChangeComment(request.getSession().getAttribute("CampId").toString(),
                                 request.getSession().getAttribute("Comment").toString());
            cc.LastChange(request.getSession().getAttribute("CampId").toString());
            response.sendRedirect("FetchCampaigns");
            }
                    */
                    
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