<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
	<%@ include file="/WEB-INF/nav.jsp"%>
	<div class="bg-black">

		<div class="w-4/5 text-right text-white p-4 mx-auto pr-0">
			<h1 class="p-3 font-bold text-3xl text-yellow-400">BOOK A
				Vehicle TODAY !</h1>
			<p class="p-3">FOR AS LOW AS $10 A DAY PLUS 15% DISCOUNT</p>
			<p class="p-3">FOR OUR RETURNING CUSTOMERS</p>
		</div>
	</div>

	<h2 class="text-center text-3xl p-5 font-bold">Login page!</h2>
	<form class="text-center" action="login" method="post">
		<div class=" w-3/5 m-auto text-center">
			<input class="block outline-none w-1/3 border-2 p-2 focus:border-white mx-auto my-2"
				placeholder="Enter the E-mail" type="email" name="email" required>
			<input class="block w-1/3 border-2 p-2 outline-none focus:border-white mx-auto my-2"
				placeholder="Enter the Password" type="password" name="password"
				required> 
			<input
				class="block w-1/3 border-2 p-2 hover:bg-yellow-400 hover:text-white hover:border-white mx-auto my-2"
				type="submit">
		</div>

	</form>
	<c:choose>
    <c:when test="${msg.equals('User registered successfully')}">
    	<p class="text-center mt-1 text-green-600">
		<span class="text-white">/</span>${msg}</p>
    </c:when>
    <c:otherwise>
    	<p class="text-center mt-1 text-red-600">
		<span class="text-white">/</span>${msg}</p>
    </c:otherwise>
</c:choose>
	<div class="w-3/5 mt-2 mx-auto text-center pt-4">

		<h4 class="p-1">OR</h4>
		<button
			class="w-1/6 border-2 p-1 hover:bg-yellow-400 hover:text-white hover:border-white">Forgot
			Password</button>
		<p class="p-2">
			Don't have a account? <a class="hover:text-yellow-400"
				href="register">Sign Up</a>
		</p>
	</div>
</body>
</html>