<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update product details</title>
</head>
<body>
<h1><a href="Logout.jsp">logout</a></h1>
<form action="UpdateProduct" method= "post">
<label>Enter the product ID</label>
<input type="text" name="pID" required>
<label>Enter the New product Name</label>
<input type="text" name="pName" required>
<label>Enter the product price</label>
<input type="text" name="price" required>
<label>Enter the product category</label>
<input type="text" name="pcat" required>
<label>Enter the product quantity</label>
<input type="text" name="pqty" required>



<button type="submit" >submit</button>
</form>
</body>
</html>