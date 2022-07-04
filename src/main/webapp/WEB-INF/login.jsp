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

	<h2 class="text-center text-3xl p-5 font-bold">Login page!</h2>
	<form class="text-center" action="login" method="post">
		<div class=" w-3/5 m-auto">
			 <input class="outline-none w-1/3 border-2 p-2 focus:border-white" placeholder="Enter the E-mail" type="email" name="email" required><br><br>
			<input class="w-1/3 border-2 p-2 outline-none focus:border-white" placeholder="Enter the Password" type="password"  name="password" required><br><br>
			<input class="w-1/6 border-2 p-2 hover:bg-yellow-400 hover:text-white hover:border-white" type="submit">
		</div>

	</form>
		${msg}
		<div class="w-3/5 m-auto text-center pt-4">
			<h4 class="p-1">OR</h4>
			<button class="w-1/6 border-2 p-1 hover:bg-yellow-400 hover:text-white hover:border-white">Forgot Password</button>
			<p class="p-1">Don't have a account? <a class="hover:text-yellow-400" href="#">Sign Up</a></p>
		</div>
</body>
</html>