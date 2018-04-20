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
        <link rel="stylesheet" href="w3.css" type="text/css">
        <!--import icons-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="pages.css" type="text/css">
        <link rel="Shortcut Icon" href="noodleswiki.ico">
    </head>
    <body>
        <%@ include file="template.jsp" %>
        <div class="w3-margin-left w3-left">
            <h1 class="w3-margin-left">Login</h1>
            <form class="w3-container" action="ControllerServlet" method="post">
                Username: <input class="w3-input" type="text" name="username"> <br/>
                Password: <input class="w3-input" type="password" name="password"><br/>
                <input class="w3-block w3-button w3-black" type="submit" name="button" value="Login" >
                <a class="w3-panel" href="register.jsp">Not registered?</a>
            </form>
        </div>
    </body>
</html>
