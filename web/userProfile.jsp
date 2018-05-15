<%@page import="wiki.Profile"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link rel="stylesheet" href="/NoodlesWiki/w3.css" type="text/css">
        <!--import icons-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="Shortcut Icon" href="noodleswiki.ico">
        <link rel="stylesheet" href="/NoodlesWiki/pages.css" type="text/css">
    </head>
    <body>
        <%@ include file="template.jsp" %>
        <div class="w3-panel w3-bottombar w3-border-black">
            <% //
                String checkR = (String) session.getAttribute("checkR");
                Profile userA = (Profile) session.getAttribute("userprofile");
                out.print("<table class=\"w3-table w3-bordered\">");
                out.print("<tr><td><b><h3>Nickname :</h3></b></td><td><h3>" + userA.getName() + "</h3></td></tr>");
                out.print("<tr><td><b><h3>Email :</h3></b></td><td><h3>" + userA.getEmail() + "</h3></td></tr>");
                out.print("<tr><td><b><h3>Rating :</h3></b></td>");
                out.print("<td><h3><a onclick=\"bookmarkRemove()\" href=\"/NoodlesWiki/\">");
                if(checkR.equals("NR") || checkR.equals("NEGATIVE")){
                out.print("<i class=\"far fa-thumbs-up w3-xlarge w3-button\"></i>");
                }else if(checkR.equals("POSITIVE")){
                    out.print("<i class=\"fas fa-thumbs-up w3-xlarge w3-button\"></i>");
                }
                out.print("</a> " + userA.getRate() + "");
                out.print("<a onclick=\"bookmarkRemove()\" href=\"/NoodlesWiki/\">");
                if(checkR.equals("NR") || checkR.equals("POSITIVE")){
                out.print("<i class=\"far fa-thumbs-down w3-xlarge w3-button\"></i>");
                }else if (checkR.equals("NEGATIVE")){
                    out.print("<i class=\"far fa-thumbs-down w3-xlarge w3-button\"></i>");
                }
                out.print("</a></h3></td></tr>");
                out.print("<tr><td><h3>Contribution: ");
            %>

            <c:forEach var="contributed" items="${userprofile.contributed}">
                <table class="w3-table w3-bordered">        
                    <h3><a href="/NoodlesWiki/article/?keyword=${contributed.name}">${contributed.name}</a></h3>
                </table>
            </c:forEach>

            <% //
                out.print("</h3><br><br></td>");
                out.print("</table>");
            %>
        </div>
        <%@ include file="end_template.jspf" %>
    </body>
</html>
