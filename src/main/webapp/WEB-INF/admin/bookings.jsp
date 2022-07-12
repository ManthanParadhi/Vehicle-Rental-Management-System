<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
    <%@ page import="com.shashank.vrms.enums.BookingStatus" %>
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
				<th>Need Driver</th>
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
					<td>${booking.isNeedDriver()}</td>
					<td>${booking.getBookedOn()}</td>
					<td>${booking.getFromDate()}</td>
					<td>${booking.getTillDate()}</td>
					<td>${booking.getBookingPrice()}</td>
					<td>${booking.getBookingStatus()}</td>
					
					<c:if test="${booking.getBookingStatus() eq BookingStatus.PENDING }">
						
						<td>
							<form action="booking/approve" method="post">
								<input type="hidden" name="id" value="${booking.getId()}">
   								<button type="submit" >Approve Booking</button>
   							</form>
						</td>
						<td><form action="booking/decline" method="post">
								<input type="hidden" name="id" value="${booking.getId()}">
   								<button type="submit" >Decline Booking</button>
   							</form></td>
					
					</c:if>
					
					<td><a href="booking/view/${booking.getId()}"><button>View Booking</button></a></td>
					
				</tr>

			</c:forEach>
		</tbody>
	</table>
</body>
</html>