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
 <form:form method="post" action="" modelAttribute="clinic">
	<table>
	<tr>
		
		<tr>
				
				<td><form:select path="facilities" >
						<form:option value="Select facilities"></form:option>
						<c:forEach items="${clinicList}" var="clinic">
						
							<form:option value="${clinic.facilities}">${clinic.facilities}</form:option>
						</c:forEach>
				</form:select>
				</td>
			</tr>
	</tr>
	
	<tr>
				<td colspan="2"><input type="submit" value="Update" /></td>
			</tr>
	</table>
</form:form>
</body>
</html>