<%-- 
    Document   : template
    Created on : 2018-3-2, 15:15:23
    Author     : btk16xmu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Navbar on top-->
<div class="w3-top">
    <div class="w3-bar w3-top w3-black w3-large">
        <a href="index.jsp" class="w3-bar-item w3-button" title="Home page">NoodlesWiki</a>
        <a class="w3-bar-item w3-button w3-right w3-hide-large w3-hover-white" href="javascript:void(0)" onclick="openBar()">
            <!--menu icon-->
            <i class="fa fa-bars w3-xlarge"></i>
        </a>
        <a class ="w3-bar-item w3-button w3-right w3-hover-white">
            <!--user icon-->
            <i class="fa fa-user w3-xlarge" title="Log in/Register"></i>
        </a>
        <div class="w3-right">
            <button class="w3-bar-item w3-button w3-black w3-right" type="submit"><i class="fa fa-search"></i></button>
            <input id="search_input" class="w3-border" type="text" placeholder="Search..">
        </div>

    </div>
</div>
<!-- Sidebar -->
<nav class="w3-sidebar w3-bar-block w3-collapse w3-large w3-animate-left" id="sidebar">
    <a href="javascript:void(0)" onclick="closeBar()" class="w3-right w3-padding-large w3-hover-black w3-hide-large" title="Close Menu">
        <i class="fa fa-close"></i>
    </a>
    <h4 class="w3-bar-item"><b>Menu</b></h4>
    <a class="w3-bar-item w3-button w3-hover-black" href="categories.jsp">Categories</a>
    <a class="w3-bar-item w3-button w3-hover-black" href="#">Link</a>
    <a class="w3-bar-item w3-button w3-hover-black" href="#">Link</a>
    <a class="w3-bar-item w3-button w3-hover-black" href="sandbox.jsp">Sandbox</a>
</nav>
<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="closeBar()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- shift 200px when sidebar visible -->
<div class="w3-main" style="margin-left:200px; margin-top:43px;">

<script src="nav.js"></script>

