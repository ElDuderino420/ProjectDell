<%-- 
    Document   : nerdPOE
    Created on : 19 Nov 2015, 11:34:00 AM
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
        <link rel="stylesheet" type="text/css" href="coolpoe.css">
        <title>NERD POE!!!</title>
    </head>
    <body>
        <% List<POEDetails> viewpoe = (List<POEDetails>) request.getSession().getAttribute("lust");
            String id = request.getSession().getAttribute("campIDDD").toString().toUpperCase();

        %>
        <h2>POE List for Campaign <%=id%></h2>
        <div>
        <ul>
            <% for (POEDetails s : viewpoe) {
                    request.getSession().setAttribute("filename", s.getDl());

                    String filepath = "Poe/" + id + "/" + s.getDl();

            %><li><a href="<c:url value="<%=filepath%>"/>"><%=s.getDl()%></a></li>

            <%}%>
        </ul>

        <form action="DellNavCon" method="POST">
            <button id="back" class="button" type="submit" value="DC" name="DNC">Back</button>
        </form>
        </div>
    </body>
</html>
