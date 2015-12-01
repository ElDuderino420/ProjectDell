<%-- 
    Document   : derp
    Created on : 27-Oct-2015, 10:28:40
    Author     : butwhole
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<% request.getSession().setAttribute("realPath", application.getRealPath(request.getServletPath()));
    String msg = "";
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="maincss.css">

        <title>Dell Industries</title>
    </head>
    <body>
        <img id="pic" src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Dell-Logo.svg/2000px-Dell-Logo.svg.png"/><br><br><br><br><br><br><br><br><br>
        <form action="Main" id="login" method="POST">
            <%
            if(request.getSession().getAttribute("errUP") != null){
                msg = request.getSession().getAttribute("errUP").toString();
        %><div id="warning"><%=msg%></div>
        <%}%>
            
  
            <input class="input" type="text" name="lid" placeholder="Username"/>
            <input class="input" type="password" name="pass" placeholder="Password"/><br><br>
            <button id="loginb" class="button" type="submit">Login</button><br>
            
        </form>
    </body>
</html>
