<%-- 
    Document   : Partner
    Created on : 09-Nov-2015, 11:50:09
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
        <title>Partner Home</title>
    </head>
    <body>

        <%  List<Campaign> CampData = (List<Campaign>) session.getAttribute("allCamp");
            List<Campaign> doneCamp = (List<Campaign>) session.getAttribute("doneCamp");
            String Selected = request.getSession().getAttribute("Selected").toString();
            String count = "class=\"alt\"";
            String msg = "";
            
            if (request.getSession().getAttribute("errIN") != null) {
                msg = request.getSession().getAttribute("errIN").toString();
            }

        %>
        <form action="navCon">
            <img class="delllogo" src="https://upload.wikimedia.org/wikipedia/commons/4/48/Dell_Logo.svg"/>
            <h1>&nbsp;Partner Campaigns</h1><br><br><br><br><br><br><br>
            <%if (!msg.equals("")) {
            %><div style="float: top;" id="warning"><%=msg%></div>
            <%}%>
            <div id="partner">
                <br>
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
                            for (Campaign c : CampData) {
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
                        <td id="selectb"><button name="sel" value="<%=c.getId()%>" type="submit">SELECT</button></td>
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



                </table>
                <br>
            </div>
            <div class="buttons">
                <button id="b" class="button" name="nav" value="NC" type="submit">Create Campaign</button>
                <button id="b" class="button" name="nav" value="D" type="submit">Details</button>
                <button id="b" class="button" name="nav" value="UP" type="submit">Upload POE</button>
                <button id="b" class="button" name="nav" value="PD" type="submit">View POE</button>
                <button id="b" class="button" name="nav" value="Com" type="submit">Complete</button>
            </div>
            <br>

        </form>
        <div id="partner">
            <br>
            <table id="partner" cellspacing="0">
                <th>Campaign ID</th>
                <th>Partner ID</th>
                <th>Dell ID</th>
                <th>Campaign approval</th>
                <th>POE status</th>
                <th>Last Changed</th>
                <th>Comments</th>
                    <%                    
                            count = "class=\"alt\"";
                            for (Campaign c : doneCamp) {
                            if (count.equals("class=\"alt\"")) {
                                count = "";
                            } else {
                                count = "class=\"alt\"";
                            }
                    %>
                <tr <%=count%>>
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
            <br>
        </div>

        <table>
            <tr>
                <td>
                    <form action="LogOut">
                        <button class="button" type="submit">Log Out</button>
                    </form>
                </td>
                <td>
                    <form action="navCon">
                        <button class="button" type="submit" name="nav" value="EP">Edit Profile</button>
                    </form>
                </td>

            </tr>
        </table>
    </body>
</html>
