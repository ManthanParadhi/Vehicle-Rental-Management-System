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

	<h2>Admin Dashboard!</h2>
	<ul>
  <li><a href="vehicle/add">Add vehicle</a></li>
  <li><a href="brand/add">Add brand</a></li>
  <li><a href="users">View users</a></li>
  <li><a href="businessInformation/add">Add Business Information</a></li>
   <li><a href="businessInformation">View Business Information</a></li>
    <li><a href="brands">View brands</a></li>
     <li><a href="vehicles">View vehicles</a></li>
      <li><a href="driver/add">Add driver</a></li>
      <li><a href="drivers">View drivers</a></li>
       <li><a href="bookings">View Bookings</a></li>
</ul>
	<c:if test="${not empty msg}">
		${msg}
		<c:remove var="msg" scope="session" />
	</c:if>
</body>
</html>