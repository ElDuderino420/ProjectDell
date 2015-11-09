<%-- 
    Document   : derp
    Created on : 27-Oct-2015, 10:28:40
    Author     : butwhole
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<% request.getSession().setAttribute("realPath", application.getRealPath(request.getServletPath())); 
ServletContext context = pageContext.getServletContext();
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dell Industries</title>
    </head>
    <body>
        <h1>DELL</h1>
        <form action="Main" method="POST">
        <input type="text" name="lid" />
        <input type="password" name="pass"/>
        <button type="submit">Login</button>
        </form>
    </body>
</html>
