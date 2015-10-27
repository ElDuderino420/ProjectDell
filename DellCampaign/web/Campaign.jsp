<%-- 
    Document   : Campaign
    Created on : 27-Oct-2015, 12:53:05
    Author     : butwhole
--%>

<%@page import="java.util.List"%>
<%@page import="Domain.Campaign"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
        <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
        <script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
    </head>
    <body>
        <h1>DELL Campaigns</h1>
        <% List<Campaign> data = (List<Campaign>) session.getAttribute("allCamp");

        %>

        <div data-role="main" class="ui-content">
            <a href="#myPopup" data-rel="popup" class="ui-btn ui-btn-inline ui-corner-all">New Campaign</a>
            <div data-role="popup" id="myPopup" class="ui-content">
                <h3>Create New Campaign</h3>
                <form action="MDFRequest.jsp" method="POST">
                    Partner ID: <input name="PartnerID" type = "text"/> <br/>
                    Partner Password: <input name ="Password" type = "password"/> <br/> 
                    <button type="submit" >Continue</button>
                </form>
            </div>
        </div>
        <table>
            <th>Campaign ID</th>
            <th>Campaign name</th>
            <th>Partner ID</th>
            <th>Dell ID</th>
            <th>Campaign approval</th>
            <th>POE status</th>
            <th>Date Created</th>
            <th>Last Changed</th>
            <th>Comments</th>
                <%                    for (Campaign c : data) {
                        out.print("<tr>"
                                + "<td>" + c.getId() + "</td>"
                                + "<td>" + c.getName() + "</td>"
                                + "<td>" + c.getPid() + "</td>"
                                + "<td>" + c.getDid() + "</td>"
                                + "<td>" + c.isCampApproved() + "</td>"
                                + "<td>" + c.isPoeApproved() + "</td>"
                                + "<td>" + c.getDateCreated() + "</td>"
                                + "<td>" + c.getDateChanged() + "</td>"
                                + "<td>" + c.getComment() + "</td>"
                                + "</tr>");
                    }
                %>

        </table>

    </body>
</html>
