<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page isELIgnored="false"%>

<%@ page import="com.shashank.vrms.enums.IdProofType" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<script src="https://cdn.tailwindcss.com"></script>

</head>
<body>
	<%@ include file="/WEB-INF/nav.jsp"%>
	<div class="bg-black">
		<div class="w-4/5 text-right text-white p-4 mx-auto pr-0">
			<h1 class="p-3 font-bold text-3xl text-yellow-400">BOOK A Vehicle TODAY !</h1>
			<p class="p-3">FOR AS LOW AS $10 A DAY PLUS 15% DISCOUNT</p>
			<p class="p-3">FOR OUR RETURNING CUSTOMERS</p>
		</div>
	</div>
	<h3 class="text-center p-2">Already have a account.<a class="hover:text-yellow-400" href="login"> Login</a> </h3>
	<h2 class="text-center text-3xl p-2 font-bold">Register page</h2>

	<form class="text-center" action="register" method="post">
		<div class=" w-1/4 m-auto">
			<input class="w-full outline-none border-2 p-2 m-1 focus:border-white" placeholder="Enter First Name" type="text" name="firstName" required>
			<input class="w-full outline-none border-2 p-2 m-1 focus:border-white" placeholder="Enter Last Name" type="text" name="lastName" required>
			<input class="w-full outline-none border-2 p-2 m-1 focus:border-white" placeholder="Enter your E-mail id" type="email" name="email" required>
			<input class="w-full outline-none border-2 p-2 m-1 focus:border-white" placeholder="Enter Password" type="password" name="password" required>
			
			<input class="w-full outline-none border-2 p-2 m-1 focus:border-white" placeholder="Enter Address Line" type="text" name="addressLine" required>
			<input class="w-full outline-none border-2 p-2 m-1 focus:border-white" placeholder="State" type="text" name="state" required>
			<input class="w-full outline-none border-2 p-2 m-1 focus:border-white" placeholder="City" type="text" name="city" required>
			<input class="w-full outline-none border-2 p-2 m-1 focus:border-white" placeholder="Pincode" type="text" name="pincode" required>
			<input class="w-full outline-none border-2 p-2 m-1 focus:border-white" placeholder="Contact Number" type="text" name="contactNumber" required>
			
			<c:set var="idProofTypes" value="<%=IdProofType.values()%>"/>
	
<select name="idProofType"  required>
  <option value="" disabled selected hidden>Select ID Proof Type</option>
  
  <c:forEach items="${idProofTypes}" var="idProofType">
     <option value="${idProofType}" >${idProofType}</option>
  
</c:forEach>
  
  </select><br><br>
  <input class="w-full outline-none border-2 p-2 m-1 focus:border-white" placeholder="ID Proof Number" type="text" name="idProofNumber" required>
  
			
			
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