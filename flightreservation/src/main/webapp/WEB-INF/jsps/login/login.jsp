<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register User</title>
</head>
<body>
<h3>Login: </h3>
<form action="login" method="post">
<pre>
User Name: <input type="text" name="username" placeholder="Email" >
Password: <input type="password" name="password" placeholder="Password" >
<input type="submit" value="login" >
${msg}
</pre>
</form>
</body>
</html>