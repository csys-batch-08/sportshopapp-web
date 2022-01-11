<%-- <%@page import="com.sportshopapp.model.UserReg"%>
<%@page import="com.sportshopapp.daoimpl.OrderDetailDAOImpl"%>
<%@page import="com.sportshopapp.model.OrderItems"%>
<%@page import="java.util.List"%>
<%@page import="com.sportshopapp.daoimpl.OderItemsDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cancel order</title>
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

body {
/* background: linear-gradient(rgba(26,176,156,0.7),rgba(239,78,28,0.5)) ,url(Images/homepage_img.jpg); */
background-image: url(Images/homepage_img.jpg);
background-repeat: no-repeat;
background-size: cover;
}

.logo img {
height: 60px;
width: 60px;
margin-left: 20px;
}

/* banner */
.slide {
position: absolute;
top: 120px;
}
/* progress */
.products {
margin-top: 330px;
border-spacing: 0 200px;
}

.slide img {
box-shadow: 0 0 10px black;
}

.products tr td {
padding-left: 220px;
}

img {
box-shadow: 0 0 10px black;
}

.logo img {
box-shadow: none;
}

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
top: 30px;
left: 50px;
}

#product {
position: relative;
background-color: rgba(158, 202, 207, 0.5);
height: 190px;
border-radius: 5px;
width: 1200px;
top:150px;
}

#product img {
height: 100px;
width: 90px;
position: relative;
left: 40px;
top:20px;
}

#product h3 {
position: relative;
left: 10px;
}

#product #details {
position: relative;
left: 220px;
top: -90px;
}

#product #btn {
position: relative;
left: 900px;
top:-130px;
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
top:20px;
}

#btn  {
position: relative;
top: -40px;
}

a {
text-decoration: none;
color: black;
}
#userName{
position: relative;
left: 1100px;
}

</style>
<body>

<%UserReg currentUser = (UserReg)session.getAttribute("logincustomer");
OderItemsDAOImpl currentCancelOrder = new OderItemsDAOImpl();
%>
<div id="container">

<div class="nav">

<nav class="list">
<ul>
<li><a>Cart</a></li>
<li><a href="Index.jsp">SignOut</a></li>
<li><a href="UserProfile.jsp">MyProfile</a></li>
<li><a >MyOrders</a></li>
</ul>

<!-- slideshow -->
<br><br><br>
<h2 id="userName">welcome <%=currentUser.getUserName()%></h2>
</div>

<% OderItemsDAOImpl myOrder= new OderItemsDAOImpl();
List<OrderItems> myOrderList = myOrder.ViewMyOrder(currentUser);
OderItemsDAOImpl cancelOrder= new OderItemsDAOImpl();
int orderId=Integer.parseInt(request.getParameter("orderId"));
OrderDetailDAOImpl orderDao=new OrderDetailDAOImpl();
/* orderDao.deleteProduct(myAllOrders.getOrderModel().getOrderId()); */
boolean flag;

%>
<% for(OrderItems myAllOrders : myOrderList)
{
flag =orderDao.checkStatus(myAllOrders.getOderModel().getOrderId());
%>

 <div id="product">
<div id="img"> 
<img src="<%=myAllOrders.getProduct().getProductImg()%>" alt="">
<h3><%=myAllOrders.getProduct().getProductName() %></h3>
</div>
<div id="details">

<h3>
price :<%=myAllOrders.getUnitPrice()+ "rs"%></h3>


Total Quantity:
<%=myAllOrders.getQuantity() %></h3>
<h3>
Total Amt :
<%=myAllOrders.getTotalPrice() %></h3>

</div>
<% if(flag){%>
<div id="btn">
<button>
<a id="cancel" href="MyOrder.jsp?orderId=<%=myAllOrders.getOderModel().getOrderId()%>">Cancel Order</a>
</button>
<br>
</button>
</div>
<% }%>
</div>

<br>
<br>
<%}%>

 --%>


</div>

</div>
<div id="footer"></div>


</body>
</html>