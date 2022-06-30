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
	<form action="" method="post">
	
	<label >Vehicle type :</label>
<select name="type">
  <option value="" disabled selected hidden>Select type</option>
  <option value="TWO_WHEELER">Two wheeler</option>
  <option value="FOUR_WHEELER">Four Wheeler</option>
  
  </select><br><br>
  
	Enter Model : <input type="text" name="model" required> <br><br>
	Enter variant  : <input type="text" name="variant" required> <br><br>
	Enter color : <input type="text" name="color" required> <br><br>
	Enter Registration number : <input type="text" name="registrationNumber" required> <br><br>
	Enter Registration year : <input type="text" name="registrationYear" required> <br><br>
	Enter engine number : <input type="text" name="engineNumber" required> <br><br>
	Enter chasis number : <input type="text" name="chasisNumber" required> <br><br>
	Enter Brand  :
	
	<select required name="brandId">
			<option value="" disabled selected hidden>Select Brand</option>
			<c:forEach items="${brandList}" var="brand">
				<option value="${brand.getId()}">${brand.getBrand()}
				</option>
			</c:forEach>
		</select><br><br>
		
		

	<label >Seating capacity:</label>

<select name="seatingCapacity">
  <option value="" disabled selected hidden>Select Seating capacity</option>
  <option value="1">1 Seater</option>
  <option value="2">2 Seater</option>
  <option value="4">4 Seater</option>
  <option value="5">5 Seater</option>
  <option value="7">7 Seater</option>
  <option value="8">8 Seater</option>
  <option value="10">10 Seater</option>
</select><br><br>

<label >Availability :</label>
<select name="isAvailable">
  <option value="" disabled selected hidden>Select availability</option>
  <option value="true">Available</option>
  <option value="false">Not Available</option>
  
  </select><br><br>
  
	Enter image url : <input type="text" name="imageUrl" required> <br><br>
	Enter registration expiry date :  <input type="datetime-local" name="registrationExpiryDate" required><br><br>
	Enter puc expiry date :  <input type="datetime-local" name="pucExpiryDate" required><br><br>
	Enter insurance expiry date :  <input type="datetime-local" name="insuranceExpirydate" required><br><br>
	
	<input type="submit">
	
	</form><br><br>
	
	
	${msg}
</body>
</html>