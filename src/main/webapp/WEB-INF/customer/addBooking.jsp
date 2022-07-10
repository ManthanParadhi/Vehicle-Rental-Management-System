<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page isELIgnored="false"%>

<%@ page import="com.shashank.vrms.utilities.Helper" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<link
	href="https://cdn.rawgit.com/dubrox/Multiple-Dates-Picker-for-jQuery-UI/master/jquery-ui.multidatespicker.css"
	rel="stylesheet" />
<link
	href="https://code.jquery.com/ui/1.12.1/themes/pepper-grinder/jquery-ui.css"
	rel="stylesheet" />
<script
	src="https://cdn.rawgit.com/dubrox/Multiple-Dates-Picker-for-jQuery-UI/master/jquery-ui.multidatespicker.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>

<script>
	
	
	const invalidDates = [
		
			
			
			<c:forEach items="${vehicle.getBooking()}" var="booking">
		
			new Date(${Helper.getYear(booking.getFromDate())}, ${Helper.getMonth(booking.getFromDate())}, ${Helper.getDay(booking.getFromDate())}),  
			
		</c:forEach>
			
			]
	
	<c:forEach items="${vehicle.getBooking()}" var="booking">
	console.log(${Helper.getYear(booking.getFromDate())})
	console.log(${Helper.getMonth(booking.getFromDate())})
	console.log(${Helper.getDay(booking.getFromDate())})
	//new Date(${Helper.getYear(booking.getFromDate())}, ${Helper.getMonth(booking.getFromDate())}, ${Helper.getDay(booking.getFromDate())}), 
	
</c:forEach>
	
	console.log(invalidDates)
	
	$(document).ready(function() {
		$('#fromDate').multiDatesPicker({
			// disable the 1st and 3rd of the current month
			addDisabledDates : invalidDates,
			minDate : 0,
			maxPicks : 1
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<form action="c/book" method="post">
		<input type="hidden" name="id" value="${vehicle.getId()}"><br>
		<br> From Date : <input id="fromDate" name="fromDate" /><br>
		<br> Till Date : <input type="datetime" name="tillDate" required><br>
		<br> Need Driver : <input type="checkbox" name="needDriver"><br>
		<br>
		<button type="submit">Book</button>
		<br>
		<br>

	</form>
</body>
</html>