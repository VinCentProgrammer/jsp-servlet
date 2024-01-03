package controller;

import java.io.IOException;

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
 * Servlet implementation class ChangePassController
 */
@WebServlet("/change-pass")
public class ChangePassController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePassController() {
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
		String passwordOld = request.getParameter("passwordOld");
		String passwordNew = request.getParameter("passwordNew");
		String passwordNewConfirm = request.getParameter("passwordNewConfirm");
		passwordOld = Encode.encodingToSHA1(passwordOld);
		passwordNew = Encode.encodingToSHA1(passwordNew);
		passwordNewConfirm = Encode.encodingToSHA1(passwordNewConfirm);

		String url = "/changePass.jsp";
		String messageError = null;
		// Check password old exist in db
		CustomerDAO cd = new CustomerDAO();
		Customer c = new Customer();
		c.setPassword(passwordOld);
		Customer customerCheck = cd.selectCustomerByPassword(c);

		if (customerCheck == null) {
			messageError = "Password current not exist in db!";
		} else {
			// Check password new <-> password new confirm
			if (!passwordNew.equals(passwordNewConfirm)) {
				messageError = "Confirmation password does not match!";
			}
			// Check password new != password old
			if (passwordNew.equals(passwordOld)) {
				messageError = "The new password matches the old password!";
			}
		}

		// Result
		if (messageError == null) {
			customerCheck.setPassword(passwordNew);
			cd.updatePass(customerCheck);
			url = "/changePassSuccess.jsp";
		} else {
			request.setAttribute("messageError", messageError);
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
