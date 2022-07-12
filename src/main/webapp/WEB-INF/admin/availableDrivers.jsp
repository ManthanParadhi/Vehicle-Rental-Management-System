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

${msg}
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
				<th>Availability Status</th>
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
					<td>${driver.getAvailabilityStatus()}</td>
					<td>${driver.getCreatedOn()}</td>
					<td>${driver.getUpdatedOn()}</td>

					<td><form action="" method="post">
						<input type="hidden" name="id" value="${driver.getId()}">
   						<button type="submit" >Allot</button>
					</form></td>
					
				</tr>

			</c:forEach>
		</tbody>
	</table>
</body>
</html>