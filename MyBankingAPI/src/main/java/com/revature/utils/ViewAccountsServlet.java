package com.revature.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daos.AccountDao;
import com.revature.daos.UserDao;
import com.revature.models.Account;
import com.revature.models.AccountType;
import com.revature.models.User;

public class ViewAccountsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException {
		System.out.println(this.getServletName() + " instantiated....");
		super.init();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		
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
		
		// 1. Establish the connection.
		Connection conn = ConnectionFactory.getConnection();
		
		if(conn != null) {
			UserDao ud = new UserDao(conn);
			AccountDao ad = new AccountDao(conn);
			currentuser = ud.findByUserName(currentuser.getUsername());
			System.out.println("User Name - " + currentuser.getFirstName());
			
			PrintWriter out = res.getWriter();
			out.flush();

			if(currentuser != null) {
				List <Account> accounts = ad.findAccounstByUserId(currentuser.getUserId());
				System.out.println("No of Accounts - " + accounts.size());
				session.setAttribute("CurrentUser", currentuser);
				session.setAttribute("user", currentuser.getFirstName());
				if(accounts.size() > 0) {
					res.setContentType("text/html");
					out.println("<html>");
					out.println("<table>");
					out.println("<tr>");
	
					out.println("<th>");
					out.println("<h2>");
					out.println("Account Id");
					out.println("</h2>");
					out.println("</th>");
	
					out.println("<th></th>");
	
					out.println("<th>");
					out.println("<h2>");
					out.println("Account Type");
					out.println("</h2>");
					out.println("</th>");
	
					out.println("<th></th>");
	
					out.println("<th>");
					out.println("<h2>");
					out.println("Balance");
					out.println("</h2>");
					out.println("</th>");
	
					out.println("</tr>");
					
					Iterator<Account> it = accounts.iterator();
					
					while(it.hasNext()) {
						Account acc = (Account) it.next();
						AccountType accType = acc.getType();
						out.println("<tr>");
						out.println("<td>");

						int accId = acc.getAccountId();
						System.out.println("accId - " + accId);
						out.println("<a href=/MyBankingAPI/findAccountByIds?accountId=" + accId + ">");
						out.println(accId);
						out.println("</a>");
						out.println("</td>");

						out.println("<td></td>");
						
						out.println("<td>");
						out.println(accType.getTypeName());
						System.out.println("accType - " + accType.getTypeName());
						out.println("</td>");
						
						out.println("<td></td>");
						
						out.println("<td>");
						out.println(acc.getBalance());
						System.out.println("acc Balance - " + acc.getBalance());
						out.println("</td>");
						out.println("</tr>");
					}
					out.println("</table>");
					out.println("</html>");
				}
				System.out.println("User Role - " + currentuser.getRole().getRoleId());
				if(currentuser.getRole().getRoleId() == 3) {
					out.println("<h3><a href=\"employee.jsp\"> Back to menu. </a></h3>");
				}
				else if(currentuser.getRole().getRoleId() == 4) {
					out.println("<h3><a href=\"admin.jsp\"> Back to menu. </a></h3>");
				}
				else if(currentuser.getRole().getRoleId() == 1) {
					out.println("<h3><a href=\"standardUser.jsp\"> Back to menu. </a></h3>");
				}
				else if(currentuser.getRole().getRoleId() == 2) {
					out.println("<h3><a href=\"premiumUser.jsp\"> Back to menu. </a></h3>");
				}
			}
		}
	}
	
	public void destroy() {
		System.out.println(this.getServletName() + " destroyed....");
		super.destroy();
	}
}
