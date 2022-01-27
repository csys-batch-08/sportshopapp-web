<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin view</title>
<link id ="tab" rel = "icon" type = "" href = "Assests/tab.png">
</head>
<style>
body {font-family: "Lato", sans-serif;}
.sidebar {
  height: 100%;
  width: 160px;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: #f0f0f5;
  overflow-x: hidden;
  padding-top: 16px;
  font-size: 13px;
}
.sidebar a {
  padding: 20px 2px 8px 16px;
  text-decoration: none;
  font-size: 13px;
  color: black;
  display: block;
  font-family:Arial Black;
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
font-size: 22px;
font-weight: 500;
/* margin-right: 20px; */
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


.list li:hover, .list a:hover {
color: blue;
/* background-color: orange; */
border-radius: 5px;
cursor: pointer;
}

.sidebar a:hover {
background-color: rgba(158, 202, 207,0.1);}
.main {
  margin-left: 160px; /* Same as the width of the sidenav */
  padding: 0px 50px;
  top: 200px;
  padding-top: 100px;
}
.slidebar{
top: 50px;
padding-top: 100px;
}
@media screen and (max-height: 450px) {
  .sidebar {padding-top: 15px;}
  .sidebar a {font-size: 18px;}
}
#name{
position: relative;
left: 440px;
top: -335px;
width: 550px;
}
#sign{
position: relative;
left: 1200px;
top: 18px;

}
</style>
<body>

<nav class="list">
<ul>


<li><a id = "sign" href ="Login.jsp">SignOut</a></li>

</ul>
<div class="sidebar">
  <a href="ViewAllUsers"><i class="fa fa-fw fa-home"></i> ALLUSER</a>
  <a href="ShowAllProduct"><i class="fa fa-fw fa-wrench"></i> Show all products</a>
 <!--  <a href="Orders"><i class="fa fa-fw fa-user"></i> ORDERS</a> -->
  <a href="UpdateProduct.jsp"><i class="fa fa-fw fa-envelope"></i> Update products</a>
  <a href="Add"><i class="fa fa-fw fa-envelope"></i> Add products</a>
</div>

<div class="main">
  <h1 style="color: white;">HELLO ADMIN</h1>
</div>
<img id="name" alt="webName" src="Assests/name.png">
</body>
</html>