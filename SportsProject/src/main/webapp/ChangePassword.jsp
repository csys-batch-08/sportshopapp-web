<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change password</title>
</head>
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