<%-- 
    Document   : ViewPartners
    Created on : 01-Dec-2015, 13:35:24
    Author     : butwhole
--%>
<%@page import="Domain.Partner"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="maincss.css">
        <title>All Partners</title>
    </head>
    <body>
        <% List<Partner> partData = (List<Partner>) session.getAttribute("Partners");
           String Selected = request.getSession().getAttribute("Selected").toString();
           String count = "class=\"alt\"";
        %>
        
        <form action="PartnerCon" method="POST">
            <div id="partner">
                <h2>Partners</h2>
                <table id="partner">
                    <th></th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Date Created</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                   
                        <%                    for (Partner c : partData) {
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
                        <td><%= c.getName() %></td>
                        <td><%= c.getDateCreated() %></td>
                        <td><%= c.getEmail() %></td>
                        <td><%= c.getPhone() %></td> 
                    </tr>
                    <%} else {%>
                    <tr <%=count%>>
                        <td><button name="sel" value="<%=c.getId()%>" type="submit">Select</button></td>
                        <td><%= c.getId()%></td>
                        <td><%= c.getName() %></td>
                        <td><%= c.getDateCreated() %></td>
                        <td><%= c.getEmail() %></td>
                        <td><%= c.getPhone() %></td> 
                    </tr>
                    <%}
                        }%>

                </table><br>

                <button id="details" class="button" type="submit" value="D" name="PC">Delete</button>
                <button id="details" class="button" type="submit" value="B" name="PC">Back</button>
            </div>

        </form>
    </body>
</html>
