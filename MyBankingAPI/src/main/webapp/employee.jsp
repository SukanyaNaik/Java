
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Standard User</title>
</head>
<body>
<%
String userName = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) userName = cookie.getValue();
}
}
%>
<h1>Welcome <%=userName %>!</h1>
<br>
<form action="logoutServlet" method="post">
<table>
			<tr>
				<td>
					<h3><a href="findUserById.html"> Find user by id </a></h3>
				</td>
			</tr>
			
			<tr>
				<td>
					<h3><a href="findUserByName.html"> Find user by Name </a></h3>
				</td>
			</tr>
			
			<tr>
				<td>
					<h3><a href="findAccountById.html">Find account by id </a></h3>
				</td>	
			</tr>
			
			<tr>
				<td>
					<h3><a href="updateUser.html">Update User </a></h3>
				</td>
			</tr>
			
			<tr>
				<td>
					<h3><a href="deleteUser.html">Delete user by id </a></h3>
				</td>
			</tr>
		</table>
		
		<input type="submit" value="Logout" >
</form>
</body>
</html>
