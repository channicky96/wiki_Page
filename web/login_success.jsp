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
    </head>
    <body>
        <h1>Login success </h1>
        <%
<<<<<<< HEAD
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

=======
            try{
                Connection connectionUrl = null;
//
                String userid = request.getParameter("username");
//                session.putValue("userid",userid);
//                String pwd = request.getParameter("userpassword");
//                
//                out.println("<p>"+userid+"</p>");
                out.println("<p>----------------------1---------------------</p>");
                Class.forName("org.postgresql.Driver");
                
                String url = "jdbc:postgresql://127.0.0.1/studentdb";
//                
                out.println("<p>----------------------2---------------------</p>");
                connectionUrl = DriverManager.getConnection(url,"student","dbpassword"); 
//                
                out.println("<p>---------------------3----------------------</p>");
                Statement st = connectionUrl.createStatement();
                out.println("<p>"+userid+"</p>");
//                
                out.println("<p>---------------------4---------------------</p>");
                ResultSet rs = st.executeQuery("select * from users where username = '"+userid+"'");
                
                out.println("<p>---------------------5----------------------</p>");
                while (rs.next()){
                    int id = rs.getInt("id");
                    out.println("<p>Welcome back "+ id+": "+userid +"</p>");
                }
                connectionUrl.close();
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
                out.println("<p>not found</p>");
                
>>>>>>> 534c71743fe16eeef46b1fe14360d8afdef306ba
            }
        %>
    </body>
</html>
