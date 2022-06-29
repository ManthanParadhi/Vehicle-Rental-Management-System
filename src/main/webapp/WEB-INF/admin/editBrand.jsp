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
	<form action="admin/brand/edit" method="post">
		<input type="hidden" name="id" value="${brand.getId()}"><br>
		Enter Brand name : <input type="text" name="brandName" value="${brand.getBrand()}"><br>
			
		<br> <input type="submit">
	</form>
</body>
</html>