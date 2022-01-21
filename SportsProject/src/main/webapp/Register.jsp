<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register page</title>
    <link id ="tab" rel = "icon" type = "" href = "Assests/tab.png">

   
</head>
<style>
body {
	
	background-image: url(Assests/bcg.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	background-attachment: fixed;
	/* background-static: */
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
	.signup{
	 width:380px;
        height:450px;
        position:relative;
        margin:6% auto; 
        background: transparent;
        padding:20px;
        top: -30px;
	}
	#nameWeb{
position: relative;
left: 0px;
top: -160px;
width: 550px;
}
#regis{
left: -500px;
}
</style>
<body>
<nav class="list">
<ul>
<center><img  id="nameWeb"  alt="webName" src="Assests/name.png"></center>
</ul>
<br><br>
<form action="registerweb" >
    <fieldset class="signup">
       <center><h2 style="color: white;">Registeration</h2></center>

                <label for="name" style="color: white; ">User Name:</label >
                <input type="text"   name="UserName" id="name" placeholder="Enter user name" style="position: absolute;left: 130px;" required autofocus><br><br>
                <label for="address" style="color: white;">Address:</label>
                <input type="text" name="address" id="addres" placeholder="Enter your address"style="position: absolute;left: 130px;" required autofocus><br><br>
                <label for="emailId" style="color: white;">Email Id:</label>
                <input type="email" name="UserEmail" id="emailId" placeholder="Enter email Id" style="position: absolute;left: 130px;" required ><br><br>
                <label for="name" style="color: white;">First Name:</label>
                <input type="text" name="FirstName" id="name" placeholder="Enter your first name" style="position: absolute;left: 130px;" required autofocus><br><br>
                <label for="name" style="color: white;">Last Name:</label>
                <input type="text" name="LastName" id="name" placeholder="Enter your last name" style="position: absolute;left: 130px;" required autofocus><br><br>
                <label for="mobile" style="color: white;"> Mobile Number:</label>
                <input type="number" name="MobileNumber" id="mobile" placeholder="Enter mobile number" style="position: absolute;left: 130px;" required><br><br>
                <label for="password" style="color: white;">Password:</label>
                <input type="password" name="UserPassword" id="password" placeholder="********" style="position: absolute;left: 130px;" required ><br><br>

          <center><button type="submit" id="regis">Click to Register</button></center><br><br>
      <p style="color: white;"> Already registered user?</p> <button><a id="reg" href= "Login.jsp">Login</button>
          
    </fieldset>
    </form>
</body>
</html>

