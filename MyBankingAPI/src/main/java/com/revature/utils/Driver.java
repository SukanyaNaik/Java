package com.revature.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.daos.AccountDao;
import com.revature.daos.UserDao;
import com.revature.models.User;

public class Driver {

	public static void main(String[] args) {
		
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
				//AccountDao ad = new AccountDao(conn);
				
				//ud.findAll();
				ud.findById(1002);
				//User user = new User();
				//user = ud.create(user);
				//ud.update();
				
				conn.close();
			}
			else {
				System.out.println("Connection failed.\n");
			}
			
		}
		
		catch(SQLException e) {
			System.out.println("Error connecting to the Databse.\n");
		}
		
	} // end of main function.
} // end of class Driver.
