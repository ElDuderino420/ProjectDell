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
        <link rel="stylesheet" type="text/css" href="maincss.css">

    </head>
    <body>
        <div class="upload">
            <h3>File Upload:</h3>
            <p>Select a file to upload:</p>


            <form role="form" action="UploadFile.jsp" method="post" enctype="multipart/form-data">

                <div class="fileUpload btn btn-primary">
                    <input class="custom-file-input" type="file" name="file" />
                </div>
                <br><br>
                <button id="submit" class="button" type="submit" value="submit" name="submit">Submit</button>
                <br><br>
                
            </form>
            <form action="PartnerFetch" method="post" >
                <button id="submit" class="button" type="submit" value="back" name="submit">Back</button>
                <br><br>
            </form>
        </div>
    </body>
</html>
