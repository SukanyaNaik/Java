package com.revature.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateUserServlet extends HttpServlet {
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
			conn.setAutoCommit(false);
			Statement statement = conn.createStatement();
			String sql = "UPDATE Users SET Pwd= '"+password+"' WHERE Email= '"+email+"'";
			int result = statement.executeUpdate(sql);                   
			// an insert statement affects 1 row, but an update or delete statment can affect more...	
			
			PrintWriter out = res.getWriter();
			
			if (result > 0) {
				out.println("<h1>Password updated for " + email + "</h1>");
				conn.commit();
			} else {
				out.println("<h1>Error updating user...</h1>");
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