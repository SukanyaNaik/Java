package com.revature.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daos.AccountDao;
import com.revature.daos.UserDao;
import com.revature.models.Account;
import com.revature.models.User;

public class UpgradeUserServlet extends HttpServlet {
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
				
		HttpSession session = req.getSession();
		User tempUser = (User) session.getAttribute("CurrentUser");
		System.out.println("Finally..............");
		
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
				ud.upgrade(tempUser);
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
