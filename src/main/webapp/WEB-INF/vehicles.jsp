<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.tailwindcss.com"></script>

<title>Our Vehicles</title>
</head>

<style>


</style>
<body>
<c:if test="${not empty msg}">
		${msg}
		<c:remove var="msg" scope="session" />
	</c:if>
		<%@ include file="/WEB-INF/nav.jsp" %>
	
    <div class="bg-black text-white mx-auto container">
        <h1 class="p-3 text-center font-bold text-3xl text-yellow-400">Vehicles</h1>
    </div>	
			<div class="grid grid-cols-2 container mx-auto w-4/5 gap-5 mt-4">
			
			<c:forEach items="${vehicleList}" var="vehicle" varStatus="status">
			<a href = "vehicle/${vehicle.getId()}"class="container flex border-2">
				<img class="w-52 h-48" src= "${vehicle.getImageUrl()}">
				<div class="ml-4">
				<h2 class ="font-bold text-xl mt-4">${vehicle.getModel()}</h2>
				<h2 class ="font-bold text-xl mt-4 text-yellow-400">${vehicle.getPricePerDay()} ₹</h2>
				<form class="mt-8" action="c/book" method="post">
				<input type="hidden" name="id" value="${vehicle.getId()}">
				<button class="border-2 p-1 hover:bg-yellow-400 hover:text-white hover:border-white" type="submit">Book Now</button>
				</form>				
				</div>
			</a>
			
			</c:forEach>
			</div>
</body>
</html>