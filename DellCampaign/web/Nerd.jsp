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
        <link rel="stylesheet" type="text/css" href="mdf.css">
        <title>NERD MDF!!!</title>
    </head>
    <% CampaignDetails cd = (CampaignDetails)request.getSession().getAttribute("currentCD");
    %>
    <body>
        <h2 style="color: rgb(0,135,203); margin-bottom: 0;">Enterprise Field Marketing:</h2>

        <h4 style="color: rgb(0,135,203); margin-top: 0;">Marketing Development Fund (MDF) Request</h4>
        <h6>*Required Field</h6>
        <form action='DellNavCon'>
            <table>
                <tr>
                    <td id="inputtxt">Submission date*<span id="smallstuff">(YYYY-MM-DD)</span>: <br><input class="input" name="SubmissionDate" placeholder="YYYY-MM-DD" type = "text" value="<%= LocalDateTime.now().toString().substring(0, 10)%>" readonly required/></td>
                    <td id="inputtxt">Contact name*: <br><input class="input" name ="ContactName" type = "text" value="<%= cd.getContactName()%>" required/></td>
                    <td id="inputtxt">Company name*: <br><input class="input" name ="CompanyName" type = "text" value="<%= cd.getCompanyName()%>" required/></td>
                </tr>
                <tr>
                    <td id="inputtxt">Company address*<span id="smallstuff">(city,state and zip)</span>:<br><input class="input" name ="Address" placeholder="city,state and zip" type = "text" value="<%= cd.getCompanyAddress()%>" required/> </td>
                    <td id="inputtxt">Contact email*: <br><input class="input" name ="ContactEmail" type = "text" value="<%= cd.getContactEmail()%>" required/></td>
                    <td id="inputtxt">Contact Phone*: <br><input class="input" name ="ContactPhone" type = "text" value="<%= cd.getContactPhone()%>" required/></td>
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
            <div style="border-bottom: 1px solid black"></div><br>
            <h4>Program Overview</h4>
            <table>
                <tr>
                    <td id="inputtxt">Program Date*<span id="smallstuff">(YYYY-MM-DD)</span>: <br><input class="input" name ="ProgramDate" placeholder="YYYY-MM-DD" type = "text" value="<%= cd.getProgramDate()%>" required/></td>
                    <td id="inputtxt">Start time*<span id="smallstuff">(HH:MM:SS)</span>: <br><input class="input" name ="StartTime" placeholder="HH:MM:SS" type = "text" value="<%= cd.getStartTime()%>" required/></td>
                    <td id="inputtxt">End time*<span id="smallstuff">(HH:MM:SS)</span>: <br><input class="input" name ="EndTime" placeholder="HH:MM:SS" type = "text" value="<%= cd.getEndTime()%>" required/></td>
                </tr>
                <tr>
                    <td id="inputtxt">Estimated # of attendees*: <br><input class="input" name ="NOAttendees" type = "text" value="<%= cd.getEstimatedAttendees()%>" required/></td>
                    <td id="inputtxt">Venue name*: <br><input class="input" name ="VenueName" type = "text" value="<%= cd.getVenueName()%>" required/></td>
                    <td id="inputtxt">Venue address*<span id="smallstuff">(city,state and zip)</span>: <br><input class="input" name ="VenueAddress" placeholder="city,state and zip" type = "text" value="<%= cd.getVenueAddress()%>" required/></td>
                </tr>
            </table>
            <br>
            <div style="border-bottom: 1px solid black"></div><br>
            <h4>Type of Lead Generating Program</h4>

            <table>
                <tr>
                    <td id="inputtxt"><input class="kkk" name = ftfevent type = "checkbox" <%= cd.getChecked(cd.isFaceToFace())%>/>Face-to-Face Event</td>
                    <td id="inputtxt"><input class="kkk" name = tradeshows type = "checkbox" <%= cd.getChecked(cd.isTradeShows())%>/>Tradeshows</td>
                    <td id="inputtxt"><input class="kkk" name = mtcamp type = "checkbox" <%= cd.getChecked(cd.isMultiTouch())%>/>Multi-Touch Campaign</td>
                </tr>
                <tr>
                    <td id="inputtxt"><input class="kkk" name = dooropen type = "checkbox" <%= cd.getChecked(cd.isDoorOpener())%>/>Door Opener Campaign</td>
                    <td id="inputtxt"><input class="kkk" name = 3rdparty type = "checkbox" <%= cd.getChecked(cd.isThirdParty())%>/>Third Party Campaign</td>
                </tr>
                <tr>
                    <td id="inputtxt"><input class="kkk" name = directmail type = "checkbox" <%= cd.getChecked(cd.isDirectMail())%>/>Direct Mail</td>
                    <td id="inputtxt"><input class="kkk" name = blitzcamp type = "checkbox" <%= cd.getChecked(cd.isBlitz())%>/>Blitz Campaign (appt-setting or opportunity blitz)</td>
                </tr>
            </table>



            <p id="inputtxt">Program description and/or agenda*:</p>
            <textarea class="binput" name ="desc" required><%= cd.getProgramDescription()%></textarea>
            <br>
            <br>
            <div style="border-bottom: 1px solid black"></div><br>
            <h4>Dell enterprise products to be discussed</h4>
            <table>
                <tr>
                    <td id="inputtxt">Storage</td>
                    <td id="inputtxt">Server</td>
                    <td id="inputtxt">Networking</td>
                    <td id="inputtxt">Solutions</td>
                </tr>
                <tr>
                    <td id="inputtxt"><input class="kkk" name = SC4000 type = "checkbox" <%= cd.getChecked(cd.isSc4000())%>/>Dell Storage SC4000 Series</td>
                    <td id="inputtxt"><input class="kkk" name = poweredgeservers type = "checkbox" <%= cd.getChecked(cd.isPowerEdgeServers())%>/> The Latest Generation of Del PowerEdge Servers</td>
                    <td id="inputtxt"><input class="kkk" name = SDN type = "checkbox" <%= cd.getChecked(cd.isSdn())%>/> Software-Defined Networking (SDN): Data Center Networkin </td>
                    <td id="inputtxt"><input class="kkk" name = cloud type = "checkbox" <%= cd.getChecked(cd.isCloudClientComputing())%>/> Cloud Client-Computing</td>
                </tr>
                <tr>
                    <td id="inputtxt"><input class="kkk" name = PS4210 type = "checkbox" <%= cd.getChecked(cd.isPs4210())%> />Dell Storage PS4210 Series</td>
                    <td id="inputtxt"><input class="kkk" name = winserver type = "checkbox" <%= cd.getChecked(cd.isWindowsServer())%>/> Windows Server 2003 Migration</td>
                    <td id="inputtxt"><input class="kkk" name = usercentric type = "checkbox" <%= cd.getChecked(cd.isUserCentric())%>/> User-Centric Networking</td>
                    <td id="inputtxt"><input class="kkk" name = infrahardware type = "checkbox" <%= cd.getChecked(cd.isInfrastructureHardware())%>/> Converged Infrastructure Hardware</td>
                </tr>
                <tr>
                    <td id="inputtxt"><input class="kkk" name = storagesolutions type = "checkbox" <%= cd.getChecked(cd.isDellStorageSol())%>/>Dell Storage Solutions</td>
                    <td id="inputtxt"><input class="kkk" name = x86server type = "checkbox" <%= cd.getChecked(cd.isX86Server())%>/> x86 Server Transition</td>
                    <td></td>
                    <td id="inputtxt"><input class="kkk" name = bladedatacenter type = "checkbox" <%= cd.getChecked(cd.isBladeDataCenter())%>/> Dell Converged Blade Data Center</td>
                </tr>
                <tr>
                    <td id="inputtxt"><input class="kkk" name = pricedisk type = "checkbox" <%= cd.getChecked(cd.isFlashPriceDisk())%>/>Flash at the Price of Disk</td>
                    <td id="inputtxt"><input class="kkk" name = VRTX type = "checkbox" <%= cd.getChecked(cd.isPowerEdgeVRTX())%>/> PowerEdge VRTX</td>
                    <td></td>
                    <td id="inputtxt"><input class="kkk" name = optimizedenterprise type = "checkbox" <%= cd.getChecked(cd.isOptimizedEnterprise())%>/> Optimized Enterprise(Future-Ready IT) </td>
                </tr>
                <tr>
                    <td id="inputtxt"><input class="kkk" name = fluidcache type = "checkbox" <%= cd.getChecked(cd.isFluidCache())%>/>Fluid Cache for SAN</td>
                    <td></td>
                    <td></td>
                    <td id="inputtxt"><input class="kkk" name = poweredgefx type = "checkbox" <%= cd.getChecked(cd.isPowerEdgeFX())%>/> PowerEdge FX Architecture</td>
                </tr>
                <tr>
                    <td id="inputtxt"><input class="kkk" name = dataprotec type = "checkbox" <%= cd.getChecked(cd.isDataProtection())%>/>Data Protection</td>
                    <td></td>
                    <td></td>
                    <td id="inputtxt"><input class="kkk" name = SDS type = "checkbox" <%= cd.getChecked(cd.isSds())%>/> Software-Defined Storage(SDS)</td>
                </tr>
            </table>
            <p style="font-weight: bold">Is there a software component to your campaign?</p>
            <p>If so, please detail the specific software component(s) in the space below.</p>
            <textarea class="binput" name =softwareComponent ><%= cd.getSoftwareComponent()%></textarea>
            <br>
            <br>
            <div style="border-bottom: 1px solid black"></div><br>
            <h4>Target Audience <span style="font-weight: normal">(Please check all the apply)</span></h4>
            <table>
                <tr>
                    <td id="inputtxt"><input class="kkk" name = SMB type='checkbox'<%= cd.getChecked(cd.isSmb())%>/>SMB (Small & Medium Business)</td>
                    <td id="inputtxt"><input class="kkk" name = LE type='checkbox'<%= cd.getChecked(cd.isLe())%>/>LE (Large Enterprise, LEA & G500)</td>
                    <td id="inputtxt"><input class="kkk" name = PUB type='checkbox'<%= cd.getChecked(cd.isPub())%>/>PUB (Public, Federal, Education and Healthcare)*</td>
                </tr>
            </table>
            <h6 style='font-weight: normal'>*Partners need to comply with PUB restrictions and limitations within any programs. See additional information within the terms and conditions(T&C) below.</h6>

            <div style="border-bottom: 1px solid black"></div><br>

            <h4>Additional Program Information</h4>

            <p id="inputtxt">Total projected cost of program*: <input class="input" name='cost' type='text' value="<%= cd.getTotalProjectedCost()%>" required/></p>
            <p id="inputtxt">Total MDF requesting from Dell*: <input class="input" name='requesting' type='text' value="<%= cd.getMdfRequest()%>" required/></p>
            <p>Note: Dell will fund up to fifty percent (50%)** of the projected total cost, based on actual costs incurred for the activity.**See terms and conditions for rules and restrictions.</p>
            <p id="inputtxt">Preferred method of reimbursement* <span id="smallstuff">(AMEX or check/EFT)</span>:<input class="input" name='methodofreimbursement' placeholder="AMEX or check/EFT" type='text' value="<%= cd.getReimbursement()%>" required/></p>
            <p id="inputtxt">Participating Technology Partner(s)* <span id="smallstuff">(VMware, Microsoft, etc.)</span>:<input class="input" name='partner' placeholder="VMware, Microsoft, etc." type='text' value="<%= cd.getTechnologyPartners()%>" required/></p>
            <p id="inputtxt">Total Technology Partner(s) MDF contribution*: <input class="input" name='partnercontribution' type='text' value="<%= cd.getTotalMDFContribution()%>" required/></p>
            <p id="inputtxt">Estimated # of opportunities (deals registered through Dell Deal Registration)*: <input class="input" name='NoOpp' type='text' value="<%= cd.getEstimatedOpportunities()%>" required/></p>
            <p id="inputtxt">Estimated revenue from program*:<input class="input" name='estimatedrevenue' type='text' value="<%= cd.getEstimatedRevenue()%>" required/></p>

            
                      
            <button id="back" class="button" type='submit' name='DNC' value="DC" >Back</button>
        </form>
    </body>
</html>
