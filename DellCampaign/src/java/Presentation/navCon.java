/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

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
            request.getSession().setAttribute("CampId", request.getParameter("CampId"));
            //request.getSession().setAttribute("button", request.getParameter("nav"));
            String derp = request.getParameter("nav").toString();
            
            if(derp.equals("NC")){
                response.sendRedirect("MDFRequest");
            }
            if(derp.equals("AC")){
                response.sendRedirect("CampApproval");
            }
            if(derp.equals("RC")){
                response.sendRedirect("CampApproval");
            }
            if(derp.equals("UP")){
                response.sendRedirect("CampApproval");
            }
            if(derp.equals("AP")){
                response.sendRedirect("POEApproval");
            }
            if(derp.equals("RP")){
                response.sendRedirect("CampApproval");
            }
            if(derp.equals("CC")){
                response.sendRedirect("CampApproval");
            }
                    
        }
        catch (Exception ex) 
        {
            ex.printStackTrace();
            response.sendRedirect("index.jsp?msg=OMG WHY YOU SUCK?!?!"+ex.getMessage());
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