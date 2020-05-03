<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%--  <div id="doctorList"> --%>
<form:form method="post" action="appointment" modelAttribute="doctorModel">
	<table>
	<tr>
		
		<td><form:select path="userid">
				<form:option value="Select Doctor"></form:option>
				<c:forEach items="${doctorList}" var="doctor">
					<form:option value="${doctor.userid}">${doctor.firstName} ${doctor.lastName}</form:option>
				</c:forEach>
			</form:select></td>
	</tr>
	
	<tr>
				<td colspan="2"><input type="submit" value="Book Appointment" /></td>

			</tr>
	</table>
</form:form>
 <%-- </div> --%>
</body>
</html>