<%@page import="com.sportshopapp.model.UserRegModel"%>
<%@page import="java.util.List"%>
<%@page import="com.sportshopapp.daoimpl.UserDAOImpl"%>
<%@page import="com.sportshopapp.dao.UserDaoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, Helvetica, sans-serif;
        }
     #allusers{
       position: absolute;
       top:100px;
       left:200px;
       right: 200px;
       bottom: 100px;
       }
       
   
        body{
            background-color: white;
            }
        #allusers table,th,tr,td{
        border: 1px solid black;
        border-collapse: collapse;
        padding: 10px;
        }
    </style>
</head>
<h1><a href="Logout.jsp">logout</a></h1>
<body>
<% UserDaoDAO obj=new UserDAOImpl();
List<UserRegModel> userList= obj.viewAllUsers();
%>
<div id="allusers">
<table>
<thead>
<tr>
<th>User name</th>
<th>Address</th>
<th>First Name</th>
<th>Last Name</th>
<th>MailId</th>
<th>mobile</th>
<th>Wallet</th>

</tr>
</thead>
<tbody>
<%for(UserRegModel customer:userList){ %>
<tr>
<td><%=customer.getUserName() %></td>
<td><%=customer.getAddress() %></td>
<td><%=customer.getFirstName()%></td>
<td><%=customer.getLastName() %></td>
<td><%=customer.getEmail()%></td>
<td><%=customer.getPhone() %></td>
<td><%=customer.getMyWallet()%></td>

</tr>
<%} %>
</tbody>
</table>
</div>
</body>

</html>