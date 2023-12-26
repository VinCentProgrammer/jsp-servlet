<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hóa đơn</title>
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
	double totalPrice = 0;
	// Processor
	String processor = request.getParameter("processor");
	double processorPrice = 0;
	if (processor != null) {
		if (processor.equals("Core I9")) {
			processorPrice = 5000000;
		} else if (processor.equals("Core I7")) {
			processorPrice = 3000000;
		} else if (processor.equals("Core I5")) {
			processorPrice = 1000000;
		}
		totalPrice += processorPrice;
	}

	// Ram
	double ramPrice = 0;
	String ram = request.getParameter("ram");
	if (ram != null) {
		if (ram.equals("Ram 8GB")) {
			ramPrice = 3000000;
		} else if (ram.equals("Ram 16GB")) {
			ramPrice = 6000000;
		}
		totalPrice += ramPrice;
	}

	// Monitor
	double monitorPrice = 0;
	String monitor = request.getParameter("monitor");
	if (monitor != null) {
		monitorPrice = 10000000;
		totalPrice += monitorPrice;
	}

	// Accessories
	String[] accessories = request.getParameterValues("accessories");
	%>


	<h1>HÓA ĐƠN</h1>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Tên sản phẩm</th>
				<th scope="col">Giá tiền</th>
			</tr>
		</thead>
		<tbody>
			<%
			if (processor != null) {
			%>
			<tr>
				<th scope="col"><%=processor%></th>
				<th scope="col"><%=processorPrice%></th>
			</tr>
			<%
			}
			%>

			<%
			if (ram != null) {
			%>
			<tr>
				<th scope="col"><%=ram%></th>
				<th scope="col"><%=ramPrice%></th>
			</tr>
			<%
			}
			%>

			<%
			if (monitor != null) {
			%>
			<tr>
				<th scope="col"><%=monitor%></th>
				<th scope="col"><%=monitorPrice%></th>
			</tr>
			<%
			}
			%>

			<%
			if (accessories != null) {
				for (String accessory : accessories) {
					double accessoryPrice = 0;
					if (accessory.equals("Camera")) {
				accessoryPrice = 2000000;
					} else if (accessory.equals("Printer")) {
				accessoryPrice = 4000000;
					} else if (accessory.equals("Scanner")) {
				accessoryPrice = 8000000;
					}
			%>
			<tr>
				<th scope="col"><%=accessory%></th>
				<th scope="col"><%=accessoryPrice%></th>
			</tr>
			<%
			}
			%>
			<%
			}
			%>

			<%
			if (totalPrice != 0) {
				double price = Math.round(totalPrice);
			%>
			<tr>
				<th scope="col">Tổng tiền</th>
				<th scope="col"><%=price%></th>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>



</body>
</html>