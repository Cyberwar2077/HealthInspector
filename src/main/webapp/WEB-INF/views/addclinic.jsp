<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add clinic</title>
</head>
<body>
<h2>Add Clinic</h2>
 <br/>
    <form:form method="post" action="saveclinic" modelAttribute="clinic">
    
      <table>
         <tr>
                <td><form:label path="clinicName">Clinic Name</form:label></td>
                <td><form:input path="clinicName" /></td>
            </tr>
                     <tr>
                <td><form:label path="clinicId">Clinic Id</form:label></td>
                <td><form:input path="clinicId" /></td>
            </tr>
            
         <tr>
                <td><form:label path="address">Address</form:label></td>
                <td><form:input path="address" /></td>
            </tr>
          
            <tr>
                <td><form:label path="facilities">Facilities Available </form:label></td>
                <td><form:input path="facilities" /></td>
            </tr>
           
            <tr>
                <td><form:label path="contactNumber">Contact Number</form:label></td>
                <td><form:input path="contactNumber" /></td>
            </tr>
            
           <tr>
                <td><form:label path="website">Website</form:label></td>
                <td><form:input path="website" /></td>
            </tr>
            
           <tr>
                <td><form:label path="locality">Locality/Pincode</form:label></td>
                <td><form:input path="locality" /></td>
            </tr>
            
            
            <tr>
                <td colspan="2"><input type="submit" value="Save"/></td>
            </tr>
        </table>
    </form:form>
</body>
</html>





