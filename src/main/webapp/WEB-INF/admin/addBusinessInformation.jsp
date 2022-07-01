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
	
		Enter Business Name : <input type="text" name="businessName" required><br><br>
		Enter Business Email : <input type="email" name="businessEmail" required><br><br>
		Enter Business Address : <input type="text" name="businessAddress" required><br><br>
		Enter Business Contact Number : <input type="text" name="businessContactNumber" required><br><br>
		
		<input type="submit">
	</form>
</body>
</html>