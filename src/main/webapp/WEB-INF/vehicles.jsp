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

<style>


</style>
<body>
<c:if test="${not empty msg}">
		${msg}<br>
		<c:remove var="msg" scope="session" />
	</c:if>
	

			<c:forEach items="${vehicleList}" var="vehicle" varStatus="status">
			<div>
	
			<img src= "${vehicle.getImageUrl()}"><br>
				${vehicle.getModel()}
				<form action="c/book" method="post">
				<input type="hidden" name="id" value="${vehicle.getId()}"><br>
				<button type="submit">Book Now</button><br><br>
				</form>
				
				<form action="vehicle/${vehicle.getId()}">
				<input type="hidden" name="id" value="${vehicle.getId()}"><br>
				<button type="submit">Show Details</button><br><br>
				</form>
				
			</div>
			
			</c:forEach>
	
	<br>
</body>
</html>