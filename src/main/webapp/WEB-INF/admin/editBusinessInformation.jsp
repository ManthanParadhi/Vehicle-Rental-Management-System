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
	
		<input type="hidden" name="id" value="${businessInformation.getId()}"><br>
		Enter Business Name : <input type="text" name="businessName" required value="${businessInformation.getId()}"><br><br>
		Enter Business Email : <input type="email" name="businessEmail" required value="${businessInformation.getBusinessEmail()}"><br><br>
		Enter Business Address : <input type="text" name="businessAddress" required value="${businessInformation.getBusinessAddress()}"><br><br>
		Enter Business Contact Number : <input type="text" name="businessContactNumber" required value="${businessInformation.getBusinessContactNumber()}"><br><br>
		
		<input type="submit">
	</form>
</body>
</html>