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

	<c:if test="${not empty msg}">
		${msg}
		<c:remove var="msg" scope="session" />
	</c:if>
	<form action="" method="post">
		Enter Brand Name : <input type="text" name="brandName" required>
		<input type="submit">
	</form>

	
</body>
</html>