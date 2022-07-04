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
	<h2>Register page!</h2>

	<form action="register" method="post">
		Enter fName : <input type="text" name="firstName" required><br><br>
		Enter lName : <input type="text" name="lastName" required><br><br>
		Enter email id :<input type="email" name="email" required><br><br>
		Enter password : <input type="password" name="password" required><br><br>
		<input type="submit">
	</form>
	
	
		${msg}
	
</body>
</html>