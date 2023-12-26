<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String hoVaTen = request.getParameter("hoVaTen");
	String email = request.getParameter("email");
	String soLuong = request.getParameter("soLuong");
	%>
	
	<p>
		Cảm ơn  <%=hoVaTen %> đã đặt <%=soLuong %> đơn hàng. Mọi thông tin liên hệ email: <%=email %> 
		
	</p>
</body>
</html>