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
        <% List<Campaign> CampData = (List<Campaign>) session.getAttribute("allCamp");
            List<Campaign> PoeData = (List<Campaign>) session.getAttribute("allPOE");
        %>
        <form action="DellNavCon">
            <div id="contentarea">
                <h2>New Campaigns</h2>
                <table cellspacing="0">
                    <th>Campaign ID</th>
                    <th>Partner ID</th>
                    <th>Dell ID</th>
                    <th>Campaign approval</th>
                    <th>POE status</th>
                    <th>Last Changed</th>
                    <th>Comments</th>
                        <%                    for (Campaign c : CampData) {
                                out.print("<tr>"
                                        + "<td>" + c.getId() + "</td>"
                                        + "<td>" + c.getPid() + "</td>"
                                        + "<td>" + c.getDid() + "</td>"
                                        + "<td>" + c.getCampApproved() + "</td>"
                                        + "<td>" + c.getPoeApproved() + "</td>"
                                        + "<td>" + c.getDateChanged() + "</td>"
                                        + "<td><pre>" + c.getComment() + "</pre></td>"
                                        + "</tr>");
                            }
                        %>

                </table>
            </div>
            <input type="text" name="Cid" />
            <button type="submit" value="CD" name="DNC">Details</button>
        </form>
        <form action="DellNavCon">
            <div id="contentarea">
                <table cellspacing="0">
                    <th>Campaign ID</th>
                    <th>Partner ID</th>
                    <th>Dell ID</th>
                    <th>Campaign approval</th>
                    <th>POE status</th>
                    <th>Last Changed</th>
                    <th>Comments</th>
                        <%                    for (Campaign c : PoeData) {
                                out.print("<tr>"
                                        + "<td>" + c.getId() + "</td>"
                                        + "<td>" + c.getPid() + "</td>"
                                        + "<td>" + c.getDid() + "</td>"
                                        + "<td>" + c.getCampApproved() + "</td>"
                                        + "<td>" + c.getPoeApproved() + "</td>"
                                        + "<td>" + c.getDateChanged() + "</td>"
                                        + "<td><pre>" + c.getComment() + "</pre></td>"
                                        + "</tr>");
                            }
                        %>

                </table>
            </div>
            <input type="text" name="Cid2" />
            <button type="submit" value="PD" name="DNC" >Details</button>
        </form>
    </body>
</html>
