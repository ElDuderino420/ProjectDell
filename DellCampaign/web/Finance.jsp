<%-- 
    Document   : Finance
    Created on : 19 Nov 2015, 4:20:00 PM
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
        <link rel="stylesheet" type="text/css" href="maincss.css">

        <title>JSP Page</title>
    </head>
    <body>
        <% List<Campaign> CampData = (List<Campaign>) session.getAttribute("allCamp");
            String count = "class=\"alt\"";
        %>

        <div id="partner">
            <h2>Completed Campaigns</h2>
            <table id="partner" cellspacing="0">
                <th>Campaign ID</th>
                <th>Partner ID</th>
                <th>Dell ID</th>
                <th>Last Changed</th>
                <th>Comments</th>
                <th>Invoice</th>

                <%for (Campaign c : CampData) {
                        if (count.equals("class=\"alt\"")) {
                            count = "";
                        } else {
                            count = "class=\"alt\"";
                        }

                        String poe = "Poe/" + c.getId() + "/invoice.pdf";
                %>
                <tr <%=count%> >
                    <td><%= c.getId()%></td>
                    <td><%= c.getPid()%></td>
                    <td><%= c.getDid()%></td>
                    <td><%= c.getDateChanged()%></td>
                    <td><pre><%= c.getComment()%></pre></td>
                    <td>  <a href="<c:url value="<%= poe%>"/>">Download Invoice</a> </td>
                </tr>


                </tr><%

                    }
                %>

            </table>

        </div>
        <br><br><br><br><br>
        <a href ="index.jsp">Log Out</a>
    </body>
</html>
