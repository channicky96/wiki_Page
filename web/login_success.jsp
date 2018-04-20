<%-- 
    Document   : login_success
    Created on : 09-Mar-2018, 13:27:08
    Author     : acc16scu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import=" java.sql.*"%>
<%@page import=" javax.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="Shortcut Icon" href="noodleswiki.ico">
    </head>
    <body>
        <h1>Login success </h1>
        <%
            try {
                Connection connectionUrl = null;
                String username = request.getParameter("username");
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://127.0.0.1/studentdb";
                connectionUrl = DriverManager.getConnection(url, "student", "dbpassword"); //8084?
                Statement st = connectionUrl.createStatement();
                out.println("<p>Your username is : " + username + "</p>");
                ResultSet rs = st.executeQuery("select * from users where username = '" + username + "'");
                while (rs.next()) {
                    String nn = rs.getString("nickname");
                    out.println("<p>Welcome back " + nn + "</p>");
                }
                connectionUrl.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                out.println("<p>not found</p>");
              
            }
        %>
    </body>
</html>
