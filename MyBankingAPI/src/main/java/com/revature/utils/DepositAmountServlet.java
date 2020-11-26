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
import com.revature.models.Account;
import com.revature.models.User;

public class DepositAmountServlet extends HttpServlet {
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
		System.out.println("UserName" + tempUser.getUsername());
		
		try {
		//Connection conn = (Connection) session.getAttribute("Connection");
		Connection conn = ConnectionFactory.getConnection();
		AccountDao ad = new AccountDao(conn);
				
		String tempAmount = req.getParameter("amount");
		double amount = Double.parseDouble(tempAmount);
		String tempaAcountNo = req.getParameter("accountNo");
		int accountNo = Integer.parseInt(tempaAcountNo);
		
		Account tempAccount = (Account) ad.findById(accountNo);
		//ad.withdraw(tempAccount, amount);
		boolean isUpdated = ad.deposit(tempAccount, amount);
		tempAccount = (Account) ad.findById(accountNo);
		
		PrintWriter out = res.getWriter();
		if (tempAccount != null && isUpdated)
		{
			
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
			out.println(tempAccount.getAccountId());
			out.println("</h3></td>");
			
			out.println("<td>  </td>");
			
			out.println("<td><h3>");
			out.println(tempAccount.getBalance());
			out.println("</h3></td>");
			
			out.println("<td>  </td>");
			
			out.println("<td><h3>");
			out.println(tempAccount.getStatus().getStatus());
			out.println("</h3></td>");
			
			out.println("<td>  </td>");
			
			out.println("<td><h3>");
			out.println(tempAccount.getType().getTypeName());
			out.println("</h3></td>");
			
			out.println("</tr>");
			out.println("<table>");
			
			out.println("<h3><a href=\"standardUser.jsp\"> Back to menu. </a></h3>");
			
		}
		else {
			out.println("<table>");
			out.println("<tr>");
			out.println("<td><h2>Error in depositing...</h2></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td><h3><a href=\"standardUser.jsp\"> Back to menu. </a></h3><td>");
			out.println("</tr>");
			out.println("<table>");
		}
		conn.close();
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
