<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Login page</title>
<link id ="tab" rel = "icon" type = "" href = "Assests/tab.png">
</head>
<style>



.list ul li {
	list-style: none;
	display: inline-block;
}
#tab{
width: 100%;
}

.list li {
	float: right;
	padding: 20px;
}
.list li{
list-style: none;
}

.list ul {
	/* background-color: #10847E;*/
	height: 70px;
	position: absolute;
	margin-right: 0%;
	position: absolute;
	top: -25px;
	background-color: rgba(255, 255, 255, 0.603);
	box-shadow: 0 5 black;
	/* margin-top: 0%; */
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
	/* margin-right: 20px; */
}

.list li:hover, .list a:hover {
	color: orange;
	border-radius: 5px;
	cursor: pointer;
}
signuptable{
border-spacing: 5px;

}
body {
	
	background-image: url(Assests/bcg.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	background-attachment: fixed;
	/* background-static: */
	}
reg {
     
}
.button a{
  background-color: #e6f2ff;
  border: none;
  color: black;
  /* padding: 10px 15px; */
  text-align: center;
  text-decoration: none;
 /*  display: inline-block; */
  font-size: 15px;
  margin: 4px 2px;
  cursor: pointer;
  border-radius:4px;
}
.button {
  background-color: #e6f2ff;
  border: none;
  color: black;
  /* padding: 10px 15px; */
  text-align: center;
  text-decoration: none;
 /*  display: inline-block; */
  font-size: 15px;he
  margin: 4px 2px;
  cursor: pointer;
  border-radius:4px;
}
.login{
        width:380px;
        height:300px;
        position:relative;
        margin:6% auto; 
        background: transparent;
        padding:20px;
        top: -30px;
}
#names{
position: relative;
left: -30px;
top: -607px;
width: 550px;
}
</style>
<body>

<br><br><br><br><br><br><br><br>
<div class="nav">

		<nav class="list">
			<ul>
					<li><a href="register.jsp">Register</a></li>
					<li><a href="about.jsp">About us</a></li>
					
					
			</ul>
<form action="loginweb2">
    <fieldset class="login">
       <center><h2 style="color: white;">Login </h2></center>

                         <label for="name" style="color: white;padding-left:50px; " >User Name:  </label>
              <input type="text" name="userName" id="name" placeholder="Enter user name" required autofocus ><br><br><br>
         
               <label for="password" style="color: white;padding-left:50px; ">Password:  &nbsp; </label> </th>
              <input type="password" name="password" id="password" placeholder="********" required >&nbsp;&nbsp;&nbsp;
      <br><br><div style="padding-top: 10px; padding-left:150px">
      
         <button class="button" type="submit"> Login</button></div>
          
               <div style="padding-top: 10px; padding-left:120px"> <button class="button"  ><a id="reg" href= "Register.jsp">Registration</a></button></div>
               <img id="names" alt="webName" src="Assests/name.png">
</body>
</html>