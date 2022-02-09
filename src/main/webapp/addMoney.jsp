<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Wallet recharge</title>
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
	overflow-x: hidden;
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

signuptable {
	border-spacing: 5px;
}

body {
	background-image: url(Assests/bcg.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	background-attachment: fixed;
	/* background-static: */
}

}
#table {
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 10px 15px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 15px;
	margin: 4px 2px;
	cursor: pointer;
	top: -120px;
}

.table {
	top: -100px;
	right: 100px;
	height: 25px;
}

#mon {
	top: 100px;
	height: 120pc;
}

.container {
	position: relative;
	font-family: Arial;
}

.text-block {
	position: absolute;
	bottom: 300px;
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
	<div id="container">

		<div class="nav">

			<nav class="list">
				<ul>

					<li><a href="index.jsp">SignOut</a></li>
					<li><a href="cartserv">Cart</a></li>
					<li><a href="UserProfile">MyProfile</a></li>
					<li><a href="MyOrder.jsp">MyOrders</a></li>
					<li><a href="UserView.jsp">Home</a></li>

				</ul>
			</nav>
			<form class="text-block" action="addMoney">
				<label id="mon" for="money">Enter amount</label> <input
					class="table" type="text" name="wallet" min="100"
					pattern="[1-9][0-9]+" required> &nbsp; &nbsp;
				<button>Add</button>
			</form>
		</div>
	</div>
	<img id="name" alt="webName" src="Assests/name.png">
</body>
</html>