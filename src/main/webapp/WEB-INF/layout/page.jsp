<%--
  Created by IntelliJ IDEA.
  User: 陈祥
  Date: 2016/8/26
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@page session="false" %>
<html>
<head>
    <title>Spittr</title>
</head>
<body>
<div class="header">
    <t:insertAttribute name="header"/>
</div>

<div class="content">
    <t:insertAttribute name="body"/>
</div>

<div class="footer">
    <t:insertAttribute name="footer"/>
</div>
</body>
</html>
