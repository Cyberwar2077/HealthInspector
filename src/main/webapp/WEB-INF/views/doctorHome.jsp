<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Home Page</title>
<script type="text/javascript">
function changeStatus(status){
	document.getElementById("status").value=status;
	document.getElementById("statuschange").submit();
}
</script>
</head>
<body>
<h2>Doctor Home Page</h2>
<p>Welcome, ${userLogin.userid}    
 ${message}</p>
<a href="update">Update Details</a><br>
<a href="showclinic">Add Clinic</a><br>
<form:form id="statuschange" method="post" action="changeStatus" modelAttribute="appointment">
<c:forEach items="${appointments}" var="appointment">
					<form:input path="appointmentId" type="text" readonly="readonly" value="${appointment.appointmentId}"></form:input>
					${appointment.patientName.firstName} ${appointment.patientName.lastName}
					<form:hidden path="appointmentStatus" id="status" value='P'/>
					<input type="button" value="accept" onclick="changeStatus('A')">
					<input type="button" value="reject" onclick="changeStatus('R')">
				</c:forEach>
</form:form>
</body>
</html>