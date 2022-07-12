<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${vehicle.getModel()}</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="h-screen">
	<%@ include file="/WEB-INF/nav.jsp" %>
		<div class="text-white mx-auto container bg-black">
			<h1 class="p-3 text-center font-bold text-3xl text-yellow-400">${vehicle.getModel()}</h1>
		</div>
	<div
		class="container w-4/5 mx-auto flex justify-evenly p-4 h-4/5 items-center">
		<img class="w-1/3 top-1/2 h-fit" src="${vehicle.getImageUrl()}">
		<div>
			<p class ="p-1"><b>Model :</b> ${vehicle.getModel()}</p>
			<p class ="p-1"><b>Variant :</b> ${vehicle.getVariant()}</p>
			<p class ="p-1"><b>Brand :</b> ${vehicle.getBrand().getBrand()}</p>
			<p class ="p-1"><b>Color :</b> ${vehicle.getColor()}</p>	
			<p class ="p-1"><b>Registration Number :</b> ${vehicle.getRegistrationNumber()}</p>
			<p class ="p-1"><b>Registration Year :</b> ${vehicle.getRegistrationYear()}</p>
			<p class ="p-1"><b>Seating Capacity :</b> ${vehicle.getSeatingCapacity()}</p>
			<p class ="p-1"><b>Availability :</b> ${vehicle.isAvailable() eq "true" ? 'Available' : 'Not Available'}</p>
			<p class ="p-1"><b>Registration Expires On :</b> ${vehicle.getDocuments().getRegExpiresOn()}</p>
			<p class ="p-1"><b>PUC Expires On :</b> ${vehicle.getDocuments().getPucExpiresOn()}</p>
			<p class ="p-1"><b>Insurance Expires On
				:</b> ${vehicle.getDocuments().getInsuranceExpiresOn()}</p>
			<p class ="p-1"><b>Price Per Day :</b> ${vehicle.getPricePerDay()} ₹</p>
				
				
			<a
				href="${pageContext.request.contextPath}/c/book/${vehicle.getId()}">
				<button
					class="w-full mt-8 border-2 p-2 hover:bg-yellow-400 hover:text-white hover:border-white mx-auto block">Book
					Now</button>
			</a>
		</div>
	</div>
</body>
</html>