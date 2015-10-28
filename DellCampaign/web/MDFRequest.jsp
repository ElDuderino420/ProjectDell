<%-- 
    Document   : MDFRequest
    Created on : 27-Oct-2015, 14:47:51
    Author     : butwhole
--%>

<%@page import="java.time.LocalDateTime"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css"> 
 
         <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
         <script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>-->
        <link rel="stylesheet" href="maincss.css" type="text/css" media="screen"/>
        <title>MDF Reqeust</title>
    </head>
    <body>
        <h2 style="color: rgb(0,135,203); margin-bottom: 0;">Enterprise Field Marketing:</h2>

        <h4 style="color: rgb(0,135,203); margin-top: 0;">Marketing Development Fund (MDF) Request</h4>
        <form>
            <table>
                <tr>
                    <td>Submission date: <br><input name="SubmissionDate" type = "text" value="<%= LocalDateTime.now()%>"/></td>
                    <td>Contact name: <br><input name ="ContactName" type = "text"/></td>
                    <td>Company name: <br><input name ="CompanyName" type = "text"/></td>
                </tr>
                <tr>
                    <td>Company address (city,state and zip):<br><input name ="Address" type = "text"/> </td>
                    <td>Contact email: <br><input name ="ContactEmail" type = "text"/></td>
                    <td>Contact Phone: <br><input name ="ContactPhone" type = "text"/></td>
                </tr>
            </table>
            <div style="border-bottom: 1px solid black"></div>

            <p>To best support your marketing needs, Dell recommends a 6+ week lead time (from the actual start date of the
                activity) to allow sufficient time for campaign development and promotion. The MDF request form allows you to fully
                detail your proposal for your marketing manager’s review. 
            </p>
            <p style="font-weight: bold">Please note, each field within the form must be completed for your request to be reviewed and/or approved.
                Any submissions containing incomplete forms will be returned. </p>
            <div style="border-bottom: 1px solid black"></div>
            <h4>Program Overview</h4>
            <table>
                <tr>
                    <td>Program Date: <br><input name ="ProgramDate" type = "text"/></td>
                    <td>Start time: <br><input name ="StartTime" type = "text"/></td>
                    <td>End time: <br><input name ="EndTime" type = "text"/></td>
                </tr>
                <tr>
                    <td>Estimated # of attendees: <br><input name ="NOAttendees" type = "text"/></td>
                    <td>Venue name: <br><input name ="VenueName" type = "text"/></td>
                    <td>Venue address(city,state and zip): <br><input name ="VenueAddress type = "text"/></td>
                </tr>
            </table>
            <div style="border-bottom: 1px solid black"></div>
            <h4>Type of Lead Generating Program</h4>
            <table>
                <tr>
                    <td><input name = ftfevent type = "checkbox" >Face-to-Face Event</td>
                    <td><input name = tradeshows type = "checkbox"> Tradeshows</td>
                    <td><input name = mtcamp type = "checkbox"> Multi-Touch Campaign</td>
                </tr>
                <tr>
                    <td><input name = dooropen type = "checkbox"> Door Opener Campaign</td>
                    <td><input name = 3rdparty type = "checkbox"> Third Party Campaign</td>
                </tr>
                <tr>
                    <td><input name = directmail type = "checkbox"> Direct Mail</td>
                    <td><input name = blitzcamp type = "checkbox"> Blitz Campaign (appt-setting or opportunity blitz)</td>
                </tr>
            </table>
            <p>Program description and/or agenda:</p><br>
            <input name =desc type="text" >
            <div style="border-bottom: 1px solid black"></div>
            <h4>Dell enterprise products to be discussed</h4>
            <table>
                <tr>
                    <td>Storage</td>
                    <td>Server</td>
                    <td>Networking</td>
                    <td>Solutions</td>
                </tr>
                <tr>
                    <td><input name = SC4000 type = "checkbox" >Dell Storage SC4000 Series</td>
                    <td><input name = poweredgeservers type = "checkbox"> The Latest Generation of Del PowerEdge Servers</td>
                    <td><input name = SDN type = "checkbox"> Software-Defined Networking (SDN): </td>
                    <td><input name = cloud type = "checkbox"> Cloud Client-Computing</td>
                </tr>
                <tr>
                    <td><input name = PS4210 type = "checkbox" >Dell Storage PS4210 Series</td>
                    <td><input name = winserver type = "checkbox"> Windows Server 2003 Migration</td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Data Center Networking</td>
                    <td><input name = infrahardware type = "checkbox"> Converged Infrastructure Hardware</td>
                </tr>
                <tr>
                    <td><input name = storagesolutions type = "checkbox" >Dell Storage Solutions</td>
                    <td><input name = x86server type = "checkbox"> x86 Server Transition</td>
                    <td><input name = usercentric type = "checkbox"> User-Centric Networking</td>
                    <td><input name = bladedatacenter type = "checkbox"> Dell Converged Blade Data Center</td>
                </tr>
                <tr>
                    <td><input name = pricedisk type = "checkbox" >Flash at the Price of Disk</td>
                    <td><input name = VRTX type = "checkbox"> PowerEdge VRTX</td>
                    <td></td>
                    <td><input name = optimizedenterprise type = "checkbox"> Optimized Enterprise(Future-Ready IT) </td>
                </tr>
                <tr>
                    <td><input name = fluidcache type = "checkbox" >Fluid Cache for SAN</td>
                    <td></td>
                    <td></td>
                    <td><input name = poweredgefx type = "checkbox"> PowerEdge FX Architecture</td>
                </tr>
                <tr>
                    <td><input name = dataprotec type = "checkbox" >Data Protection</td>
                    <td></td>
                    <td></td>
                    <td><input name = SDS type = "checkbox"> Software-Defined Storage(SDS)</td>
                </tr>
            </table>
            <p style="font-weight: bold">Is there a software component to your campaign?</p><br>
            <p>If so, please detail the specific software component(s) in the space below.</p>
            <input name =desc type="text" >
            <div style="border-bottom: 1px solid black"></div>
            <h4>Target Audience <span style="font-weight: normal">(Please check all the apply)</span></h4>
            <table>
                <tr>
                    <td><input name = SMB type='checkbox'>SMB (Small & Medium Business)</td>
                    <td><input name = LE type='checkbox'>LE (Large Enterprise, LEA & G500)</td>
                    <td><input name = PUB type='checkbox'>PUB (Public, Federal, Education and Healthcare)*</td>
                </tr>
            </table>
            <h6 style='font-weight: normal'>*Partners need to comply with PUB restrictions and limitations within any programs. See additional information within the terms and conditions(T&C) below.</h6>
            
            <div style="border-bottom: 1px solid black"></div>
            
            <h4>Additional Program Information</h4>
            
            Total projected cost of program: <input name='cost' type='text'><br>
            Total MDF requesting from Dell: <input name='requesting' type='text'><br>
            <p>Note: Dell will fund up to fifty percent (50%)* of the projected total cost, based on actual costs incurred for the activity.*See terms and conditions for rules and restrictions.</p><br>
            Preferred method of reimbursement (AMEX or check/EFT):<input name='methodofreimbursement' type='text'><br>
            Participating Technology Partner(s) (VMware, Microsoft, etc.):<input name='partner' type='text'><br>
            Total Technology Partner(s) MDF contribution: <input name='partnercontribution' type='text'><br>
            Estimated # of opportunities (deals registered through Dell Deal Registration): <input name='NoOpp' type='text'><br>
            Estimated revenue from program:<input name='estimatedrevenue' type='text'><br>

            

            
        </form>
    </body>
</html>
