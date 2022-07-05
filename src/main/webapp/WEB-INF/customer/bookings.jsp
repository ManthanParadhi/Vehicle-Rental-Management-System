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
	My Bookings!
	
	<c:if test="${not empty msg}">
		${msg}
		<c:remove var="msg" scope="session" />
	</c:if>
	<table cellspacing="20">

		<tbody>

			<tr>
				<th>Sr No</th>
				<th>Vehicle ID</th>
				<th>User ID</th>
				<th>Driver ID</th>
				<th>Booked On</th>
				<th>From Date</th>
				<th>Till Date</th>
				<th>Booking Price</th>
				<th>Booking Status</th>

			</tr>

			<c:forEach items="${bookingList}" var="booking" varStatus="status">
				<tr>

					<td>${status.count}</td>
					<td>${booking.getVehicle().getId()}</td>
					<td>${booking.getUser().getId()}</td>
					<td>${booking.getDriver().getId()}</td>
					<td>${booking.getBookedOn()}</td>
					<td>${booking.getFromDate()}</td>
					<td>${booking.getTillDate()}</td>
					<td>${booking.getBookingPrice()}</td>
					<td>${driver.getBookingStatus()}</td>

					<td><a href="booking/cancel/${driver.getId()}"><button>Cancel Booking</button></a></td>
					
				</tr>

			</c:forEach>
		</tbody>
	</table>
</body>
</html>