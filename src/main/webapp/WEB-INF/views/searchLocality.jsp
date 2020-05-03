<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>
    <form:form method="post" action="/findLocality" modelAttribute="clinic">
             <table>
            <tr>
                <td><form:label path="locality">Locality</form:label></td>
                <td><form:input path="locality" /></td>
            </tr>
            
   
             <tr>
                <td colspan="2"><input type="submit" value="Search"/></td>
            </tr>
        </table>
    </form:form>
</body>
</html>