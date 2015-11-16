<%-- 
    Document   : MDFRequest
    Created on : 27-Oct-2015, 14:47:51
    Author     : butwhole
--%>

<%@page import="java.time.LocalDateTime"%>
<%@page import="Domain.CampaignDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- <link rel="stylesheet" href="maincss.css" type="text/css" media="screen"/> -->
        <title>MDF Request</title>
    </head>
    <% CampaignDetails cd = (CampaignDetails)request.getSession().getAttribute("currentCD");
    %>
    <body>
        <h2 style="color: rgb(0,135,203); margin-bottom: 0;">Enterprise Field Marketing:</h2>

        <h4 style="color: rgb(0,135,203); margin-top: 0;">Marketing Development Fund (MDF) Request</h4>
        <h6>*Required Field</h6>
        <form action='CampaignApproval'>
            <table>
                <tr>
                    <td>Submission date*(YYYY-MM-DD): <br><input name="SubmissionDate" type = "text" value="<%= cd.getDateCreated()%>" readonly/></td>
                    <td>Contact name*: <br><input name ="ContactName" type = "text" value="<%= cd.getContactName()%>" readonly/></td>
                    <td>Company name*: <br><input name ="CompanyName" type = "text" value="<%= cd.getCompanyName()%>" readonly/></td>
                </tr>
                <tr>
                    <td>Company address (city,state and zip)*:<br><input name ="Address" type = "text" value="<%= cd.getCompanyAddress()%>" readonly/> </td>
                    <td>Contact email*: <br><input name ="ContactEmail" type = "text" value="<%= cd.getContactEmail()%>" readonly/></td>
                    <td>Contact Phone*: <br><input name ="ContactPhone" type = "text" value="<%= cd.getContactPhone()%>" readonly/></td>
                </tr>
            </table>
                    <br>
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
                    <td>Program Date(YYYY-MM-DD)*: <br><input name ="ProgramDate" type = "text" value="<%= cd.getProgramDate()%>" readonly/></td>
                    <td>Start time(HH:MM:SS)*: <br><input name ="StartTime" type = "text" value="<%= cd.getStartTime()%>" readonly/></td>
                    <td>End time(HH:MM:SS)*: <br><input name ="EndTime" type = "text" value="<%= cd.getEndTime()%>" readonly/></td>
                </tr>
                <tr>
                    <td>Estimated # of attendees*: <br><input name ="NOAttendees" type = "text" value="<%= cd.getEstimatedAttendees()%>" readonly/></td>
                    <td>Venue name*: <br><input name ="VenueName" type = "text" value="<%= cd.getVenueName()%>" readonly/></td>
                    <td>Venue address(city,state and zip)*: <br><input name ="VenueAddress" type = "text" value="<%= cd.getVenueAddress()%>" readonly/></td>
                </tr>
            </table>
            <br>
            <div style="border-bottom: 1px solid black"></div>
            <h4>Type of Lead Generating Program</h4>
            <table>
                <tr>
                    <td><input name = ftfevent type = "checkbox" <%= cd.getChecked(cd.isFaceToFace())%> disabled/>Face-to-Face Event</td>
                    <td><input name = tradeshows type = "checkbox" <%= cd.getChecked(cd.isTradeShows())%> disabled/> Tradeshows</td>
                    <td><input name = mtcamp type = "checkbox" <%= cd.getChecked(cd.isMultiTouch())%> disabled/> Multi-Touch Campaign</td>
                </tr>
                <tr>
                    <td><input name = dooropen type = "checkbox" <%= cd.getChecked(cd.isDoorOpener())%> disabled/> Door Opener Campaign</td>
                    <td><input name = 3rdparty type = "checkbox" <%= cd.getChecked(cd.isThirdParty())%> disabled/> Third Party Campaign</td>
                </tr>
                <tr>
                    <td><input name = directmail type = "checkbox" <%= cd.getChecked(cd.isDirectMail())%> disabled/> Direct Mail</td>
                    <td><input name = blitzcamp type = "checkbox" <%= cd.getChecked(cd.isBlitz())%> disabled/> Blitz Campaign (appt-setting or opportunity blitz)</td>
                </tr>
            </table>
            <p>Program description and/or agenda*:</p><br>
            <textarea name ="desc" readonly><%= cd.getProgramDescription()%></textarea>
            <br>
            <br>
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
                    <td><input name = SC4000 type = "checkbox" <%= cd.getChecked(cd.isSc4000())%> disabled/>Dell Storage SC4000 Series</td>
                    <td><input name = poweredgeservers type = "checkbox" <%= cd.getChecked(cd.isPowerEdgeServers())%> disabled/> The Latest Generation of Del PowerEdge Servers</td>
                    <td><input name = SDN type = "checkbox" <%= cd.getChecked(cd.isSdn())%> disabled/> Software-Defined Networking (SDN): Data Center Networkin </td>
                    <td><input name = cloud type = "checkbox" <%= cd.getChecked(cd.isCloudClientComputing())%> disabled/> Cloud Client-Computing</td>
                </tr>
                <tr>
                    <td><input name = PS4210 type = "checkbox" <%= cd.getChecked(cd.isPs4210())%> disabled/>Dell Storage PS4210 Series</td>
                    <td><input name = winserver type = "checkbox" <%= cd.getChecked(cd.isWindowsServer())%> disabled/> Windows Server 2003 Migration</td>
                    <td><input name = usercentric type = "checkbox" <%= cd.getChecked(cd.isUserCentric())%> disabled/> User-Centric Networking</td>
                    <td><input name = infrahardware type = "checkbox" <%= cd.getChecked(cd.isInfrastructureHardware())%> disabled/> Converged Infrastructure Hardware</td>
                </tr>
                <tr>
                    <td><input name = storagesolutions type = "checkbox" <%= cd.getChecked(cd.isDellStorageSol())%> disabled/>Dell Storage Solutions</td>
                    <td><input name = x86server type = "checkbox" <%= cd.getChecked(cd.isX86Server())%> disabled/> x86 Server Transition</td>
                    <td></td>
                    <td><input name = bladedatacenter type = "checkbox" <%= cd.getChecked(cd.isBladeDataCenter())%> disabled/> Dell Converged Blade Data Center</td>
                </tr>
                <tr>
                    <td><input name = pricedisk type = "checkbox" <%= cd.getChecked(cd.isFlashPriceDisk())%> disabled/>Flash at the Price of Disk</td>
                    <td><input name = VRTX type = "checkbox" <%= cd.getChecked(cd.isPowerEdgeVRTX())%> disabled/> PowerEdge VRTX</td>
                    <td></td>
                    <td><input name = optimizedenterprise type = "checkbox" <%= cd.getChecked(cd.isOptimizedEnterprise())%> disabled/> Optimized Enterprise(Future-Ready IT) </td>
                </tr>
                <tr>
                    <td><input name = fluidcache type = "checkbox" <%= cd.getChecked(cd.isFluidCache())%> disabled/>Fluid Cache for SAN</td>
                    <td></td>
                    <td></td>
                    <td><input name = poweredgefx type = "checkbox" <%= cd.getChecked(cd.isPowerEdgeFX())%> disabled/> PowerEdge FX Architecture</td>
                </tr>
                <tr>
                    <td><input name = dataprotec type = "checkbox" <%= cd.getChecked(cd.isDataProtection())%> disabled/>Data Protection</td>
                    <td></td>
                    <td></td>
                    <td><input name = SDS type = "checkbox" <%= cd.getChecked(cd.isSds())%> disabled/> Software-Defined Storage(SDS)</td>
                </tr>
            </table>
            <p style="font-weight: bold">Is there a software component to your campaign?</p>
            <p>If so, please detail the specific software component(s) in the space below.</p>
            <textarea name =softwareComponent readonly><%= cd.getSoftwareComponent() %></textarea>
            <br>
            <br>
            <div style="border-bottom: 1px solid black"></div>
            <h4>Target Audience <span style="font-weight: normal">(Please check all the apply)</span></h4>
            <table>
                <tr>
                    <td><input name = SMB type='checkbox'<%= cd.getChecked(cd.isSmb())%> disabled/>SMB (Small & Medium Business)</td>
                    <td><input name = LE type='checkbox'<%= cd.getChecked(cd.isLe())%> disabled/>LE (Large Enterprise, LEA & G500)</td>
                    <td><input name = PUB type='checkbox'<%= cd.getChecked(cd.isPub())%> disabled/>PUB (Public, Federal, Education and Healthcare)*</td>
                </tr>
            </table>
            <h6 style='font-weight: normal'>*Partners need to comply with PUB restrictions and limitations within any programs. See additional information within the terms and conditions(T&C) below.</h6>

            <div style="border-bottom: 1px solid black"></div>

            <h4>Additional Program Information</h4>

            <p>Total projected cost of program*: <input name='cost' type='text' value="<%= cd.getTotalProjectedCost()  %>" readonly/></p>
            <p>Total MDF requesting from Dell*: <input name='requesting' type='text' value="<%= cd.getMdfRequest() %>" readonly/></p>
            <p>Note: Dell will fund up to fifty percent (50%)** of the projected total cost, based on actual costs incurred for the activity.**See terms and conditions for rules and restrictions.</p>
            <p>Preferred method of reimbursement (AMEX or check/EFT)*:<input name='methodofreimbursement' type='text' value="<%= cd.getReimbursement() %>" readonly/></p>
            <p>Participating Technology Partner(s) (VMware, Microsoft, etc.)*:<input name='partner' type='text' value="<%= cd.getTechnologyPartners() %>" readonly/></p>
            <p>Total Technology Partner(s) MDF contribution*: <input name='partnercontribution' type='text' value="<%= cd.getTotalMDFContribution() %>" readonly/></p>
            <p>Estimated # of opportunities (deals registered through Dell Deal Registration)*: <input name='NoOpp' type='text' value="<%= cd.getEstimatedOpportunities() %>" readonly/></p>
            <p>Estimated revenue from program*:<input name='estimatedrevenue' type='text' value="<%= cd.getEstimatedRevenue() %>" readonly/></p>

            
            <br>
            <br>
            <h5>Comments</h5>
             <textarea name ="comment" ></textarea>
            <button type='submit' name='poe' value="Approve" >Approve</button>
            <button type='submit' name='poe' value="Reject" >Reject</button>
        </form>
    </body>
</html>
