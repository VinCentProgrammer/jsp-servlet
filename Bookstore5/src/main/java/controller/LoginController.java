package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.CustomerDAO;
import model.Customer;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login-action")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		request.setAttribute("username", username);

		String url = "/login.jsp";

		CustomerDAO cd = new CustomerDAO();

		Customer customer = new Customer();
		customer.setUsername(username);
		customer.setPassword(password);

		Customer customerLogin = cd.selectUsernameAndPassCustomer(customer);
		System.out.println(customerLogin);

		if (customerLogin != null) {
			HttpSession session = request.getSession();
			session.setAttribute("customerLogin", customerLogin);
			url = "/index.jsp";
		} else {
			request.setAttribute("loginError", "Tên đăng nhập hoặc mật khẩu không đúng!");
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
