<%-- 
    Document   : articleEditer
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

    </head>
    <body class="w3-light-grey">
        <%@ include file="template.jsp" %>

        <div class="w3-container">
            <!--<p>${title}</p>-->
            <form action="/NoodlesWiki/article/" method="POST" onsubmit="makeHtml()">
                <textarea id="editor" name="editor">${content}</textarea>
                <!--pass article information back to article servlet-->
                <input class="w3-hide" name="editedArticleName" value="${aName}"/>
                <input class="w3-hide" name="editedArticle" value="${aID}"/>
                <input class="w3-hide" name="editedSection" value="${sID}"/>
                <input class="w3-hide" name="htmlText" id="html" />


                <button type="submit">Finish</button>
                <!--<button type="submit">Finish</button>-->
            </form>
        </div>
        <script>
            var simplemde = new SimpleMDE({
                //hide H icon
                hideIcons: ["heading"],
                element: document.getElementById("editor")});
            function makeHtml() {
                document.getElementById("html").value = simplemde.options.previewRender(simplemde.value());
            }
        </script>
        <%@include file="end_template.jspf" %>
    </body>
</html>