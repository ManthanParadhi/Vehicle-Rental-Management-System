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
		${msg}<br>
		<c:remove var="msg" scope="session" />
	</c:if>
	<table cellspacing="20" border="1">

		<tbody>

			<tr>
				<th>Sr. no</th>
				<th>Model</th>
				<th>Variant</th>
				<th>Color</th>
				<th>Registration Number</th>
				<th>Registration Year</th>
				<th>Engine Number</th>
				<th>Chasis Number</th>
			    <th>Brand Name</th>
			    <th>Seating Capacity</th>
				<th>Availability</th>
				<th>Price/day</th>
				<th>Created On</th>
				<th>Updated On</th>
				<th>Image Url</th>
				<th>Type</th>
				<th>Registration Expires On</th>
				<th>PUC Expires On</th>
				<th>Insurance Expires On</th>

			</tr>

			<c:forEach items="${vehicleList}" var="vehicle" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${vehicle.getModel()}</td>
					<td>${vehicle.getVariant()}</td>
					<td>${vehicle.getColor()}</td>
					<td>${vehicle.getRegistrationNumber()}</td>
					<td>${vehicle.getRegistrationYear()}</td>
					<td>${vehicle.getEngineNumber()}</td>
					<td>${vehicle.getChasisNumber()}</td>
			        <td>${vehicle.getBrand().getBrand()}</td>
			        <td>${vehicle.getSeatingCapacity()}</td>
					<td>${vehicle.isAvailable()}</td>
					<td>${vehicle.getPricePerDay()}</td>
					<td>${vehicle.getCreatedOn()}</td>
					<td>${vehicle.getUpdatedOn()}</td>
					<td>${vehicle.getImageUrl()}</td>
					<td>${vehicle.getType().toString()}</td>
					<td>${vehicle.getDocuments().getRegExpiresOn()}</td>
					<td>${vehicle.getDocuments().getPucExpiresOn()}</td>
					<td>${vehicle.getDocuments().getInsuranceExpiresOn()}</td>
					
					<td><a href="vehicle/delete/${vehicle.getId()}"><button>Delete</button></a></td>
					<td><a href="vehicle/edit/${vehicle.getId()}"><button>Edit</button></a></td>
					<td><a href="vehicle/changeVehicleAvailability/${vehicle.getId()}"><button>${vehicle.isAvailable() == true ? 'Set as Not Available' : 'Set as Available'}</button></a></td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
	<br>
</body>
</html>