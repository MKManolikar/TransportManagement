package com.transport.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.transport.dao.DemoDao;
import com.transport.dao.UserDao;
import com.transport.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(LoginController.class);

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
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		UserDao dao = new UserDao();
		User user = new User();
		String userName = request.getParameter("username");
		String userPassword = request.getParameter("password");
		System.out.println("in LOgin servlet" + userName + " " + userPassword);
		try {

			user = dao.getUserbyName(userName);
			System.out.println(user.toString());
			if (userName.equals(user.getUserName().trim()) && userPassword.equals(user.getUserPassword().trim())) {
				String type = user.getUserType().trim();
				if ("admin".equals(type)) {
					System.out.println(type);
					response.sendRedirect("Admin.jsp");
				} else if ("commuter".equals(type)) {
					System.out.println(type);
					response.sendRedirect("Commuter.jsp");
				}
			} else {
				System.out
						.println("Account does not exist!!you should register");
				response.sendRedirect("index.html");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
