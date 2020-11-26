<!DOCTYPE html> 
<html> 

<head> 
	<title> 
		Upgrade User
	</title> 
</head> 

<body> 
<form action="upgradeUserServlet" id="upgradeUser" method="post">
	<p> 
		Select a radio button and click on Submit. 
	</p> 
	
	Do you want to upgrade? : 
	<input type="radio" name="Choice" value="Yes">yes 
	<input type="radio" name="Choice" value="No">No 
	
	<br> 
	
	<button type="button" onclick="displayRadioValue()"> 
		Submit 
	</button> 
	
	<br> 
	
	  <script> 
		function displayRadioValue() { 
			var ele = document.getElementsByName('Choice'); 
			
			if(ele[0].checked) 
				document.getElementById("upgradeUser").submit();
			if(ele[1].checked) 
					document.location.href='login.html';
		} 
	</script> 
	</form>
</body> 
</html>					 
