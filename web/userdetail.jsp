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
        <title>JSP Page</title>
        <link rel="stylesheet" href="/NoodlesWiki/w3.css" type="text/css">
        <!--import icons-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="Shortcut Icon" href="noodleswiki.ico">
        <link rel="stylesheet" href="/NoodlesWiki/pages.css" type="text/css">
    </head>
    <body>
        <%@ include file="template.jsp" %>
        <div class="w3-main" style="margin-left:200px; margin-top:43px;">

            <div style="align-content: center;" class="w3-margin-left w3-left ">
                <h1>Your account details</h1>

                <%                    
                    out.print("<div class=\"w3-bar w3-white\">");
                    out.print("<button class=\"w3-bar-item w3-button tablink w3-blue w3-leftbar w3-round-xxlarge\" onclick=\"accountChange(event,'AD')\">Account Details</button>");
                    out.print("<button class=\"w3-bar-item w3-button tablink w3-round-xxlarge\" onclick=\"accountChange(event,'UA')\">My Articles</button>");
                    out.print("<button class=\"w3-bar-item w3-button tablink w3-round-xxlarge\" onclick=\"accountChange(event,'AS')\">Account Setting</button>");
                    out.print("</div>");
                    out.print("<div id=\"AD\" class=\"w3-container w3-border account\">");
                    out.print("<table class=\"w3-table w3-bordered\" height = 400px>");
                    String username = (String) session.getAttribute("username");
                    out.print("<tr><td><b><h3>Username :</h3></b></td><td><h3>" + username + "</h3></td></tr>");
                    int userID = (Integer) session.getAttribute("userID");
                    out.print("<tr><td><b><h3>UserID :</h3></b></td><td><h3>" + userID + "</h3></td></tr>");
                    String userEmail = (String) session.getAttribute("userEmail");
                    out.print("<tr><td><b><h3>Email :</h3></b></td><td><h3>" + userEmail + "</h3></td></tr>");
                    String userNickname = (String) session.getAttribute("userNickname");
                    out.print("<tr><td><b><h3>Nickname :</h3></b></td><td><h3>" + userNickname + "</h3></td></tr>");
//                    String userRate = (String) session.getAttribute("");
//                    out.print("<tr><td><b><h3>Rating :</h3></b></td><td><br>" +  + "</td></tr>");
                    out.print("</table>");
                    out.print("</div>");
                    out.print("<div id=\"UA\" class=\"w3-container w3-border account\" style=\"display:none\">");
                    out.print("<table class=\"w3-table w3-bordered\" height = 400px>");
                    
                    
                    
                    out.print("</table>");
                    out.print("</div>");
                    out.print("<div id=\"AS\" class=\"w3-container w3-border account\" style=\"display:none\">");
                    out.print("<table class=\"w3-table \" height = 400px>");
                    out.print("<form class=\"w3-container\" action=\"ControllerServlet\" method=\"post\">");
                    out.print("<tr><th height = 150px><h2>Change Nickname</h2>");
                    out.print("<input class=\"w3-input\" type=\"text\" name=\"newNickname\" placeholder=\"Enter new nickname\" required>");
                    out.print("<input class=\"w3-block w3-button w3-black\" type=\"submit\" name=\"button\" value=\"Change Nickname\">");
                    out.print("</th></tr>");
                    out.print("</form>");
                %>
                <form class="w3-container" action="ControllerServlet" method="post">
                    <tr><th><h2>Change Password</h2>
                            <input class="w3-input" type="password" name="oldPassword" placeholder="Enter old password" required>
                            <input class="w3-input" type="password" name="newPassword" placeholder="Enter new password"required>
                            <input class="w3-input" type="password" name="confirmNewPassword" placeholder="Confirm new password"required>
                            <input class="w3-block w3-button w3-black" type="submit" name="button" value="Change Password">
                        </th></tr>
                </form>
                </table>    
            </div>
        </div>
    </div>
</body>
</html>
