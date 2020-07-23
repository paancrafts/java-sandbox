<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<a href="/SpringMVCCRUDSimple/">Home page</a>
	<a href="/SpringMVCCRUDSimple/viewemployee">Employees page</a>
	
	<h1>Edit Employee</h1>
       <form:form method="POST" action="/SpringMVCCRUDSimple/editsave">  
      	<table >  
      	<tr>
      	<td></td>  
         <td><form:hidden  path="id" /></td>
         </tr> 
         <tr>  
          <td>First name : </td> 
          <td><form:input path="firstName"  /></td>
         </tr>  
         <tr>  
          <td>Last name :</td>  
          <td><form:input path="lastName" /></td>
         </tr> 
         <tr>  
          <td>Personal Id :</td>  
          <td><form:input path="personalId" /></td>
         </tr>
         <tr>  
          <td>Designation :</td>  
          <td><form:input path="designation" /></td>
         </tr> 
         <tr>  
          <td>Archived :</td>  
          <td><form:checkbox path="archived" /></td>
         </tr>
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Edit Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
