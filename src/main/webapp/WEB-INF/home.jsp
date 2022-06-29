
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
	<br>
	<br> ${msg}
	<br> ${email}
</body>
</html>
