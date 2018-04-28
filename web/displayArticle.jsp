<%-- 
    Document   : displayArticle
    Created on : 23-Apr-2018, 11:27:24
    Author     : btk16xmu
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>displaying an article</title>
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
            </h1><a w3-right>Rate:</a>
            <div id="menu" class="w3-right w3-card w3-padding-small">
                <nav>
                    <h4 class="w3-center">Menu</h4>
                    <ol class="w3-container">
                        <c:forEach var="section" items="${sections}">
                            <li><a href="#${section.title}" class="w3-hover-shadow">${section.title}</a></li>
                            </c:forEach>
                    </ol>
                </nav>
            </div>
            <c:forEach var="section" items="${sections}">
                <div id="${section.title}" class="article_section w3-border-bottom">
                    <h3>${section.title} <a href="#${section.title}" class="w3-text-light-blue w3-small">[edit]</a></h3>
                    <p>${section.content}</p>
                </div>
            </c:forEach>
            <article>
                </body>
                </html>
