<%-- 
    Document   : PartnerViewPOE
    Created on : 12-Nov-2015, 12:24:20
    Author     : Whalecum
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="Domain.POEDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% List<POEDetails> viewpoe = (List<POEDetails>) request.getSession().getAttribute("lust");
            ServletContext context = pageContext.getServletContext();
            String filePath = application.getRealPath(request.getServletPath());
            String id = request.getSession().getAttribute("CampId").toString();
            if (id == null || id.equals("")) {
                response.sendRedirect("PartnerFetch");
            } else {

                int derp = filePath.indexOf("/build/web/");
                String f = "/";

                if (derp == -1) {
                    f = "\\";
                    derp = filePath.indexOf("\\build\\web\\");
                }
                filePath = filePath.substring(0, derp) + f + "Poe" + f + id + f;
            }
            
            request.getSession().setAttribute("filepath",filePath );
            
        %>    
        
        <% for (POEDetails s : viewpoe) {
            request.getSession().setAttribute("filename",s.getDl() );
            
            %><p><%=s.getDl()%></p><br>
            
        <%}%>
        <form>
                                <a href="<c:url value="web/Poe/c1/New Text Document (3).txt"/>">link</a>

        </form>

        
        
    </body>
</html>
