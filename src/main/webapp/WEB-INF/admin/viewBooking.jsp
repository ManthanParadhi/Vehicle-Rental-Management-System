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
<table cellspacing="20">

		<tbody>

			<tr>
			
				<th>Vehicle ID</th>
				<th>User ID</th>
				<th>Need Driver</th>
				<th>Booked On</th>
				<th>From Date</th>
				<th>Till Date</th>
				<th>Booking Price</th>
				<th>Booking Status</th>

			</tr>

			

					
					<td>${booking.getVehicle().getId()}</td>
					<td>${booking.getUser().getId()}</td>
					<td>${booking.isNeedDriver()}</td>
					<td>${booking.getBookedOn()}</td>
					<td>${booking.getFromDate()}</td>
					<td>${booking.getTillDate()}</td>
					<td>${booking.getBookingPrice()}</td>
					<td>${booking.getBookingStatus()}</td>
					
			

			
		</tbody>
	</table>
</body>
</html>