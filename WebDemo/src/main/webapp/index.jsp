<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 1/1/2024
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page Home</title>
</head>
<body>
<%
    java.lang.String username = request.getAttribute("username") + "";
    java.lang.String password = request.getAttribute("password") + "";


%>
<form action="my-servlet" method="post">
    <label for="username">Username</label><br>
    <input type="text" name="username" id="username"><br>
    <label for="password">Password</label><br>
    <input type="password" name="password" id="password"><br><br>
    <input type="submit" value="Login">
</form>
<p>

    Thong tin
    Username <%=username%>
    Password <%=password%>
</p>
</body>
</html>
