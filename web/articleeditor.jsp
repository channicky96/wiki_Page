    <%-- 
    Document   : ArticleEditer
    Created on : 20-Apr-2018, 15:02:52
    Author     : acc16scu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Article Editor - NoodlesWiki</title>
        <link rel="stylesheet" href="w3.css" type="text/css">
        <!--import icons-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="pages.css" type="text/css">
        <link rel="Shortcut Icon" href="noodleswiki.ico">
        <!--        <script src="https://cloud.tinymce.com/stable/tinymce.min.js"></script>
                <script>tinymce.init({ selector:'textarea' });</script>-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.css">
        <script src="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.js"></script>
    </head>
    <body class="w3-light-grey">
        <%@ include file="template.jsp" %>
        <!--        <div id="edit"  contenteditable="true">
                    <p> hello </p>
                    <textarea>Next, start a free trial!</textarea>
                </div>-->
        <div class="w3-container">
            <form action="ArticleServlet" method="post">
            <textarea id="editor" name="editor"></textarea>
            <button type="submit">Finish</button>
            </form>
        </div>
        <script>
            var simplemde = new SimpleMDE({ element: document.getElementById("editor") });
        </script>
    </body>
</html>