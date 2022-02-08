<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add product</title>
<link id="tab" rel="icon" type="" href="Assests/tab.png">
</head>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}

.list ul li {
	list-style: none;
	display: inline-block;
}

.list li {
	float: right;
	padding: 20px;
}

.list ul {
	/* background-color: #10847E;*/
	height: 70px;
	position: absolute;
	margin-right: 0%;
	position: absolute;
	top: 0;
	background-color: rgba(255, 255, 255, 0.603);
	box-shadow: 0 5 black;
	/* margin-top: 0%; */
	right: 0px;
	width: 1372px;
}

.list ul {
	padding-right: 0px;
}

.list ul, .list li, .list a {
	text-decoration: none;
	color: black;
	font-family: monospace;
	font-size: 25px;
	font-weight: 500;
	/* margin-right: 20px; */
}

.list li:hover, .list a:hover {
	color: white;
	background-color: orange;
	border-radius: 5px;
	cursor: pointer;
}

body {
	background-image: url(Assests/bcg.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	background-attachment: fixed;
	/* background-static: */
}

#name {
	position: relative;
	left: 380px;
	top: -680px;
	width: 550px;
}

#change {
	width: 480px;
	height: 250px;
	margin: 10% auto;
	background: transparent;
	padding: 20px;
	top: 100px;
	left: 100px;
	color: white;
	padding-left: 35px;
	background-color: grey;
	border-radius: 10px;
}

#header {
	position: absolute;
	top: 100px;
	left: 570px;
}
</style>
<body>
	<h2 id="header" style="color: white;">Add products</h2>
	<nav class="list">
		<ul>
			<li><a href="login.jsp">Sign Out</a></li>
		</ul>
	</nav>
	<form id="change" action="Add">
		<label>Enter the product name :</label> <input type="text"
			name="pname" style="position: absolute; left: 670px;" autofocus
			required><br>
		<br> <label>Enter the product Id :</label> <input type="text"
			name="prodid" style="position: absolute; left: 670px;" required><br>
		<br> <label>Enter the Price :</label> <input type="text"
			name="price" pattern="[1-9][0-9]+"
			style="position: absolute; left: 670px;" required><br>
		<br> <label>Enter the product category :</label> <input
			type="text" name="pcat" style="position: absolute; left: 670px;"
			required><br>
		<br> <label>Enter the product quantity :</label> <input
			type="text" name="pqty" style="position: absolute; left: 670px;"
			required><br>
		<br> <label>Enter the product image :</label> <input type="file"
			name="pimg" style="position: absolute; left: 670px;" required><br>
		<br> <input type="submit"
			style="border-radius: 5px; padding: 3px">
	</form>
	<img id="name" alt="webName" src="Assests/name.png">
</body>
</html>