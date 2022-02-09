<%@page import="com.sportshopapp.model.UserReg"%>
<%@page import="java.util.List"%>
<%@page import="com.sportshopapp.daoimpl.UserDAOImpl"%>
<%@page import="com.sportshopapp.dao.UserDaoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>All users</title>
<link id="tab" rel="icon" type="" href="Assests/tab.png">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>All users</title>
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

#name {
	position: relative;
	left: 70px;
	top: 40px;
	width: 550px;
}

#allusers {
	position: absolute;
	top: -200px;
	left: 300px;
	right: 200px;
	bottom: 100px;
	color: white;
}

#table {
	background-color: grey;
}

body {
	background-color: white;
}

#allusers table, th, tr, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 10px;
}

#users {
	position: absolute;
	top: 150px;
	left: 600px;
}
</style>
</head>

<body>
	<h2 id="users" style="color: white;">All users</h2>
	<nav class="list">
		<ul>
			<li><a href="index.jsp">SignOut</a></li>
		</ul>
	</nav>

	<div id="allusers">
		<table id="table">
			<thead>
				<tr>
					<th>User name</th>
					<th>Address</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Mail Id</th>
					<th>mobile</th>
					<th>Wallet</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userList}" var="current">
					<c:set var="i" value="${i+1 }" />
					<tr>
						<td><c:out value="${current.getUserName()}" /></td>
						<td><c:out value="${current.getAddress()}" /></td>
						<td><c:out value="${current.getFirstName()}" /></td>
						<td><c:out value="${current.getLastName()}" /></td>
						<td><c:out value="${current.getEmail()}" /></td>
						<td><c:out value="${current.getPhone()}" /></td>
						<td><c:out value="${current.getMyWallet()}" /></td>
					</tr>
				</c:forEach>
				<img id="name" alt="webName" src="Assests/name.png">
			</tbody>
		</table>
	</div>
</body>

</html>