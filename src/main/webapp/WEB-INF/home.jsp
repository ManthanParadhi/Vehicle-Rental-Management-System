
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<script src="https://cdn.tailwindcss.com"></script>
<title>Home</title>
</head>
<body>
	<%@ include file="/WEB-INF/nav.jsp" %>
	<div class="bg-black">
		<div class="w-4/5 text-right text-white p-4 pr-0 mx-auto">
			<h1 class="p-3 font-bold text-3xl text-yellow-400">BOOK A
				Vehicle TODAY !</h1>
			<p class="p-3">FOR AS LOW AS $10 A DAY PLUS 15% DISCOUNT</p>
			<p class="p-3">FOR OUR RETURNING CUSTOMERS</p>
		</div>
	</div>



	<c:if test="${not empty email}">
		<div>		
		<p class="text-center text-2xl p-3">Welcome  <b>${email}</b></p>
		</div>
	</c:if>
	${msg}

</body>
</html>
