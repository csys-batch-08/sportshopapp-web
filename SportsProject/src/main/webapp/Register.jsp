<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register page</title>

   
</head>
<body>

<form action="registerweb" >
    <fieldset class="signup">
       <center><h2>Registeration</h2></center>

        <table id="signuptable" style="border-spacing: 5px;">
        
        <tr>
                <th><label for="name">User Name:</label></th>
                <th><input type="text" name="UserName" id="name" placeholder="Enter user name" required autofocus></th>
            </tr>
              <tr>
                <th><label for="address">Address:</label></th>
                <th><input type="text" name="address" id="addres" placeholder="Enter your address" required autofocus></th>
            </tr>
              
            <tr>
                <th><label for="emailId">Email Id:</label></th>
                <th><input type="email" name="UserEmail" id="emailId" placeholder="Enter email Id"  required ></th>
            </tr>
            <tr>
                <th><label for="name">First Name:</label></th>
                <th><input type="text" name="FirstName" id="name" placeholder="Enter your first name" required autofocus></th>
            </tr>
            <tr>
                <th><label for="name">Last Name:</label></th>
                <th><input type="text" name="LastName" id="name" placeholder="Enter your last name" required autofocus></th>
            </tr>
         
           

            <tr>
                <th><label for="mobile">Mobile Number:</label></th>
                <th><input type="number" name="MobileNumber" id="mobile" placeholder="Enter mobile number" required></th>
            </tr>   
            
             <tr>
                <th><label for="password">Password:</label></th>
                <th><input type="password" name="UserPassword" id="password" placeholder="********" required ></th>
            </tr>
            
        </table>
        
                              
           
        <table id="buttontable">
            <tr>
                <td><button type="submit">Click to Register</button></td>  
            </tr>
        </table>    
    </fieldset>
    </form>
</body>
</html>

