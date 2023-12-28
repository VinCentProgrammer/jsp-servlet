package controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BuyAction
 */
@WebServlet("/buy-action")
public class BuyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String numOrder = request.getParameter("numOrder");
		String phoneNumber = request.getParameter("phone-number");
		String email = request.getParameter("email");
		
		request.setAttribute("numOrder", numOrder);
		request.setAttribute("phoneNumber", phoneNumber);
		request.setAttribute("email", email);
		
		
		// Xu ly numOrder
		boolean checkError = false;
		double numOrderValue = 0;
		try {
			numOrderValue = Double.parseDouble(numOrder);
		} catch (Exception e) {
			checkError = true;
			request.setAttribute("numOrderError", "Số lượng phải là số!");
		}
		
		if(!checkError && numOrderValue <= 0) {
			checkError = true;
			request.setAttribute("numOrderError", "Số lượng phải là số > 0!");
		}
		
		// Xu ly phoneNumber
		Pattern phoneNumberPattern = Pattern.compile("\\d{10}");
		Matcher phoneNumberMatcher = phoneNumberPattern.matcher(phoneNumber);
		
		if(!phoneNumberMatcher.matches()) {
			checkError = true;
			request.setAttribute("phoneNumberError", "Số điện thoại phải có 10 chữ số!");
		}
		
		// Xu ly email
		Pattern emailPattern = Pattern.compile("\\w+@\\w+(\\.\\w+)+(\\.\\w+)*");
		Matcher emailMatcher = emailPattern.matcher(email);
		
		if(!emailMatcher.matches()) {
			checkError = true;
			request.setAttribute("emailError", "Email không đúng định dạng!");
		}
		
		String url = "/index.jsp";
		if(!checkError) {
			url = "/success.jsp";
		}
		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
