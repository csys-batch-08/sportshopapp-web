
<%@page import="com.sportshopapp.daoimpl.UserDAOImpl"%>
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
<title>BuyProduct</title>
<link id ="tab" rel = "icon" type = "" href = "Assests/tab.png">
<style>
* {
margin: 0;
padding: 0;
box-sizing: border-box;
font-family: Arial, Helvetica, sans-serif;
}
#pDesc{
position: relative;
left: 200px;
top: 270px;
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

/* body {
/* background: linear-gradient(rgba(26,176,156,0.7),rgba(239,78,28,0.5)) ,url(Images/homepage_img.jpg); */
background-image: url(Images/homepage_img.jpg);
background-repeat: no-repeat;
background-size: cover;
} */
 .logo img {
height: 60px;
width: 60px;
margin-left: 20px;
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
padding-top: 10px;
position: relative;
left: 190px;
top: 10px
}
#addToCart a{
background-color: green;
text-decoration: none;
position: relative;
left: 50px;
}
#buyNow a{
background-color: green;
color: white;
text-decoration: none;
}
#message {
padding-left: 10px;
padding-right: 10px;


}
#addToCart:hover{
cursor: pointer;
}
#buyNow:hover{
cursor: pointer;
}
#price{
position: relative;
left: 190px;
top:15px;
outline: none;
border: none;
background-color: rgba(158, 202, 207,0.1);
color: black;
font-size: 16px;
}
#name{
position: relative;
left: -135px;
top: -250px;
width: 550px;
}
/* #pImg{
position: relative;
height: 200px;
width: 170px;
left:10px;
} */

#totalprice{
position: relative;
top:-190px;
left:90px;
}
#TotalPriceLabel{
position: relative;
top:-50px;
right: 60px;
padding: 
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
#totalprice{
position: relative;
top:-71px;
left:90px;
outline: none;
border: none;
background-color: rgba(158, 202, 207,0.1);
color: white;
font-weight: 700;
font-size: 17px;
}z
#paybut{
padding: 5px;
position: relative;
left: 60px;
}
</style>
</head>
<body>


<div class="nav">

<nav class="list">
<ul>


<li><a href ="index.jsp">SignOut</a></li>
<li><a href="CartJst">Cart</a></li>
<li><a href ="UserProfile">MyProfile</a></li>
<li><a href= "MyOrder.jsp">MyOrders</a></li>
<li><a href="UserView.jsp">Home</a></li>
</ul>



<table class="buyProduct">
<tbody>

<tr>


<div id="pDesc">
<p>
<b>Product category:</b>
</p><br>
<p>
<b>Product Name:</b>
</p>

<p>
<b>Price:</b>
</p>
<p>
<b>Available Quantity:</b>
</p>
</td>
<td>
<p name="pCategory"><c:out value="${currentproduct.getCategory()}" /></p>
<p name="pName"><c:out value="${currentproduct.getProductName()}" /></p>
<input name="pUnitPrice" id="price" value=" <c:out value="${currentproduct.getStrandardCost()}" />" disabled>
<p name="pQuantity"> <c:out value="${currentproduct.getQuantity()}" /></p>

</td>
<td>
<div id="qty">
<div id="qtyBox">
<form action="prod1">
<label for="">Quantity :</label>
<input type="number" id="quantity" name="quantity" min="1"  max=" <c:out value="${currentproduct.getQuantity()}" />" onclick="calculateAmt()" >
</div>
<h3 id="TotalPriceLabel">Total price : Rs </h3>
<input name="totalPrice" id="totalprice" required>
<p name="message" id="message"></p>
<button type="submit" id="paybut">Paynow</button><br>
</form>
<form action = "cartserv" id="cartForm">
<input name="cartQuanity" type = "text" id = "cartQuantity" required  readonly hidden>
<input name="cartTotalPrice" type = "text" id = "cartTotalPrice" readonly hidden>
<button type="submit" id="addToCart">Add To Cart</button>
</form>
</div>
</td>
</tr>

</tbody>
</table>
<tr>
<img id="name" alt="webName" src="Assests/name.png">
<script>
function calculateAmt() {
let price=document.getElementById("price").value;


var qty=document.getElementById("quantity");
var quanty=qty.value;
console.log(quanty);

let totalAmt = price  * quanty;

/* price=Math.floor((price.value*offer.value)/100);
 *
 */
 
 

document.getElementById("totalprice").value=totalAmt;
console.log(totalAmt);
cartfn();

}
function cartfn(){
	
	let quant = document.getElementById("quantity").value;
	let totprice = document.getElementById("totalprice").value;
	let cartquant = document.getElementById("cartQuantity");
	let carttot = document.getElementById("cartTotalPrice");
	cartquant.value = quant;
	carttot.value = totprice;
}
</script>

</body>

</html>