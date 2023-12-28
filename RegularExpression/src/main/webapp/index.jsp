<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Regular Expression</title>
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
	<div class="container m-5">
	<%
	String numOrderError = request.getAttribute("numOrderError") + "";
	String phoneNumberError = request.getAttribute("phoneNumberError") + "";
	String emailError = request.getAttribute("emailError") + "";
	
	numOrderError = (!numOrderError.equals("null")) ? numOrderError : "";
	phoneNumberError = (!phoneNumberError.equals("null")) ? phoneNumberError : "";
	emailError = (!emailError.equals("null")) ? emailError : "";
	
	
	String numOrder = request.getAttribute("numOrder") + "";
	String phoneNumber = request.getAttribute("phoneNumber") + "";
	String email = request.getAttribute("email") + "";
	
	
	%>
		<form action="buy-action" method="POST">
			Số lượng: 
			<input type="text" name="numOrder" class="form-control" required="required" value="<%=numOrder%>"/> 
			<span style="color: red"><%=numOrderError %></span> <br>
			Số điện thoại: 
			<input type="text" name="phone-number" class="form-control" required="required" value="<%=phoneNumber%>"/> 
			<span style="color: red"><%=phoneNumberError %></span> <br>
			Email: 
			<input type="text" name="email" class="form-control" required="required" value="<%=email%>"/> 
			<span style="color: red"><%=emailError %></span> <br>
			
			<input type="submit" value="Mua hàng" class="form-control btn btn-primary mt-2"/>
		</form>
	</div>
</body>

</html>