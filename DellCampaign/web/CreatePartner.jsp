<%-- 
    Document   : CreatePartner
    Created on : 24-Nov-2015, 23:12:27
    Author     : Whalecum
--%>
<%@page import="java.time.LocalDateTime"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create Partner</h1>
        <form action="ApplyPartner" method="post">
           Partner ID: <input name="PartnerID" type = "text" required/><br>
           Partner Name: <input name="PartnerName" type="text" required/><br>
           Date Created: <input name="DateCreated" type = "text" value="<%= LocalDateTime.now().toString().substring(0,10)%>" readonly required/><br>
           Password: <input name="Password" type="text" required/><br>

           
           <button name="CreatePartner" type="Submit" value="Create">Create Partner</button>
            
        </form>
        
    </body>
</html>
