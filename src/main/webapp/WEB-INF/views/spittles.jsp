<%@ page import="com.five.Spittle" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/24 0024
  Time: 上午 1:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${spittleList}" var="spittle">
<% List<Spittle> a = (ArrayList)request.getAttribute("spittleList");
    for (Spittle aa : a){
        System.out.println(aa.getMessage());
    }
     %>
    <li id="spittle_<c:out value="${spittle.id}"/>">
        <% System.out.println(1); %>
        <div class="spittleMessage">
            <c:out value="${spittle.message}"/>
        </div>
        <div>
            <span class="spittleTime"><c:out value="${spittle.time}"/></span>
            <span class="spittleLocation">
                (<c:out value="${spittle.latitude}"/>,
                <c:out value="${spittle.longtitude}"/>)
            </span>
        </div>
    </li>
</c:forEach>
</body>
</html>
