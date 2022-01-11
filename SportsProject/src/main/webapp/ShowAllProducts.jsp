
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

body {
	
	background-image: url(Assests/background.jpg);
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
</style>
<body>


<!-- <div class="sidebar">
 <a href="AddProduct.jsp"><i class="fa fa-fw fa-home"></i> ADD PROUCTS</a>
  <a href="InActiveProducts.jsp"><i class="fa fa-fw fa-wrench"></i> INACTIVE PRODUCTS</a>
  <a href="Orders.jsp"><i class="fa fa-fw fa-user"></i> CHANGE PRICE OF PRODUCTS</a>
  <a href="Product.jsp"><i class="fa fa-fw fa-envelope"></i> MODIFIY PRODUCT NAME</a>
</div> -->

<div class="main"></div>
  <%
  ProductDAOImpl obj = new ProductDAOImpl();
  List<Product> viewProducts =obj.viewAllProducts();
  %>
<div id="allusers">
<table>
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
</body>
</html>


