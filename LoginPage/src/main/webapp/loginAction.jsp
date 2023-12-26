<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Action</title>
</head>
<body>
	<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	%>

	<%
	if (username.equalsIgnoreCase("dungken2112") && password.equals("dungken@!!@")) {
	%>
	<h1>Bạn đã đăng nhập thành công!</h1>
	<%
	} else {
	%>
	<h1>Bạn đã đăng nhập thất bại!</h1>
	<%
	}
	%>
</body>
</html>