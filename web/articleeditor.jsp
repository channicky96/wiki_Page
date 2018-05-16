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
            <form action="/NoodlesWiki/article/" method="POST" onsubmit="return makeHtml()" class="w3-container">
                <label for="title">Title</label><br/>
                <input class="w3-input w3-border w3-round" id="title" name="editedTitle" value="${title}"/><br/>
                <label for="editor">Content</label>
                <textarea id="editor" name="editor">${content}</textarea>
                <!--pass article information back to article servlet-->
                <input type="hidden" name="editedArticleName" value="${aName}"/>
                <input type="hidden" name="editedArticle" value="${aID}"/>
                <input type="hidden" name="editedSection" value="${sID}"/>
                <input type="hidden" name="htmlText" id="html" />

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
                var content = simplemde.value();
                // validate form
                if (document.getElementById("title").value === '') {
                    alert("Title cannot be empty");
                    return false;
                }
                if (content === '') {
                    alert("Please write some content");
                    return false;
                }
                document.getElementById("html").value = simplemde.options.previewRender(content);
                return true;
            }
        </script>
        <%@include file="end_template.jspf" %>
    </body>
</html>