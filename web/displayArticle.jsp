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
        <script>
            function bookmarkAdd() {
                alert("Bookmark Added");
            }
            function bookmarkRemove() {
                alert("Bookmark Removed");
            }
        </script>
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
            <h1 class="w3-serif w3-bottombar">${name}

                <a href="/NoodlesWiki/articleeditor.jsp" class="w3-text-light-blue w3-large">[edit]</a>
                <a class="w3-right" id="article_rate">Rate:<i class="far fa-star w3-button"></i><i class="far fa-star w3-button"></i><i class="far fa-star w3-button"></i><i class="far fa-star w3-button"></i><i class="far fa-star w3-button"></i>
                        <%                    String name = (String) session.getAttribute("name");
                            int articleID = (Integer) session.getAttribute("pageid");
                            int userID = (Integer) session.getAttribute("userID");
                            int chk = (Integer) session.getAttribute("bookmark");
                            if (loginchk != null && chk == 1) {
                                out.print("<a onclick=\"bookmarkRemove()\" href=\"/NoodlesWiki/article/?keyword=" + name + "&bml=rbm\"><i class=\"fas fa-bookmark w3-xlarge w3-button\" title=\"Bookmark\"></i></a>");
                            } else if (loginchk != null) {
                                out.print("<a onclick=\"bookmarkAdd()\" href=\"/NoodlesWiki/article/?keyword=" + name + "&bml=abm\"><i class=\"far fa-bookmark w3-xlarge w3-button\" title=\"Bookmark\"></i></a>");
                            } else {
                                out.print("<a onclick=\"loginAlert()\" href=\"/NoodlesWiki/article/?keyword=" + name + "&bml=nli\"><i class=\"far fa-bookmark w3-xlarge w3-button\" title=\"Bookmark\"></i></a>");
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
                    <h3>${section.title} <a href="#${section.title}" class="w3-text-light-blue w3-small">[edit]</a></h3>
                    <p>${section.content}</p>
                </div>
            </c:forEach>
            <article>

                <h3>Comments:</h3>
                <table class="w3-table w3-bordered">
                    <tr>
                        <th>NickName</th>
                        <th>Comment</th>
                        <th>Date & Time</th>
                    </tr>

                    <c:forEach var="cmt" items="${comments}">
                        <tr>
                            <td>${cmt.username}</td>
                            <td>${cmt.comment}</td>
                            <td>${cmt.timestamp}</td>
                        </tr>
                    </c:forEach>
                </table>
                <%
                    String username = (String) session.getAttribute("username");
                    if (username != null) {
                %>
                <div class="w3-margin-left w3-left">
                    <form action="/NoodlesWiki/article/" method="post">
                        <!--Write a Comment:--> 
                        <input class="w3-input" type="text" name="comment" placeholder="Write comment" required> <br>
                        <input class="w3-block w3-button w3-black" type="submit" name="postComment" value="postComment" >
                    </form>
                </div>   
                <% }else{
                %>
                <div class="w3-margin-left w3-left">
                    
                        <input class="w3-input" type="text" name="comment" placeholder="Please login to comment" required> <br>
                        <input onclick="loginAlert()" class="w3-block w3-button w3-black" type="submit">
                    
                </div>
                 <%   }
                %>

                <%@ include file="end_template.jspf" %>



                </body>
                </html>
