<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
 <h2>Add User</h2>
    <br/>
    <form:form method="post" action="saveuser" modelAttribute="user">
        <table>
       
         <tr>
                <td><form:label path="firstName">First Name</form:label></td>
                <td><form:input path="firstName" /></td>
            </tr>
            
            <tr>
                <td><form:label path="lastName">Last Name</form:label></td>
                <td><form:input path="lastName" /></td>
            </tr>
            
            <tr>
                <td><form:label path="dateOfBirth">DoB</form:label></td>
                <td><form:input path="dateOfBirth" placeholder="dd/MM/yyyy"/></td>
                
            </tr>
            
             <tr>
             <td><form:label path="gender">Gender</form:label></td>
            <td><form:radiobutton path="gender" value="Male"/>Male</td>  
            <td><form:radiobutton path="gender" value="Female"/>Female</td>
            </tr>
            
             <tr>
                <td><form:label path="contactNumber">Contact Number</form:label></td>
                <td><form:input path="contactNumber" /></td>
            </tr>
            
            <tr>
                <td><form:label path="userid">User Id</form:label></td>
                <td><form:input path="userid" /></td>
            </tr>
            
            <tr>
                <td><form:label path="password">Password</form:label></td>
                <td><form:input path="password" /></td>
            </tr>
           
           <tr>
                <td><form:label path="email">Email</form:label></td>
                <td><form:input path="email" /></td>
            </tr>
            
            <tr>
				<td>User category</td>
				<td><form:select path="userCategory">
					 <form:option value="Patient" />
					  <form:option value="Doctor" />
				       </form:select>
                 </td>
            <tr>
                <td colspan="2"><input type="submit" value="register"/></td>
            </tr>
        </table>
    </form:form>
</body>
</html>