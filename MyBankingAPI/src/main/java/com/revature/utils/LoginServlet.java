package com.revature.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daos.UserDao;
import com.revature.models.User;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException {
		System.out.println(this.getServletName() + " instantiated....");
		super.init();
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {


		System.out.println(this.getServletName() + " Service method called.");
		
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
				User user = new User();
				
				System.out.println("User Name - " + req.getParameter("userName"));
				System.out.println("Password - " + req.getParameter("password"));
				user.setUsername(req.getParameter("userName"));
				user.setPassword(req.getParameter("password"));
				
				HttpSession session = req.getSession();
				session.setAttribute("CurrentUser", user);
				session.setAttribute("user", user.getFirstName());
				session.setMaxInactiveInterval(30*60);
				Cookie loginCookie = new Cookie("user",user.getUsername());
				res.addCookie(loginCookie);
				
				user = ud.login(user);
							
				if(user == null) {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
					PrintWriter out= res.getWriter();
					out.println("<font color=red>Either user name or password is wrong.</font>");
					rd.include(req, res);
				}
				else if(user.getRole().getRoleId() == 1) {
					
					loginCookie.setMaxAge(30*60);
					res.addCookie(loginCookie);
					res.sendRedirect("standardUser.jsp");
				}
				else if(user.getRole().getRoleId() == 2) {
					
					loginCookie.setMaxAge(30*60);
					res.addCookie(loginCookie);
					res.sendRedirect("premiumUser.jsp");
				}
				else if(user.getRole().getRoleId() == 3) {
					
					loginCookie.setMaxAge(30*60);
					res.addCookie(loginCookie);
					res.sendRedirect("employee.jsp");
				}
				else if(user.getRole().getRoleId() == 4) {
					
					loginCookie.setMaxAge(30*60);
					res.addCookie(loginCookie);
					res.sendRedirect("admin.jsp");
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
		System.out.println(this.getServletName() + " destroyed....");
		super.destroy();
	}
}
