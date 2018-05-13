<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : sandbox
    Created on : 2018-3-2, 15:08:05
    Author     : btk16xmu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>An article sandbox</title>
        <link rel="stylesheet" href="/NoodlesWiki/w3.css" type="text/css">
        <!--import icons-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="Shortcut Icon" href="noodleswiki.ico">
        <link rel="stylesheet" href="/NoodlesWiki/pages.css" type="text/css">
    </head>
    <body class="w3-light-grey">
        <%@ include file="template.jsp" %>
        <article class="w3-white w3-container w3-padding-large">
            <h1 class="w3-serif w3-bottombar">${name}
                <a href="#" class="w3-text-light-blue w3-large">[edit]</a>
            </h1>
            <div id="menu" class="w3-right w3-card w3-padding-small">
                <nav>
                    <h4 class="w3-center">Menu</h4>
                    <ol class="w3-container">
                        <li><a href="#" class="w3-hover-shadow">first</a></li>
                        <li><a href="#" class="w3-hover-shadow">second</a></li>
                        <li><a href="#" class="w3-hover-shadow">third</a></li>
                        <li><a href="#" class="w3-hover-shadow">references</a></li>
                    </ol>
                </nav>
            </div>
            <c:forEach var="section" items="${sections}">
                <div class="article_section w3-border-bottom">
                    <h3>${section.title} <a href="#" class="w3-text-light-blue w3-small">[edit]</a></h3>
                    <p>${section.content}</p>
                </div>
            </c:forEach>
    </body>
</html>
