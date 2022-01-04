<%@page import="com.sportshopapp.model.UserReg"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>customer view</h2>
	<ul> 
	<li><a href="ShowAllProducts.jsp"><i class="fa fa-fw fa-wrench"></i> Show all products</a></li>
	<li><a href="UserProfile.jsp">profile</a></li>
	<li><a href="UpdateUser.jsp">Edit user profile</a></li>
	<li><a href="DeleteProfile.jsp">Delete profile</a></li>
	
	</ul>
	<%
	UserReg customer = (UserReg) session.getAttribute("logincustomer");
	%>
	<% out.print( customer.getFirstName()); %>

	<%
	
	%>

</body>
</html>