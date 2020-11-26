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

import com.revature.daos.AccountDao;
import com.revature.daos.UserDao;
import com.revature.models.Account;
import com.revature.models.User;

public class FindAccountByIdServlet extends HttpServlet {
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
		
		String accountId = req.getParameter("accountId");
		int id = Integer.parseInt(accountId);
		System.out.println(this.getServletName() + " Service method called.");
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("CurrentUser");
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
				user = ud.findByUserName(user.getUsername());
				AccountDao ad = new AccountDao(conn);
				Account account = (Account) ad.findById(id);
				PrintWriter out = res.getWriter();
				
				if(account != null) {
					out.println("<table>");
					out.println("<tr>");
					
					out.println("<th>");
					out.println("<h2>");
					out.println("Account Number");
					out.println("</h2>");
					out.println("</th>");
					
					out.println("<th>  </th>");
					
					out.println("<th>");
					out.println("<h2>");
					out.println("Balance");
					out.println("</h2>");
					out.println("</th>");
					
					out.println("<th>  </th>");
					
					out.println("<th>");
					out.println("<h2>");
					out.println("Account Status");
					out.println("</h2>");
					out.println("</th>");
					
					out.println("<th>  </th>");
					
					out.println("<th>");
					out.println("<h2>");
					out.println("Account Type");
					out.println("</h2>");
					out.println("</th>");
					out.println("</tr>");
					out.println("<tr>");
					
					out.println("<td><h3>");
					out.println(account.getAccountId());
					out.println("</h3></td>");
					
					out.println("<td>  </td>");
					
					out.println("<td><h3>");
					out.println(account.getBalance());
					out.println("</h3></td>");
					
					out.println("<td>  </td>");
					
					out.println("<td><h3>");
					out.println(account.getStatus().getStatus());
					out.println("</h3></td>");
					
					out.println("<td>  </td>");
					
					out.println("<td><h3>");
					out.println(account.getType().getTypeName());
					out.println("</h3></td>");
					
					out.println("</tr>");
					out.println("<table>");
					if(user.getRole().getRoleId() == 3) {
						out.println("<h3><a href=\"employee.jsp\"> Back to menu. </a></h3>");
					}
					else if(user.getRole().getRoleId() == 4) {
						out.println("<h3><a href=\"admin.jsp\"> Back to menu. </a></h3>");
					}
					
				}
				else {
					out.println("<table>");
					out.println("<tr>");
					out.println("<td><h2>User not found</h2></td>");
					out.println("</tr>");
					out.println("<tr>");
					if(user.getRole().getRoleId() == 3) {
						out.println("<h3><a href=\"employee.jsp\"> Back to menu. </a></h3>");
					}
					else if(user.getRole().getRoleId() == 4) {
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
