<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Update product details</title>
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
	background-color: gery;
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

#name {
	position: relative;
	left: -80px;
	top: -525px;
	width: 550px;
}
</style>
<body>
	<h2 id="header" style="color: white;">Update products</h2>
	<nav class="list">
		<ul>
			<li><a href="index.jsp">SignOut</a></li>
		</ul>
	</nav>
	<form id="change" action="UpdateProduct" method="post">
		<label>Enter the product ID :</label><input type="text" name="pID"
			style="position: absolute; left: 700px;" autofocus required><br>
		<br> <label>Enter the New product Name :</label><input
			type="text" name="pName" style="position: absolute; left: 700px;"
			required><br>
		<br> <label>Enter the product price :</label><input type="text"
			name="price" style="position: absolute; left: 700px;" required><br>
		<br> <label>Enter the product category :</label><input
			type="text" name="pcat" style="position: absolute; left: 700px;"
			required><br>
		<br> <label>Enter the product quantity :</label><input
			type="text" name="pqty" style="position: absolute; left: 700px;"
			required><br>
		<br>



		<button type="submit" style="border-radius: 5px; padding: 3px">submit</button>

		<img id="name" alt="webName" src="Assests/name.png">
	</form>
</body>
</html>