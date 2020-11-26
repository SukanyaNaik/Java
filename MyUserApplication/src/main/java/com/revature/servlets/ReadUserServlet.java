package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadUserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2638327170794451640L;
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
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException {
		
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM Users");
			
			PrintWriter out = res.getWriter();
			
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>");
			out.println("First Name");
			out.println("</th>");
			out.println("<th>");
			out.println("Last Name");
			out.println("</th>");
			out.println("<th>");
			out.println("Email");
			out.println("</th>");
			out.println("</tr>");
			
			while(rs.next()) {
				out.println("<tr>");
				
				out.println("<td>");
				out.println(rs.getString("FirstName"));
				out.println("</td>");
				
				out.println("<td>");
				out.println(rs.getString("LastName"));
				out.println("</td>");
				
				out.println("<td>");
				out.println(rs.getString("Email"));
				out.println("</td>");
				
				out.println("</tr>");
			}
			out.println("<table>");
		}
		catch(SQLException e) {
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
