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
        <div class="w3-container">
            <h1>New Article</h1>
            <form class="w3-container w3-animate-left" action="/NoodlesWiki/article/" method="post">
                Title:<input name="name" type="text">
                Category:<select name="category">
                    <option value="Violet">Violet</option>
                    <option value="Red">Red</option>
                    <option value="Green">Green</option>
                    <option value="Puce">Puce</option>
                    <option value="Indigo">Indigo</option>
                    <option value="Crimson">Crimson</option>
                    <option value="Mauv">Mauv</option>
                    <option value="Pink">Pink</option>
                    <option value="Yellow">Yellow</option>
                    <option value="Goldenrod">Goldenrod</option>
                    <option value="Teal">Teal</option>
                    <option value="Khaki">Khaki</option>
                </select>
                <!--Sections:<input type="number" min="1">-->
                <input type="submit" name="button">
                <!--https://www.npmjs.com/package/tags-input-->
            </form>
        </div>
    </body>
</html>
