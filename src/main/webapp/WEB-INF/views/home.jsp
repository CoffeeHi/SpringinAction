<%--
  Created by IntelliJ IDEA.
  User: 陈祥
  Date: 2016/8/23
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Spittr</title>
</head>
<body>
<h1><s:message code="spitter.welcome"/></h1>
<a href="<c:url value="/spittles" />">Spittles</a>
<a href="<c:url value="/spitter/register" />">Register</a>
</body>
</html>
