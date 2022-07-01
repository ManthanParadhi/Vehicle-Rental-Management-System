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
<c:if test="${not empty msg}">
		${msg}
		<c:remove var="msg" scope="session" />
	</c:if>
	<table cellspacing="20">

		<tbody>

			<tr>
				
				<th>Business Name</th>
				<th>Business Address</th>
				<th>Business Email</th>
				<th>Business Contact Number</th>

			</tr>

			
				<tr>

					
					<td>${information.getBusinessName()}</td>
					<td>${information.getBusinessAddress()}</td>
					<td>${information.getBusinessEmail()}</td>
					<td>${information.getBusinessContactNumber()}</td>

					
					<td><a href="businessInformation/edit/${information.getId()}"><button>Edit</button></a></td>
				</tr>

			
		</tbody>
	</table>
</body>
</html>