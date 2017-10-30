package com.transport.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.transport.dao.UserDao;
import com.transport.model.User;
/**
 * Servlet implementation class UserDataServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(RegistrationServlet.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("username");
		String userPassword = request.getParameter("password");
		String confirmpassword = request.getParameter("confirmpassword");
		logger.info(userName+" "+userPassword+" "+confirmpassword);
		
		if(userName.isEmpty()||userPassword.isEmpty()||confirmpassword.isEmpty())
		{
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			out.println("<font color=red>Please fill all the fields</font>");
			rd.include(request, response);
		}
		else
		{
			if(userPassword.equals(confirmpassword)){
			UserDao dao = new UserDao();
			String userType="commuter";
			User user = new User(userName,userPassword,userType);
			logger.info(user.toString());
			try {
				dao.add(user);
				logger.info("user added successfully");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);
			response.sendRedirect("index.html");
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				out.println("<font color=red>confirm password do not match</font>");
				rd.forward(request, response);
				
			}
			
		}
	}
}