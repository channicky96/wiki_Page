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
        <link rel="stylesheet" href="w3.css" type="text/css">
        <!--import icons-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="nav.css" type="text/css">
    </head>
    <body class="w3-light-grey">
        <jsp:useBean id="list" scope="session" class="wiki.Category" />
        <%@ include file="template.jsp" %>
        <h1 class="w3-container">Hello World!</h1>
        <ul>
            <li><% out.println("ttttt");%></li>
            <li><jsp:getProperty name="list" property="name" /></li>
        </ul>
    </body>
</html>
