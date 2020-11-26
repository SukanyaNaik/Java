package com.revature.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daos.UserDao;
import com.revature.models.User;

public class UpdateUserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException {
		System.out.println(this.getServletName() + " is instantiated");
		super.init();
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		
		System.out.println(this.getServletName() + " Service method called.");
		HttpSession session = req.getSession();
		User currentuser = (User) session.getAttribute("CurrentUser");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver\n");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			// 1. Establish the connection.
			Connection conn = ConnectionFactory.getConnection();
			
			if(conn != null) {
				UserDao ud = new UserDao(conn);
				currentuser = ud.findByUserName(currentuser.getUsername());
				User tempUser = new User();
				User user = null;
				
				tempUser.setUsername(req.getParameter("userName"));
				tempUser.setPassword(req.getParameter("password"));
				tempUser.setFirstName(req.getParameter("firstName"));
				tempUser.setLastName(req.getParameter("lastName"));
				tempUser.setEmail(req.getParameter("email"));
				//user.setRole();
				
				user = ud.updateUserInfo(tempUser);
				
				PrintWriter out = res.getWriter();
				if(user != null) {
					out.println("<h3>User is updated!</h3>");
					if(currentuser.getRole().getRoleId() == 3) {
						out.println("<h3><a href=\"employee.jsp\"> Back to menu. </a></h3>");
					}
					else if(currentuser.getRole().getRoleId() == 4) {
						out.println("<h3><a href=\"admin.jsp\"> Back to menu. </a></h3>");
					}
					else if(currentuser.getRole().getRoleId() == 1) {
						out.println("<h3><a href=\"standardUser.jsp\"> Back to menu. </a></h3>");
					}
					else if(currentuser.getRole().getRoleId() == 2) {
						//out.println("<h3><a href=\"premiumUser.jsp\"> Back to menu. </a></h3>");
						//res.addCookie(loginCookie);
						res.sendRedirect("premiumUser.jsp");
					}
				}
				
				else {
					out.println("<h3>Error updating user!</h3>");
					if(currentuser.getRole().getRoleId() == 3) {
						out.println("<h3><a href=\"employee.jsp\"> Back to menu. </a></h3>");
					}
					else if(currentuser.getRole().getRoleId() == 4) {
						out.println("<h3><a href=\"admin.jsp\"> Back to menu. </a></h3>");
					}
					else if(currentuser.getRole().getRoleId() == 1) {
						out.println("<h3><a href=\"standardUser.jsp\"> Back to menu. </a></h3>");
					}
					else if(currentuser.getRole().getRoleId() == 2) {
						out.println("<h3><a href=\"premiumUser.jsp\"> Back to menu. </a></h3>");
					}
				}
				conn.close();
			}
			else {
				System.out.println("Connection failed.\n");
			}
			
		}
		
		catch(SQLException e) {
			System.out.println("Error connecting to the Databse.\n");
		}
	}
	
	
	public void destroy() {
		System.out.println("Destroying " + this.getServletName());
		super.destroy();
	}
}
