package com.revature.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daos.AccountDao;
import com.revature.daos.UserDao;
import com.revature.models.Account;
import com.revature.models.AccountType;
import com.revature.models.User;

public class OpenNewJointAccountServlet extends HttpServlet {

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

		String choice = req.getParameter("Choice");
		String userName = req.getParameter("userName");
		System.out.println(this.getServletName() + " Service method called.");
		System.out.println("Choice = " + choice);
		
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
				HttpSession session = req.getSession();
				
				UserDao ud = new UserDao(conn);
				User user = (User) session.getAttribute("CurrentUser");
				
				AccountDao ad = new AccountDao(conn);
				Account account = new Account();
				AccountType accountType = new AccountType();
				
				user = ud.findByUserName(user.getUsername());
				if(choice.equals("Checking")) {
					accountType.setTypeId(1);
					account.setType(accountType);
					account = (Account) ad.create(account);
					ad.openNewAccount(user,account);
				}
				else {
					accountType.setTypeId(2);
					account.setType(accountType);
					account = (Account) ad.create(account);
					ad.openNewAccount(user,account);
				}
				
				int accountId = 0;
				
				System.out.println("User Name - " + user.getUsername());
				accountId = ud.addUserToAccount(user, userName);

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
