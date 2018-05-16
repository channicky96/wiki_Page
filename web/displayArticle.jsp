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

            function basketalert() {
                alert("Article added into Basket");
            }

            function ratingAlert() {
                alert("Please login to rate");
                location.reload();
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${name}</title>
        <link rel="stylesheet" href="/NoodlesWiki/w3.css" type="text/css">
        <!--import icons-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="Shortcut Icon" href="/NoodlesWiki/noodleswiki.ico">
        <link rel="stylesheet" href="/NoodlesWiki/pages.css" type="text/css">
    </head>
    <body class="w3-light-grey">
        <%@ include file="template.jsp" %>
        <%            String name = (String) session.getAttribute("name");
            int articleID = (Integer) session.getAttribute("pageid");
            int userID = (Integer) session.getAttribute("userID");
            int chk = (Integer) session.getAttribute("bookmark");
            double newrating = (Double) session.getAttribute("newrating");
        %>
        <article class="w3-white w3-container w3-padding-large">
            <h1 class="w3-serif w3-bottombar">${name}
                <%
                    if (loginchk != null) {
                %>
                <form style="display:inline;"action="/NoodlesWiki/article/" method="POST">
                    <fieldset class="rating">
                        <input type="radio" name="stars" id="4_stars" value="four" <%if (4.0 < newrating && newrating <= 5.0) {
                                out.print("checked");
                            }%> onchange='this.form.submit();'>
                        <label class="stars" for="4_stars">4 stars</label>
                        <input type="radio" name="stars" id="3_stars" value="three" <%if (3.0 < newrating && newrating <= 4.0) {
                                out.print("checked");
                            }%> onchange='this.form.submit();'>
                        <label class="stars" for="3_stars">3 stars</label>
                        <input type="radio" name="stars" id="2_stars" value="two" <%if (2.0 < newrating && newrating <= 3.0) {
                                out.print("checked");
                            }%> onchange='this.form.submit();'>
                        <label class="stars" for="2_stars">2 stars</label>
                        <input type="radio" name="stars" id="1_stars" value="one" <%if (1.0 < newrating && newrating <= 2.0) {
                                out.print("checked");
                            }%> onchange='this.form.submit();'>
                        <label class="stars" for="1_stars">1 star</label>
                        <input type="radio" name="stars" id="0_stars" value="zero" <%if (0.0 < newrating && newrating <= 1.0) {
                                out.print("checked");
                            }%> required onchange='this.form.submit();'>
                        <label  class="stars" for="0_stars">0 star</label>
                    </fieldset>
                    <input type="hidden" name="keyword" value="${name}"/>
                </form>
                <%
                } else {
                %>
                <fieldset class="rating">
                    <input type="radio" name="stars" id="4_stars" value="four" <%if (4.0 < newrating && newrating <= 5.0) {
                            out.print("checked");
                        }%> onchange='ratingAlert();'>
                    <label class="stars" for="4_stars">4 stars</label>
                    <input type="radio" name="stars" id="3_stars" value="three" <%if (3.0 < newrating && newrating <= 4.0) {
                            out.print("checked");
                        }%> onchange='ratingAlert();'>
                    <label class="stars" for="3_stars">3 stars</label>
                    <input type="radio" name="stars" id="2_stars" value="two" <%if (2.0 < newrating && newrating <= 3.0) {
                            out.print("checked");
                        }%> onchange='ratingAlert();'>
                    <label class="stars" for="2_stars">2 stars</label>
                    <input type="radio" name="stars" id="1_stars" value="one" <%if (1.0 < newrating && newrating <= 2.0) {
                            out.print("checked");
                        }%> onchange='ratingAlert();'>
                    <label class="stars" for="1_stars">1 star</label>
                    <input type="radio" name="stars" id="0_stars" value="zero" <%if (0.0 < newrating && newrating <= 1.0) {
                            out.print("checked");
                        }%> required onchange='ratingAlert();'>
                    <label  class="stars" for="0_stars">0 star</label>
                </fieldset>
                <input type="hidden" name="keyword" value="${name}"/>
                <% }
                %>
                <%
                    if (loginchk != null && chk == 1) {
                        out.print("<a href=\"javascript:void(0)\" onclick=\"toggleEdit()\" id=\"edit\" class=\"w3-text-light-blue w3-large\">[edit]</a>");
                        out.print("<a onclick=\"bookmarkRemove()\" href=\"/NoodlesWiki/article/?keyword=" + name + "&bml=rbm\"><i class=\"fas fa-bookmark w3-xlarge w3-button\" title=\"Bookmark\"></i></a>");
                    } else if (loginchk != null) {
                        out.print("<a href=\"javascript:void(0)\" onclick=\"toggleEdit()\" id=\"edit\" class=\"w3-text-light-blue w3-large\">[edit]</a>");
                        out.print("<a onclick=\"bookmarkAdd()\" href=\"/NoodlesWiki/article/?keyword=" + name + "&bml=abm\"><i class=\"far fa-bookmark w3-xlarge w3-button\" title=\"Bookmark\"></i></a>");
                    } else {
                        out.print("<a onclick=\"loginAlert()\"><i class=\"far fa-bookmark w3-xlarge w3-button\" title=\"Bookmark\"></i></a>");
                    }
                %>      
                <a href="/NoodlesWiki/article/?basket=basket" onclick="basketalert()" >
                    <i class="fas fa-cart-plus w3-xlarge w3-button"></i>
                </a>
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
                    <h3>${section.title} 
                        <a class="hiding w3-hide w3-button w3-white w3-border w3-small w3-padding-small" href="/NoodlesWiki/article/?articleID=${pageid}&paraID=${section.order}" class="w3-text-light-blue w3-small">[edit]</a>
                        <form action="/NoodlesWiki/article/" method="POST" onsubmit="return removeConfirm()"
                              style="display:inline;">
                            <button class="hiding w3-hide w3-padding-small w3-small w3-red w3-button"
                                    id="removeSection" class="w3-button w3-black" type="submit">remove section</button>
                            <input type="hidden" name="keyword" value="${name}"/>
                            <input type="hidden" name="articleID" value="${pageid}"/>
                            <input type="hidden" name="paraID" value="${section.order}" />
                            <input type="hidden" name="removeSection" value="1" />
                        </form>
                    </h3>
                    <p>${section.content}</p>
                </div>
            </c:forEach>
            <div class="w3-margin-top w3-container w3-hide hiding">
                <a href="/NoodlesWiki/article/?articleID=${pageid}&paraID=-1" id="newSection" class="w3-button w3-black">+</a> Add section
            </div>

            <h3>Comments:</h3>
            <table class="w3-table w3-bordered">
                <tr>
                    <th>NickName</th>
                    <th>Comment</th>
                    <th>Date & Time</th>
                </tr>

                <c:forEach var="cmt" items="${comments}">
                    <tr>
                        <td><a <%if(loginchk!=null){%>href="/NoodlesWiki/ProfileServlet?userprofile=${cmt.username}"<%}%>>${cmt.username}</a></td>
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

            <% } else {
            %>

            <div class="w3-margin-left w3-left">
                <input class="w3-input" type="text" name="comment" placeholder="Please login to comment" required> <br>
                <input onclick="loginAlert()" class="w3-block w3-button w3-black" type="submit">
            </div>

            <%   }
            %>
        </article>
        <div class="w3-right-align w3-text-dark-grey" style="width:100%">last edited on ${last_edit}</div>
        <%@ include file="end_template.jspf" %>
        <script>
            function toggleEdit() {
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
            function removeConfirm() {
                var w = confirm("Remove this section?");
                if (w == true) {
                    alert("removed!");
                    return true;
                }
                return false;
            }

        </script>
    </body>
</html>