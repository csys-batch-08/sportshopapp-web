<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="loginweb1">
    <fieldset class="login">
       <center><h2>Registeration</h2></center>

        <table id="signuptable" style="border-spacing: 5px;">
             <tr>
                <th><label for="name">User Name:</label></th>
                <th><input type="text" name="UserName" id="name" placeholder="Enter user name" required autofocus></th>
            </tr>
         <tr>
                <th><label for="password">Password:</label></th>
                <th><input type="password" name="UserPassword" id="password" placeholder="********" required ></th>
            </tr>
            
        </table>
        
                              
           
        <table id="buttontable">
            <tr>
                <td><button type="submit"> Login</button></td>  
</body>
</html>