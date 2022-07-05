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
My Profile!<br><br>
		First Name : ${user.getFirstName()}<br>
		Last Name : ${user.getLastName()}<br>
		Email : ${user.getEmail()}<br>
        Address : ${user.getDetails().getAddressLine()}<br>
		State : ${user.getDetails().getState()}<br>
		City : ${user.getDetails().getCity()}<br>
		Pincode : ${user.getDetails().getPincode()}<br>
		Contact Number : ${user.getDetails().getContactNumber()}<br>
		Id Proof Type : ${user.getDetails().getIdProofType()}<br>
		Id Proof Number : ${user.getDetails().getIdProofNumber()}<br><br>
		
		<td><a href="user/edit"><button>Edit Profile</button></a></td>
</body>
</html>