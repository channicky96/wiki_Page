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
        <link rel="stylesheet" href="/NoodlesWiki/w3.css" type="text/css">
        <!--import icons-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="/NoodlesWiki/pages.css" type="text/css">
        <link rel="Shortcut Icon" href="noodleswiki.ico">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.css">
        <!--markdown editor-->
        <script src="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.js"></script>
        <!--html to markdown converter-->
        <script src="https://unpkg.com/turndown/dist/turndown.js"></script>

    </head>
    <body class="w3-light-grey">
        <%@ include file="template.jsp" %>

        <div class="w3-container">
            <!--<form action="/NoodlesWiki/article/" method="post">-->
            <p>${title}</p>
            <form>
                <textarea id="editor" name="editor">${content}</textarea>
                <button onclick="debug()">Finish</button>
                <!--<button type="submit">Finish</button>-->
            </form>
        </div>
        <script>
            var simplemde = new SimpleMDE({element: document.getElementById("editor")});
            function debug() {
                alert(simplemde.options.previewRender(simplemde.value()));
                var turndownService = new TurndownService();
//                alert(turndownService.turndown(simplemde.options.previewRender("This is *example* Markdown")));
            }

        </script>
        <%@include file="end_template.jspf" %>
    </body>
</html>