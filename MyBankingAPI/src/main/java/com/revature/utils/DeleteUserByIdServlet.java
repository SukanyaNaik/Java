package com.revature.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daos.UserDao;

public class DeleteUserByIdServlet extends HttpServlet {
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
				boolean isDeleted = ud.deleteUserById(id);
				if(isDeleted) {
					System.out.println("User was deleted!");
				}
				else {
					System.out.println("User can not be deleted!");
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
