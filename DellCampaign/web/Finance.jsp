<%-- 
    Document   : Finance
    Created on : 19 Nov 2015, 1:49:30 PM
    Author     : David
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="Domain.Campaign"%>
<%@page import="Domain.Partner"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% List<Campaign> CampData = (List<Campaign>) session.getAttribute("allCamp");%>

        <div id="contentarea">
            <h2>Completed Campaigns</h2>
            <table cellspacing="0">
                <th>Campaign ID</th>
                <th>Partner ID</th>
                <th>Dell ID</th>
                <th>Invoice</th>
                <th>Last Changed</th>
                <th>Comments</th>
                    <%for (Campaign c : CampData) {
                            String fags = "Poe/" + c.getId() + "/invoice.pdf";
                            out.print("<tr>"
                                    + "<td>" + c.getId() + "</td>"
                                    + "<td>" + c.getPid() + "</td>"
                                    + "<td>" + c.getDid() + "</td>"
                                    + "<td>" + c.getDateChanged() + "</td>"
                                    + "<td><pre>" + c.getComment() + "</pre></td>");%>

                <td>  <a href="<c:url value="<%= fags%>"/>">Download Invoice</a> </td>

                </tr><%

                    }
                %>

            </table>

        </div>
        <br>
        <a href ="index.jsp">Log Out</a>
    </body>
</html>
