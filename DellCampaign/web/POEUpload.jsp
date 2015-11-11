<%-- 
    Document   : POEUpload
    Created on : Nov 2, 2015, 10:30:16 AM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>File Uploading Form</title>
    </head>
    <body>
        <h3>File Upload:</h3>
        Select a file to upload: <br />
        
        
        <form role="form" action="UploadFile.jsp" method="post" enctype="multipart/form-data">
            
    <div class="btn btn-success btn-file">
    <i class="fa fa-cloud-upload"></i>
             Browse
    <input type="file" name="file" />
    </div>
            
    <button type="submit" value="submit" name='submit'>submit</button>`
    </form>
    </body>
</html>
