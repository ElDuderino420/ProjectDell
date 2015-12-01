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
        <title>Edit Campaign</title>
    </head>
    <% CampaignDetails cd = (CampaignDetails) request.getSession().getAttribute("currentCD");
    %>
    <body>
        <h2>Enterprise Field Marketing:</h2>

        <h4>Marketing Development Fund (MDF) Request</h4>
        <h6>*Required Field</h6>
        <form action='ApplyCampaign' method="post">
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


            <h5>Following the completion of this form, please submit your full MDF request to your Enterprise Field
                Marketing Manager for consideration and review. You may expect a response within 48 - 72 hours,
                provided all necessary details have been supplied.</h5>

            <div style="border-bottom: 1px solid black"></div><br>

            <div class="scroll" style="overflow:scroll; height:500px;">
                <h4>Dell MDF Program Process, Terms and Conditions</h4>
                <p>Dell is pleased to provide this Field Marketing Program (“Program”) to Dell PartnerDirect Partners in the United States.
                    The purpose of this Program is to provide certain marketing development funds, as further described herein, (“Funds”)
                    to Dell PartnerDirect Partners for Partners’ promotion of Dell products and services and to generate marketing leads
                    for Dell products and services (each such promotional activity an “Activity”). Funds are provided on a first-come,
                    first-serve basis, and approval of Fund proposals is subject to the following criteria:</p>
                <ul>
                    <li>Partner must hold one or more active competencies within Enterprise (Storage, Server, and/or Networking) and
                        maintain a Preferred or Premier Partner status</li> 
                    <li>Submission of a clearly defined outline of the proposed marketing activity</li>
                    <li>Review of Partner’s frequency of previous promotional funding requests </li>
                    <li>Discussion with Partner’s designated field marketing manager of Partner’s customer end-user leads database prior
                        to the proposed marketing activity</li>
                    <li>Verification of Partner’s relationship with local System Engineer (“SE”), Solutions Specialist (“SS”) and/or a Channel
                        Account Manager (“CAM”)</li>
                    <li>Whether proposed marketing activity topic is appropriate to Partner’s location and region</li>
                    <li>Whether any overlap exists between the proposed marketing activity and another Partner’s approved marketing
                        activity in the same location and region</li>
                    <li>Successfulness of prior Partner funded marketing activities</li>
                    <li>Whether marketing activity budget request is reasonable to type of activity requested</li>
                    <li>Any other requirement as deemed appropriate by Dell</li>
                </ul>
                <p>It is in Dell’s sole discretion to determine which Activities will be funded. In order to receive Funds, Partner must
                    submit a complete and accurate Dell Marketing/Demand Generation Request form via email to the Partner’s
                    pre-designated marketing manager forty-five (45) days prior to the target date of the Activity. Partners can determine
                    who their appropriate field marketing contact is by contacting the Partner Resource Desk at certified_PRD@dell.
                    com), or by logging on to the Dell PartnerDirect Portal, going to the Demand Generation Center located under the
                    Marketing and Sales Tab, and under the Q&A section, clicking on the “Who is my Dedicated Field Marketing Manager?”
                    question. Partner will be notified via email within five to seven (5-7) business days of the submission date of Dell’s
                    acceptance or rejection of the proposal as well as, if the proposal is accepted, a Dell MDF Program Confirmation of
                    the Activity. All subsequent correspondence regarding this Activity must reference the MDF Approval Number found in
                    the Dell MDF Program Confirmation. Activity requirements outlined in the Dell MDF Program Confirmation, as well as
                    all requirements referenced herein must be met to qualify for the Funds. </p>
                <p>Dell will fund up to fifty percent (50%) of the projected costs, based on actual costs incurred for an Activity. Funding
                    will be proportionate to the number of Activity sponsors (i.e. - Dell and Partner: up to 50%; Dell, Channel Partner, and
                    Technology Partner: up to 33%). If a Dell approved Activity is cancelled or postponed, the Partner must notify Dell in
                    writing and every attempt must be made to provide cancellation notice at least fourteen (14) days prior to the Activity
                    date.</p>
                <p>Funds may be used for end user programs only. Examples of activities are:</p>
                <table>
                    <tr>
                        <td>
                            <ul>
                                <li>Face-to-face event </li>
                                <li>Tradeshow (local) </li>
                                <li>Blitz day </li>
                                <li>Third party program </li>
                                <li>Door opener</li>
                            </ul>
                        </td>
                        <td>
                            <ul>
                                <li>Direct mail</li>
                                <li>Webinar</li>
                                <li>Online advertising</li>
                                <li>Or as otherwise previously approved by Dell</li>
                                
                            </ul>
                            <br>
                        </td>
                    </tr>
                </table>
                <p>Funds are not applicable to the following:</p>
                <table>
                    <tr>
                        <td>
                            <ul>
                                <li>Sales Trainings</li>
                                <li>National sales meetings </li>
                                <li>Travel</li>
                            </ul>
                        </td>
                        <td>
                            <ul>
                                <li>Networking events/meet and greets</li>
                                <li>Demo equipment purchases</li>
                                <li>Or any other event that Dell deems not applicable</li>
                            </ul>
                        </td>
                    </tr>
                </table>
                <p>The terms and conditions set forth herein (“Agreement”) shall apply to the program.</p>
                <p>By click-accepting these terms, requesting funds, or otherwise participating in the program, you (“You/Your”) agree to
                    be bound by the terms set forth in this agreement.</p>
                <p><span style='font-weight: bold;'>Eligibility.</span> You agree that You will be a Dell PartnerDirect Partner in good standing throughout the duration of the
                    Agreement, as determined by Dell. To be eligible for funds, You will have obtained, and shall maintain, storage, server,
                    and/or networking competencies and hold a Preferred or Premier Partner status during the period of the activities.
                    You shall maintain a current registration profile, including yearly updates, and promptly notify Dell, in writing, of any
                    change(s) that may affect your participation. You shall meet all other reasonable criteria as required by Dell.</p>
                <p>Promotion of Dell products and services. You shall use funds exclusively to promote Dell products and services.</p>
                <p><span style='font-weight: bold;'>Proof of Performance.</span> You shall provide Dell with Proof of Performance of activities, in the format request by Dell,
                    within thirty (30) days of the conclusion of the activities, including any additional detail requested by Dell (collectively,
                    the “Materials”). The leads generated by the demand generation activity must be uploaded into the Dell Partner Lead
                    Management tool within 48 hours of executing the activity. Your invoice, referencing Dell’s PO number if applicable, a
                    copy of the Dell MDF Program Confirmation, and any supporting documentation outlining the full cost of the Activity
                    incurred by the Partner, as well as any additional requirements as determined by Dell, including but not limited to
                    event photos. If customer leads are not submitted into the Partner Lead Management tool within two (2) weeks of the
                    activity’s completion, Dell reserves the right to deny payment of the funds in part or in full. Any proof of performance
                    not submitted to Dell within the requested time period will result in your forfeiture of rights in the Funds. You agree to
                    provide accurate and complete information.</p>
                <p><span style='font-weight: bold;'>Disbursement of Funds.</span> You will be paid the applicable funds, in United States Dollars, upon completion of an
                    Activity, provided that all appropriate Materials and tax documentation (as outlined below) have been provided to Dell
                    within the time period required. Dell shall not be responsible to provide You with any funds for any activities that have
                    not been approved and agreed to in writing by Dell in advance of your undertaking the Activities. Dell shall not be
                    responsible to pay You for any amounts above and beyond those agreed to in writing by Dell.</p>
                <p>In the event that you receive incentives related to blitz day activities, You shall distribute such amounts to Your sales
                    representatives that both booked and/or closed the sale of the associated qualifying products and/or services
                    accordingly. You shall be responsible for all charges and applicable taxes associated with such payments.
                    Notwithstanding the foregoing, You may withhold from distribution any applicable processing fees that You incurred in
                    connection with your internal administration of, and payments to be made to Your sales representatives in connection
                    with, a blitz day activity. </p>
                <p><span style='font-weight: bold;'>License.</span> You shall provide Dell with a license to use any Materials as Dell required in order to fulfill its obligations set
                    forth in this Agreement. In addition, You grant Dell a worldwide right and license to use the Materials for its marketing
                    purposes. You represent and warrant that You have obtained all necessary rights and consents to provide the license
                    rights set forth in this section to Dell.</p>
                <p><span style='font-weight: bold;'>Return of Funds.</span> If Dell has provided any funds, including funds provided in advance of receiving adequate Proof of
                    Performance, (a) that are in excess of the amounts spent by You for the Activities or (b) for which Dell does not
                    subsequently receive adequate Proof of Performance for Activities in a timely manner, as required in this Agreement,
                    You forfeit any rights to such amounts (“Unearned Amounts”) and agree to return promptly to Dell any Unearned
                    Amounts that have been disbursed by Dell. </p>
                <p><span style='font-weight: bold;'>Records.</span> Dell’s records and systems shall be authoritative and conclusive for purposes of determining all compliance
                    under the Program and performing any computation or calculation regarding the Program. All decisions made by Dell.
                    are final.</p>
                <p><span style='font-weight: bold;'>Audit.</span> Dell reserves the right to audit or request verification of any claims submitted.</p>
                <p><span style='font-weight: bold;'>Tax Liability.</span> Taxes on Funds are the sole responsibility of You. All federal, state, and local laws and regulations apply.
                    You may be required to provide relevant tax information to Dell for tax reporting purposes. Failure to provide
                    requested tax information to Dell within thirty (30) days after Your acceptance of this Agreement will result in forfeiture
                    by You of the Funds.</p>
                <p><span style='font-weight: bold;'>Independent Contractors.</span> Dell and You are independent contractors. Neither party will state, imply, nor knowingly
                    permit anyone to finder that any other relationship exists between the parties.</p>
                <p><span style='font-weight: bold;'>Legal Compliance.</span> You shall be responsible for compliance with all laws, including, but not limited to, the U.S.
                    CAN-SPAM law and related privacy laws and regulations. You will not misappropriate, violate, or infringe any third
                    party’s rights (including any right to privacy), or otherwise breach any obligation to end users (including any obligation
                    to not disclose personal information to third parties for direct marketing purposes). Your participation in the Program
                    is voluntary. Dell may provide access to You to vendors for the purposes of facilitating Activities. Provided, however,
                    You will remain responsible for all legal compliance associated with Activities</p>
                <p><span style='font-weight: bold;'>Public Disclosure Requirement.</span> All Activity invitations, registration forms, and Activity signage must prominently
                    display notice to all public entity participants an estimate in United States Dollars of all itemized products and/or
                    services that are available to all attendees at no cost. It is Your responsibility to make sure all public disclosure
                    requirements are met and to certify with Your attendees that by registering or attending this Activity, the attendees
                    have verified with their ethics counsel on their ability to accept gifts or other things of value as listed in the invitations,
                    registration forms and signage, or else they will make a payment to You for the items listed if required by law.
                    Additionally, You must be prepared to accept payment in advance or at the Activity itself for those public entity
                    participants. </p>
                <p><span style='font-weight: bold;'>Publicity.</span> You agree not to issue or release any articles, advertising, publicity or other matters mentioning or implying
                    the name of Dell without obtaining prior consent from Dell, unless You have been granted such usage rights under the
                    Dell PartnerDirect Program. All potential uses must be submitted via email to Your appropriate field marketing
                    manager four to six (4-6) weeks in advance of Your Activity date. You will be notified via email whether or not Your
                    proposed use is accepted, denied, or requires any modifications. If You are notified that Your materials require any
                    form of alteration, You certify that You will comply with all change requests before distributing Your materials. </p>
                <p><span style='font-weight: bold;'>Third Party Vendors.</span> Dell may introduce you to third party vendors (“Vendors”) that may be available to assist a
                    Partner with an Activity. This introduction is provided to you as a courtesy, and your use thereof is voluntary. You are
                    responsible for complying with all applicable laws, including but not limited to CAN-SPAM and your privacy policy.
                    Under no circumstances shall Dell be liable for any direct, indirect, consequential, incidental or special damages
                    arising out of or relating in any way to a Partner’s purchase and/or use of any such Vendor’s products and/or services. </p>
                <p><span style='font-weight: bold;'>Administration.</span> The terms and conditions of the Program and Your eligibility to participate therein are at Dell’s sole
                    discretion. All decisions made by Dell are final. Dell reserves the right to modify or cancel the Program, or
                    participation by You therein, at any time and without prior notice. If any modification is unacceptable to You, Your
                    sole recourse is to terminate Your participation in the Program. If You continue to participate in the Program, that
                    participation will constitute Your binding acceptance of the modification. Approval of Activities and disbursement of
                    Funds is in Dell’s sole discretion.</p>
                <p><span style='font-weight: bold;'>Confidentiality.</span> This Agreement and the terms hereof are Dell confidential information, and You shall maintain such
                    information as confidential and shall not disclose such information to any third party, even after termination of this
                    Agreement, unless required by law. </p>
                <p><span style='font-weight: bold;'>Indemnification.</span> To the fullest extent permitted by law, You shall indemnify, defend, and hold harmless Dell and its
                    subsidiaries, affiliates, parents, successors, and assigns, from and against any claim, demand, cause of action, debt,
                    or liability (including reasonable attorney or legal fees, expenses and court costs) based upon, arising from, or related
                    to Your failure to comply with all obligations under this Agreement. Dell reserves the right to not pay such Funds in
                    certain circumstances, including, without limitation, if You have failed to comply with or certify to Dell all of the terms
                    and conditions of this Agreement, including all obligations set forth in the Legal Compliance and Public Disclosure
                    Requirement sections.</p>
                <p><span style='font-weight: bold;'>Miscellaneous.</span> Your participation and use of this Program are subject to and governed by the Dell PartnerDirect
                    Program Terms and Conditions. The PartnerDirect Program Terms and Conditions are incorporated herein by
                    reference. This Agreement constitutes the entire agreement between Dell and You with respect to the subject matter
                    hereof and supersedes any and all prior agreements and understandings regarding the same subject matter, whether
                    established by custom, practice, procedure, or precedent. This Agreement shall be governed by and subject to Texas
                    law, without reference to its conflict of laws principles. Dell and You are independent contractors. Neither party is
                    hereby granted any right or authority to assume, create or incur and obligation, liability, or responsibility of any kind,
                    whether express or implied, against, or in the name of, or on behalf of, another party. This Agreement may be
                    executed in any number of counterparts and any party hereto may execute any such counterpart, each of which
                    when executed and delivered shall be deemed to be an original and all of which counterparts taken together shall
                    constitute but one and the same instrument. A facsimile of an executed counterpart of this Agreement shall be
                    sufficient to evidence the binding agreement of each party to the terms hereof. You may not assign this Agreement or
                    any amount due under this Agreement, to any third party without the express written consent of Dell. If any provision
                    of this Agreement is void or unenforceable, the parties agree to delete it and agree that the remainder will continue to
                    be in effect. </p>
                <br>
            </div>
            <br>
            <h5>Comments</h5>
            <textarea class="binput" name ="Comment" ></textarea><br>
            <button class="button" type='submit' name='edit' value="Save" >Save and Edit</button>
            <button class="button" type='submit' name='edit' value="Delete">Delete</button><br><br>
        </form>
            <form method='Post' action='PartnerFetch'> 
                <button id="back" class="button" type="submit">Back</button>
            </form>
    </body>
</html>
