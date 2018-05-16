<%-- 
    Document   : login_success
    Created on : 09-Mar-2018, 13:27:08
    Author     : acc16scu
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Date"%>
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
            <c:forEach var="bmk" items="${bkmrklist}">

                <div class="w3-third w3-container w3-margin-bottom">
                    <div class="w3-container w3-white">
                        <p><b>${bmk}</b></p>
                        <p>Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla.</p>
                    </div>
                </div>
            </c:forEach>

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
