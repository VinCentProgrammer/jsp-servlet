<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<style>
	.home {
		width: 960px;
		margin: 0 auto;
	}
	main {
		min-height: 400px;
	}
</style>
</head>
<body>
	<%
		String username = (String)session.getAttribute("username");
	%>
	
	<%if(username == null) { %>
		<jsp:forward page="login.jsp"></jsp:forward>
	<%} else { %>
	
	<div class="home">
		<header>
			<p>Xin chào <%=username %>, chào mừng bạn đến với chúng tôi!!!</p>
			<p><a href="logout-action">Đăng xuất</a></p>
		</header>
		<main>
			<h1>Trang chủ</h1>
			<ul>
				<li><a href="detail-1.jsp">Trang chi tiết 1</a></li>
				<li><a href="detail-2.jsp">Trang chi tiết 2</a></li>
			</ul>	
		</main>
		
		<footer>
			<p>Bản quyền thuộc về Hà Văn Dũng</p>
		</footer>
	</div>
	<%} %>
</body>
</html>