<%-- 
    Document   : article
    Created on : 14-Mar-2018, 09:24:46
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
        <%
            try {
                Connection connectionUrl = null;
                //int h = request.getIntHeader("articleid");
                String articleid = request.getParameter("articleid");
//                int aid = Integer.valueOf(articleid);
                System.out.println("h: "+articleid);
                //int articleid = 2;
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://127.0.0.1/studentdb";
                connectionUrl = DriverManager.getConnection(url, "student", "dbpassword"); //8084?
                Statement st = connectionUrl.createStatement();
                //out.println("<p>Your username is : " + username + "</p>");
                ResultSet rs = st.executeQuery("select * from article where articleID = '" + articleid + "'");
                while (rs.next()) {
                    String title = rs.getString("articleTitle");
                    out.println("<h1>Title: " + title + "</h1>");
                    String maintext = rs.getString("mainContent");
                    out.println("<p>content: " + maintext + "</p>");
                }
                connectionUrl.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                out.println("<p>not found</p>");

            }
        %>
    </body>
</html>
