<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
	
	<link rel="stylesheet" type="text/css" href="public/css/index.css">
	<script src="public/js/index.js"></script>
</head>
<body>
	<%
	String username = request.getParameter("username") + "";
	String fullname = request.getParameter("fullname") + "";
	String gender = request.getParameter("gender") + "";
	String dateOfBirth = request.getParameter("dateOfBirth") + "";
	String customerAddress = request.getParameter("customerAddress") + "";
	String purchaseAddress = request.getParameter("purchaseAddress") + "";
	String deliveryAddress = request.getParameter("deliveryAddress") + "";
	String phoneNumber = request.getParameter("phoneNumber") + "";
	String email = request.getParameter("email") + "";
	String acceptMail = request.getParameter("acceptMail") + "";
	
	username = (!username.equals("null")) ? username : " ";
	fullname = (!fullname.equals("null")) ? fullname : " ";
	gender = (!gender.equals("null")) ? gender : " ";
	dateOfBirth = (!dateOfBirth.equals("null")) ? dateOfBirth : " ";
	customerAddress = (!customerAddress.equals("null")) ? customerAddress : " ";
	purchaseAddress = (!purchaseAddress.equals("null")) ? purchaseAddress : " ";
	deliveryAddress = (!deliveryAddress.equals("null")) ? deliveryAddress : " ";
	phoneNumber = (!phoneNumber.equals("null")) ? phoneNumber : " ";
	email = (!email.equals("null")) ? email : " ";
	acceptMail = (!acceptMail.equals("null")) ? acceptMail : " ";
	
	
	String usernameError = request.getParameter("usernameError") + "";
	String passwordError = request.getParameter("passwordError") + "";
	
	usernameError = (!usernameError.equals("null")) ? usernameError : " ";
	passwordError = (!passwordError.equals("null")) ? passwordError : " ";
	
	%>
	
	<div class="container">
		<div class="text-center">
			<h1>ĐĂNG KÝ TÀI KHOẢN</h1>
		</div>

		<form class="form" action="register-action" method="post">
			<div class="row">
				<div class="col-sm-6">
					<h3>Tài khoản</h3>
					<div class="mb-3">
						<label for="username" class="form-label">Tên đăng nhập
						<span class="red">*</span> <span class="red"><%=usernameError %></span>
						</label> 
							<input type="text" class="form-control"
							id="username" name="username" required="required" value="<%=username%>">
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Mật khẩu
						<span class="red">*</span> <span class="red"><%=passwordError %></span>
						</label> <input type="password" class="form-control"
						id="password" name="password" required="required" onkeyup="checkPassword()">
					</div>
					<div class="mb-3">
						<label for="passwordConfirm" class="form-label" >Nhập lại
							mật khẩu<span class="red">*</span> <span id="errorPass" class="red" ></span>
						</label> <input type="password" class="form-control" id="passwordConfirm"
							name="passwordConfirm" required="required" onkeyup="checkPassword()">
					</div>
					<hr />
					<h3>Thông tin khách hàng</h3>
					<div class="mb-3">
						<label for="fullname" class="form-label">Họ và tên</label> 
						<input
							type="text" class="form-control" id="fullname" name="fullname" value="<%=fullname%>">
					</div>
					<div class="mb-3">
						<label for="gender" class="form-label">Giới tính</label> <select
							class="form-control" id="gender" name="gender">
							<option></option>
							<option value="Nam" <%=gender.equals("Nam") ? "selected='selected'" : "" %>>Nam</option>
							<option value="Nữ" <%=gender.equals("Nữ") ? "selected='selected'" : "" %>>Nữ</option>
							<option value="Khác" <%=gender.equals("Khác") ? "selected='selected'" : "" %>>Khác</option>
						</select>
					</div>
					<div class="mb-3">
						<label for="dateOfBirth" class="form-label">Ngày sinh</label>
						 <input
							type="date" class="form-control" id="dateOfBirth" name="dateOfBirth" 
							value="<%=dateOfBirth%>">
					</div>
				</div>
				<div class="col-sm-6">
					<h3>Địa chỉ</h3>
					<div class="mb-3">
						<label for="customerAddress" class="form-label">Địa chỉ
							khách hàng</label> <input type="text" class="form-control"
							id="customerAddress" name="customerAddress" value="<%=customerAddress%>">
					</div>
					<div class="mb-3">
						<label for="purchaseAddress" class="form-label">Địa chỉ mua
							hàng</label> <input type="text" class="form-control" id="purchaseAddress"
							name="purchaseAddress" value="<%=purchaseAddress%>">
					</div>
					<div class="mb-3">
						<label for="deliveryAddress" class="form-label">Địa chỉ
							nhận hàng</label> <input type="text" class="form-control"
							id="deliveryAddress" name="deliveryAddress" value="<%=deliveryAddress%>">
					</div>
					<div class="mb-3">
						<label for="phoneNumber" class="form-label">Điện thoại</label> <input
							type="tel" class="form-control" id="phoneNumber" name="phoneNumber" value="<%=phoneNumber%>">
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> <input
							type="email" class="form-control" id="email" name="email" value="<%=email%>">
					</div>
					<hr />
					<div class="mb-3">
						<label for="acceptRules" class="form-label">Đồng ý với
							<a>điều khoản của công ty </a><span id="red">*</span>
						</label> <input type="checkbox" class="form-check-input"
							id="acceptRules" name="acceptRules" required="required" onchange="checkAcceptRules()">
					</div>
					<div class="mb-3">
						<label for="acceptMail" class="form-label">Đồng ý nhận
							email</label> 
							<input type="checkbox" class="form-check-input"
							id="acceptMail" name="acceptMail" <%=acceptMail.equals("on") ? "checked='checked'" : "" %>>
					</div>
					<input class="btn btn-primary form-control" type="submit"
						value="Đăng ký" name="submit" id="submit" style="visibility: hidden;" />
				</div>
			</div>
		</form>
	</div>
</body>


</html>