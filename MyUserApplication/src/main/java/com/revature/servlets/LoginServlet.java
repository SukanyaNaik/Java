package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Connection conn;  // Make sure that the driver software is included in lib.

	
	public void init() throws ServletException {

		System.out.println(this.getServletName() + " INSTANTIATED!");
		super.init();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String username = "Sukanya";
		String password = "123";
		try {
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@database-2.c0rzi76acgyn.us-east-1.rds.amazonaws.com:1521:FIRSTDB", "admin", "12345678");
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// we will ALSO use a doPost method here....but we will take in different parameters
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password"); // this is the password you want to update
		
		// the we create an insert statement Statement statement = conn.createStatement()
		try {
			//conn.setAutoCommit(false);
			Statement statement = conn.createStatement();
			String sql = "SELECT * FROM Users WHERE email = '"+email+"' AND Pwd = '" + password + "' ";
			ResultSet rs = statement.executeQuery(sql);                   
			// an insert statement affects 1 row, but an update or delete statment can affect more...	
			
			PrintWriter out = res.getWriter();
			
			RequestDispatcher rd = req.getRequestDispatcher("homeServlet");
			
			if(rs.next()) {
				req.setAttribute("message", "Access granted! Welcome...");
				rd.forward(req, res);
			} else {
				rd = req.getRequestDispatcher("login.html");
				rd.include(req, res);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void destroy() {
		System.out.println(this.getServletName() + " DESTROYED!");
		super.destroy();
		// we will also close our connection
		try {
			conn.close();
			System.out.println("Connection closed.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
