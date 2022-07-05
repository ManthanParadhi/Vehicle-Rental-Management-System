
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page isELIgnored="false"%>
<html>
<body>
	<h2>Home page!</h2>


	<c:if test="${empty email}">
		<a href="register">Register here</a>
		<br>
		<a href="login">Login here</a>
		<br>
		
		
		</c:if>
		
		<c:if test="${not empty email}">
		<br>Welcome  ${email}<br><br>
		<a href="c/user">My Profile</a><br>
		
		</c:if>
		
		<a href="c/bookings">My Bookings</a><br>
		<a href="vehicles">Vehicles</a><br><br>
		
	
	<br>
	<br> ${msg}
	
</body>
</html>
