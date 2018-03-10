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
            try{
                Connection connectionUrl = null;
                String Driver = "org.postgresql.Driver";
                String url = "jdbc:postgresql://localhost:5432";
                String userid = request.getParameter("username");
                
                session.putValue("userid",userid);
                String pwd = request.getParameter("userpassword");
                
                out.println("<p>"+userid+"</p>");
                out.println("<p>----------------------1---------------------</p>");
                //Class.forName(Driver);
                Class.forName("com.postgresql.Driver");
                out.println("<p>----------------------2---------------------</p>");
                connectionUrl = DriverManager.getConnection(url,"acc16scu","Ronis1337"); //8084?
                out.println("<p>-------------------------------------------</p>");
                Statement st = connectionUrl.createStatement();
                out.println("<p>"+userid+"</p>");
                out.println("<p>---------------------3---------------------</p>");
                ResultSet rs = st.executeQuery("select id from user where username = '"+userid+"'");
                out.println("<p>---------------------4----------------------</p>");
                while (rs.next()){
                    out.println("<p>Welcome back "+ userid +"</p>");
                }
                connectionUrl.close();
            }
            catch(ClassNotFoundException e){
                System.out.println("not found");
                e.printStackTrace();
            }
        %>
    </body>
</html>
