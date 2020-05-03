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

	<form:form method="post" action="savedoctor" modelAttribute="doctor">
		<table>

			<tr>
				<td><form:label path="userid">User Id</form:label></td>
				<td><form:input path="userid" value="${userid}" readonly="true"/></td>
			</tr>
			<tr>
				<td><form:label path="speciality">Speciality</form:label></td>
				<td><form:input path="speciality" /></td>
			</tr>




 			<tr>
				<td>Add Clinic</td>
				<td><form:select path="clinicId" >
						<form:option value="Select Clinic"></form:option>
						<c:forEach items="${clinicList}" var="clinic">
						
							<form:option value="${clinic.clinicId}">${clinic.clinicName}</form:option>
						</c:forEach>
				</form:select>
				</td>
			</tr>



			<tr>
				<td><form:label path="days">Days</form:label></td>
				<td>Monday<form:checkbox path="days" value="Monday"></form:checkbox>
					Tuesday<form:checkbox path="days" value="Tuesday"></form:checkbox>
					Wednesday<form:checkbox path="days" value="Wednesday"></form:checkbox>
					Thursday<form:checkbox path="days" value="Thursday"></form:checkbox>
					Friday<form:checkbox path="days" value="Friday"></form:checkbox>
					Saturday<form:checkbox path="days" value="Saturday"></form:checkbox>
					Sunday<form:checkbox path="days" value="Sunday"></form:checkbox>
				</td>
			</tr>
			<tr>
				<td>Time</td>
				<td><form:select path="time">
						<form:option value="9:00 AM - 12:00 PM" />
						<form:option value="1:00 PM - 4:00 PM" />
						<form:option value="5:00 PM - 8:00 PM" />
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Update" /></td>
			</tr>




		</table>
	</form:form>



</body>
</html>