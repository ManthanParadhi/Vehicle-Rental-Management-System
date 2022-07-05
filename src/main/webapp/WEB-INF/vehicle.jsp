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

					<img src= "${vehicle.getImageUrl()}"><br>
				
				
					
				Model : 	${vehicle.getModel()}<br>
				Variant :	${vehicle.getVariant()}<br>
				Brand : ${vehicle.getBrand().getBrand()}<br>
				Color :	${vehicle.getColor()}<br>
				Registration Number :	${vehicle.getRegistrationNumber()}<br>
				Registration Year : 	${vehicle.getRegistrationYear()}<br>
					
			        
			   Seating Capacity :   ${vehicle.getSeatingCapacity()}<br>
			   Availability :	${vehicle.isAvailable() eq "true" ? 'Available' : 'Not Available'}<br>
			   
			   
			
				
					
				Registration Expires On	: ${vehicle.getDocuments().getRegExpiresOn()}<br>
				Puc Expires On : ${vehicle.getDocuments().getPucExpiresOn()}<br>
				Insurance Expires On :${vehicle.getDocuments().getInsuranceExpiresOn()}<br>
					
					<form action="c/book" method="post">
				<input type="hidden" name="id" value="${vehicle.getId()}"><br>
				<button type="submit">Book Now</button><br><br>
				</form>
</body>
</html>