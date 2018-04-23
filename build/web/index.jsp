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
        <link rel="stylesheet" href="/NoodlesWiki/w3.css" type="text/css">
        <!--import Font Awesome Icons-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="Shortcut Icon" href="noodleswiki.ico">
        <link rel="stylesheet" href="/NoodlesWiki/pages.css" type="text/css">

>>>>>>> 4520f52c5c4322c36f4af4270ce6a225cd6db6c4
    </head>
    <body class="w3-light-grey">
        <%@ include file="template.jsp" %>
        <!-- First Photo Grid-->
            <div class="w3-row-padding">
                <div class="w3-third w3-container w3-margin-bottom">
                    <img src="https://i.imgur.com/OvMZBs9.jpg" alt="" style="width:100%" class="w3-hover-opacity">
                    <div class="w3-container w3-white">
                        <p><b>article 1</b></p>
                        <p>Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla.</p>
                    </div>
                </div>
                <div class="w3-third w3-container w3-margin-bottom">
                    <img src="https://i.imgur.com/OvMZBs9.jpg" alt="" style="width:100%" class="w3-hover-opacity">
                    <div class="w3-container w3-white">
                        <p><b>article 2</b></p>
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
    </body>
</html>
