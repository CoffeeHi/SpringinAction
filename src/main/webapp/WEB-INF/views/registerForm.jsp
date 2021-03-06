<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/24 0024
  Time: 下午 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" session="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<html>
<head>
    <title>Spitter</title>
    <style>
        label.error {
            color: red;
        }
        input.error {
            background-color: #FFCCCC;
        }
        div.errors {
            background-color: #FFCCCC;
            border: 2px solid red;
        }
    </style>
</head>
<body>
<h1>Register</h1>
<sf:form method="post" commandName="spitter" enctype="multipart/form-data">
    <sf:errors path="*" element="div" cssClass="errors"/>
    <sf:label path="firstName" cssErrorClass="error">First Name</sf:label>: <sf:input path="firstName" cssErrorClass="error"/><br/>
    <sf:label path="lastName" cssErrorClass="error">Last Name</sf:label>: <sf:input path="lastName" cssErrorClass="error"/><br/>
    <sf:label path="username" cssErrorClass="error">Username</sf:label>: <sf:input path="username" cssErrorClass="error"/><br/>
    <sf:label path="password" cssErrorClass="error">Password</sf:label>: <sf:password path="password" cssErrorClass="error"/><br/>
    <input type="file" name="profilePicture" accept="image/jpeg,image/png,image/gif"/><br/>
    <input type="submit" value="Register">
</sf:form>
</body>
</html>
