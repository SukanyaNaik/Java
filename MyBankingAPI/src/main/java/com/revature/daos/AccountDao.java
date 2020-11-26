package com.revature.daos;

import java.math.MathContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.AccountStatus;
import com.revature.models.AccountType;
import com.revature.models.User;

public class AccountDao implements DAO{
	private Connection conn;
	private ResultSet rs;

	public AccountDao(Connection conn) {
		this.conn = conn;
	}
	
	public void testAccountDao() {
		
		try {
			// 2. Create a statement object to send to the database.
			Statement statement = conn.createStatement();

			// 3. Execute the statement.
			String sql = "SELECT * FROM Account";
			ResultSet rs = statement.executeQuery(sql);

			// 4. Process the resultSet.
			if (rs != null) {
				System.out.println("RS not null\n");

				while(rs.next()) {
					String firstName = rs.getString(2);
					double balance = rs.getDouble(4);
					System.out.println("First Name  - " + firstName + " Balance - " + balance);
				}
			}

			// 5. close the connection.
			rs.close();
		}
		catch(SQLException e) {
			System.out.println("Connection failed.\n");
		}
	}

	public List findAll() {
		List <Account> accounts = new ArrayList<Account>();
		Account temp = new Account();
				
		Statement statement = null;
		try {
			String sql = "SELECT * FROM Account";
			statement = conn.createStatement();

			// 3. Execute the statement.
			rs = statement.executeQuery(sql);
			//createStatementAndExecuteQuery(sql);
			
			// 4. Process the resultSet.
			if (rs != null) {
				AccountStatus status = new AccountStatus();
				AccountType type = 	new AccountType();
				System.out.println("RS not null\n");
				
				while(rs.next()) {
					temp.setAccountId(rs.getInt(1));
					temp.setBalance(rs.getDouble(2));
					status.setStatusId(rs.getInt(3));
					type.setTypeId(rs.getInt(4));
					
					System.out.println("Account Id - " + temp.getAccountId() +
							"\t Balance - " + temp.getBalance() +
							"\t Status Id - " + rs.getInt(3) +
							"\t Type Id - " + rs.getInt(4));
					accounts.add(temp);
				}
				 rs.close();
			}
		}
		
		catch(SQLException e) {
			System.out.println("Connection failed.\n");
		}
		
		int statusId = 0;
		for (int i = 0; i < accounts.size(); i++) {
			
			Account tempAccount = accounts.get(i);
			AccountStatus tempAccountStatus = tempAccount.getStatus();
			statusId = tempAccountStatus.getStatusId();
			
			try {
				String statusQuery = "SELECT * FROM AccountStatus WHERE StatusId = " + statusId;
				ResultSet statusRs = statement.executeQuery(statusQuery);
							
				if(statusRs.next()) {
					tempAccountStatus.setStatus(statusRs.getString(2));
					tempAccount.setStatus(tempAccountStatus);
					
					System.out.println("Status Id - " + tempAccountStatus.getStatusId() +
									   " Status - " + tempAccountStatus.getStatus());
					
					statusRs.close();
				}
			}
			catch(SQLException e) {
				System.out.println("Connection failed.\n");
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		
		int typeId = 0;
		for (int i = 0; i < accounts.size(); i++) {
			Account tempAccount = accounts.get(i);
			AccountType tempAccountType = tempAccount.getType();
			typeId = tempAccountType.getTypeId();
			
			try {
				String typeQuery = "SELECT * FROM AccountType WHERE TypeId = " + typeId;
				ResultSet typeRs = statement.executeQuery(typeQuery);
							
				if(typeRs.next()) {
					tempAccountType.setTypeName(typeRs.getString(2));
					tempAccount.setType(tempAccountType);
					
					System.out.println("Type Id - " + tempAccountType.getTypeId() + 
									   " Type Name - " + tempAccountType.getTypeName());
					
					typeRs.close();
				}
			}
			catch(SQLException e) {
				System.out.println("Connection failed.\n");
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		return null;
	}

	public Object findById(Integer id) {
		
		int statusId = 0, typeId = 0;
		
		Account tempAccount = null;
		AccountStatus tempStatus = new AccountStatus();
		AccountType tempType = new AccountType();
		
		Statement statement = null;
		String sql = "SELECT * FROM Account where AccountId = " + id;
		
		try {
			// 2. Create a statement object to send to the database.
			statement = conn.createStatement();

			// 3. Execute the statement.
			rs = statement.executeQuery(sql);
			
			// 4. Process the resultSet.
			if (rs != null) {
				if(rs.next()) {
					tempAccount = new Account();
				    System.out.println("RS not null\n");
							
					do {	
						System.out.println("RS not null\n");
						tempAccount.setAccountId(rs.getInt(1));
						tempAccount.setBalance(rs.getDouble(2));

						System.out.println("Account Id - " + tempAccount.getAccountId() +
									   " Balance - " + tempAccount.getBalance() + 
									   " Account Status - " + rs.getInt(3) +
									   " Account Type - " + rs.getInt(4));
		
						statusId = rs.getInt(3);
						typeId = rs.getInt(4);
						tempStatus.setStatusId(statusId);
						tempType.setTypeId(typeId);

					}while(rs.next()) ;
				}
				// 5. close the connection.
				rs.close();
			}
		}
		catch(SQLException e) {
			System.out.println("Connection failed.\n");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		try {
			String roleQuery = "SELECT * FROM AccountStatus WHERE StatusId = " + statusId;
			ResultSet statusRs = statement.executeQuery(roleQuery);
						
			if(statusRs.next()) {
				tempStatus.setStatus(statusRs.getString(2));
				tempAccount.setStatus(tempStatus);
				System.out.println("Status Id - " + tempStatus.getStatusId() + 
								   " Status - " + tempStatus.getStatus());
				statusRs.close();
			}
		}
		catch(SQLException e) {
			System.out.println("Connection failed.\n");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		try {
			String roleQuery = "SELECT * FROM AccountType WHERE TypeId = " + typeId;
			ResultSet typeRs = statement.executeQuery(roleQuery);
						
			if(typeRs.next()) {
				tempType.setTypeName(typeRs.getString(2));
				tempAccount.setType(tempType);
				System.out.println("Type Id - " + tempType.getTypeId() + 
								   " Type - " + tempType.getTypeName());
				typeRs.close();
			}
		}
		catch(SQLException e) {
			System.out.println("Connection failed.\n");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return tempAccount;
	}

	public Account update(Account acc) {
		String sql = "UPDATE Account  "
				+ "set UserName = ?, "
				+ "Pwd = ?, "
				+ "FirstName = ?, "
				+ "LastName = ?, "
				+ "Email = ?, "
				+ "RoleId_ref = ? "
				+ "where UserId = ?";
		
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
	
			int numRows = ps.executeUpdate();
			conn.commit();
			if (numRows > 0) {								// Making sure the sql statement returned something
				ResultSet pk = ps.getGeneratedKeys();		// primary keys
				while (pk.next()) {
//					user.setUserId(pk.getInt(1));
				}
			}
		}
		catch(SQLException e) {
			System.out.println("Connection failed.\n");
			e.printStackTrace();
		}
		return null;
	}

	public boolean openNewAccount(User user, Account account) {
		
		boolean isAccountCreated = false;
		System.out.println("User Id = " + user.getUserId());
		System.out.println("Account Id = " + account.getAccountId());
		
		String sql = "INSERT INTO UserAccount (UserId_ref, AccountId_ref) VALUES(?, ?)";
		
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, user.getUserId());
			ps.setInt(2, account.getAccountId());
			
			int numRows = ps.executeUpdate();
			
			if (numRows > 0) {								// Making sure the sql statement returned something
				ResultSet pk = ps.getGeneratedKeys();		// primary keys
				while (pk.next()) {
//					user.setUserId(pk.getInt(1));
					System.out.println("User Id - " + pk.getInt(1));
					System.out.println("Opened new account for " + user.getUsername());
				}
				isAccountCreated = true;
			}
			conn.commit();
		}
		catch(SQLException e) {
			System.out.println("Connection failed.\n");
			e.printStackTrace();
		}
		return isAccountCreated;
	}
	
	
	public Object create(Object obj) {
		
		Account account = (Account) obj;
		AccountType accountType = null;
		AccountStatus accountStatus = null;
		
		//String sql = "INSERT INTO Account (AccountId, Balance, StatusId_ref, TypeId_ref) "
		//		+ "VALUES(sequence.nextval,?, ?, ?)" +
		//		 "  returning AccountId into ?";
		
		String sql = "INSERT INTO Account (Balance, StatusId_ref, TypeId_ref) "
						+ "VALUES(?, ?, ?)" ;
				
		int statusId = 1;
		int typeId = 0;
		int accountId = 0;
		
		try {
			conn.setAutoCommit(false);
			//String generatedColumns[] = {"AccountId"};
			PreparedStatement ps = conn.prepareStatement(sql,new String[] { "AccountId" });

			ps.setDouble(1, 0);
			ps.setInt(2, statusId);
			
			typeId = account.getType().getTypeId();
			System.out.println("Account Type - " + account.getType().getTypeId());
			System.out.println("Type id = " + typeId);
			ps.setInt(3, typeId);
			
			int numRows = ps.executeUpdate();
			
			if (numRows > 0) {								// Making sure the sql statement returned something
				ResultSet pk = ps.getGeneratedKeys();		// primary keys
		
				while (pk.next()) {
					System.out.println("Account Id - " + pk.getLong(1));
					accountId = (int) pk.getLong(1);
					account.setAccountId(accountId);
				}
			}
			conn.commit();
		}
		catch(SQLException e) {
			System.out.println("Connection failed.\n");
			e.printStackTrace();
		}
		
		try {
			// 2. Create a statement object to send to the database.
			Statement statement = conn.createStatement();
			String accountStatusSQL = "SELECT Status FROM AccountStatus WHERE StatusId = " + statusId;
			
			// 3. Execute the statement.
			rs = statement.executeQuery(accountStatusSQL);
			
			// 4. Process the resultSet.
			if (rs != null) {
				System.out.println("RS not null\n");
							
				while(rs.next()) {
					//accountStatus = new AccountType()
					accountStatus = new AccountStatus();
					accountStatus.setStatusId(statusId);
					accountStatus.setStatus(rs.getString(1));
					account.setStatus(accountStatus);
				}
				rs.close();
			}
		}
		catch(SQLException e) {
			System.out.println("Connection failed.\n");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		try {
			// 2. Create a statement object to send to the database.
			Statement statement = conn.createStatement();
			String accountTypeSQL = "SELECT TypeName FROM AccountType WHERE TypeId = " + typeId;
			
			// 3. Execute the statement.
			rs = statement.executeQuery(accountTypeSQL);
			
			// 4. Process the resultSet.
			if (rs != null) {
				System.out.println("RS not null\n");
							
				while(rs.next()) {
					accountType = new AccountType();
					accountType.setTypeId(typeId);
					accountType.setTypeName(rs.getString(1));
					account.setType(accountType);
				}
				rs.close();
			}
		}
		catch(SQLException e) {
			System.out.println("Connection failed.\n");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return account;
	}

	public Account findAccountByUserId(int userId) {
		Account acc = null;
		Statement statement1 = null;
		int accountId = 0;
				
		String userAccountSql = "SELECT AccountId_ref FROM UserAccount where UserId_ref = " + userId;
		
		try {
			// 2. Create a statement object to send to the database.
			statement1 = conn.createStatement();

			// 3. Execute the statement.
			rs = statement1.executeQuery(userAccountSql);
			
			// 4. Process the resultSet.
			if (rs != null) {
				System.out.println("RS not null\n");
							
				while(rs.next()) {
					accountId = rs.getInt(1);	
				}
				rs.close();
			}
			if(accountId != 0) {
				acc = new Account();
				acc = (Account) findById(accountId);
			}
		}
		catch(SQLException e) {
			System.out.println("Connection failed.\n");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return acc;
	}
		
	public boolean withdraw(Account acc, double amount) {
		
		String status = acc.getStatus().getStatus();
		double newBalance = acc.getBalance() - amount;
		boolean isUpdated = false;
		if(status.equals("Open") && newBalance >= 10) {
			String sql = "UPDATE Account "
					+ "set Balance = ? "
					+ "where AccountId = ?";
			try {
				conn.setAutoCommit(false);
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setDouble(1,newBalance);
				ps.setInt(2, acc.getAccountId());
			
				int numRows = ps.executeUpdate();
				conn.commit();
				if (numRows > 0) {								// Making sure the sql statement returned something
					ResultSet pk = ps.getGeneratedKeys();		// primary keys
					while (pk.next()) {
//						user.setUserId(pk.getInt(1));
					}
					isUpdated = true;
				}
			}
			catch(SQLException e) {
				System.out.println("Connection failed.\n");
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Account is not open");
		}
		return isUpdated;
	}
	
	public boolean deposit(Account acc, double amount) {
		
		String status = acc.getStatus().getStatus();
		double newBalance = acc.getBalance() + amount;
		boolean isUpdated = false;
		if(status.equals("Open")) {
			String sql = "UPDATE Account "
					+ "set Balance = ? "
					+ "where AccountId = ?";
			try {
				conn.setAutoCommit(false);
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setDouble(1,newBalance);
				ps.setInt(2, acc.getAccountId());
			
				int numRows = ps.executeUpdate();
				conn.commit();
				if (numRows > 0) {								
					isUpdated = true;
					// Making sure the sql statement returned something
					ResultSet pk = ps.getGeneratedKeys();		
					// primary keys
					while (pk.next()) {
//						user.setUserId(pk.getInt(1));
					}
				}
			}
			catch(SQLException e) {
				System.out.println("Connection failed.\n");
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Account is not open");
		}
		return isUpdated;
	}
	
	public Object update(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object findById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}
}
