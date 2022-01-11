<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add product</title>
</head>
<body>
<h1><a href="Logout.jsp">logout</a></h1>
<form action="Add">
<label>Enter the product name</label>
<input type="text" name="pname" required><br><br>
<label>Enter the product ID</label>
<input type="text" name="pid" required><br><br>
<label>Enter the Price</label>
<input type="text" name="price" pattern = "[1-9][0-9]+"required><br><br>
<label>Enter the product category</label>
<input type="text" name="pcat" required><br><br>
<label>Enter the product quantity</label>
<input type="text" name="pqty" required><br><br>
<input type="submit" value="submit">
</form>
</body>
</html>