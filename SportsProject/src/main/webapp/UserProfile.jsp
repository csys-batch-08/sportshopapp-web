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
<%
UserReg customer = (UserReg) session.getAttribute("logincustomer");
%>
<%out.print(customer.getUserName()); %>
<%out.print(customer.getAddress()); %>
<%out.print(customer.getFirstName()); %>
<%out.print(customer.getLastName()); %>
<%out.print(customer.getEmail()); %>
<%out.print(customer.getPhone()); %>
<%out.print(customer.getMyWallet()); %>

</body>
</html>