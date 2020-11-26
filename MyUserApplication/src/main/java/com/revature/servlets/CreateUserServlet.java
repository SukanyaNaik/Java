package com.revature.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateUserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Connection conn;
	
	public void init() throws ServletException{
		
		System.out.println(this.getServletName() + " instantiated");
		super.init();
		
		// We will establish JDBC connection here.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver\n");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String username = "Sukanya";
		String password = "123";
		
		try {
			
			conn = DriverManager.getConnection(url, username, password);
			
		} catch (SQLException e) {
			System.out.println("Unable to obtain connection to database" + "\n" + e + "\n");
		}
		
		if(conn != null) {
			System.out.println("****Connection to the database is established.****");
		}
		else {
			System.out.println("------------Error-----------------");
		}
	}
	
	
	 // Since we are creating a user and changing the database
	 // we must use doPost() method
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException{
		
		String userName = req.getParameter("userName");
		String pwd = req.getParameter("password");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		
		String sql = "INSERT INTO Users (UserName, Pwd, FirstName, LastName, Email, RoleId_ref) VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, userName);
			ps.setString(2, pwd);
			ps.setString(3, firstName);
			ps.setString(4, lastName);
			ps.setString(5, email);
			ps.setInt(6,1);
			
			int numRows = ps.executeUpdate();
			
			if (numRows > 0) {								// Making sure the sql statement returned something
				System.out.println("User was created.");
//				ResultSet pk = ps.getGeneratedKeys();		// primary keys
//				while (pk.next()) {
//					user.setUserId(pk.getInt(1));
//					System.out.println("User Id - " + pk.getInt(1));
//				}
			}
			conn.commit();
		}
		catch(SQLException e) {
			System.out.println("Connection failed.\n");
			e.printStackTrace();
		}
	}
	
	public void destroy() {
		
		System.out.println(this.getServletName() + " destroyed..");
		
		// Close the connection.
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		super.destroy();
	}

}
