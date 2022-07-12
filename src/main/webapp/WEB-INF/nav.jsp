
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<script src="https://cdn.tailwindcss.com"></script>
<title>Home</title>
</head>
<body>
	<header class="bg-black">
		<nav class="flex w-4/5 mx-auto justify-between items-center">
			<h1 class="inline p-3 m-0 text-white text-3xl">KVRS</h1>
			<div class="inline p-3 m-0 text-white">
				<h3 class="inline pl-6 py-3 m-0 text-white hover:text-yellow-400">
					<a href="home">Home</a>
				</h3>
				<h3 class="inline pl-6 py-3 m-0 text-white hover:text-yellow-400">
					<a href="login">About</a>
				</h3>
				<h3 class="inline pl-6 py-3 m-0 text-white hover:text-yellow-400">
					<a href="${pageContext.request.contextPath}/c/bookings">My Bookings</a>
				</h3>
				<h3 class="inline pl-6 py-3 m-0 text-white hover:text-yellow-400">
					<a href="vehicles">Vehicles</a>
				</h3>
				<h3 class="inline pl-6 py-3 m-0 text-white hover:text-yellow-400">
					<a href="contact">Contact</a>
				</h3>
				<c:if test="${not empty email}">
					<h3 class="inline pl-6 py-3 m-0 text-white hover:text-yellow-400">
						<a href="c/user">My Profile</a> ${name}
					</h3>
				</c:if>

				<c:if test="${empty email}">
					<h3 class="inline pl-6 py-3 m-0 text-white hover:text-yellow-400">
						<a href="login">Login</a> <span>|</span> <a href="${pageContext.request.contextPath}/register">Register</a>
					</h3>

				</c:if>
				
				
			</div>
		</nav>
	</header>

</body>
</html>
