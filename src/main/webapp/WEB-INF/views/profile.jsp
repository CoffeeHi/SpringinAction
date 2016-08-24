<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/24 0024
  Time: 下午 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<h1>Your Profile</h1>
<c:out value="${spitter.username}"/><br/>
<c:out value="${spitter.firstName}"/><br/>
<c:out value="${spitter.lastName}"/><br/>
</body>
</html>
