<%-- 
    Document   : template
    Created on : 2018-3-2, 15:15:23
    Author     : btk16xmu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="/NoodlesWiki/nav.js" type="text/javascript"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Navbar on top-->
<div class="w3-top">
    <div class="w3-bar w3-top w3-black w3-large">
        <a href="/NoodlesWiki/index.jsp" class="w3-bar-item w3-button" title="Home page">NoodlesWiki</a>
        <a class="w3-bar-item w3-button w3-right w3-hide-large w3-hover-white" href="javascript:void(0)" onclick="openBar()">
            <!--menu icon-->
            <i class="fa fa-bars w3-xlarge"></i>
        </a>
        <!--Basket icon only appears if user is logged in-->
        <%
            String loginchk1 = (String) session.getAttribute("username");
            if (loginchk1 != null) {
        %>

        <a href="/NoodlesWiki/ProfileServlet" class ="w3-bar-item w3-button w3-right w3-hover-white">
            <!--user icon-->
            <i class="fa fa-user w3-xlarge" title="Log in/Register"></i>
        </a>
        <a href="/NoodlesWiki/article/?download=download" class ="w3-bar-item w3-button w3-right w3-hover-white">           
            <i class="fas fa-shopping-cart" title="Basket"></i>
        </a> 
        <%
        } else {
        %>
        <a href="/NoodlesWiki/login.jsp" class ="w3-bar-item w3-button w3-right w3-hover-white">
            <!--user icon-->
            <i class="fa fa-user w3-xlarge" title="Log in/Register"></i>
        </a>
        <%
            }
        %>
        <!--Logout icon only appears if user is logged in-->
        <%
            String loginchk = (String) session.getAttribute("username");
            String Nickname = (String) session.getAttribute("userNickname");
            if (loginchk != null) {
                out.print("<div class=\"w3-bar-item w3-animate-opacity\">Welcome back " + Nickname + " !</div>");
                out.print("<form class=\"w3-bar-item w3-right\" style=\"padding:0px;\" action=\"/NoodlesWiki/ControllerServlet\" method=\"post\">");
                out.print("<input class=\"w3-button w3-right w3-black w3-hover-white\" type=\"submit\" name=\"button\" value=\"Logout\">");
                out.print("</form>");
                out.print("<a href=\"/NoodlesWiki/newArticle.jsp\" class =\"w3-bar-item w3-button w3-right w3-hover-white\">"
                        + "<i class=\"fas fa-plus\"></i></a>");
            } else {
                out.print("<div class=\"w3-bar-item w3-animate-opacity\">Welcome Visitor</div>");
            }
        %>
        <div class="w3-right w3-cell-top">
            <form action="/NoodlesWiki/article/" method="post">
                <input id="search_input" class="w3-border w3-round-large w3-padding-small" type="text" name="keyword" placeholder="Search.." required>
                <button class="w3-bar-item w3-button w3-black w3-right w3-round-large" type="submit" name="submit"><i class="fa fa-search"></i></button>
            </form>
        </div>

    </div>
</div>
<!-- Sidebar -->
<nav class="w3-sidebar w3-bar-block w3-collapse w3-large" id="sidebar">
    <a href="javascript:void(0)" onclick="closeBar()" class="w3-right w3-padding-large w3-hover-black w3-hide-large" title="Close Menu">
        <i class="fa fa-close"></i>
    </a>
    <h4 class="w3-bar-item"><b>Menu</b></h4>
    <a class="w3-bar-item w3-button w3-hover-black" href="/NoodlesWiki/categories">Categories</a>
    <%
        if (loginchk1 != null) {
    %>
    <a class="w3-bar-item w3-button w3-hover-black" href="/NoodlesWiki/article/?newsfeed=true">Newsfeed</a>
    <a class="w3-bar-item w3-button w3-hover-black" href="#">Link</a>
    <%}
    %>
</nav>
<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="closeBar()" style="cursor:pointer" title="close side menu" id="overlay"></div>


<!-- shift 200px when sidebar visible -->
<div class="w3-main" style="margin-left:200px; margin-top:43px;">
