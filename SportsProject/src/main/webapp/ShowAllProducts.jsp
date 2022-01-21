
 <%@page import="com.sportshopapp.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.sportshopapp.daoimpl.ProductDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All products</title>
<link id ="tab" rel = "icon" type = "" href = "Assests/tab.png">
</head>
<style>
body {font-family: "Lato", sans-serif;}

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
.list ul li {
	list-style: none;
	display: inline-block;
}
#tab{
width: 100%;
}

.list li {
	float: right;
	padding: 20px;
}
.list li{
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
  font-family:Arial Black;
}

.sidebar a:hover {
  color: #f1f1f1;
}

.main {
  margin-left: 160px; /* Same as the width of the sidenav */
  padding: 0px 10px;
}
 #allusers table,th,tr,td{
        border: 1px solid black;
        border-collapse: collapse;
        padding: 10px;
        }
             #allusers{
       position: absolute;
       top:100px;
       left:200px;
       right: 200px;
       bottom: 100px;
       }
       
@media screen and (max-height: 450px) {
  .sidebar {padding-top: 15px;}
  .sidebar a {font-size: 18px;}
}
#table{
background-color: grey;
top: 50px;
}
#names{
position: relative;
left: 395px;
top: -168px;
width: 550px;
}
#allusers{
position: absolute;
       top:150px;
       left:370px;

}
#products{

position: absolute;
       top:80px;
       left:590px;
color: white;
}
</style>
<body>
<h2 id="products"> All products</h2>
<nav class="list">
<ul>
<li> <a href="Login.jsp"><i class="fa fa-fw fa-home"></i> Sign out</a></li>
</ul>

  
</div> 

<div class="main"></div>
  <%
  ProductDAOImpl obj = new ProductDAOImpl();
  List<Product> viewProducts =obj.viewAllProducts();
  %>
<div id="allusers">
<table id="table">
<thead>
<tr>
<th>ProductName</th>
<th>ProductID</th>
<th>UnitPrice</th>
<th> Category</th>
<th> Quantity Available</th>
</tr>
</thead>
<tbody>
<%
for(Product product:viewProducts){
%>
<tr>
<td><%=product.getProductName()%></td>
<td><%=product.getProductId()%></td>
<td><%=product.getStrandardCost()%></td>
<td><%=product.getCategory()%></td>
<td><%=product.getQuantity() %></td>

</tr>
<%} %>
</tbody>
</table>
</div>
 
</div>
<img id="names" alt="webName" src="Assests/name.png">
</body>
</html>


