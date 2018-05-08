<%-- 
    Document   : displayArticle
    Created on : 23-Apr-2018, 11:27:24
    Author     : btk16xmu
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>displaying an article</title>
        <link rel="stylesheet" href="/NoodlesWiki/w3.css" type="text/css">
        <!--import icons-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="Shortcut Icon" href="noodleswiki.ico">
        <link rel="stylesheet" href="/NoodlesWiki/pages.css" type="text/css">
    </head>
    <body class="w3-light-grey">
        <%@ include file="template.jsp" %>
        <article class="w3-white w3-container w3-padding-large">
            <h1 class="w3-serif w3-bottombar">${article.name}
                <a href="javascript:void(0)" onclick="openEdit()" id="edit" class="w3-text-light-blue w3-large">[edit]</a>
                <a class="w3-right" id="article_rate">Rate:<i class="far fa-star w3-button"></i><i class="far fa-star w3-button"></i><i class="far fa-star w3-button"></i><i class="far fa-star w3-button"></i><i class="far fa-star w3-button"></i></a>
                        <%                    String name = (String) session.getAttribute("name");
                            int articleID = (Integer) session.getAttribute("pageid");
                            int userID = (Integer) session.getAttribute("userID");
                            int chk = (Integer) session.getAttribute("bookmark");
                            if (loginchk != null && chk == 1) {

                                out.print("<a href=\"/NoodlesWiki/article/?keyword=" + name + "\"><i class=\"fas fa-bookmark w3-xlarge w3-button\" title=\"Bookmark\"></i></a>");

                            } else if (loginchk != null) {
                                out.print("<a><i class=\"far fa-bookmark w3-xlarge w3-button\" title=\"Bookmark\"></i></a>");
                            } else {
                                out.print("<a onclick=\"loginAlert()\"><i class=\"far fa-bookmark w3-xlarge w3-button\" title=\"Bookmark\"></i></a>");
                            }
                        %>
            </h1>
            <div id="menu" class="w3-right w3-card w3-padding-small">
                <nav>
                    <h4 class="w3-center">Menu</h4>
                    <ol class="w3-container">
                        <c:forEach var="section" items="${sections}">
                            <li><a href="#${section.title}" class="w3-hover-shadow">${section.title}</a></li>
                            </c:forEach>
                    </ol>
                </nav>
            </div>
            <c:forEach var="section" items="${sections}">
                <div id="${section.title}" class="article_section w3-border-bottom">
                    <h3>${section.title} <a class="hiding w3-hide w3-button w3-white w3-border w3-small w3-padding-small" onclick="passPara()" href="/NoodlesWiki/article/?articleID=${article.id}&paraID=${section.order}" class="w3-text-light-blue w3-small">[edit]</a></h3>
                    <p>${section.content}</p>
                </div>
            </c:forEach>
            <div class="w3-container w3-padding-large w3-hide hiding">
                <button id="newSection" class="w3-button w3-black">+</button> Add section
            </div>
        </article>

        <script>
            function openEdit() {
                bts = document.getElementsByClassName("hiding");
                var i;
                for (i = 0; i < bts.length; i++) {
                    if (bts[i].className.indexOf("w3-hide") === -1) {
                        bts[i].className += " w3-hide";
                    } else {
                        bts[i].className = bts[i].className.replace(" w3-hide", "");
                    }
                }
            }
        </script>
        <%@ include file="end_template.jspf" %>

    </body>
</html>
