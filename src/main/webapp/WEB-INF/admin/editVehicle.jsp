<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.shashank.vrms.enums.VehicleType" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="" method="post">
	<br>
	
	<input type="hidden" name="id" value="${vehicle.getId()}"><br>
	<label >Vehicle type :</label>
	
	<c:set var="vehicleTypes" value="<%=VehicleType.values()%>"/>
	
<select name="type" >

  <option value="" disabled selected hidden>Select type</option>
  <c:forEach items="${vehicleTypes}" var="vehicleType">
     <option value="${vehicleType}" ${vehicle.getType() eq vehicleType ? 'selected' : ''}>${vehicleType}</option>
  
</c:forEach>
 
  
  </select><br><br>
  
	Enter Model : <input type="text" name="model" value="${vehicle.getModel()}" required> <br><br>
	Enter variant  : <input type="text" name="variant" value="${vehicle.getVariant()}"  required> <br><br>
	Enter color : <input type="text" name="color" value="${vehicle.getColor()}" required> <br><br>
	Enter Registration number : <input type="text" name="registrationNumber" value="${vehicle.getRegistrationNumber()}"  required> <br><br>
	Enter Registration year : <input type="text" name="registrationYear" value="${vehicle.getRegistrationYear()}" required> <br><br>
	Enter engine number : <input type="text" name="engineNumber" value="${vehicle.getEngineNumber()}" required> <br><br>
	Enter chasis number : <input type="text" name="chasisNumber" value="${vehicle.getChasisNumber()}" required> <br><br>
	Enter Brand  :
	
	<select required name="brandId" value="${vehicle.getBrandId()}" >
			<option value="" disabled selected hidden>Select Brand</option>
			<c:forEach items="${brandList}" var="brand">
				<option value="${brand.getId()}" ${vehicle.getBrandId() == brand.getId() ? 'selected' : ''}>${brand.getBrand()}
				</option>
			</c:forEach>
		</select><br><br>
		
		

	<label >Seating capacity:</label>

<select name="seatingCapacity" value="${vehicle.getSeatingCapacity()}" >
  <option value="" disabled selected hidden>Select Seating capacity</option>
  
  <option value="2" ${vehicle.getSeatingCapacity() == 2 ? 'selected' : ''}>2 Seater</option>
  <option value="4" ${vehicle.getSeatingCapacity() == 4 ? 'selected' : ''}>4 Seater</option>
  <option value="5" ${vehicle.getSeatingCapacity() == 5 ? 'selected' : ''}>5 Seater</option>
  <option value="7" ${vehicle.getSeatingCapacity() == 7 ? 'selected' : ''}>7 Seater</option>
  <option value="8" ${vehicle.getSeatingCapacity() == 8 ? 'selected' : ''}>8 Seater</option>
  <option value="10" ${vehicle.getSeatingCapacity() == 10 ? 'selected' : ''}>10 Seater</option>
</select><br><br>

<label >Availability :</label>
<select name="isAvailable" value="${vehicle.isAvailable()}" >
  <option value="" disabled selected hidden>Select availability</option>
  <option value="true" ${vehicle.isAvailable() == true ? 'selected' : ''}>Available</option>
  <option value="false" ${vehicle.isAvailable() == false ? 'selected' : ''}>Not Available</option>
  
  </select><br><br>
  
	Enter image url : <input type="text" name="imageUrl"  value="${vehicle.getImageUrl()}" required> <br><br>
	Enter registration expiry date :  <input type="datetime-local" name="registrationExpiryDate" value="${vehicle.getDocuments().getRegExpiresOn()}"  required><br><br>
	Enter puc expiry date :  <input type="datetime-local" name="pucExpiryDate" value="${vehicle.getDocuments().getPucExpiresOn()}" required><br><br>
	Enter insurance expiry date :  <input type="datetime-local" name="insuranceExpirydate" value="${vehicle.getDocuments().getInsuranceExpiresOn()}" required><br><br>
	
	<input type="submit">
	
	</form><br><br>
</body>
</html>