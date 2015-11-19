<%-- 
    Document   : DellViewPOE
    Created on : 19 Nov 2015, 11:00:15 AM
    Author     : David
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
           String id = request.getSession().getAttribute("CID").toString().toUpperCase();
            
        %>    
        <ul>
        <% for (POEDetails s : viewpoe) {
            request.getSession().setAttribute("filename",s.getDl() );
            
            String filepath = "Poe/" + id + "/" + s.getDl();
            
            %><li><a href="<c:url value="<%=filepath%>"/>"><%=s.getDl()%></a></li>
            
        <%}%>
        </ul>
        
        <form action="POEApproval" method="POST">
            <h5>Comments</h5>
            <textarea name ="comment" ></textarea>
            <button type='submit' name='poe' value="Approve" >Approve</button>
            <button type='submit' name='poe' value="Reject" >Reject</button>
        </form>
        
        
    </body>
</html>
