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
		hi!
		
		Name : ${information.getBusinessName()} <br><br>
		Email :${information.getBusinessEmail()} <br><br>
		Contact : ${information.getBusinessContactNumber()} <br><br>
		Address : ${information.getBusinessAddress()} <br><br>
		
</body>
</html>