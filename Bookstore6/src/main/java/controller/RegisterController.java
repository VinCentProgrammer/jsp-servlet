package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.CustomerDAO;
import model.Customer;
import util.Encode;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register-action")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; Charset=UTF-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("passwordConfirm");
		String fullname = request.getParameter("fullname");
		String gender = request.getParameter("gender");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String customerAddress = request.getParameter("customerAddress");
		String purchaseAddress = request.getParameter("purchaseAddress");
		String deliveryAddress = request.getParameter("deliveryAddress");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		String acceptMail = request.getParameter("acceptMail");

		request.setAttribute("username", username);
		request.setAttribute("fullname", fullname);
		request.setAttribute("gender", gender);
		request.setAttribute("dateOfBirth", dateOfBirth);
		request.setAttribute("customerAddress", customerAddress);
		request.setAttribute("purchaseAddress", purchaseAddress);
		request.setAttribute("deliveryAddress", deliveryAddress);
		request.setAttribute("phoneNumber", phoneNumber);
		request.setAttribute("email", email);
		request.setAttribute("acceptMail", acceptMail);

		Date date = Date.valueOf(dateOfBirth);

		// Xu ly username
//		Pattern usernamePattern = Pattern.compile("^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$");
//		Matcher usernameMatcher = usernamePattern.matcher(username);

		String url = "/register.jsp";
		boolean isError = false;
		String usernameError = null;

//		if (!usernameMatcher.matches()) {
//			isError = true;
//			usernameError += "Username không đúng định dạng!";
//		}

		CustomerDAO c = new CustomerDAO();
		Customer customer = new Customer(username + "$%#12", username, password, fullname, gender, customerAddress,
				deliveryAddress, purchaseAddress, date, phoneNumber, email, acceptMail != null);

		if (c.checkExist(customer)) {
			isError = true;
			usernameError += "Username đã tồn tại, vui lòng chọn tên khác!";
		}

		// Xu ly password
//		if (!password.equals(passwordConfirm)) {
//			isError = true;
//			request.setAttribute("passwordError", "Xác nhận password không chính xác!");
//		}

		request.setAttribute("usernameError", usernameError);

		// Không lỗi
		if (!isError) {
			String passEncode = Encode.encodingToSHA1(password);
			customer.setPassword(passEncode);

			c.insert(customer);
			url = "/success.jsp";
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
