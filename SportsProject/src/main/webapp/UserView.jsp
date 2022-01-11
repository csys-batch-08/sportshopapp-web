<%@page import="java.util.List"%>
<%@page import="com.sportshopapp.model.UserReg"%>
<%@page import="com.sportshopapp.model.Product"%>
<%@page import="com.sportshopapp.daoimpl.ProductDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@page import="javax.servlet.http.HttpSession"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
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
 background-color: #10847E;
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

.list ul, .list li, .list a {
text-decoration: none;
color: black;
font-family: monospace;
font-size: 25px;
font-weight: 500;
 margin-right: 20px; 
}

.list li:hover, .list a:hover {
color: white;
background-color: orange;
border-radius: 5px;
cursor: pointer;
}

/*  body {
background: linear-gradient(rgba(26,176,156,0.7),rgba(239,78,28,0.5)) ,url(Images/homepage_img.jpg); 
background-image: url(Images/homepage_img.jpg);
background-repeat: no-repeat;
background-size: cover;
}  */

.logo img {
height: 60px;
width: 60px;
margin-left: 20px;
} 
body {
	
	background-image: url(Assests/background.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	background-attachment: fixed;
	/* background-static: */
}

.buyProduct {
position: absolute;
top: 150px;
left: 170px;
}
.buyProduct{
background-color: rgba(158, 202, 207,0.5);
width: 900px;
height: 300px;
border-radius: 5px;
}

.buyProduct img {
position:relative;
left:-30px;
height: 220px;
width: 220px;
} 

#qty {
position: relative;
left: 20px;
top: 74px;
}

#qty button {
position: relative;
left: 80px;
}

#qty input {
width: 40px;
position: relative;
}

#qty #qtyBox {
position: relative;
left: -30px;
}

.buyProduct td p{
padding-top: 20px;
position: relative;
left:-100px;
}
#addToCart a{
background-color: green;
text-decoration: none;
}
#buyNow a{
background-color: green;
color: white;
text-decoration: none;
}
#addToCart:hover{
cursor: pointer;
}
#buyNow:hover{
cursor: pointer;
}
#price{
position: relative;
left: -100px;
top:8px;
outline: none;
border: none;
background-color: rgba(158, 202, 207,0.1);
color: black;
}
 #pImg{
position: relative;
height: 200px;
width: 170px;
left:10px;
} 
#pDesc{
position: relative;
left: 40px;
}
#totalprice{
position: relative;
top:-190px;
left:90px;
}
#TotalPriceLabel{
position: relative;
top:-170px;
right: 50px;
}

#offer{
position: relative;
left: -100px;
top:8px;
outline: none;
border: none;
background-color: rgba(158, 202, 207,0.1);
color: black;
}
</style>
</head>
<body>
<%
 
UserReg currentUser = (UserReg)session.getAttribute("logincustomer");%>
<div id="container">

<div class="nav">

<nav class="list">
<ul>
<li><a href= "Cart.jsp">Cart</a></li>
<li><a href ="Login.jsp">SignOut</a></li>
<li><a href ="UserProfile.jsp">MyProfile</a></li>
<li><a href= "MyOrder.jsp?orderId=0">MyOrders</a></li>
<li><a href="UserView.jsp">Home</a></li>
</ul>
<br><br><br><br>
<div id="serachbar">
<input type="text" id="searchProduct"  name="searchProduct" required>
<a href="AllProducts.jsp"><button>search</button></a>
<h2 id="userName">welcome <%=currentUser.getUserName() %></h2>
</div>
<br><br><br>

<% ProductDAOImpl product= new ProductDAOImpl();
List<Product> productList = product.viewAllProducts();
%>
<% for(Product products : productList)

{
%>

<div id="product">

<h3><%=products.getProductName() %></h3>
</div>
<div id="category">

<h3>Category : <%=products.getCategory() %></h3>
</div>
<div id="details">

<h3>Available quantity : <%=products.getQuantity() %></h3>
</div>
<div id="details">

<h3>
price : <%=products.getStrandardCost()+ " rs"%></h3>

<%=products.getProductId()%>
</div>
<div id="btn">
<button>
<a id="btn1" href="BuyProduct.jsp?pid=<%=products.getProductId()%>">Buy Now</a>
</button>
<br>
<%-- <button>
<a id="btn1" href="Cart.jsp?cartpId<%=products.getProductId()%>">Add To Cart</a>
</button> --%>
</button>
</div>
</div>

<br>
<br>
<%} %>
</body>
</html>
</html>