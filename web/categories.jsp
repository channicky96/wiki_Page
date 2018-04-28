<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <!-- shift 200px when sidebar visible -->
        <div class="w3-main" style="margin-left:200px; margin-top:43px;">
        <h1 class="w3-container">Categories</h1>
        <%@ include file="category_list.jsp" %>
        </div>
    </body>
</html>
