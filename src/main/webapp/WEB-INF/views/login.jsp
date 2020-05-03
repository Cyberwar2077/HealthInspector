<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Login</title>
 
<style type="text/css">
.error
{
color: red;
}
/*body
{
	background-color:linen;
}*/
</style>
</head>
<body>
${uname} 
<h2>Login</h2>
<form:form method="post" action="validate" modelAttribute="userLogin">
        <table>
            <tr>
                <td><form:label path="userid">UserId</form:label></td>
                <td><form:input path="userid" /></td>
                 <td><form:errors path="userid" cssClass="error"/>
            </tr>
            <tr>
                <td><form:label path="password">password</form:label></td>
                <td><form:password path="password" /></td>
                  <td><form:errors path="password" cssClass="error"/>
            </tr>
             
            <tr>
                <td><input type="submit" value="Login"/></td>
            </tr>
        </table>
    </form:form>

</body>


</html>