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
				<th>Sr No</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Contact Number</th>
				<th>Address</th>
				<th>Id proof type</th>
				<th>Id proof number</th>
				<th>Created On</th>
				<th>Updated on</th>

			</tr>

			<c:forEach items="${driverList}" var="driver" varStatus="status">
				<tr>

					<td>${status.count}</td>
					<td>${driver.getFirstName()}</td>
					<td>${driver.getLastName()}</td>
					<td>${driver.getContactNumber()}</td>
					<td>${driver.getAddressLine()}</td>
					<td>${driver.getIdProofType()}</td>
					<td>${driver.getIdProofNumber()}</td>
					<td>${driver.getCreatedOn()}</td>
					<td>${driver.getUpdatedOn()}</td>

					<td><a href="driver/delete/${driver.getId()}"><button>Delete</button></a></td>
					<td><a href="driver/edit/${driver.getId()}"><button>Edit</button></a></td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
</body>
</html>