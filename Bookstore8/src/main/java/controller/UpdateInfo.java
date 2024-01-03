package controller;

import java.io.IOException;
import java.sql.Date;

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
 * Servlet implementation class UpdateInfo
 */
@WebServlet("/update-info")
public class UpdateInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fullname = request.getParameter("fullname");
		String gender = request.getParameter("gender");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String customerAddress = request.getParameter("customerAddress");
		String purchaseAddress = request.getParameter("purchaseAddress");
		String deliveryAddress = request.getParameter("deliveryAddress");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		String acceptMail = request.getParameter("acceptMail");
		Date date = Date.valueOf(dateOfBirth);

		String url = "/updateInfo.jsp";
		boolean isError = false;

		CustomerDAO cd = new CustomerDAO();
		HttpSession session = request.getSession();
		Object customerLoginObj = session.getAttribute("khachHang");
		String customerId = ((Customer) customerLoginObj).getCustomerId();

		Customer customer = new Customer(customerId, "", "", fullname, gender, customerAddress, deliveryAddress,
				purchaseAddress, date, phoneNumber, email, acceptMail != null);

		if (!isError) {
			cd.updateInfo(customer);
			Customer customerAfterUpdate = cd.selectById(customer);
			session.setAttribute("khachHang", customerAfterUpdate);

			url = "/successUpdateInfo.jsp";
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
