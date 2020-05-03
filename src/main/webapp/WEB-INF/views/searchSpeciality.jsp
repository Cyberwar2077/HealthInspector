<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%-- 
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script>
	function ajaxFunction(event, formId, divId, postUrl) {
		var clicked = event.target.value;
		var form = "#" + formId;
		var div = "#" + divId;
		var dataUrl = "/" + postUrl;
		var formJson = $(form).serialize();
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : dataUrl,
			data : formJson,
			success : function(data) {
				$(div).replaceWith(data);
				console.log("SUCCESS : ", data);
				document.getElementById("btn").disabled = false;
			},
			error : function(e) {
				console.log("ERROR : ", e);
				document.getElementById("btn").disabled = false;

			}
		});
	}
</script>
--%>
</head>
<body>
	<%--     <form:form id="speciality"  method="post" action="getDoctors" modelAttribute="doctor"> --%>
	<form:form method="post" action="getDoctors" modelAttribute="doctor">

		<table>
			<tr>

				<td><form:select path="speciality">
						<form:option value="Select Speciality"></form:option>
						<c:forEach items="${specialityList}" var="speciality">

							<form:option value="${speciality}">${speciality}</form:option>
						</c:forEach>
					</form:select></td>
			</tr>

			<tr>
				<%--	<td colspan="2"><input id="btn" type="button" value="Search" onClick="ajaxFunction(event,'speciality','doctorList','getDoctors')"/></td>
				--%>
				<td colspan="2"><input type="submit" value="Search" />
			</tr>
		</table>
	</form:form>
	<%-- <div id="doctorList"></div> --%>
</body>
</html>