<%-- 
    Document   : download
    Created on : 12 Nov 2015, 1:48:44 PM
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%    
  String filename = request.getParameter("filename");
  String filepath = request.getParameter("filepath");

  response.setContentType("APPLICATION/OCTET-STREAM");   
  response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   
  
  java.io.FileInputStream fileInputStream=new java.io.FileInputStream(filepath + filename);  
            
  int i;   
  while ((i=fileInputStream.read()) != -1) {  
    out.write(i);   
  }   
  fileInputStream.close();   
  response.sendRedirect("PartnerViewPOE.jsp");
%>   