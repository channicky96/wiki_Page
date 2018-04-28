<%-- 
    Document   : login
    Created on : 07-Mar-2018, 12:23:45
    Author     : acc16scu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Details</title>
        <link rel="stylesheet" href="/NoodlesWiki/w3.css" type="text/css">
        <!--import icons-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="Shortcut Icon" href="noodleswiki.ico">
        <link rel="stylesheet" href="/NoodlesWiki/pages.css" type="text/css">
    </head>
    <body>
        <%@ include file="template.jsp" %>
        <div style="align-content: center;" class="w3-margin-left w3-left">
            <h1>Your account details</h1>
           
            <%
                out.print("<div class=\"w3-bar w3-white\">");
                out.print("<button class=\"w3-bar-item w3-button tablink w3-blue w3-round-xxlarge\" onclick=\"accountChange(event,'AD')\">Account Details</button>");
                out.print("<button class=\"w3-bar-item w3-button tablink w3-round-xxlarge\" onclick=\"accountChange(event,'AS')\">Account Setting</button>");
                out.print("</div>");
                out.print("<div id=\"AD\" class=\"w3-container w3-border account\">");
                out.print("<table class=\"w3-table w3-bordered\">");
                String username = (String)session.getAttribute("username");
                out.print("<tr><td><b>Username</b></td><td>"+username+"</td></tr>");
                int userID = (Integer)session.getAttribute("userID");
                out.print("<tr><td><b>UserID</b></td><td>"+userID+"</td></tr>");
                String userEmail = (String)session.getAttribute("userEmail");
                out.print("<tr><td><b>Email</b></td><td>"+userEmail+"</td></tr>");
                String userNickname = (String)session.getAttribute("userNickname");
                out.print("<tr><td><b>Nickname</b></td><td>"+userNickname+"</td></tr>");
                out.print("</table>");
                out.print("</div>");
                out.print("<div id=\"AS\" class=\"w3-container w3-border account\" style=\"display:none\">");
                out.print("<form class=\"w3-container\" action=\"ControllerServlet\" method=\"post\">");
                out.print("<div class=\"w3-dropdown-click\">");
                out.print("<a href=\"javascript:void(0)\" onclick=\"changeNickname()\" class=\"w3-button\">Change Nickname</a>");
                out.print("<div id=\"changeNickname\" class=\"w3-dropdown-content w3-bar-block w3-border\">");
                out.print("<input class=\"w3-input\" type=\"text\" name=\"newNickname\" placeholder=\"Enter new nickname\" required>");
                out.print("<input class=\"w3-block w3-button w3-black\" type=\"submit\" name=\"button\" value=\"Change Nickname\">");
                out.print("</div>");
                out.print("</form>");               
            %>
                <form class="w3-container" action="ControllerServlet" method="post">
                    <div class="w3-dropdown-click">
                        <a href="javascript:void(0)" onclick="changePassword()" class="w3-button">Change Password</a>
                        <div id="changePassword" class="w3-dropdown-content w3-bar-block w3-border">
                            <input class="w3-input" type="password" name="oldPassword" placeholder="Enter old password" required>
                            <input class="w3-input" type="password" name="newPassword" placeholder="Enter new password"required>
                            <input class="w3-input" type="password" name="confirmNewPassword" placeholder="Confirm new password"required>
                            <input class="w3-block w3-button w3-black" type="submit" name="button" value="Change Password">
                        </div>
                    </div> 
                </form>
            </div>
        </div>
        <%@ include file="end_template.jspf" %>
    </body>
</html>
