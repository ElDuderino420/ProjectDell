/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationDell;

import Domain.CampaignController;
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
public class PartnerCon extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            CampaignController cc = new CampaignController();
            String selected = request.getSession().getAttribute("Selected").toString();
            String pc = "";
            String sel = "";
            // removes the error message when you click a button
            if(request.getSession().getAttribute("errDEL") != null){
            request.getSession().removeAttribute("errDEL");
            }
            // checks if select button is clicked or otherwise
            if (request.getParameter("PC") == null) {
                sel = request.getParameter("sel");
            } else {
                pc = request.getParameter("PC");
            }
            
            // if the button clicked is not a select button
            if(!pc.equals("")){
                // delete button
                if(pc.equals("D")){
                    // checks if there is any ongoing campaings for that partner
                    // if not the partner is deleted (all data from both server and database is deleted)
                    if(cc.fetchCampaigns("truncate", selected).isEmpty()){
                    String path = request.getSession().getAttribute("filepath").toString();
                    cc.deletePart(selected,path);
                    request.getSession().setAttribute("Partners", cc.fetchAllPartners());
                    response.sendRedirect("ViewPartners.jsp");
                    }
                    // if there is any ongoing campaigns, retuns back to view partner with an error message
                    else{
                        request.getSession().setAttribute("errDEL", "This Partner has ongoing campaigns and cannot be deleted at this time.");
                        response.sendRedirect("ViewPartners.jsp");
                    }
                }
                // back button
                if(pc.equals("B")){
                    response.sendRedirect("DellFetch");
                }
            }
            // sellect button
            else if (!sel.equals("")) {
                request.getSession().setAttribute("Selected", sel);
                response.sendRedirect("ViewPartners.jsp");
                    
            }
            else{
                response.sendRedirect("ViewPartners.jsp");
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