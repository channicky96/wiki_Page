<%-- 
    Document   : basket
    Created on : 14-Mar-2018, 09:24:46
    Author     : acc16scu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import=" java.sql.*"%>
<%@page import=" javax.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <script>
            function downloadedAlert() {
                alert("Text file generated");
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Noodles Wiki</title>
        <link rel="stylesheet" href="/NoodlesWiki/w3.css" type="text/css">
        <!--import Font Awesome Icons-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="Shortcut Icon" href="noodleswiki.ico">
        <link rel="stylesheet" href="/NoodlesWiki/pages.css" type="text/css">
    </head>
    <body>
        <%@ include file="template.jsp" %>
        <div style="align-content: center;" class="w3-margin-left w3-left ">
            <h1>Basket items:  </h1>
            <%                
                out.print("<div id=\"AD\" class=\"w3-container w3-border account\">");
                out.print("<table class=\"w3-table w3-bordered\">");
            %>
            <c:forEach var="basket" items="${basket}">
                <table class="w3-table w3-bordered">        
                    <tr><td><b><h3><a href="/NoodlesWiki/article/?keyword=${basket.name}">${basket.name}</a></h3></b></td></tr><br>
                </table>
            </c:forEach>
            <%
                out.print("</table></div><br><br>");
            %>
            <a href="/NoodlesWiki/article/?download=download" onclick="downloadedAlert()">
                <i class="fas fa-download" title="Download"> Download</i>
            </a>

        </div>
    </body>
</html>
