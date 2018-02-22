<%-- 
    Document   : index
    Created on : 2018-2-22, 10:57:45
    Author     : placy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="w3.css" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <style>
            .w3-sidebar {
                z-index: 3;
                width: 200px;
                top: 43px;
                bottom: 0;
                height: inherit;
            }
        </style>

    </head>
    <body class="w3-light-grey">
        <!-- Navbar on top-->
        <div class="w3-top">
            <div class="w3-bar w3-top w3-black w3-left-align w3-large">
                <a class="w3-bar-item w3-button w3-right w3-hide-large w3-hover-white w3-large" href="javascript:void(0)" onclick="w3_open()">
                    <i class="fa fa-bars w3-xlarge"></i>
                </a>
                <a href="#" class="w3-bar-item w3-button">NoodlesWiki</a>
            </div>
        </div>
        <!-- Sidebar -->
        <nav class="w3-sidebar w3-bar-block w3-collapse w3-large w3-animate-left" id="sidebar">
            <a href="javascript:void(0)" onclick="w3_close()" class="w3-right w3-padding-large w3-hover-black w3-hide-large" title="Close Menu">
                <i class="fa fa-close"></i>
            </a>
            <h4 class="w3-bar-item"><b>Menu</b></h4>
            <a class="w3-bar-item w3-button w3-hover-black" href="#">Link</a>
            <a class="w3-bar-item w3-button w3-hover-black" href="#">Link</a>
            <a class="w3-bar-item w3-button w3-hover-black" href="#">Link</a>
            <a class="w3-bar-item w3-button w3-hover-black" href="#">Link</a>
        </nav>
        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

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

        <script>
// Get the Sidebar
            var mySidebar = document.getElementById("sidebar");

// Get the DIV with overlay effect
            var overlayBg = document.getElementById("myOverlay");

// Toggle between showing and hiding the sidebar, and add overlay effect
            function w3_open() {
                if (mySidebar.style.display === 'block') {
                    mySidebar.style.display = 'none';
                    overlayBg.style.display = "none";
                } else {
                    mySidebar.style.display = 'block';
                    overlayBg.style.display = "block";
                }
            }

// Close the sidebar with the close button
            function w3_close() {
                mySidebar.style.display = "none";
                overlayBg.style.display = "none";
            }
        </script>

    </body>
</html>
