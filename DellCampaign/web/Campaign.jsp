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
        <link rel="stylesheet" href="maincss.css" type="text/css" media="screen"/>


    </head>
    <body>
        <h1>DELL Campaigns</h1>
        <% List<Campaign> data = (List<Campaign>) session.getAttribute("allCamp");

        %>
        <form action="navCon">
            Campaign id: <input name ="CampId" type = "text"/> <br>
            <div id="leftmenu">
                <button type="Submit" value="NC" name="nav">New Campaign</button>
                <button type="Submit" value="AC" name="nav">Approve Campaign</button>
                <button type="Submit" value="RC" name="nav">Reject Campaign</button>
                <button type="Submit" value="UP" name="nav">Upload POE</button>
                <button type="Submit" value="AP" name="nav">Approve POE</button>
                <button type="Submit" value="RP" name="nav">Reject POE</button>
                <button type="Submit" value="CC" name="nav">Change Comment</button>
                <div id="comment" >Comment: <textarea name ="Comment" type = "text"></textarea></div>
            </div>

        </form>
        <div id="contentarea">
            <table cellspacing="0">
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
        </div>

    </body>
</html>
