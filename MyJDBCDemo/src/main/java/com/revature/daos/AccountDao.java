package com.revature.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.utils.ConnectionFactory;

// THE DAO : Data Access Object
// It's a structural design pattern that allows us to isolate the application/
// a.k.a business logic from the persistence layer (relational database) by using
// an API.....

// The JDBC is the API that gives us Classes and Objects to interact with our persistance layer.



// we are creating a concrete DAO to demo functionality and the 5 basic steps of JDBC connection
public class AccountDao {

	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 1. Establish the Connection Object\
		
		int s = 0;
		List<Account> accounts = new ArrayList<Account>();
		try {
			Connection conn = ConnectionFactory.getConnection();
			if( conn != null) {
				System.out.println("Congrats you're connected!");
			} else {
				System.out.println("Connection failed");
			}
			
		// 2. Create a Statement Object to send to the database (SQL)
			Statement  statement = conn.createStatement();
			

		// 3. Execute the Statement Object (this object contains the data from the database)	
			ResultSet resultSet = statement.executeQuery("SELECT * FROM account");
			if (resultSet != null) {
				System.out.println("RS not null");
			}
			
		// 4. Process the Result by iterating through the ResultSet.	
			while(resultSet.next()) {
				Account temp = new Account();
				s = resultSet.getInt("account_no");
				temp.setAccountNo(resultSet.getInt("account_no"));
				temp.setFirstName(resultSet.getString(2));
				temp.setLastName(resultSet.getString(3));
				temp.setBalance(resultSet.getInt(4));
				accounts.add(temp);
				System.out.println("Account No - " + s);
			}
			
			conn.close();
		} catch (SQLException e) {
			System.out.println("Your connection failed, sorry!");
			e.printStackTrace();
		}
		//System.out.println(s);
		System.out.println(accounts);
	}
	
	public Account create(Account acc) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "INSERT INTO account (account_no, first_name, last_name, balance) VALUES(?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,  getUserId());
			
			
			int numRows = ps.executeUpdate();
			
			if (numRows > 0) {								// Making sure the sql statement returned something
				ResultSet pk = ps.getGeneratedKeys();		// primary keys
				while (pk.next()) {
					acc.setAccountNo(pk.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
	}

	private int getUserId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
