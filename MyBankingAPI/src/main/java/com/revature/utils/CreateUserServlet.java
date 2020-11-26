package com.revature.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daos.UserDao;
import com.revature.models.User;

public class CreateUserServlet extends HttpServlet {

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
				
				user.setUsername(req.getParameter("userName"));
				user.setPassword(req.getParameter("password"));
				user.setFirstName(req.getParameter("firstName"));
				user.setLastName(req.getParameter("lastName"));
				user.setEmail(req.getParameter("email"));
				
				user = ud.create(user);
				if (user != null) {
					RequestDispatcher rd = req.getRequestDispatcher("login.html");
					rd.include(req, res); 
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
