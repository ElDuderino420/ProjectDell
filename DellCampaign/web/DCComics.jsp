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
        <title>Deleted and Completed Campaigns</title>
    </head>
    <body>
        <%
            List<Campaign> DoneData = (List<Campaign>) session.getAttribute("doneCamp");
            List<Campaign> DeletedData = (List<Campaign>) session.getAttribute("deletedCamp");
            request.getSession().setAttribute("filepath", application.getRealPath(request.getServletPath()));
            String Selected = request.getSession().getAttribute("Selected").toString();
            String count = "class=\"alt\"";
        %>

        <form action="DellNavCon" method="POST">
            <div id="partner">
                <h2>Completed Campaigns</h2>
                <table id="partner">
                    <th></th>
                    <th>Campaign ID</th>
                    <th>Partner ID</th>
                    <th>Dell ID</th>
                    <th>Campaign approval</th>
                    <th>POE status</th>
                    <th>Last Changed</th>
                    <th>Comments</th>
                        <%                    for (Campaign c : DoneData) {
                                if (count.equals("class=\"alt\"")) {
                                    count = "";
                                } else {
                                    count = "class=\"alt\"";
                                }
                                if (Selected.equals(c.getId())) {
                        %>
                    <tr <%=count%> id="selected">
                        <td><button id="selectb" name="sel2" value="<%=c.getId()%>" type="submit">Select</button></td>
                        <%} else {%>
                    <tr <%=count%>>
                        <td><button name="sel2" value="<%=c.getId()%>" type="submit">Select</button></td>
                        <%}%>
                        <td><%= c.getId()%></td>
                        <td><%= c.getPid()%></td>
                        <td><%= c.getDid()%></td>
                        <td><%= c.getCampApproved()%></td>
                        <td><%= c.getPoeApproved()%></td>
                        <td><%= c.getDateChanged()%></td>
                        <td><%= c.getComment()%></td>
                    </tr>
                    <%}%>

                </table>
                    <br><button id="details" class="button" type="submit" value="nerd" name="DNC">Details</button>
            <button id="details" class="button" type="submit" value="viewpoe" name="DNC">View POE</button><br><br>
            </div>
            

        </form>
        <form action="DellNavCon" method="POST">
            <div id="partner">
                <h2>Deleted Campaigns</h2>
                <table id="partner">
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
                            for (Campaign c : DeletedData) {
                                if (count.equals("class=\"alt\"")) {
                                    count = "";
                                } else {
                                    count = "class=\"alt\"";
                                }
                                if (Selected.equals(c.getId())) {
                        %>
                    <tr <%=count%> id="selected">
                        <td><button id="selectb" name="sel2" value="<%=c.getId()%>" type="submit">Select</button></td>
                        <%} else {%>
                    <tr <%=count%>>
                        <td><button name="sel2" value="<%=c.getId()%>" type="submit">Select</button></td>
                        <%}%>
                        <td><%= c.getId()%></td>
                        <td><%= c.getPid()%></td>
                        <td><%= c.getDid()%></td>
                        <td><%= c.getCampApproved()%></td>
                        <td><%= c.getPoeApproved()%></td>
                        <td><%= c.getDateChanged()%></td>
                        <td><%= c.getComment()%></td>
                    </tr>
                    <%}%>

                </table>
                    <br><button id="bb" class="button" type="submit" value="nuke" name="DNC" >Permanent Delete</button> <br><br><br><br>
                    <button id="back" class="button" type="submit" value="back" name="DNC" >Back</button>
            </div><br><br>
            

        </form>

    </body>
</html>
