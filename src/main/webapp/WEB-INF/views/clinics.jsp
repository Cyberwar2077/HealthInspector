<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Details Page</title>
</head>
<body>


	<tr>

		<td><form:select path="clinic">
				<form:option value="Select Clinic"></form:option>
				<c:forEach items="${clinic}" var="clinic">

					<form:option value="${clinic.clinicId}">${clinic.clinicName}</form:option>
				</c:forEach>
			</form:select></td>
	</tr>

</body>
</html>