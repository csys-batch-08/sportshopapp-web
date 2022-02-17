
<%@page import="com.sportshopapp.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.sportshopapp.daoimpl.ProductDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>All products</title>
<link id="tab" rel="icon" type="" href="Assests/tab.png">
</head>
<style>
body {
	font-family: "Lato", sans-serif;
}

.sidebar {
	height: 100%;
	width: 160px;
	position: fixed;
	z-index: 1;
	top: 0;
	left: 0;
	background-color: lightgreen;
	overflow-x: hidden;
	padding-top: 16px;
}



body {
	background-image: url(Assests/bcg.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	background-attachment: fixed;
	/* background-static: */
}

.sidebar a {
	padding: 20px 2px 8px 16px;
	text-decoration: none;
	font-size: 15px;
	color: black;
	display: block;
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
}

#allusers {
	position: absolute;
	top: 100px;
	left: 200px;
	right: 200px;
	bottom: 100px;
}

@media screen and (max-height: 450px) {
	.sidebar {
		padding-top: 15px;
	}
	.sidebar a {
		font-size: 18px;
	}
}

#table {
	background-color: rgba(255, 255, 255, 0.903);
	top: 50px;
}

#names {
	position: relative;
	left: 395px;
	top: -270px;
	width: 550px;
}

#allusers {
	position: absolute;
	top: 150px;
	left: 370px;
}

#products {
	position: absolute;
	top: 80px;
	left: 590px;
	color: white;
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

#tab {
	width: 100%;
}

.list li {
	float: right;
	padding: 20px;
}

.list li {
	list-style: none;
}

.list ul {
	/* background-color: #10847E;*/
	height: 70px;
	position: absolute;
	margin-right: 0%;
	position: absolute;
	top: -25px;
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
	color: orange;
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
	<h2 id="products">All products</h2>
	<nav class="list">
		<ul>
			<li><a href="index.jsp"><em class="fa fa-fw fa-home"></em>>
					Sign out</a></li>
		</ul>
		<div class="sidebar">
			<a href="ViewAllUsers"><em class="fa fa-fw fa-home"></em>> All users</a> <a
				href="ShowAllProduct"><em class="fa fa-fw fa-wrench"></em>> Show
				all products</a> <a href="updateProduct.jsp"><em
				class="fa fa-fw fa-envelope"></em>> Update products</a> <a href="add.jsp"><em
				class="fa fa-fw fa-envelope"></em>> Add products</a>
		</div>
		</div>
		<div class="main"></div>
		<div id="allusers">
			<table id="table">
				<thead>
					<tr>
						<th>ProductName</th>
						<th>ProductID</th>
						<th>UnitPrice</th>
						<th>Category</th>
						<th>Quantity Available</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${viewProduct}" var="current">
						<c:set var="i" value="${i+1 }" />

						<tr>
							<td><c:out value="${current.getProductName()}" /></td>
							<td><c:out value="${current.getProductId()}" /></td>
							<td><c:out value="${current.getStrandardCost()}" /></td>
							<td><c:out value="${current.getCategory()}" /></td>
							<td><c:out value="${current.getQuantity()}" /></td>

						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>



		<img id="names" alt="webName" src="Assests/name.png">
</body>
</html>


