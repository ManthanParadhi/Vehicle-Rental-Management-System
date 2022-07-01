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

		${msg} <br>
		
	
	<table cellspacing="20">

		<tbody>

			<tr>
				<th>Sr. No.</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Contact Number</th>
				<th>Address</th>
				<th>City</th>
				<th>State</th>
				<th>Pincode</th>
				<th>Id Proof Type</th>
				<th>Id Proof Number</th>
				<th>Created On</th>
				<th>Updated On</th>
				
				

			</tr>

			<c:forEach items="${userList}" var="user" varStatus="status">
				<tr>

					<td>${status.count}</td>
					<td>${user.getFirstName()}</td>
					<td>${user.getLastName()}</td>
					<td>${user.getEmail()}</td>
					<td>${user.getDetails().getContactNumber()}</td>
					<td>${user.getDetails().getAddressLine()}</td>
					<td>${user.getDetails().getCity()}</td>
					<td>${user.getDetails().getState()}</td>
					<td>${user.getDetails().getPincode()}</td>
					<td>${user.getDetails().getIdProofType()}</td>
					<td>${user.getDetails().getIdProofNumber()}</td>
					<td>${user.getCreatedOn()}</td>
					<td>${user.getUpdatedOn()}</td>

				</tr>

			</c:forEach>
		</tbody>
	</table>
</body>
</html>