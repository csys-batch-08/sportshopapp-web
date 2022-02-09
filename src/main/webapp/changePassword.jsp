<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Change password</title>
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

/* body {
overflow-x: hidden;
} */
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
	margin-top: 0%;
	right: 0px;
	width: 1372px;
}

.list ul {
	padding-right: 0px;
}

body {
	background-image: url(Assests/bcg.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	background-attachment: fixed;
	/* background-static: */
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

.text-block {
	position: absolute;
	bottom: 250px;
	right: 500px;
	background-color: #ebebe0;
	border-radius: 15px;
	color: black;
	padding-left: 30px;
	padding-right: 30px;
	padding-top: 30px;
	padding-bottom: 30px;
}

#name {
	position: relative;
	left: -135px;
	top: -160px;
	width: 550px;
}
</style>
<body>

	<nav class="list">
		<ul>
			<li><a href="index.jsp">SignOut</a></li>
			<li><a href="cartserv">Cart</a></li>
			<li><a href="UserProfile">MyProfile</a></li>
			<li><a href="MyOrder.jsp">MyOrders</a></li>
			<li><a href="UserView.jsp">Home</a></li>
		</ul>
	</nav>
	<form class="text-block" action="ChangePassword">
		<label for="userName">Enter User name</label> <input type="text"
			name="uname"> <br>
		<br> <label for="pword">New Password</label> <input
			type="password" name="pword" required min="8"> <br> <br>
		<input type="submit">
	</form>
	<img id="name" alt="webName" src="Assests/name.png">
</body>
</html>