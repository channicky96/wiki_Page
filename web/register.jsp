<%-- 
    Document   : register
    Created on : 10-Mar-2018, 16:59:20
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
            <h1 class="w3-margin-left">Register</h1>
            <form class="w3-container w3-animate-left" action="ControllerServlet" method="post">
                Nickname: <input class="w3-input" type="text" name="nickname" required> <br>
                Password: <input class="w3-input" type="password" name="password" required><br>
                Confirm Password: <input class="w3-input" type="password" name="password1" required><br>
                Email: <input class="w3-input" type="email" name="useremail" required><br>
                <input class="w3-block w3-button w3-black" type="submit" name="button" value="Register" ><br>
            </form>
            <a class="w3-panel" href="login.jsp">Already registered?</a>
        </div>
        <%@ include file="end_template.jspf" %>
    </body>
</html>
