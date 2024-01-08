<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
%>
<nav class="navbar navbar-expand-lg bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="#"> <img
			src="https://1.bp.blogspot.com/-f_5JLvF9_gU/YZGM7p_fkFI/AAAAAAAAAVo/zHkM8tD3ioAvD1pFznG1kw-QOmOibu5ywCLcBGAsYHQ/s150/1-removebg-preview.png"
			alt="Bootstrap" height="24">
		</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="#">Trang chủ</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Combo
						giảm giá </a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> Thể loại </a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="#">Quần Jean</a></li>
						<li><a class="dropdown-item" href="#">Áo thun</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="#">Áo sơ mi</a></li>
					</ul></li>
				<li class="nav-item"><a class="nav-link disabled">Hết hàng</a>
				</li>
			</ul>
			<form class="d-flex" role="search">
				<input class="form-control me-2" type="search"
					placeholder="Nội dung tìm kiếm" aria-label="Search">
				<button class="btn btn-outline-success" type="submit">Tìm</button>
				<%
				Object obj = session.getAttribute("khachHang");
				Customer khachHang = null;
				if (obj != null)
					khachHang = (Customer) obj;

				if (khachHang == null) {
				%>
				<a class="btn btn-primary" style="white-space: nowrap;"
					href="<%=url %>/CustomerView/login.jsp"> Đăng nhập </a>
				<%
				} else {
				%>
				<div class="row text-center" style="margin-left: 0.25em">
					<div class="dropdown dropstart text-end">
						<button type="button" class="btn btn-primary dropdown-toggle"
							data-bs-toggle="dropdown">
							<b><%=khachHang.getUsername()%></b>
						</button>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Đơn hàng của tôi</a></li>
							<li><a class="dropdown-item" href="#">Thông báo</a></li>
							<li><a class="dropdown-item"
								href="<%=url %>/CustomerView/updateInfo.jsp">Thay đổi thông tin</a></li>
							<li><a class="dropdown-item"
								href="<%=url %>/CustomerView/changePass.jsp">Đổi mật khẩu</a></li>
							<li><a class="dropdown-item"
								href="<%=url %>/customer?customer_act=logout">Đăng xuất</a></li>
						</ul>
					</div>
				</div>
				<%
				}
				%>
			</form>
		</div>
	</div>
</nav>