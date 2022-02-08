<%@page import="java.util.List"%>
<%@page import="com.sportshopapp.daoimpl.OderItemsDAOImpl"%>
<%@page import="com.sportshopapp.daoimpl.OrderDetailDAOImpl"%>
<%@page import="com.sportshopapp.model.OrderItems"%>
<%@page import="com.sportshopapp.daoimpl.OrderDetailDAOImpl"%>
<%@page import="com.sportshopapp.model.UserReg"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="orderItem"
	class="com.sportshopapp.daoimpl.OderItemsDAOImpl" />
<jsp:useBean id="orderDao"
	class="com.sportshopapp.daoimpl.OrderDetailDAOImpl" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My orders</title>
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

.logo img {
	height: 60px;
	width: 60px;
	margin-left: 20px;
}

banner 
.slide {
	position: absolute;
	top: 120px;
}
/* progress 
.products {
margin-top: 5500px;
border-spacing: 0 200px;
} */
#copyrights {
	text-align: center;
	color: yellow;
}

#allproducts a {
	text-decoration: none;
	color: black;
}

#allproducts a:hover {
	text-decoration: underline;
	color: white;
}

#allproducts {
	text-align: center;
}

#product {
	position: relative;
	left: 50px;
	background-color: rgba(158, 202, 207, 0.5);
	height: 220px;
	border-radius: 5px;
	width: 1200px;
	top: 200px;
}

#product img {
	height: 100px;
	width: 90px;
	position: relative;
	left: 40px;
	top: 20px;
}

#product h3 {
	position: relative;
	left: 10px;
	top: 180px;
}

#product #details {
	box-shadow: 0 5 black;
	position: relative;
	left: 220px;
	top: -120px;
}

#product #btn {
	position: relative;
	left: 900px;
	top: -130px;
}

#product #btn button {
	height: 30px;
	width: 90px;
	background-color: orange;
	border: none;
	border-radius: 5px;
}

#btn1 {
	position: relative;
	left: 120px;
	top: -40px;
}

#product #btn button:hover {
	background-color: white;
	box-shadow: 0 0 5px black;
	color: green;
	color: orange;
}

#product #img h3 {
	position: relative;
	left: 40px;
	top: 20px;
}

#btn {
	position: relative;
	top: -40px;
}

a {
	text-decoration: none;
	color: black;
}
/* #userName{
position: relative;
left: 1100px;
} */
#idButton {
	position: relative;
	top: 160px;
}
/*  #names{
position: relative;
left: -135px;
top: -13px;
width: 550px;
}  */
/* #details {
	position: absolute;
} */

#tag {
	position: absolute;
	height:
}

#names {
	position: relative;
	left: -150px;
	top: -8394px;
	width: 550px;
}
</style>

<body>
	<c:if test="${cancelorder}">
		<h1>Order cancelled Successfully!!!</h1>
	</c:if>
	<div id="container">
		<div class="nav">
			<nav class="list">
				<ul>
					<li><a href="index.jsp">SignOut</a></li>
					<li><a href="cartserv">Cart</a></li>
					<li><a href="UserProfile">MyProfile</a></li>
					<li><a href="myOrder.jsp">MyOrders</a></li>
					<li><a href="userView.jsp">Home</a></li>
				</ul>
			</nav>
		</div>
	</div>
	<c:forEach items="${myOrderList}" var="myOrder">
		<c:set var="i" value="${i+1 }" />
		
			
		<div id="product">

			<h3>
				<c:out value="${myOrder.getUserName()}" />
			</h3>
			<div id="details">
				<h3>
					Price :Rs &nbsp;
					<c:out value="${myOrder.getUnitPrice()}" />
				</h3>

				<h3>
					Total Quantity:
					<c:out value="${myOrder.getQuantity()}" />
				</h3>

				<h3>
					Total Amount :
					<c:out value="${myOrder.getTotalPrice()}" />
				</h3>
			</div>
			<c:if test="${orderDao.checkStatus(myOrder.getOrderId())}">
				<div id="btn">
					<button id="idButton">
						<a id="cancel" name="cancelOrderPId"
							href="cancelorderserv?orderId=<c:out value="${myOrder.getOrderId()}" />">Cancel
							Order</a>
					</button>
			</c:if>
		</div>
		<br>
		<br>
		</div>
		<br>
	</c:forEach>
	</div>
	<div id="footer"></div>
	<img id="names" alt="webName" src="Assests/name.png">
</body>
</html>