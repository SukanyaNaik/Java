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

	public class FindUserByIdServlet extends HttpServlet {
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
		
		String userid = req.getParameter("userId");
		int id = Integer.parseInt(userid);
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
				User user = ud.findById(id);
				
				PrintWriter out = res.getWriter();
				
				if(user != null) {
					out.println("<table>");
					out.println("<tr>");
					
					out.println("<th>");
					out.println("<h2>");
					out.println("First Name");
					out.println("</h2>");
					out.println("</th>");
					
					out.println("<th></th>");
					
					out.println("<th>");
					out.println("<h2>");
					out.println("Last Name");
					out.println("</h2>");
					out.println("</th>");
					
					out.println("<th></th>");
					
					out.println("<th>");
					out.println("<h2>");
					out.println("Email");
					out.println("</h2>");
					out.println("</th>");
					
					out.println("</tr>");
					out.println("<tr>");
					
					out.println("<td><h3>");
					out.println(user.getFirstName());
					out.println("</h3></td>");
					
					out.println("<td></td>");
					
					out.println("<td><h3>");
					out.println(user.getLastName());
					out.println("</h3></td>");
					
					out.println("<td></td>");
					
					out.println("<td><h3>");
					out.println(user.getEmail());
					out.println("</h3></td>");
					
					out.println("</tr>");
					out.println("<table>");
					
					if(currentuser.getRole().getRoleId() == 3) {
						out.println("<h3><a href=\"employee.jsp\"> Back to menu. </a></h3>");
					}
					else if(currentuser.getRole().getRoleId() == 4) {
						out.println("<h3><a href=\"admin.jsp\"> Back to menu. </a></h3>");
					}
					
				}
				else {
					out.println("<table>");
					out.println("<tr>");
					out.println("<td><h2>User not found</h2></td>");
					out.println("</tr>");
					out.println("<tr>");
					if(currentuser.getRole().getRoleId() == 3) {
						out.println("<h3><a href=\"employee.jsp\"> Back to menu. </a></h3>");
					}
					else if(currentuser.getRole().getRoleId() == 4) {
						out.println("<h3><a href=\"admin.jsp\"> Back to menu. </a></h3>");
					}
					out.println("</tr>");
					out.println("<table>");
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
