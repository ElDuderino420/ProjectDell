<%-- 
    Document   : Campaign
    Created on : 27-Oct-2015, 12:53:05
    Author     : butwhole
--%>

<%@page import="java.util.List"%>
<%@page import="Domain.Campaign"%>
<%@page import="Domain.Partner"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        

    </head>
    <body>
        <h1>DELL Campaigns</h1>
        <% List<Campaign> data = (List<Campaign>) session.getAttribute("allCamp");

        %>
        <a href="MDFRequest.jsp">New Campaign</a>
        <table>
            <th>Campaign ID</th>
            <th>Partner ID</th>
            <th>Dell ID</th>
            <th>Campaign approval</th>
            <th>POE status</th>
            <th>Last Changed</th>
            <th>Comments</th>
                <%                    for (Campaign c : data) {
                        out.print("<tr>"
                                + "<td>" + c.getId() + "</td>"
                                + "<td>" + c.getPid() + "</td>"
                                + "<td>" + c.getDid() + "</td>"
                                + "<td>" + c.getCampApproved() + "</td>"
                                + "<td>" + c.getPoeApproved() + "</td>"
                                + "<td>" + c.getDateChanged() + "</td>"
                                + "<td>" + c.getComment() + "</td>"
                                + "</tr>");
                    }
                %>

        </table>

    </body>
</html>
