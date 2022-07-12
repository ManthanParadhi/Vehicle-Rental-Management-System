<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.shashank.vrms.enums.IdProofType" %>
<%@ page import="com.shashank.vrms.enums.AvailabilityStatus" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="" method="post">
	
	<input type="hidden" name="id" value="${driver.getId()}"><br>
	First Name : <input type="text" name = "firstName"  value="${driver.getFirstName()}" required> <br><br>
	Last Name : <input type="text" name = "lastName" value="${driver.getLastName()}" required> <br><br>
	Contact Number : <input type="text" name = "contactNumber" value="${driver.getContactNumber()}" required> <br><br>
	Address : <input type="text" name = "address" value="${driver.getAddressLine()}" required> <br><br>
	
	<label >ID proof type :</label>
	
	<c:set var="idProofTypes" value="<%=IdProofType.values()%>"/>
	
<select name="idProofType"  required>
  <option value="" disabled selected hidden>Select type</option>
  
  <c:forEach items="${idProofTypes}" var="idProofType">
     <option value="${idProofType}" 
     ${driver.getIdProofType() eq idProofType ? 'selected' : ''}>${idProofType}</option>
  
</c:forEach>
  
  </select><br><br>
  
  ID proof Number : <input type="text" name = "idProofNumber" value="${driver.getIdProofNumber()}" required> <br><br>	
  
   <label >Availability Status :</label>
  <c:set var="availabilityStatuss" value="<%=AvailabilityStatus.values()%>"/>
	
<select name="availabilityStatus"  required>
  <option value="" disabled selected hidden>Select type</option>
  
  <c:forEach items="${availabilityStatuss}" var="availabilityStatus">
     <option value="${availabilityStatus}"  ${driver.getAvailabilityStatus() eq availabilityStatus ? 'selected' : ''} >${availabilityStatus}</option>
  
</c:forEach>
  
  </select><br><br>
  
  <input type="submit"> 
	
	
	</form>
</body>
</html>