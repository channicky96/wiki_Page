<%-- 
    Document   : index
    Created on : 2018-2-22, 10:57:45
    Author     : noodlesEngineering
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Noodles Wiki</title>
        <link rel="stylesheet" href="w3.css" type="text/css">
        <!--import icons-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <style>
            .w3-sidebar {
                z-index: 3;
                width: 200px;
                top: 43px;
                bottom: 0;
                height: inherit;
            }
            #search_input {
                height: 43px;
            }
        </style>

    </head>
    <body class="w3-light-grey">
        <!-- Navbar on top-->
        <div class="w3-top">
            <div class="w3-bar w3-top w3-black w3-large">
                <a href="index.jsp" class="w3-bar-item w3-button">NoodlesWiki</a>
                <a class="w3-bar-item w3-button w3-right w3-hide-large w3-hover-white w3-large" href="javascript:void(0)" onclick="openBar()">
                    <i class="fa fa-bars w3-xlarge"></i>
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
            <a class="w3-bar-item w3-button w3-hover-black" href="#">Categories</a>
            <a class="w3-bar-item w3-button w3-hover-black" href="#">Link</a>
            <a class="w3-bar-item w3-button w3-hover-black" href="#">Link</a>
            <a class="w3-bar-item w3-button w3-hover-black" href="#">Link</a>
        </nav>
        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large" onclick="closeBar()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

        <!-- shift 200px when sidebar visible -->
        <div class="w3-main" style="margin-left:200px; margin-top:43px;">
            <!-- First Photo Grid-->
            <div class="w3-row-padding">
                <div class="w3-third w3-container w3-margin-bottom">
                    <img src="https://i.imgur.com/OvMZBs9.jpg" alt="" style="width:100%" class="w3-hover-opacity">
                    <div class="w3-container w3-white">
                        <p><b>Lorem Ipsum</b></p>
                        <p>Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla.</p>
                    </div>
                </div>
                <div class="w3-third w3-container w3-margin-bottom">
                    <img src="https://i.imgur.com/OvMZBs9.jpg" alt="" style="width:100%" class="w3-hover-opacity">
                    <div class="w3-container w3-white">
                        <p><b>Lorem Ipsum</b></p>
                        <p>Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla.</p>
                    </div>
                </div>
                <div class="w3-third w3-container w3-margin-bottom">
                    <img src="https://i.imgur.com/OvMZBs9.jpg" alt="" style="width:100%" class="w3-hover-opacity">
                    <div class="w3-container w3-white">
                        <p><b>Lorem Ipsum</b></p>
                        <p>Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla.</p>
                    </div>
                </div>
            </div>
        </div>

        <!-- Pagination -->
        <div class="w3-center w3-padding-32">
            <div class="w3-bar">
                <a href="#" class="w3-bar-item w3-button w3-hover-black">«</a>
                <a href="#" class="w3-bar-item w3-black w3-button">1</a>
                <a href="#" class="w3-bar-item w3-button w3-hover-black">2</a>
                <a href="#" class="w3-bar-item w3-button w3-hover-black">3</a>
                <a href="#" class="w3-bar-item w3-button w3-hover-black">4</a>
                <a href="#" class="w3-bar-item w3-button w3-hover-black">»</a>
            </div>
        </div>

        <script src="nav.js"></script>

    </body>
</html>
