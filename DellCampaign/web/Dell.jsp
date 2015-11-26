<%-- 
    Document   : Dell
    Created on : 09-Nov-2015, 11:11:20
    Author     : butwhole
--%>
<%@page import="java.util.List"%>
<%@page import="Domain.Campaign"%>
<%@page import="Domain.Partner"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="maincss.css">

        <title>Dell Main Window</title>
    </head>
    <body>
        <img class="delllogo" src="https://upload.wikimedia.org/wikipedia/commons/4/48/Dell_Logo.svg"/>
        <h1>&nbsp;Dell Campaigns</h1><br><br><br><br><br><br><br>

        <form action="DellNavCon" method="POST">
            <div class="buttons">
                <button id="bb" class="button" type="submit" name="DNC" value="DC">Deleted and Completed Campaigns</button>
                <button id="bb" class="button" type="submit" name="DNC" value="CP">Create Partner</button>
            </div>
        </form>
        <% List<Campaign> CampData = (List<Campaign>) session.getAttribute("allCamp");
            List<Campaign> PoeData = (List<Campaign>) session.getAttribute("allPOE");
            String Selected = request.getSession().getAttribute("Selected").toString();
            String count = "class=\"alt\"";

        %>

        <form action="DellNavCon" method="POST">
            <div id="partner">
                <h2>Campaign Approval Queue</h2>
                <table id="partner" cellspacing="0">
                    <th></th>
                    <th>Campaign ID</th>
                    <th>Partner ID</th>
                    <th>Dell ID</th>
                    <th>Campaign approval</th>
                    <th>POE status</th>
                    <th>Last Changed</th>
                    <th>Comments</th>
                        <%                    for (Campaign c : CampData) {
                                if (count.equals("class=\"alt\"")) {
                                    count = "";
                                } else {
                                    count = "class=\"alt\"";
                                }
                                if (Selected.equals(c.getId())) {
                        %>
                    <tr <%=count%> id="selected">
                        <td><button name="sel" value="<%=c.getId()%>" type="submit">Select</button></td>
                        <td><%= c.getId()%></td>
                        <td><%= c.getPid()%></td>
                        <td><%= c.getDid()%></td>
                        <td><%= c.getCampApproved()%></td>
                        <td><%= c.getPoeApproved()%></td>
                        <td><%= c.getDateChanged()%></td>
                        <td><%= c.getComment()%></td>
                    </tr>
                    <%} else {%>
                    <tr <%=count%>>
                        <td><button name="sel" value="<%=c.getId()%>" type="submit">Select</button></td>
                        <td><%= c.getId()%></td>
                        <td><%= c.getPid()%></td>
                        <td><%= c.getDid()%></td>
                        <td><%= c.getCampApproved()%></td>
                        <td><%= c.getPoeApproved()%></td>
                        <td><%= c.getDateChanged()%></td>
                        <td><%= c.getComment()%></td>
                    </tr>
                    <%}
                        }%>

                </table><br>

                <button id="details" class="button" type="submit" value="CD" name="DNC">Details</button>
            </div>

        </form>
        <form action="DellNavCon" method="POST">
            <div id="partner">
                <h2>POE Approval Queue</h2>

                <table id="partner" cellspacing="0">
                    <th></th>
                    <th>Campaign ID</th>
                    <th>Partner ID</th>
                    <th>Dell ID</th>
                    <th>Campaign approval</th>
                    <th>POE status</th>
                    <th>Last Changed</th>
                    <th>Comments</th>
                        <%                    
                        count = "class=\"alt\"";
                        for (Campaign c : PoeData) {
                                if (count.equals("class=\"alt\"")) {
                                    count = "";
                                } else {
                                    count = "class=\"alt\"";
                                }
                                if (Selected.equals(c.getId())) {
                        %>
                    <tr <%=count%> id="selected">
                        <td id="selectb"><button name="sel" value="<%=c.getId()%>" type="submit">SELECT</button></td>
                        <td><%= c.getId()%></td>
                        <td><%= c.getPid()%></td>
                        <td><%= c.getDid()%></td>
                        <td><%= c.getCampApproved()%></td>
                        <td><%= c.getPoeApproved()%></td>
                        <td><%= c.getDateChanged()%></td>
                        <td><%= c.getComment()%></td>
                    </tr>
                    <%} else {%>
                    <tr <%=count%>>
                        <td><button name="sel" value="<%=c.getId()%>" type="submit">SELECT</button></td>
                        <td><%= c.getId()%></td>
                        <td><%= c.getPid()%></td>
                        <td><%= c.getDid()%></td>
                        <td><%= c.getCampApproved()%></td>
                        <td><%= c.getPoeApproved()%></td>
                        <td><%= c.getDateChanged()%></td>
                        <td><%= c.getComment()%></td>
                    </tr>
                    <%}
                        }%>

                </table><br>
                <button id="details" class="button" type="submit" value="PD" name="DNC" >Details</button> <br><br><br><br><br>
            </div>

            <a href="index.jsp">Log Out</a>
        </form>
    </body>
</html>
