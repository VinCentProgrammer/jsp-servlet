<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.lang.Math" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Example JSP</title>
</head>
<body>	
	<%
		int a = 10;
		int b = 20;
		int sum = a + b;
		double sqrtSum = Math.sqrt(sum);
	%>
	
	<p>
	Tổng <%=a %> + <%=b %> la: <b><%=sum %></b>
	</p>
	<p>
	Căn bậc 2  của <%=sum %> la: <b><%=sqrtSum %></b>
	</p>
</body>
</html>