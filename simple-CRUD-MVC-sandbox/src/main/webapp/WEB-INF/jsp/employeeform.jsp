<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<a href="/SpringMVCCRUDSimple/">Home page</a>
	<a href="/SpringMVCCRUDSimple/viewemployee">Employees page</a>
	
	<h1>Add New Employee</h1>
       <form:form method="post" action="save">  
      	<table >  
         <tr>  
          <td>First name : </td> 
          <td><form:input path="FirstName"  /></td>
         </tr>  
         <tr>  
          <td>Last name :</td>  
          <td><form:input path="LastName" /></td>
         </tr> 
         <tr>  
          <td>Personal ID :</td>  
          <td><form:input path="personalId" /></td>
         </tr> 
         <tr> 
         <tr>  
          <td>Designation :</td>  
          <td><form:input path="designation" /></td>
         </tr> 
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
