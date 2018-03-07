<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="wiki.Category"%>

<%-- 
    Document   : category_list
    Created on : 2018-3-3, 14:58:50
    Author     : btk16xmu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="cList" scope="session" class="wiki.Category" />
<ul>
    <li><% out.println("ttttt");%></li>
    <c:forEach var="item" items="${cList.list}">
        <li>${item}</li>
    </c:forEach>
    <li><jsp:getProperty name="cList" property="name" /></li>
</ul>