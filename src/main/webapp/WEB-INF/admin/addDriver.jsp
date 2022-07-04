<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.shashank.vrms.enums.IdProofType" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	${msg}
	<form action="" method="post">
	
	First Name : <input type="text" name = "firstName" required> <br><br>
	Last Name : <input type="text" name = "lastName" required> <br><br>
	Contact Number : <input type="text" name = "contactNumber" required> <br><br>
	Address : <input type="text" name = "address" required> <br><br>
	
	<label >ID proof type :</label>
	
	<c:set var="idProofTypes" value="<%=IdProofType.values()%>"/>
	
<select name="idProofType"  required>
  <option value="" disabled selected hidden>Select type</option>
  
  <c:forEach items="${idProofTypes}" var="idProofType">
     <option value="${idProofType}" >${idProofType}</option>
  
</c:forEach>
  
  </select><br><br>
  
  ID proof Number : <input type="text" name = "idProofNumber" required> <br><br>	
  
  <input type="submit"> 
	
	
	</form>
</body>
</html>