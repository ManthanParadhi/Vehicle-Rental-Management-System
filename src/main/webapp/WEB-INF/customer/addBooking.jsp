<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page isELIgnored="false"%>

<%@ page import="com.shashank.vrms.utilities.Helper" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>Insert title here</title>


<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
 

<script>
const VALID_DATE_REGEX = /^\d{2}\/\d{2}\/\d{4}$/;

//An array of objects containing disabled date ranges
 var disabledDates = [
 
	<c:forEach items="${vehicle.getBooking()}" var="booking" varStatus="status">
	
	
	<c:set value="${booking.getFromDate()}" var="fromDateString" />
	<c:set value="${booking.getTillDate()}" var="tillDateString" />

		<fmt:parseDate value="${fromDateString}" var="fromDateObject"
		                pattern="yyyy-MM-dd HH:mm:ss" />
		<fmt:parseDate value="${tillDateString}" var="tillDateObject"
			            pattern="yyyy-MM-dd HH:mm:ss" />		
		
	{ from:"<fmt:formatDate value="${fromDateObject }" pattern="dd/MM/yyyy" />", to:"<fmt:formatDate value="${tillDateObject }" pattern="dd/MM/yyyy" />" },

</c:forEach>
 
]; 


$( function() {
$("#fromDate").datepicker({
 minDate: new Date(),
 

 beforeShowDay: function (date) {
     // For each calendar date, check if it is within a disabled range.
     for (i = 0; i < disabledDates.length; i++) {
         // Get each from/to ranges
         var From = disabledDates[i].from.split("/");
         var To = disabledDates[i].to.split("/");
         // Format them as dates : Year, Month (zero-based), Date
         var FromDate = new Date(From[2], From[1] - 1, From[0]);
         var ToDate = new Date(To[2], To[1] - 1, To[0]);

         // Set a flag to be used when found
         var found = false;
         // Compare date
         if (date >= FromDate && date <= ToDate) {
             found = true;
             return [false, "red"]; // Return false (disabled) and the "red" class.
         }
     }

     //At the end of the for loop, if the date wasn't found, return true.
     if (!found) {
         return [true, ""]; // Return true (Not disabled) and no class.
     }
 }
})})

$( function() {
$("#toDate").datepicker({
 minDate: new Date(),


 beforeShowDay: function (date) {
     //console.log(date);

     // For each calendar date, check if it is within a disabled range.
     for (i = 0; i < disabledDates.length; i++) {
         // Get each from/to ranges
         var From = disabledDates[i].from.split("/");
         var To = disabledDates[i].to.split("/");
         // Format them as dates : Year, Month (zero-based), Date
         var FromDate = new Date(From[2], From[1] - 1, From[0]);
         var ToDate = new Date(To[2], To[1] - 1, To[0]);

         // Set a flag to be used when found
         var found = false;
         // Compare date
         if (date >= FromDate && date <= ToDate) {
             found = true;
             return [false, "red"]; // Return false (disabled) and the "red" class.
         }
     }

     //At the end of the for loop, if the date wasn't found, return true.
     if (!found) {
         return [true, ""]; // Return true (Not disabled) and no class.
     }
 }
})});
    

</script>








</head>
<body>

${msg}


	<form action="" method="post">
		<input type="hidden" name="id" value="${vehicle.getId()}"><br>
		<br> From Date : <input id="fromDate" name="fromDate" autocomplete="off"  required/><br>
		<br> Till Date : <input id="toDate" name="tillDate" autocomplete="off" required /><br>
		<br> Need Driver : <input type="checkbox" name="needDriver" value="needDriver"><br>
		<br>
		<button type="submit">Book</button>
		<br>
		<br>

	</form>
	
	
	
	
	
	
	
	
	
	
	<c:forEach items="${vehicle.getBooking()}" var="booking" varStatus="status">
	
	
	<c:set value="${booking.getFromDate()}" var="fromDateString" />
	<c:set value="${booking.getTillDate()}" var="tillDateString" />

		<fmt:parseDate value="${fromDateString}" var="fromDateObject"
		                pattern="yyyy-MM-dd HH:mm:ss" />
		<fmt:parseDate value="${tillDateString}" var="tillDateObject"
			            pattern="yyyy-MM-dd HH:mm:ss" />		
		
	<fmt:formatDate value="${fromDateObject }" pattern="dd/MM/yyyy" />, to:"<fmt:formatDate value="${tillDateObject }" pattern="dd/MM/yyyy" />" }
	</c:forEach>
	
</body>
</html>