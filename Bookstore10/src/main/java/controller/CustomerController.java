package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import util.Encode;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet(name = "/customer", urlPatterns = "/customer")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String customer_act = request.getParameter("customer_act");
		if (customer_act.equals("login")) {
			login(request, response);
		} else if (customer_act.equals("logout")) {
			logout(request, response);
		} else if (customer_act.equals("register")) {
			register(request, response);
		} else if (customer_act.equals("change-pass")) {
			changePass(request, response);
		} else if (customer_act.equals("update-info")) {
			updateInfo(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			password = Encode.encodingToSHA1(password);

			request.setAttribute("username", username);

			Customer kh = new Customer();
			kh.setUsername(username);
			kh.setPassword(password);

			CustomerDAO khd = new CustomerDAO();
			Customer khachHang = khd.selectUsernameAndPassCustomer(kh);
			String url = "/index.jsp";
			if (khachHang != null) {
				HttpSession session = request.getSession();
				session.setAttribute("khachHang", khachHang);
			} else {
				request.setAttribute("baoLoi", "Tên đăng nhập hoặc mật khẩu không đúng!");
				url = "/CustomerView/login.jsp";
			}
			System.out.println(url);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) {
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
		try {
			HttpSession session = request.getSession();
			if (session != null) {
				session.invalidate();

				response.sendRedirect(basePath + "/index.jsp");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void register(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; Charset=UTF-8");

			String username = request.getParameter("username");
			String password = request.getParameter("password");
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

			// Xu ly username
//		Pattern usernamePattern = Pattern.compile("^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$");
//		Matcher usernameMatcher = usernamePattern.matcher(username);

			String url = "/CustomerView/register.jsp";
			boolean isError = false;
			String usernameError = null;

//		if (!usernameMatcher.matches()) {
//			isError = true;
//			usernameError += "Username không đúng định dạng!";
//		}
			Date date = null;
			if (!dateOfBirth.equals("null")) {
				date = Date.valueOf(dateOfBirth);
			}

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
				url = "/CustomerView/success.jsp";
			}

			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void changePass(HttpServletRequest request, HttpServletResponse response) {
		try {
			String passwordOld = request.getParameter("passwordOld");
			String passwordNew = request.getParameter("passwordNew");
			String passwordNewConfirm = request.getParameter("passwordNewConfirm");
			passwordOld = Encode.encodingToSHA1(passwordOld);
			passwordNew = Encode.encodingToSHA1(passwordNew);
			passwordNewConfirm = Encode.encodingToSHA1(passwordNewConfirm);

			String url = "/CustomerView/changePass.jsp";
			String messageError = null;
			// Check password old exist in db
			CustomerDAO cd = new CustomerDAO();
			Customer c = new Customer();
			c.setPassword(passwordOld);
			Customer customerCheck = cd.selectCustomerByPassword(c);

			if (customerCheck == null) {
				messageError = "Password current not exist in db!";
			} else {
				// Check password new != password old
				if (passwordNew.equals(passwordOld)) {
					messageError = "The new password matches the old password!";
				} else {
					// Check password new <-> password new confirm
					if (!passwordNew.equals(passwordNewConfirm)) {
						messageError = "Confirmation password does not match!";
					}
				}
			}

			// Result
			if (messageError == null) {
				customerCheck.setPassword(passwordNew);
				cd.updatePass(customerCheck);
				url = "/CustomerView/changePassSuccess.jsp";
			} else {
				request.setAttribute("messageError", messageError);
			}

			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);

		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void updateInfo(HttpServletRequest request, HttpServletResponse response) {
		try {
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

			String url = "/CustomerView/updateInfo.jsp";
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

				url = "/CustomerView/successUpdateInfo.jsp";
			}

			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
