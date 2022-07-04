<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Login page!</h2>
	<form action="login" method="post">

		Enter email id : <input type="email" name="email" required><br><br>
		<br> Enter password : <input type="password" name="password" required><br><br>
		<input type="submit">

	</form>
		${msg}
	
</body>
</html>