<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change password</title>
<link id ="tab" rel = "icon" type = "" href = "Assests/tab.png">
</head>
<style>
* {
margin: 0;
padding: 0;
box-sizing: border-box;
font-family: Arial, Helvetica, sans-serif;
}
body {
	
	background-image: url(Assests/bcg.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	background-attachment: fixed;
	/* background-static: */
}

/* body {
overflow-x: hidden;
} */

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
</style>
<body>

<form action="ChangePassword">
        <label for="userName">Enter User name</label>
        <input type="text" name="uname" >   <br><br>
        <label for="pword">New Password</label>
        <input type="password" name="pword" required min="8"> <br> <br>
        <input type="submit">
    </form>
</body>
</html>