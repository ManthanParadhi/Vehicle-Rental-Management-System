<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.tailwindcss.com"></script>
<script src="https://kit.fontawesome.com/ce918e7a16.js"
	crossorigin="anonymous"></script>
<title>Profile</title>
</head>
<body>
	<c:if test="${not empty msg}">
		${msg}
		<c:remove var="msg" scope="session" />
	</c:if>

	<%@ include file="/WEB-INF/nav.jsp"%>

	<div class="px-4 mt-12 border-2 w-4/5 mx-auto">
		<div class="flex flex-row">
			<h3
				class="basis-4/5 text-4xl font-semibold leading-normal text-gray-800">
				Profile</h3>
			<a class="basis-1/5 self-center" href="user/edit"><button
					class=" border-2 p-2 w-full hover:bg-yellow-400 hover:text-white hover:border-white mx-auto block">Edit
					Profile</button></a>
		</div>
		<h3
			class="text-base font-semibold leading-normal text-gray-500 mb-8">
			Basic info, for faster booking experience</h3>
		<div class="flex flex-row pb-3">
			<p class= "basis-1/4">Name</p>
			<p class= "basis-3/4">${user.getFirstName()} ${user.getLastName()}</p>
		</div>
		<hr class="pb-3">
		<div class="flex flex-row pb-3">
			<p class= "basis-1/4">Address</p>
			<p class= "basis-3/4">${user.getDetails().getAddressLine()}</p>
		</div>
		<hr class="pb-3">
		<div class="flex flex-row pb-3">
			<p class= "basis-1/4">City</p>
			<p class= "basis-3/4">${user.getDetails().getCity()}</p>
		</div>
		<hr class="pb-3">
		<div class="flex flex-row pb-3">
			<p class= "basis-1/4">State</p>
			<p class= "basis-3/4">${user.getDetails().getState()}</p>
		</div>
		<hr class="pb-3">
		<div class="flex flex-row pb-3">
			<p class= "basis-1/4">Pincode</p>
			<p class= "basis-3/4">${user.getDetails().getPincode()}</p>
		</div>
		<hr class="pb-3">
		<div class="flex flex-row pb-3">
			<p class= "basis-1/4">Email Id</p>
			<p class= "basis-3/4">${user.getEmail()}</p>
		</div>
		<hr class="pb-3">
		<div class="flex flex-row pb-3">
			<p class= "basis-1/4">Contact Number</p>
			<p class= "basis-3/4">${user.getDetails().getContactNumber()}</p>
		</div>
		<hr class="pb-3">
		<div class="flex flex-row pb-3">
			<p class= "basis-1/4">Id Proof</p>
			<p class= "basis-3/4">${user.getDetails().getIdProofType()}</p>
		</div>
		<hr class="pb-3">
		<div class="flex flex-row pb-3">
			<p class= "basis-1/4">Id Proof Number</p>
			<p class= "basis-3/4">${user.getDetails().getIdProofNumber()}</p>
		</div>
	</div>
</body>
</html>