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
            
            if(request.getSession().getAttribute("errDEL") != null){
            request.getSession().removeAttribute("errDEL");
            }
            
            if (request.getParameter("PC") == null) {
                sel = request.getParameter("sel");
            } else {
                pc = request.getParameter("PC");
            }
               
            if(!pc.equals("")){
                if(pc.equals("D")){
                    if(cc.FetchCampaigns("truncate", selected).isEmpty()){
                    String path = request.getSession().getAttribute("filepath").toString();
                    cc.deletePart(selected,path);
                    request.getSession().setAttribute("Partners", cc.FetchAllPartners());
                    response.sendRedirect("ViewPartners.jsp");
                    }
                    else{
                        request.getSession().setAttribute("errDEL", "This Partner has ongoing campaigns and cannot be deleted at this time.");
                        response.sendRedirect("ViewPartners.jsp");
                    }
                }
                if(pc.equals("B")){
                    response.sendRedirect("DellFetch");
                }
            }
            
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