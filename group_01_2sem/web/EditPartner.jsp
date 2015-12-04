<%-- 
    Document   : AddInfo
    Created on : 25-Nov-2015, 00:15:51
    Author     : Whalecum
--%>
<%@page import="Domain.Partner"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="mdf.css">
        <title>Edit Profile</title>
    </head>
    <% Partner p = (Partner)request.getSession().getAttribute("part");
    %>
    
    
    </head>
    <body>
        <div class="upload">
        <h2>Edit Profile</h2>
        <form style="display: inline" action="navCon" method="post">
            <table style="margin-left: 10px; text-align: left;" >
                <tr><td>Partner ID: </td><td> <input id="inputtxt" class="input" name="PartnerID" type = "text" value="<%= p.getId() %>" required readonly/></td></tr>
           <tr><td>Partner Name: </td><td><input id="inputtxt" class="input" name="PartnerName" type="text" value="<%= p.getName() %>" required/></td></tr>
           <tr><td>Date Created: </td><td><input id="inputtxt" class="input" name="DateCreated" type = "text" value="<%= p.getDateCreated() %>" readonly required/></td></tr>
           <tr><td>Password: </td><td><input id="inputtxt" class="input" name="Password" type = "text" value="<%= p.getPassword() %>"  required/></td></tr>
           <tr><td>Email: </td><td><input id="inputtxt" class="input" name="Email" type="text" value="<%= p.getEmail() %>" required/></td></tr>
           <tr><td>Phone Number: </td><td><input id="inputtxt" class="input" name="Phone" type="text" value="<%= p.getPhone() %>" required/></td></tr>
           </table>
           <br><br>
           <button id="buttons" class="button" name="nav" type="Submit" value="EditPartner">Apply Partner</button>
        </form>
           <form style="display: inline" action="PartnerFetch" method="post">
           <button id="buttons" class="button" type="Submit">Back</button>
            <br><br>
        </form>
    </body>
</html>
