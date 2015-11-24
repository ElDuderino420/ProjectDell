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
        <title>Deleted and Completed Campaigns</title>
    </head>
    <body>
        <%
            List<Campaign> DoneData = (List<Campaign>) session.getAttribute("doneCamp");
            List<Campaign> DeletedData = (List<Campaign>) session.getAttribute("deletedCamp");
            request.getSession().setAttribute("filepath", application.getRealPath(request.getServletPath()));
            String Selected = request.getSession().getAttribute("Selected").toString();
        %>
        
        <form action="DellNavCon" method="POST">
            <div id="contentarea">
                <h2>Completed Campaigns</h2>
                <table cellspacing="0">
                    <th>Campaign ID</th>
                    <th>Partner ID</th>
                    <th>Dell ID</th>
                    <th>Campaign approval</th>
                    <th>POE status</th>
                    <th>Last Changed</th>
                    <th>Comments</th>
                        <%                    for (Campaign c : DoneData) {
                                if (Selected.equals(c.getId())) {
                        %>
                    <tr bgcolor="red">
                        <%} else { %>
                    <tr>
                        <%}%>
                        <td><button name="sel" value="<%=c.getId()%>" type="submit">Select</button></td>
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
            </div>
            <button type="submit" value="nerd" name="DNC">Details</button>
            <button type="submit" value="viewpoe" name="DNC">View POE</button>

        </form>
        <form action="DellNavCon" method="POST">
            <div id="contentarea">
                <table cellspacing="0">
                    <th>Campaign ID</th>
                    <th>Partner ID</th>
                    <th>Dell ID</th>
                    <th>Campaign approval</th>
                    <th>POE status</th>
                    <th>Last Changed</th>
                    <th>Comments</th>
                         <%                    for (Campaign c : DeletedData) {
                                if (Selected.equals(c.getId())) {
                        %>
                    <tr bgcolor="red">
                        <%} else { %>
                    <tr>
                        <%}%>
                        <td><button name="sel" value="<%=c.getId()%>" type="submit">Select</button></td>
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
            </div>
            <button type="submit" value="nuke" name="DNC" >Permanent Delete</button> <br>

        </form>

        <form action="DellNavCon">
            <button type="submit" value="back" name="DNC" >Back</button>
        </form>
        <a href="index.jsp">Log Out</a>
    </body>
</html>
