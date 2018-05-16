<%-- 
    Document   : index
    Created on : 2018-2-22, 10:57:45
    Author     : noodlesEngineering
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Date"%>
<%@page import="wiki.Newsfeed"%>

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
    </head>
    <body onload="startTime()" class="w3-light-grey">
        <%@ include file="template.jsp" %>

        <div class="w3-row-padding">
            <c:forEach var="bmk" items="${bmlist}">
                <div class="w3-third w3-container w3-margin-bottom">
                    <div style="max-height: 12em; overflow: hidden; background-image: linear-gradient(180deg,hsla(255,0%,100%,0),#fff);" class="w3-container w3-white">
                        <p><b><a href="/NoodlesWiki/article/?keyword=${bmk.title}">${bmk.title}</a></b></p>
                        <p>${bmk.preview}</p>
                    </div>
                </div>
            </c:forEach>

            <div class="w3-third w3-container w3-margin-bottom">
                <div class="w3-container w3-white">
                    <p><b><a href="/NoodlesWiki/article/?keyword=Java">Java</a></b></p>
                    <p>Java is object oriented. Unchanged C++ or C code will not work in Java, in most cases, though Java looks much like C and C++.</p>
                </div>
            </div>
            <div class="w3-third w3-container w3-margin-bottom">
                <div class="w3-container w3-white">
                    <p><b><a href="/NoodlesWiki/article/?keyword=JavaServer Pages">JavaServer Pages</a></b></p>
                    <p>JavaServer Pages (JSP) is a technology that helps software developers create dynamically generated web pages based on HTML, XML, or other document types. </p>
                </div>
            </div>
        </div>

        <h2 align="center" class="w3-container" id="clock"></h2>
        <script>
            function startTime() {
                var today = new Date();
                var h = today.getHours();
                var m = today.getMinutes();
                var s = today.getSeconds();
                m = checkTime(m);
                s = checkTime(s);
                var month = new Array();
                month[0] = "January";
                month[1] = "February";
                month[2] = "March";
                month[3] = "April";
                month[4] = "May";
                month[5] = "June";
                month[6] = "July";
                month[7] = "August";
                month[8] = "September";
                month[9] = "October";
                month[10] = "November";
                month[11] = "December";

                var weekday = new Array(7);
                weekday[0] = "Sun";
                weekday[1] = "Mon";
                weekday[2] = "Tue";
                weekday[3] = "Wed";
                weekday[4] = "Thu";
                weekday[5] = "Fri";
                weekday[6] = "Sat";

                var d = weekday[today.getDay()];
                var n = month[today.getMonth()];
                var str = d + " " + today.getDate() + " " + n + " "
                        + h + ":" + m + ":" + s + " " + today.getFullYear();
                document.getElementById('clock').innerHTML = str;

                var t = setTimeout(startTime, 500);
            }
            function checkTime(i) {
                if (i < 10) {
                    i = "0" + i
                }
                ;  // add zero in front of numbers < 10
                return i;
            }
        </script>
        <%@ include file="end_template.jspf" %>
    </body>
</html>
