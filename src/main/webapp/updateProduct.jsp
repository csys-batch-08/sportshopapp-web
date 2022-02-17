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
.sidebar {
	height: 100%;
	width: 160px;
	position: fixed;
	z-index: 1;
	top: 0;
	left: 0;
	background-color: #f0f0f5;
	overflow-x: hidden;
	padding-top: 16px;
	font-size: 13px;
}

.sidebar a {
	padding: 20px 2px 8px 16px;
	text-decoration: none;
	font-size: 13px;
	color: black;
	display: block;
	font-family: Arial Black;
}
.sidebar a:hover {
	background-color: rgba(158, 202, 207, 0.1);
}

.main {
	margin-left: 160px; /* Same as the width of the sidenav */
	padding: 0px 50px;
	top: 200px;
	padding-top: 100px;
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

.slidebar {
	top: 50px;
	padding-top: 100px;
}

@media screen and (max-height: 450px) {
	.sidebar {
		padding-top: 15px;
	}
	.sidebar a {
		font-size: 18px;
	}
}
</style>
<body>
	<h2 id="header" style="color: white;">Update products</h2>
	<nav class="list">
		<ul>
			<li><a href="index.jsp">SignOut</a></li>
		</ul>
		<div class="sidebar">
			<a href="ViewAllUsers"><em class="fa fa-fw fa-home"></em> All users</a> <a
				href="ShowAllProduct"><em class="fa fa-fw fa-wrench"></em> Show
				all products</a> <a href="updateProduct.jsp"><em
				class="fa fa-fw fa-envelope"></em> Update products</a> <a href="add.jsp"><em
				class="fa fa-fw fa-envelope"></em> Add products</a>
		</div>
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