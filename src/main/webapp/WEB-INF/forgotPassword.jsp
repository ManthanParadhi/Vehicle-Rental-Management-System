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

	${msg}

	<form action="" method="post">
	
	Enter your Registered Email Id : <input type="email" name = "email" required> <br><br>
	<input type="submit">
	
	</form>

</body>
</html>