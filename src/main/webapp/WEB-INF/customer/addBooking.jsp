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


const fn = (e) => {
 e.preventDefault();
 const formInput = Object.fromEntries(new FormData(e.target));
 const fromDate = formInput.fromDate;
 const toDate = formInput.toDate;
 checkIfDatesValid(fromDate, toDate)
}

const checkIfDatesValid = (fromDate, toDate) => {
 // Check if dates are not empty
 if (!fromDate || !toDate) {
     alert("Please enter a valid date!");
     
     return;
 }
 // Check if dates are valid
 if (!VALID_DATE_REGEX.test(fromDate) || !VALID_DATE_REGEX.test(toDate)) {
     alert("Please enter a valid date!");
     return;
 }
 
 // Check if dates are are greater than equal to today
 const toDaysDateMillis = new Date().setHours(0,0,0,0)
 const fromDateMillis = new Date(fromDate).setHours(0,0,0,0)
 const toDateMillis = new Date(toDate).setHours(0,0,0,0)
 if(fromDateMillis < toDaysDateMillis || toDateMillis < toDaysDateMillis){
     alert("Dates should be greater than or equal to today's date!");
     return;
 }
 
 // Check if toDate is greater than or equal to from date
 if(toDateMillis < fromDateMillis){
     alert("From date should be greater than till date!");
     return;
 }
 
 
 for(let i=0 ; i< disabledDates.length ; i++) {
     // Check if both dates are either before range or after range
     if(
         (
           (
               compareDates(fromDate, disabledDates[i].from) === -1  
            && 
               compareDates(fromDate, disabledDates[i].to) === -1
           )
           &&
            (
               compareDates(toDate, disabledDates[i].from) === -1  
            && 
               compareDates(toDate, disabledDates[i].to) === -1
           )
         )
                     ||
         (
           (
               compareDates(fromDate, disabledDates[i].from) === 1
            && 
               compareDates(fromDate, disabledDates[i].to) === 1
           )
           &&
            (
               compareDates(toDate, disabledDates[i].from) === 1  
            && 
               compareDates(toDate, disabledDates[i].to) === 1
           )
         )
       ){
         continue;
     }else{
         console.log( disabledDates[i].from)
         console.log( disabledDates[i].to)
         alert("Please enter a valid date!");
         return;
     }
 }
 console.log('valid')
};

const compareDates = (stringDateA, stringDateB) => {
 // In our case stringDateB is DD/MM/YYYY
 // We need MM/DD/YYYY in date constructor
 let d = stringDateB.split("/");
 let dat = new Date(d[2] + '/' + d[1] + '/' + d[0]);
 const dateA = new Date(stringDateA)
 dateA.setHours(0,0,0,0)
 const dateB = new Date(dat)
 dateB.setHours(0,0,0,0)
 const millisA = dateA.getTime();
 const millisB = dateB.getTime();
 if (millisA === millisB) return 0;
 else if (millisA > millisB) return -1;
 else if (millisA < millisB) return 1;
};
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