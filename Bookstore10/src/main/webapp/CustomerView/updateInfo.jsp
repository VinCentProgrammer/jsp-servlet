<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Đăng ký</title>
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
		String fullname = customer.getFullname();
		String gender = customer.getGender();
		String dateOfBirth = customer.getDateOfBirth().toString();
		String customerAddress = customer.getAddress();
		String purchaseAddress = customer.getPurchaseAddress();
		String deliveryAddress = customer.getDeliveryAddress();
		String phoneNumber = customer.getPhoneNumber();
		String email = customer.getEmail();
		boolean acceptMail = customer.isSubscription();
	%>

	<div class="container">
		<jsp:include page="../header.jsp"></jsp:include>
		<div class="text-center">
			<h1>ĐĂNG KÝ TÀI KHOẢN</h1>
		</div>

		<form class="form" action="../customer" method="POST">
			<input type="hidden" name="customer_act" value="update-info" />
			<div class="row">
				<div class="col-sm-6">
					<h3>Thông tin khách hàng</h3>
					<div class="mb-3">
						<label for="fullname" class="form-label">Họ và tên</label> <input
							type="text" class="form-control" id="fullname" name="fullname"
							value="<%=fullname%>">
					</div>
					<div class="mb-3">
						<label for="gender" class="form-label">Giới tính</label> <select
							class="form-control" id="gender" name="gender">
							<option></option>
							<option value="Male"
								<%=gender.equals("Male") ? "selected='selected'" : ""%>>Nam</option>
							<option value="Female"
								<%=gender.equals("Female") ? "selected='selected'" : ""%>>Nữ</option>
							<option value="Other"
								<%=gender.equals("Other") ? "selected='selected'" : ""%>>Khác</option>
						</select>
					</div>
					<div class="mb-3">
						<label for="dateOfBirth" class="form-label">Ngày sinh</label> <input
							type="date" class="form-control" id="dateOfBirth"
							name="dateOfBirth" value="<%=dateOfBirth%>">
					</div>
				</div>
				<div class="col-sm-6">
					<h3>Địa chỉ</h3>
					<div class="mb-3">
						<label for="customerAddress" class="form-label">Địa chỉ
							khách hàng</label> <input type="text" class="form-control"
							id="customerAddress" name="customerAddress"
							value="<%=customerAddress%>">
					</div>
					<div class="mb-3">
						<label for="purchaseAddress" class="form-label">Địa chỉ
							mua hàng</label> <input type="text" class="form-control"
							id="purchaseAddress" name="purchaseAddress"
							value="<%=purchaseAddress%>">
					</div>
					<div class="mb-3">
						<label for="deliveryAddress" class="form-label">Địa chỉ
							nhận hàng</label> <input type="text" class="form-control"
							id="deliveryAddress" name="deliveryAddress"
							value="<%=deliveryAddress%>">
					</div>
					<div class="mb-3">
						<label for="phoneNumber" class="form-label">Điện thoại</label> <input
							type="tel" class="form-control" id="phoneNumber"
							name="phoneNumber" value="<%=phoneNumber%>">
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> <input
							type="email" class="form-control" id="email" name="email"
							value="<%=email%>">
					</div>
					<hr />
					<div class="mb-3">
						<label for="acceptMail" class="form-label">Đồng ý nhận
							email</label> <input type="checkbox" class="form-check-input"
							id="acceptMail" name="acceptMail"
							<%=acceptMail ? "checked='checked'" : ""%>>
					</div>
					<input class="btn btn-primary form-control" type="submit"
						value="Lưu thông tin" name="submit" id="submit" />
				</div>
			</div>
		</form>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>

	<%
	} else {
	%>
	<h1>
		Vui lòng <a href="<%=url%>/CustomerView/login.jsp">đăng nhập</a>
	</h1>
	<%
	}
	%>
</body>


</html>