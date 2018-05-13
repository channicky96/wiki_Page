<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="wiki.Category"%>

<%-- 
    Document   : categories
    Created on : 2018-3-2, 16:51:17
    Author     : btk16xmu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categories - NoodlesWiki</title>
        <link rel="stylesheet" href="/NoodlesWiki/w3.css" type="text/css">
        <!--import icons-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="Shortcut Icon" href="noodleswiki.ico">
        <link rel="stylesheet" href="/NoodlesWiki/pages.css" type="text/css">
    </head>
    <body class="w3-light-grey">
        <%@ include file="template.jsp" %>
        <div class="w3-white w3-container w3-margin">
            <h1 class="w3-container">Categories</h1>
            <ul class="w3-ul">
                <c:forEach var="cat" items="${categoryList}">
                    <li><h4>${cat}</h4>
                            <c:forEach var="articleName" items="${cat.list}">
                            <ul><li><a href="/NoodlesWiki/article/?keyword=${articleName}">${articleName}</li></a></ul>
                                </c:forEach>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <%@include file="end_template.jspf" %>

    </body>
</html>
