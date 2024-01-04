<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password Success Page</title>
<%
String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
%>
</head>
<body>
	<h1>Thay đổi mật khẩu thành công, 
	nhấn vào <a href="<%=url %>/index.jsp">đây</a> để trở lại trang chủ.
	</h1>
</body>
</html>