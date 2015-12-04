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
        <link rel="stylesheet" type="text/css" href="mdf.css">
        <title>Create Partner</title>
    </head>
    <body>
        <div class="upload">
            <h2>Create Partner</h2>

                <form style="display: inline" action="ApplyPartner" method="post">

                            <table style="margin-left: 10px; text-align: left;">
                                <tr><td>Partner ID:  </td><td> <input id="inputtxt" class="input" name="PartnerID" type = "text" value="<%=request.getSession().getAttribute("PartId").toString()%>" readonly required/></td></tr>
                                <tr><td>Partner Name: </td><td><input id="inputtxt" class="input" name="PartnerName" type="text" required/></td></tr>
                                <tr><td>Date Created: </td><td><input id="inputtxt"  class="input" name="DateCreated" type = "text" value="<%= LocalDateTime.now().toString().substring(0, 10)%>" readonly required/></td></tr>
                                <tr><td>Password:     </td><td><input id="inputtxt" class="input" name="Password" type="text" required/></td></tr>
                            </table>

                    <button id="buttons" class="button" name="CreatePartner" type="Submit" value="Create">Create Partner</button>
                </form>
                                <form style="display: inline" action="DellFetch">
            <button id="buttons" class="button" name="CreatePartner" type="submit" value="Back">Back</button>
                                </form>

    <br><br>
</div>
</body>
</html>
