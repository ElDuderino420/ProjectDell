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
        <title>JSP Page</title>
    </head>
    <% Partner p = (Partner)request.getSession().getAttribute("part");
    %>
    
    <body>
        <h1>Edit Partner</h1>
        <form action="navCon" method="post">
           Partner ID: <input name="PartnerID" type = "text" value="<%= p.getId() %>" required readonly/><br>
           Partner Name: <input name="PartnerName" type="text" value="<%= p.getName() %>" required/><br>     
           Password: <input name="DateCreated" type = "text" value="<%= p.getPassword() %>"  required/><br>
           Email: <input name="Password" type="text" value="<%= p.getEmail() %>" required/><br>
           Phone Number: <input name="Password" type="text" value="<%= p.getPhone() %>" required/><br>

           <button name="EditPartner" type="Submit" value="EPartner">Apply Partner</button>
            
        </form>
    </body>
</html>
