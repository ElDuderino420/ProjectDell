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
        <title>Dell Main Window</title>
    </head>
    <body>
        <form action="DellNavCon" method="POST">
            
            <button type="submit" name="DNC" value="DC">Deleted and Completed Campaigns</button>
            <button type="submit" name="DNC" value="CP">Create Partner</button>
            
        </form>
        <% List<Campaign> CampData = (List<Campaign>) session.getAttribute("allCamp");
           List<Campaign> PoeData = (List<Campaign>) session.getAttribute("allPOE");
           String Selected = request.getSession().getAttribute("Selected").toString();
           
           
        %>
        
        <form action="DellNavCon" method="POST">
            <div id="contentarea">
                <h2>New Campaigns</h2>
                <table cellspacing="0">
                    <th></th>
                    <th>Campaign ID</th>
                    <th>Partner ID</th>
                    <th>Dell ID</th>
                    <th>Campaign approval</th>
                    <th>POE status</th>
                    <th>Last Changed</th>
                    <th>Comments</th>
                        <%                    for (Campaign c : CampData) {
                            if(Selected.equals(c.getId())){
                        %>
                    <tr bgcolor="red">
                        <td><button name="sel" value="<%=c.getId()%>" type="submit">Select</button></td>
                        <td><%= c.getId()%></td>
                        <td><%= c.getPid()%></td>
                        <td><%= c.getDid()%></td>
                        <td><%= c.getCampApproved()%></td>
                        <td><%= c.getPoeApproved()%></td>
                        <td><%= c.getDateChanged()%></td>
                        <td><%= c.getComment()%></td>
                    </tr>
                    <%} else{ %>
                    <tr>
                        <td><button name="sel" value="<%=c.getId()%>" type="submit">Select</button></td>
                        <td><%= c.getId()%></td>
                        <td><%= c.getPid()%></td>
                        <td><%= c.getDid()%></td>
                        <td><%= c.getCampApproved()%></td>
                        <td><%= c.getPoeApproved()%></td>
                        <td><%= c.getDateChanged()%></td>
                        <td><%= c.getComment()%></td>
                    </tr>
                    <%}}%>

                </table>
                    
                    
            </div>
            <button type="submit" value="CD" name="DNC">Details</button>
        </form>
        <form action="DellNavCon" method="POST">
            <div id="contentarea">
                <table cellspacing="0">
                    <th></th>
                    <th>Campaign ID</th>
                    <th>Partner ID</th>
                    <th>Dell ID</th>
                    <th>Campaign approval</th>
                    <th>POE status</th>
                    <th>Last Changed</th>
                    <th>Comments</th>
                        <%                    for (Campaign c : PoeData) {
                            if(Selected.equals(c.getId())){
                        %>
                    <tr bgcolor="red">
                        <td><button name="sel" value="<%=c.getId()%>" type="submit">Select</button></td>
                        <td><%= c.getId()%></td>
                        <td><%= c.getPid()%></td>
                        <td><%= c.getDid()%></td>
                        <td><%= c.getCampApproved()%></td>
                        <td><%= c.getPoeApproved()%></td>
                        <td><%= c.getDateChanged()%></td>
                        <td><%= c.getComment()%></td>
                    </tr>
                    <%} else{ %>
                    <tr>
                        <td><button name="sel" value="<%=c.getId()%>" type="submit">Select</button></td>
                        <td><%= c.getId()%></td>
                        <td><%= c.getPid()%></td>
                        <td><%= c.getDid()%></td>
                        <td><%= c.getCampApproved()%></td>
                        <td><%= c.getPoeApproved()%></td>
                        <td><%= c.getDateChanged()%></td>
                        <td><%= c.getComment()%></td>
                    </tr>
                    <%}}%>

                </table>
            </div>
            <button type="submit" value="PD" name="DNC" >Details</button> <br>
            <a href="index.jsp">Log Out</a>
        </form>
    </body>
</html>
