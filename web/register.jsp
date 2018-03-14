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
    </head>
    <body>
        <h1>Register</h1>
        <form action="ControllerServlet" method="post">
            Nickname: <input type="text" name="nickname"> <br>
            Password: <input type="password" name="password"><br>
            Confirm Password: <input type="password" name="password1"><br>
            Email: <input type="email" name="useremail"><br>
            <input type="submit" name="button" value="register" ><br>
        </form>
        <a href="login.jsp">Already registered?</a>
    </body>
</html>
