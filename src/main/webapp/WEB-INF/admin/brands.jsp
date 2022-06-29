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
				<th>Brand Id</th>
				<th>Brand Name</th>
				<th>Created On</th>
				<th>Updated on</th>

			</tr>

			<c:forEach items="${brandList}" var="brand" varStatus="status">
				<tr>

					<td>${status.count}</td>
					<td>${brand.getBrand()}</td>
					<td>${brand.getCreatedOn()}</td>
					<td>${brand.getUpdatedOn()}</td>

					<td><a href="brand/delete/${brand.getId()}"><button>Delete</button></a></td>
					<td><a href="brand/edit/${brand.getId()}"><button>Edit</button></a></td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
	<br>

</body>
</html>