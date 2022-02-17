<%@page import="com.sportshopapp.model.UserReg"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>User profile</title>
<link id="tab" rel="icon" type="" href="Assests/tab.png">
</head>
<style>
body {
	font-family: "Lato", sans-serif;
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
}

body {
	background-image: url(Assests/bcg.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	background-attachment: fixed;
}

.sidebar a {
	background-color: rgba(158, 202, 207, 0.1);
	padding: 20px 2px 8px 16px;
	text-decoration: none;
	font-size: 15px;
	color: black;
	display: block;
	font-family: "Lato", sans-serif;
	top: 100px;
	font-family: Arial Black;
}

.sidebar a:hover {
	color: #f1f1f1;
}

.main {
	margin-left: 160px; /* Same as the width of the sidenav */
	padding: 0px 10px;
}

#allusers table, th, tr, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 10px;
	top: 150px;
}

#allusers {
	position: absolute;
	top: 200px;
	background-color: grey;
	left: 200px;
	right: 200px;
	bottom: 100px;
}

@media screen and (max-height: 450px) {
	.sidebar {
		padding-top: 50px;
	}
	.sidebar a {
		font-size: 18px;
	}
}
</style>
<body>
	<nav class="list">
		<ul>
			<li><a href="index.jsp">SignOut</a></li>
			<li><a href="cartserv">Cart</a></li>
			<li><a href="userProfile">MyProfile</a></li>
			<li><a href="myOrder.jsp">MyOrders</a></li>
			<li><a href="userView.jsp">Home</a></li>
		</ul>
		<div class="sidebar">
			<a href="changePassword.jsp"><em class="fa fa-fw fa-user"></em>>
				Change Password</a> <a href="addMoney.jsp"><em
				class="fa fa-fw fa-user"></em>> Add money to wallet</a>
		</div>
		<div class="main"></div>
		<div>
			<table id="allusers">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Address</th>
						<th>Email Id</th>
						<th>User Name</th>
						<th>Phone Number</th>
						<th>Wallet</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><c:out value="${customer.getFirstName()}" /></td>
						<td><c:out value="${customer.getLastName()}" /></td>
						<td><c:out value="${customer.getAddress()}" /></td>
						<td><c:out value="${customer.getEmail()}" /></td>
						<td><c:out value="${customer.getUserName()}" /></td>
						<td><c:out value="${customer.getPhone()}" /></td>
						<td><c:out value="${customer.getMyWallet()}" /></td>
					</tr>
				</tbody>
			</table>
		</div>

		</div>
</body>
</html>