
<%-- 
    Document   : UploadFile
    Created on : Nov 2, 2015, 10:02:11 AM
    Author     : Alex
--%>

<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="org.apache.commons.io.output.*" %>

<%
    File file;
    int maxFileSize = 5000000 * 1024;
    int maxMemSize = 5000000 * 1024;
    ServletContext context = pageContext.getServletContext();
    String filePath = application.getRealPath(request.getServletPath());
    String id = request.getSession().getAttribute("CampId").toString();
    if (id == null || id.equals("")) {
        response.sendRedirect("FetchCampaigns");
    } else {
        
        int derp = filePath.indexOf("/build/web/");
        String f = "/";
        
        if(derp==-1){
            f = "\\";
            derp = filePath.indexOf("\\build\\web\\");
        }
        filePath = filePath.substring(0, derp) + f+"Poe"+f + id + f;
        file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
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
                        boolean isInMemory = fi.isInMemory();
                        long sizeInBytes = fi.getSize();
                        // Write the file
                        if (fileName.lastIndexOf(f) >= 0) {
                            file = new File(filePath
                                    + fileName.substring(fileName.lastIndexOf(f)));
                        } else {
                            file = new File(filePath
                                    + fileName.substring(fileName.lastIndexOf(f) + 1));
                        }

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
            response.sendRedirect("FetchCampaigns");

        }
    }
%>