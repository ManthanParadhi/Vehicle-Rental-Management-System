
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
            <h3 class="inline pl-6 py-3 m-0 text-white"><a href="home">Home</a></h3>
            <h3 class="inline pl-6 py-3 m-0 text-white"><a href="login">About</a></h3>
            <h3 class="inline pl-6 py-3 m-0 text-white"><a href="vehicles">Vehicles</a></h3>
            <h3 class="inline pl-6 py-3 m-0 text-white"><a href="contact">Contact</a></h3>
            <c:if test="${empty email}">
				<h3 class="inline pl-6 py-3 m-0 text-white hover:text-yellow-400"><a href="login">Login</a>
				<span>|</span>
				<a href="register">Register</a></h3>
				
			</c:if>
        </div>
    </nav>
    <div class="w-4/5 text-right text-white p-14 pr-0 m-auto">
        <h1 class="p-3 font-bold text-3xl text-yellow-400">BOOK A Vehicle TODAY !</h1>
        <p class="p-3">FOR AS LOW AS $10 A DAY PLUS 15% DISCOUNT</p>
        <p class="p-3">FOR OUR RETURNING CUSTOMERS</p>
    </div>
</header>
	
		
		
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
