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
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <form action="ControllerServlet" method="post">
            Username: <input type="text" name="username"> <br>
            Password: <input type="password" name="password"><br>
            <input type="submit" value="login" >
        </form>
        
    </body>
</html>
