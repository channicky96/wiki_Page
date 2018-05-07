<%-- 
    Document   : newArticle
    Created on : 06-May-2018, 20:57:56
    Author     : acc16scu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Article</title>
        <link rel="stylesheet" href="/NoodlesWiki/w3.css" type="text/css">
        <!--import Font Awesome Icons-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="Shortcut Icon" href="noodleswiki.ico">
        <link rel="stylesheet" href="/NoodlesWiki/pages.css" type="text/css">
    </head>
    <body>
        <%@ include file="template.jsp" %>
        <h1>New Article</h1>
        <form class="w3-container w3-animate-left" action="ArticleServerlet" method="post">
            Title:<input type="text">
            Tags:
            Category:<select>
                <option value="Nature">Nature</option>
            </select>
            Sections:<input type="number">
            <input type="submit" name="button">
<!--            https://www.npmjs.com/package/tags-input-->
        </form>
    </body>
</html>
