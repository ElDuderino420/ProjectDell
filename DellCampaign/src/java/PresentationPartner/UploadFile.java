/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationPartner;

import Domain.CampaignController;
import Domain.POEDetails;
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
public class UploadFile extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            CampaignController cc = new CampaignController();
            String id = request.getSession().getAttribute("CampId").toString();
            String POEname = request.getSession().getAttribute("POEname").toString();
            boolean dupli = false;
            cc.LastChange(id);
            
            List<POEDetails> list = cc.ViewPOE(id);
            
            for (POEDetails poe : list) {
                if(poe.getDl().equals(POEname)){
                    dupli = true;
                }
            }

            String invoi = request.getSession().getAttribute("invoi").toString();
            
            if (invoi.equals("true")) {
                invoi = "Invoice has been uploaded";
            } else {
                invoi = "";
            }
            
            if (dupli == true) {
                cc.deletePOE(id, POEname);
            }
            cc.createPOE(id, POEname, invoi);
            response.sendRedirect("PartnerFetch");
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
