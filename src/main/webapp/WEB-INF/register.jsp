<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.tailwindcss.com"></script>

</head>
<body>
	<header class="bg-black">
		<nav class="flex w-4/5 mx-auto justify-between items-center">
			<h1 class="inline p-3 m-0 text-white text-3xl">KVRS</h1>
			<div class="inline p-3 m-0 text-white">
				<a href="#" class="inline pl-6 py-3 m-0 text-white hover:text-yellow-400">Home</a>
				<a href="#" class="inline pl-6 py-3 m-0 text-white hover:text-yellow-400">About</a>
				<a href="#" class="inline pl-6 py-3 m-0 text-white hover:text-yellow-400">Vehicle</a>
				<a href="#" class="inline pl-6 py-3 m-0 text-white hover:text-yellow-400">Contact</a>
			</div>
		</nav>
		<div class="w-4/5 text-right text-white p-4 mx-auto pr-0">
			<h1 class="p-3 font-bold text-3xl text-yellow-400">BOOK A Vehicle TODAY !</h1>
			<p class="p-3">FOR AS LOW AS $10 A DAY PLUS 15% DISCOUNT</p>
			<p class="p-3">FOR OUR RETURNING CUSTOMERS</p>
		</div>
	</header>
	<h2 class="text-center text-3xl p-5 font-bold">Register page</h2>

	<form class="text-center" action="register" method="post">
		<div class=" w-1/4 m-auto">
			<input class="w-full outline-none border-2 p-2 m-1 focus:border-white" placeholder="Enter First Name" type="text" name="firstName" required>
			<input class="w-full outline-none border-2 p-2 m-1 focus:border-white" placeholder="Enter Last Name" type="text" name="lastName" required>
			<input class="w-full outline-none border-2 p-2 m-1 focus:border-white" placeholder="Enter your E-mail id" type="email" name="email" required>
			<input class="w-full outline-none border-2 p-2 m-1 focus:border-white" placeholder="Enter Password" type="password" name="password" required>
			
			<div class="text-xs p-2">
			${msg}
				<ul class="list-disc text-gray-500 cursor-default">
					<li class="text-left">Password must be at least 8 characters long.</li>
					<li class="text-left">Password must not be longer than 18 characters.</li>
					<li class="text-left">Password must contain at least one upper case and one lower case letter.</li>
					<li class="text-left">Password must contain at least one number or punctuation character.</li>
					<li class="text-left">Password must not contain space or unicode characters.</li>
				</ul>
			</div>

			<input class="cursor-pointer w-1/3 border-2 p-2 hover:bg-yellow-400 hover:text-white hover:border-white" type="submit">
		</div>
	</form>
	
	
		
	
</body>
</html>