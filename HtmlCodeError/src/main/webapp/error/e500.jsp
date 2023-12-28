<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Server Error</title>
</head>
<body>
	<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getLocalPort()
			+ request.getContextPath();
	%>
	<h1>Server Error</h1>
	<img alt="Not Found" src="<%=path %>/img/500.png">
</body>
</html>