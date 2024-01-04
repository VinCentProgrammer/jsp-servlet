<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password Page</title>
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
	<%
	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
	%>
	<%
	Object customerObject = session.getAttribute("khachHang");
	Customer customer = null;
	if (customerObject != null) {
		customer = (Customer) customerObject;
	}
	if (customer != null) {
		String messageError = request.getAttribute("messageError") + "";
	%>
	<div class="container m-3">
		<div class="row">
			<div class="col-md-6">
				<div class="card card-outline-secondary">
					<div class="text-danger m-2"><%=messageError.equals("null") ? "" : messageError%></div>
					<div class="card-header">
						<h3 class="mb-0">Change Password</h3>
					</div>
					<div class="card-body">
						<form class="form" role="form" autocomplete="off"
							action="../customer" method="POST">
							<input type="hidden" name="customer_act" value="change-pass" />
							<div class="form-group">
								<label for="inputPasswordOld">Current Password</label> <input
									type="password" name="passwordOld" class="form-control"
									id="inputPasswordOld" required="required">
							</div>
							<div class="form-group">
								<label for="inputPasswordNew">New Password</label> <input
									type="password" class="form-control" id="inputPasswordNew"
									name="passwordNew" required="required">
							</div>
							<div class="form-group">
								<label for="inputPasswordNewConfirm">New Confirm
									Password</label> <input type="password" class="form-control"
									id="inputPasswordNewConfirm" name="passwordNewConfirm"
									required="required">
							</div>
							<div class="form-group mt-2">
								<button type="submit" class="btn btn-success btn-lg float-right">Save</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%
	} else {
	%>
	<h1>
		Vui lòng đăng nhập! Quay lại <a href="<%=url %>/index.jsp">trang chủ </a>
	</h1>
	<%
	}
	%>
</body>
</html>