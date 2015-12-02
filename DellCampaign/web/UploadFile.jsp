
<%-- 
    Document   : UploadFile
    Created on : Nov 2, 2015, 10:02:11 AM
    Author     : Alexsucksbigdick
--%>

<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="org.apache.commons.io.output.*" %>

<%
    File file;
    int maxFileSize = 5000 * 1024;
    int maxMemSize = 5000 * 1024;
    String filePath = application.getRealPath(request.getServletPath());
    String id = request.getSession().getAttribute("CampId").toString().toUpperCase();
    if (id == null || id.equals("")) {
        response.sendRedirect("PartnerFetch");
    } else {

        int n = filePath.indexOf("/web/");
        String f = "/";

        if (n == -1) {
            f = "\\";
            n = filePath.indexOf("\\web\\");
        }
        filePath = filePath.substring(0, n) + f + "web" + f + "Poe" + f + id + f;
        file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        else{
            file.delete();
        }

        // Verify the content type
        String contentType = request.getContentType();

        if ((contentType.indexOf("multipart/form-data") >= 0)) {

            DiskFileItemFactory factory = new DiskFileItemFactory();
            // maximum size that will be stored in memory
            factory.setSizeThreshold(maxMemSize);
            // Location to save data that is larger than maxMemSize.
            factory.setRepository(new File("C:\\temp\\"));

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);
            // maximum file size to be uploaded.
            upload.setSizeMax(maxFileSize);
            try {
                // Parse the request to get file items.
                List<FileItem> fileItems = upload.parseRequest(request);

                // Process the uploaded file items
                Iterator i = fileItems.iterator();

                while (i.hasNext()) {
                    FileItem fi = (FileItem) i.next();
                    if (!fi.isFormField()) {
                        // Get the uploaded file parameters
                        String fieldName = fi.getFieldName();
                        String fileName = fi.getName();
                        if(fileName.equalsIgnoreCase("Invoice.pdf")){
                           fileName = "invoice.pdf";
                           request.getSession().setAttribute("invoi", "true");
                        }
                        else{
                           request.getSession().setAttribute("invoi", "false"); 
                        }

                        // Write the file
                        if (fileName.lastIndexOf(f) >= 0) {
                            file = new File(filePath
                                    + fileName.substring(fileName.lastIndexOf(f)));
                        } else {
                            file = new File(filePath
                                    + fileName.substring(fileName.lastIndexOf(f) + 1));
                        }
                        request.getSession().setAttribute("POEname", file.getName());
                        fi.write(file);

                        request.setAttribute("Success", "Successfully Uploaded");
                        response.sendRedirect("UploadFile");

                    }
                }

            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else {
            request.setAttribute("Error", "Error!!");
            response.sendRedirect("PartnerFetch");

        }
    }
%>