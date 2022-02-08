
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User details update</title>
<link id="tab" rel="icon" type="" href="Assests/tab.png">
</head>
<body>
	<h1>
		<a href="index.jsp">logout</a>
	</h1>
	<form action="UpdateUser">
		<label>Enter user name</label> <input type="text" name="pID" required>
		<label>Enter the New product Name</label> <input type="text"
			name="pName" required> <label>Enter the New product
			Name</label> <input type="text" name="price" required> <label>Enter
			the New product Name</label> <input type="text" name="pcat" required>
		<label>Enter the New product Name</label> <input type="text"
			name="pqty" required>

		<button type="submit">submit</button>
	</form>
</body>
</html>