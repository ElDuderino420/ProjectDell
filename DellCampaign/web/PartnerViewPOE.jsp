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
        <link rel="stylesheet" type="text/css" href="coolpoe.css">
        <title>VIEW POE</title>
    </head>
    <body>
        <% List<POEDetails> viewpoe = (List<POEDetails>) request.getSession().getAttribute("lust");
           String id = request.getSession().getAttribute("CampId").toString().toUpperCase();
            
        %>  
        <h2>POE List for Campaign <%=id%></h2>
        <div>
        
        <ul>
        <% for (POEDetails s : viewpoe) {
            request.getSession().setAttribute("filename",s.getDl() );
            
            String filepath = "Poe/" + id + "/" + s.getDl();
            
            %><li><a href="<c:url value="<%=filepath%>"/>"><%=s.getDl()%></a></li>
            
        <%}%>
        </ul>
        <br>
        <form method="POST" action="PartnerFetch">
            <button class="button" type="submit">Back</button>
        </form>
        </div>
        
    </body>
</html>
