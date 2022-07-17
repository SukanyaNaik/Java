package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.models.UserAccount;
import com.revature.utils.FindUserByIdServlet;

public class UserDao implements DAO <User, Integer>{
	
	private Connection conn;
	private ResultSet rs;
	
	
	public UserDao(Connection conn) {
		this.conn = conn;
	}
	
	public void testUserDao() {
		
		try {
			// 2. Create a statement object to send to the database.
			Statement statement = conn.createStatement();

			// 3. Execute the statement.
			String sql = "SELECT * FROM Account";
			rs = statement.executeQuery(sql);

			// 4. Process the resultSet.
			if (rs != null) {
				System.out.println("RS not null\n");

				while(rs.next()) {
					int firstName = rs.getInt(1);
					double balance = rs.getDouble(2);
					System.out.println("Account Number- " + firstName + "\tBalance- " + balance);
				}
			}

			// 5. close the connection.
			 rs.close();
		}
		
		catch(SQLException e) {
			System.out.println("Connection failed.\n");
		}
	}

	public List<User> findAll() {
		List <User> users = new ArrayList<User>();
		User temp = new User();
				
		Statement statement = null;
		try {
			String sql = "SELECT * FROM Users";
			statement = conn.createStatement();

			// 3. Execute the statement.
			rs = statement.executeQuery(sql);
			//createStatementAndExecuteQuery(sql);
			
			// 4. Process the resultSet.
			if (rs != null) {
				Role role = new Role();
								
				System.out.println("RS not null\n");
				
				while(rs.next()) {
					temp.setUserId(rs.getInt(1)); 
					temp.setUsername(rs.getString(2));
					temp.setPassword(rs.getString(3));
					temp.setFirstName(rs.getString(4));
					temp.setLastName(rs.getString(5));
					temp.setEmail(rs.getString(6));
					role.setRoleId(rs.getInt(7));
					
					System.out.println("UserId- " + temp.getUserId() +
							"\t User Name- " + temp.getUsername() +
							"\t Password- " + temp.getPassword() +
							"\t First Name- " + temp.getFirstName() +
							"\t Last Name- " + temp.getLastName() +
							"\t - Email- " + temp.getEmail() +
							"\t Role Id- " + rs.getInt(7));
					users.add(temp);
				}
				 rs.close();
			}
		}
		
		catch(SQLException e) {
			System.out.println("Connection failed.\n");
		}
		
		int roleId = 0;
		for (int i = 0; i < users.size(); i++) {
			User tempUser = users.get(i);
			Role tempRole = tempUser.getRole(); 
			roleId = tempRole.getRoleId();
			
			try {
				String roleQuery = "SELECT * FROM RoleTable WHERE roleId = " + roleId;
				ResultSet roleRs = statement.executeQuery(roleQuery);
							
				if(roleRs.next()) {
					tempRole.setRole(roleRs.getString(2));
					tempUser.setRole(tempRole);
					System.out.println("Role Id - " + tempRole.getRole() + "Role - " + tempRole.getRole());
					roleRs.close();
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

	public User findById(Integer id) {
		
		int roleId = 0;
		List <User> users = new ArrayList<User>();
		User temp = null;
		Role role = new Role();
		
		Statement statement = null;
		String sql = "SELECT * FROM Users where UserId = " + id;
		
		try {
			// 2. Create a statement object to send to the database.
			statement = conn.createStatement();

			// 3. Execute the statement.
			rs = statement.executeQuery(sql);
			
			// 4. Process the resultSet.
			if (rs != null) {
				if(rs.next()) {
					temp = new User();
				    System.out.println("RS not null\n");
							
					do {
						temp.setUserId(rs.getInt(1));
						temp.setUsername(rs.getString(2));
						temp.setPassword(rs.getString(3));
						temp.setFirstName(rs.getString(4));
						temp.setLastName(rs.getString(5));
						temp.setEmail(rs.getString(6));

						System.out.println("UserId- " + temp.getUserId() + "\t User Name- " + temp.getUsername()
								+ "\t Password- " + temp.getPassword() + "\t First Name- " + temp.getFirstName()
								+ "\t Last Name- " + temp.getLastName() + "\t Email- " + temp.getEmail()
								+ "\t Role Id- " + rs.getInt(7));

						roleId = rs.getInt(7);
						role.setRoleId(roleId);
						users.add(temp);
						
					} while (rs.next());
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
			String roleQuery = "SELECT * FROM RoleTable WHERE roleId = " + roleId;
			ResultSet roleRs = statement.executeQuery(roleQuery);
						
			if(roleRs.next()) {
				role.setRole(roleRs.getString(2));
				temp.setRole(role);
				System.out.println("Role Id - " + role.getRole() + "Role - " + role.getRole());
				roleRs.close();
			}
		}
		catch(SQLException e) {
			System.out.println("Connection failed.\n");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return temp;
	}

	public User findByUserName(String userName) {
		int roleId = 0;
		
		User temp = null;
		Role role = new Role();
		
		Statement statement = null;
		String sql = "SELECT * FROM Users where UserName = '" + userName + "'";
		
		try {
			// 2. Create a statement object to send to the database.
			statement = conn.createStatement();

			// 3. Execute the statement.
			rs = statement.executeQuery(sql);
			
			// 4. Process the resultSet.
			if (rs != null) {
				if(rs.next()) {
					//temp = new User();		
					System.out.println("RS not null\n");

					do {
						temp = new User();
						temp.setUserId(rs.getInt(1));
						temp.setUsername(rs.getString(2));
						temp.setPassword(rs.getString(3));
						temp.setFirstName(rs.getString(4));
						temp.setLastName(rs.getString(5));
						temp.setEmail(rs.getString(6));

						roleId = rs.getInt(7);
						role.setRoleId(roleId);
						// users.add(temp);
					} while (rs.next());
				
				}//if
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
			String roleQuery = "SELECT * FROM RoleTable WHERE roleId = " + roleId;
			ResultSet roleRs = statement.executeQuery(roleQuery);
						
			if(roleRs.next()) {
				role.setRole(roleRs.getString(2));
				temp.setRole(role);
				System.out.println("Role Id - " + role.getRole() + "Role - " + role.getRole());
				roleRs.close();
			}
		}
		catch(SQLException e) {
			System.out.println("Connection failed.\n");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return temp;
	}
	
	public User create(User user) {
		
		User tempUser = null;
		String sql = "INSERT INTO Users (UserName, Pwd, FirstName, LastName, Email, RoleId_ref) VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getEmail());
			ps.setInt(6, 1);
			
			int numRows = ps.executeUpdate();
			
			if (numRows > 0) {								// Making sure the sql statement returned something
				ResultSet pk = ps.getGeneratedKeys();		// primary keys
				while (pk.next()) {
					user.setUserId(pk.getInt(1));
					System.out.println("User Id - " + pk.getInt(1));
				}
				tempUser = user;
			}
			conn.commit();
		}
		catch(SQLException e) {
			System.out.println("Connection failed.\n");
			e.printStackTrace();
		}
		return tempUser;
	}

	public User updateUserInfo(User user) {
		User tempUser = null;
		
		tempUser = findByUserName(user.getUsername());
		if(tempUser != null) {
			user.setUserId(tempUser.getUserId());
			user.setRole(tempUser.getRole());
			tempUser = update(user);
		}

		return tempUser;
	}
	
	public User update(User user) { 

		String sql = "UPDATE Users "
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

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getEmail());
			ps.setInt(6,user.getRole().getRoleId());
			ps.setInt(7,user.getUserId());
			
			int numRows = ps.executeUpdate();
			conn.commit();
			
			if (numRows > 0) {								// Making sure the sql statement returned something
				ResultSet pk = ps.getGeneratedKeys();		// primary keys
				while (pk.next()) {
					user.setUserId(pk.getInt(1));
				}
			}
		}
		catch(SQLException e) {
			System.out.println("Connection failed.\n");
			e.printStackTrace();
		}
		return user;
	}
	
	
	public boolean deleteUserById(int userId) {
		boolean ifDeleted = false;
		
		String sql = "DELETE FROM Users where UserId = " + userId;
		
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			
			int numRows = ps.executeUpdate();
			conn.commit();
			if (numRows > 0) {								// Making sure the sql statement returned something
				ifDeleted = true;
			}
		}
		catch(SQLException e) {
			System.out.println("Connection failed.\n");
			e.printStackTrace();
		}
		
		return ifDeleted;
	}
	
	
	public void upgrade(User user) {
		user.getRole().setRoleId(2);
		user = update(user);
	}
	
	
	public int addUserToAccount(User user, String userName) {
		System.out.println("Let's add user");
		User tempUser = null;
		UserAccount uc = null;
		int accountId = 0;
		
		tempUser = findByUserName(userName);
		if(tempUser != null) {
			System.out.println("User found");
			
			String sql = "SELECT AccountId_ref FROM UserAccount where UserId_ref = " + user.getUserId();
			
			try {
				// 2. Create a statement object to send to the database.
				Statement statement = conn.createStatement();

				// 3. Execute the statement.
				rs = statement.executeQuery(sql);
				
				// 4. Process the resultSet.
				if (rs != null) {
											
					System.out.println("RS not null\n");
					while(rs.next()) {
						accountId = rs.getInt(1);
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
				uc = new UserAccount();
				uc.setAccountId(accountId);
				uc.setUserId(tempUser.getUserId());
				
				String userAccountSql = "INSERT INTO UserAccount (UserId_ref, AccountId_ref)"
						+ " VALUES(" + uc.getUserId() + "," + uc.getAccountId()+ ")";
				
				Statement statement = conn.createStatement();
				
				conn.setAutoCommit(false);
				int numRows = statement.executeUpdate(userAccountSql);
				
				if (numRows > 0) {								// Making sure the sql statement returned something
					conn.commit();
					System.out.println("User was successfully added");
				}
			}
			catch(SQLException e) {
				System.out.println("Connection failed.\n");
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		
		}
		else {
			System.out.println("User not found");
		}
		
		return accountId;
	}
	
	
	public void createStatementAndExecuteQuery(String sql)
	{
		try {
			// 2. Create a statement object to send to the database.
			Statement statement = conn.createStatement();

			// 3. Execute the statement.
			rs = statement.executeQuery(sql);
		}
		catch(SQLException e) {
			System.out.println("Connection failed.\n");
		}
	}
		
	
	public void createStatementAndExecutePreparedStatement(String sql) {
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//ps.setInt(1,  getUserId());
			
			
			int numRows = ps.executeUpdate();
			
			if (numRows > 0) {
			}
		}
		catch(SQLException e) {
			System.out.println("Connection failed.\n");
		}
	}
	

	public User login(User user) {
	
		User temp = null;
		Role role = new Role();
		int roleId = 0;
		Statement statement = null;
		// String sql = "SELECT Pwd, RoleId_ref FROM Users where UserName = '" +
		// user.getUsername() + "'";
		String sql = "SELECT * FROM Users where "
				+ "UserName = '" + user.getUsername() + "'" 
				+ "AND Pwd = '" + user.getPassword() + "'";

		System.out.println("Query - " + sql);
		try {
			// 2. Create a statement object to send to the database.
			statement = conn.createStatement();

			// 3. Execute the statement.
			rs = statement.executeQuery(sql);

			// 4. Process the resultSet.
			while (rs.next()) {
				temp = new User();
				temp.setUserId(rs.getInt(1));
				temp.setUsername(rs.getString(2));
				temp.setPassword(rs.getString(3));
				temp.setFirstName(rs.getString(4));
				temp.setLastName(rs.getString(5));
				temp.setEmail(rs.getString(6));
				// rs.getInt(7);
				System.out
						.println("UserId- " + temp.getUserId() + "\t User Name- " + temp.getUsername() + "\t Password- "
								+ temp.getPassword() + "\t First Name- " + temp.getFirstName() + "\t Last Name- "
								+ temp.getLastName() + "\t Email- " + temp.getEmail() + "\t Role Id- " + rs.getInt(7));

				roleId = rs.getInt(7);
				role.setRoleId(roleId);
			}
			rs.close();

		}

		catch (SQLException e) {
			System.out.println("Connection failed.\n");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		try {
			String roleQuery = "SELECT * FROM RoleTable WHERE roleId = " + roleId;
			ResultSet roleRs = statement.executeQuery(roleQuery);

			if (roleRs.next()) {
				role.setRole(roleRs.getString(2));
				temp.setRole(role);
				System.out.println("Role Id - " + role.getRole() + "Role - " + role.getRole());
				roleRs.close();
			}
		} catch (SQLException e) {
			System.out.println("Connection failed.\n");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return temp;
	}

}
