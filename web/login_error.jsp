<%-- 
    Document   : login_error
    Created on : 09-Mar-2018, 13:28:27
    Author     : acc16scu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="/NoodlesWiki/w3.css" type="text/css">
        <!--import icons-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="Shortcut Icon" href="noodleswiki.ico">
        <link rel="stylesheet" href="/NoodlesWiki/pages.css" type="text/css">
    </head>
    <body>
        <%@ include file="template.jsp" %>
        <div class="w3-main" style="margin-left:200px; margin-top:43px;">
            <h2 class="w3-container w3-cell-row w3-red w3-animate-top">Username or password incorrect!</h2>

            <div class="w3-margin-left">
                <form class="w3-container w3-left" action="ControllerServlet" method="post">
                    Username: <input class="w3-input" type="text" name="username"> <br/>
                    Password: <input class="w3-input" type="password" name="password"><br/>
                    <input class="w3-block w3-button w3-black" type="submit" name="button" value="Login" >
                    <a class="w3-panel" href="/NoodlesWiki/register.jsp">Not registered?</a>
                </form>
            </div>
        </div>
    </body>
</html>
