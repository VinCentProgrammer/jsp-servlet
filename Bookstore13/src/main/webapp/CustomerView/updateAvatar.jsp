<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Thay đổi ảnh đại diện</title>
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
<%
String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
%>
<link rel="stylesheet" type="text/css"
	href="<%=url%>/public/css/index.css">
<script src="<%=url%>/public/js/index.js"></script>
</head>
<body>
	<%
	Object customerObject = session.getAttribute("khachHang");
	Customer customer = null;
	if (customerObject != null) {
		customer = (Customer) customerObject;
	}
	if (customer != null) {
		String imgPath = customer.getImgPath();
	%>

	<div class="container">
		<jsp:include page="../header.jsp"></jsp:include>

		<div class="text-center">
			<h1>THAY ĐỔI AVATAR</h1>
		</div>
		
		<form class="form" action="<%=url %>/customer-update-avatar" method="POST" enctype="multipart/form-data">
			<div class="row">
				<div class="col-sm-6">
					<h3>Tài khoản</h3>
					<img alt="" src="<%=url %>/uploadFile/<%=imgPath%>">
					<div class="mb-3">
						<label for="uploadAvatar" class="form-label">Avatar</label> 
						<input type="file" class="form-control" id="uploadAvatar" name="uploadAvatar" required="required">
					</div>
					
					<input class="btn btn-primary form-control" type="submit"
						value="Đăng ký" name="submit" id="submit"/>
				</div>
			</div>
		</form>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
	
	<%} %>
</body>


</html>