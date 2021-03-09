import java.sql.*;

public class JDBCDemo {

	public static void main(String[] args) throws Exception {
		
		String url = "jdbc:mysql://localhost:3306/student?useSSL=false&allowPublicKeyRetrieval=true";
		String userName = "root";
		String password = "Root123";
		String query = "";
		
		//Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, userName, password);
		Statement st = con.createStatement();
		
		//query = "insert into StudentName values (2,'Vanita')";
		//int count = st.executeUpdate(query);
		//System.out.println(count + "row(s) updated");
		
		query = "Select * from StudentName where RollNo = 2";
		ResultSet rs = st.executeQuery(query);
		int RollNo = 0;
		String Name = "";
		while(rs.next())
		{
			RollNo = rs.getInt("RollNo");
			Name = rs.getString("FirstName");
			
			System.out.println("Student id : " + RollNo + " Student Name : " + Name);
		}
		st.close();
		con.close();
	}

}

//mysql-connector-java-8.0.18.jar
