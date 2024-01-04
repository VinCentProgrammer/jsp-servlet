<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Đăng nhập</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous"></script>

<!-- Custom styles for this template -->
<%
String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
%>
<link href="<%=url%>/public/css/login.css" rel="stylesheet">

</head>
<body>
	<%
	String username = request.getAttribute("username") + "";
	username = username.equals("null") ? "" : username;
	%>
	<main class="form-signin w-100 m-auto">
		<form class="text-center" action="../customer" method="POST">
		<input type="hidden" name="customer_act" value="login"/>
			<img class="mb-4" src="<%=url%>/img/logo/logo.png" alt="" width="72">
			<h1 class="h3 mb-3 fw-normal">ĐĂNG NHẬP</h1>
			<%
			String baoLoi = request.getAttribute("baoLoi") + "";
			if (baoLoi.equals("null")) {
				baoLoi = "";
			}
			%>
			<div class="text-center">
				<span class="red"><%=baoLoi%></span>
			</div>
			<div class="form-floating">
				<input type="text" class="form-control" id="username"
					placeholder="Tên đăng nhập" name="username" value="<%=username%>">
				<label for="username">Tên đăng nhập</label>
			</div>
			<div class="form-floating">
				<input type="password" class="form-control" id="password"
					placeholder="Mật khẩu" name="password"> <label
					for="password">Mật khẩu</label>
			</div>

			<div class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me">
					Ghi nhớ tài khoản này
				</label>
			</div>
			<button class="w-100 btn btn-lg btn-primary" type="submit">Đăng
				nhập</button>
			<a href="<%=url %>/CustomerView/register.jsp">Đăng ký tài khoản mới</a>
			<p class="mt-5 mb-3 text-muted">&copy; 2017–2025</p>
		</form>
	</main>
</body>
</html>