<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
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
</head>
<body>
	<div class="container">
		<form action="loginAction.jsp" method="POST">
		
			<div class="mb-3">
				<label for="username" class="form-label">Username</label> 
				<input type="text" class="form-control" id="username" name="username">
			</div>
			
			<div class="mb-3">
				<label for="password" class="form-label">Password</label> 
				<input type="password" class="form-control" id="password" name="password">
			</div>

			<div class="mb-3 form-check">
				<input type="checkbox" class="form-check-input" id="remember-me">
				<label class="form-check-label" for="remember-me">Remember me</label>
			</div>
			
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>