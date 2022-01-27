<%@page import="java.util.List"%>
<%@page import="com.sportshopapp.model.UserReg"%>
<%@page import="com.sportshopapp.model.Product"%>
<%@page import="com.sportshopapp.daoimpl.ProductDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@page import="javax.servlet.http.HttpSession"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
<link id ="tab" rel = "icon" type = "" href = "Assests/tab.png">
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
#product{
padding-left: 50px;
}
#category{
padding-left: 50px;
}
#btn{
padding-left: 50px;
}
#detail{
padding-left: 50px;
}
#details{
padding-left: 50px;
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
color: black;
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
	
	background-image: url(Assests/bcg.jpg);
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
#product{
color: white;

}
.font{
font-family: "Times New Roman", Times, serif;
font-size: 24px;
}
.font1{
font-family: "Times New Roman", Times, serif;
font-size: 24px;
}

.font2{
font-family: "Times New Roman", Times, serif;
font-size: 24px;
}
.font3{
font-family: "Times New Roman", Times, serif;
font-size: 24px;
}

#category{
color: white;
}

#details{
color: white;

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
color: white;
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
color: white;
}
#name{
position: relative;
left: 50;
top: -162px;
width: 550px;
}
#totalprice{
position: relative;
top:-190px;
left:90px;
}
#TotalPriceLabel{
position: relative;
top:-190px;
right: 50px;
color: white;
}

#btn{
font-size: 5px;
}

/* Slideshow container */
.slideshow-container {
  max-width: 900px;
  position: relative;
  margin: auto;
}

/* Hide the images by default */
.mySlides {
  display: none;
}

/* Next & previous buttons */
.prev, .next {
  cursor: pointer;
  position: absolute;
  top: 50%;
  width: auto;
  margin-top: 102px;
  padding: 16px;
  color: white;
  font-weight: bold;
  font-size: 18px;
  transition: 0.6s ease;
  border-radius: 0 3px 3px 0;
  user-select: none;
}

/* Position the "next button" to the right */
.next {
  right: 0;
  border-radius: 3px 0 0 3px;
}

/* On hover, add a black background color with a little bit see-through */
.prev:hover, .next:hover {
  background-color: rgba(0,0,0,0.8);
}

/* Caption text */
.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 50%;
  text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}


/* The dots/bullets/indicators */
.dot {
  cursor: pointer;
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active, .dot:hover {
  background-color: #717171;
}

/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  animation-name: fade;
  animation-duration: 3s;
}

@-webkit-keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}

</style>
</head>
<body>
<%
 
UserReg currentUser = (UserReg)session.getAttribute("logincustomer");%>
<div id="container">

<div class="nav">

<nav class="list">
<ul>

<li><a href ="Login.jsp">SignOut</a></li>
<li><a href= "Cart.jsp">Cart</a></li>
<li><a href ="UserProfile.jsp">MyProfile</a></li>
<li><a href= "MyOrder.jsp?orderId=0">MyOrders</a></li>
<img id="name" alt="webName" src="Assests/name.png">
</ul>
<br><br><br><br>

<div id="serachbar">

<!-- <input type="text" id="searchProduct"  name="searchProduct" required>
<a href="AllProducts.jsp"><button>search</button></a> -->
<%-- <h2 id="userName">welcome <%=currentUser.getUserName() %></h2> --%>
</div>
<br><br><br>
<div class="slideshow-container">

    <!-- Full-width images with number and caption text -->

    
    <div class="mySlides fade" style="display: none;">
      <div class="numbertext"></div>
      <img src="Assests/5.jpg" style="width:100%;height: 350px;">
      <div class="text"></div>
    </div>
  
    <div class="mySlides fade" style="display: none;">
      <div class="numbertext"></div>
      <img src="Assests/2.png" style="width:100%" height: 350px;>
      <div class="text"></div>
    </div>
    
    <div class="mySlides fade" style="display: none;">
      <div class="numbertext"></div>
      <img src="Assests/3.jpg" style="width:100%" height: 350px;>
      <div class="text"></div>
    </div>
    
    <div class="mySlides fade" style="display: none;">
      <div class="numbertext"></div>
      <img src="Assests/4.png" style="width:100%" height: 350px;>
      <div class="text"></div>
    </div>
  
 
  
    <!-- Next and previous buttons -->
    <a class="prev" onclick="plusSlides(-1)"></a>
    <a class="next" onclick="plusSlides(1)"></a>
  </div>
  <br>
  
  <!-- The dots/circles -->
  <div style="text-align:center">
    <span class="dot" onclick="currentSlide(1)"></span> 
    <span class="dot" onclick="currentSlide(2)"></span> 
    <span class="dot" onclick="currentSlide(3)"></span> 
     <span class="dot" onclick="currentSlide(4)"></span>
  </div>


<c:forEach items="${productList}" var="current">
				 <c:set var="i" value="${i+1 }"/>



<div id="product" >

<h3 class="font"> Product :<c:out value="${current.getProductName()}" /></h3>
</div>
<div id="category" >

<h3 class="font1">Category : <c:out value="${current.getCategory()}"/></h3>
</div>
<div id="details" >

<h3 class="font2">Available quantity :<c:out value="${current.getQuantity()}" /> </h3>
</div>
<div id="details" >

<h3 class="font3">
Price :<c:out value="${current.getStrandardCost()+  rs}" /></h3>
<h3 class="font3">
Product Id:<c:out value="${current.getProductId()}" /></h3>	
</div>
<div id="btn">
<button>
<a  href="BuyServlet?pid=<c:out value="${current.getProductId()}" />">Buy Now</a>
</button>

</div>

<br>
<br>
</c:forEach>


</body>
<script>
    var slideIndex = 0;
showSlides();

function showSlides() {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none"; 
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1} 
  slides[slideIndex-1].style.display = "block"; 
  setTimeout(showSlides, 2000); // Change image every 2 seconds
}

</script>
</html>
</html>