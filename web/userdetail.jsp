<%-- 
    Document   : userdetail
    Created on : 07-Mar-2018, 12:23:45
    Author     : acc16scu
--%>

<%@page import="wiki.Profile"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <div style="align-content: center;" class="w3-margin-left w3-left ">
            <h1>Your account details</h1>

            <%  //              
                out.print("<div class=\"w3-bar w3-white\">");
                out.print("<button class=\"w3-bar-item w3-button tablink w3-blue w3-leftbar w3-round-xxlarge\" onclick=\"accountChange(event,'AD')\">Account Details</button>");
                out.print("<button class=\"w3-bar-item w3-button tablink w3-round-xxlarge\" onclick=\"accountChange(event,'UA')\">My Articles</button>");
                out.print("<button class=\"w3-bar-item w3-button tablink w3-round-xxlarge\" onclick=\"accountChange(event,'FA')\">Favourite Articles</button>");
                out.print("<button class=\"w3-bar-item w3-button tablink w3-round-xxlarge\" onclick=\"accountChange(event,'AS')\">Account Setting</button>");
                out.print("</div>");
                out.print("<div id=\"AD\" class=\"w3-container w3-border account\">");
                out.print("<table class=\"w3-table w3-bordered\">");
                String username = (String) session.getAttribute("username");
                out.print("<tr><td><b><h3>Username :</h3></b></td><td><h3>" + username + "</h3></td></tr>");
                int userID = (Integer) session.getAttribute("userID");
                out.print("<tr><td><b><h3>UserID :</h3></b></td><td><h3>" + userID + "</h3></td></tr>");
                String userEmail = (String) session.getAttribute("userEmail");
                out.print("<tr><td><b><h3>Email :</h3></b></td><td><h3>" + userEmail + "</h3></td></tr>");
                String userNickname = (String) session.getAttribute("userNickname");
                out.print("<tr><td><b><h3>Nickname :</h3></b></td><td><h3>" + userNickname + "</h3></td></tr>");

                Profile p = (Profile) session.getAttribute("userprofile");
                Integer newrating = (Integer) session.getAttribute("TotalVote");

                out.print("<tr><td><b><h3>Rating :</h3></b></td><td><h3>" + newrating + "</h3></td></tr>");
                out.print("</table>");
                out.print("</div>");
                out.print("<div id=\"UA\" class=\"w3-container w3-border account\" style=\"display:none\">");
                out.print("<table class=\"w3-table w3-bordered\">");
            %>
            <c:forEach var="myArticles" items="${myArticles}">
                <table class="w3-table w3-bordered">        
                    <tr><td><b><h3><a href="/NoodlesWiki/article/?keyword=${myArticles}">${myArticles}</a></h3></b></td></tr><br>
                </table>
            </c:forEach>

            <%
                out.print("</table>");
                out.print("</div>");
            %>
            <div id="FA" class="w3-container w3-border account" style="display:none">
                <c:forEach var="bmitem" items="${bmlist}">
                    <table class="w3-table w3-bordered">        
                        <tr><td><b><h3><a href="/NoodlesWiki/article/?keyword=${bmitem}">${bmitem}</a></h3></b></td></tr><br>
                    </table>
                </c:forEach>
            </div>

            <%
                out.print("<div id=\"AS\" class=\"w3-container w3-border account\" style=\"display:none\">");
                out.print("<table class=\"w3-table \">");
                out.print("<form class=\"w3-container\" action=\"ControllerServlet\" method=\"post\">");
                out.print("<tr><th><button onclick=\"popout('CN')\" class=\"w3-btn w3-block w3-black w3-left-align\">Change Nickname</button>");
                out.print("<div id=\"CN\" class=\"w3-container w3-hide\">");
                out.print("<input class=\"w3-input\" type=\"text\" maxlength=\"20\" name=\"newNickname\" placeholder=\"Enter new nickname\" required>");
                out.print("<input class=\"w3-block w3-button w3-black\" type=\"submit\" name=\"button\" value=\"Change Nickname\">");
                out.print("</div></th></tr>");
                out.print("</form>");
            %>
            <form class="w3-container" action="ControllerServlet" method="post">
                <tr><th>
                        <button onclick="popout('CP')" class="w3-btn w3-block w3-black w3-left-align">Change Password</button>
                        <div id="CP" class="w3-container w3-hide">
                            <input class="w3-input" type="password" name="oldPassword" placeholder="Enter old password" required>
                            <input class="w3-input" type="password" name="newPassword" placeholder="Enter new password"required>
                            <input class="w3-input" type="password" name="confirmNewPassword" placeholder="Confirm new password"required>
                            <input class="w3-block w3-button w3-black" type="submit" name="button" value="Change Password">
                        </div>
                    </th></tr>
            </form>   
        </div>
        <%@ include file="end_template.jspf" %>
    </body>
</html>
