<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><a href="Logout.jsp">logout</a></h1>
<form action="Add">
<label>Enter the product name</label>
<input type="text" name="pname" required>
<label>Enter the product ID</label>
<input type="text" name="pid" required>
<label>Enter the Price</label>
<input type="text" name="price" required>
<label>Enter the product category</label>
<input type="text" name="pcat" required>
<label>Enter the product quantity</label>
<input type="text" name="pqty" required>
<input type="submit" value="submit">
</form>
</body>
</html>