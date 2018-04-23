<%-- 
    Document   : 404
    Created on : 19-Apr-2018, 12:41:05
    Author     : btk16xmu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page not found</title>
        <link rel="stylesheet" href="/NoodlesWiki/w3.css" type="text/css">
        <!--import icons-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="Shortcut Icon" href="noodleswiki.ico">
        <link rel="stylesheet" href="/NoodlesWiki/pages.css" type="text/css">
        <style>
            body {
                background-color: #777;
            }
            #main {
                height: 100%;
                padding: auto;
                font-size: xx-large;
                color: white;
                text-align: center;
            }
            h1 {
                font-size: 144px;
            }
            p {
                font-size: small;
            }
        </style>
    </head>
    <body>
        <%@ include file="template.jsp" %>
        <div id="main">
            <h1>404</h1>
            <h2>not found</h2>
            <p>goto <a href="index.jsp">homepage</a></p>
        </div>
    </body>
</html>
