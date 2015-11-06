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
        <% String msg = request.getParameter("msg");
            if (msg != null) {
        %>
        <h5 style="color: red"><%=msg%></h5>
        <%}%>
        <p><%=application.getRealPath(request.getServletPath()).toString() %></p>
        <p><%= context.getRealPath(request.getServletPath()) %></p>
        <a href="FetchCampaigns">Continue</a>
    </body>
</html>
