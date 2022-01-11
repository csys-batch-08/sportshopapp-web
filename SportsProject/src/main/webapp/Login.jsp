<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login page</title>
<script >

body {
	
	background-image: url(Assests/background.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	background-attachment: fixed;
	/* background-static: */
}
</script>
</head>

<body>
<form action="loginweb1">
    <fieldset class="login">
       <center><h3>Login </h3></center>

        <table id="signuptable" style="border-spacing: 5px;">
             <tr>
                <th><label for="name">User Name:</label></th>
                <th><input type="text" name="userName" id="name" placeholder="Enter user name" required autofocus></th>
            </tr>
         <tr>
                <th><label for="password">Password:</label></th>
                <th><input type="password" name="password" id="password" placeholder="********" required ></th>
            </tr>
            
        </table>
        
                              
           
        <table id="buttontable">
            <tr>
                <td><button type="submit"> Login</button></td>  
</body>
</html>