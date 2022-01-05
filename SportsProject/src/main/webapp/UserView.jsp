<%@page import="com.sportshopapp.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.sportshopapp.daoimpl.ProductDAOImpl"%>
<%@page import="com.sportshopapp.model.UserReg"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
 <style>
         * {
            margin-left: -5px;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, Helvetica, sans-serif;
        	}
   /*      body{
            background-image: url(Images/homepage_img.jpg);
            background-repeat: no-repeat;
            background-size: cover;
        } */
        #product{
            position: relative;
            top: 30px;
            left: 50px;
            
        } 
        #product{
            position: relative;
            background-color: rgba(158, 202, 207,0.5);
            height: 190px;
            border-radius: 5px;
            width: 1200px;
        }
       /*  #product img{
            height: 100px;
            width: 90px;
            position: relative;
            left: 40px;
        } */
        #product h3{
            position: relative;
            left: 10px;
        }
         #product #details{
            position: relative;
            left: 220px;
            top: -165px;
        }
        #product #btn{
            position: relative;
            top: -250px;
            left: 900px;
        }
        #product #btn button{
            height: 30px;
            width: 90px;
            background-color: rgb(145, 230, 18);
            border: none;
            border-radius: 5px;
        }
        #product #btn{
            position: relative;
            }
         #btn1{
             position: relative;
             left: 120px;
             top: -40px;
         }  
         #product #btn button:hover{
             background-color: white;
             box-shadow: 0 0 5px black;
         } 
         #product #img h3{
         position: relative;
         left: 30px;
         }
         #btn #buynow{
         position: relative;
         top:-10px;
         }
         a{
         text-decoration: none;
         color: black;
         }
    </style>
<body>

	<h2>customer view</h2>
	<div class="sidebar">
	<%
	UserReg customer = (UserReg) session.getAttribute("logincustomer");
	%>
		
    <a href="UserProfile.jsp">profile</a>
	<a href="UpdateUser.jsp">Edit user profile</a>
	<a href="DeleteProfile.jsp">Delete profile</a>
	</div>
	
<%-- 	<div class="main"></div>
  <% ProductDAOImpl obj = new ProductDAOImpl();
List<Product> productList =obj.viewAllProducts();
     session.setAttribute("productList", productList);%>

	div class="main"></div>
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
</div> --%>
<% ProductDAOImpl product= new ProductDAOImpl();
List<Product> allproduct = product.viewAllProducts();
	%>
	<% for(Product products : allproduct)
		
	{
	%>
	<form action="cart">
    <div id="product">
        <div id="img">
            <%-- <img src="<%=1.jpg %>" alt="horlicks"> --%>
            <h3><%=products.getProductName() %></h3>
        </div>
        <div id="details">
        <h3>Product ID : <%=products.getProductId() %></h3>
            <h3>Category : <%=products.getCategory() %></h3>
            <h3>price :<%=products.getStrandardCost()+ "rs"%></h3>
         
        </div>
        <div id="btn">
            <a href="BuyProduct.jsp">Buy Now</a><br>
           <a href="">Add To Cart</a></button>
        </div>
	</div>
	</form>
		<br><br>
	<%} %>


</body>
</html>